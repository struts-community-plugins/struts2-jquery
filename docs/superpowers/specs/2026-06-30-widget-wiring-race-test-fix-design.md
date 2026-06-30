# Integration-test widget-wiring race — central fix design

Date: 2026-06-30
Branch: release/6.0.x
Scope: `struts2-jquery-integration-tests` (test code only — no production JS change)

## Problem

Selenium integration tests intermittently fail with errors such as:

```
NoSuchElementException: Unable to find an element with xpath .//*[@id = 'lettersList']
  at com.jgeppert.jquery.a.ATagIT.testJsonResult(ATagIT.java:125)
```

The failing parameter set varies run to run (e.g. one run failed `[4] loadfromcdn`,
another failed `[2] uncompressed` and `[4]`), which is the signature of a race, not a
deterministic per-variant bug.

## Root cause (evidence-based)

`AbstractJQueryTest.waitForInitialPageLoad()` waits for: document-ready, `jQuery`
defined, `jQuery.struts2_jquery` defined, `jQuery.active === 0`, and no animations.

None of these cover the **per-element widget wiring** that struts2-jquery performs.
Each `sj:` element emits an inline `jQuery(document).ready(...)` block (`a-close.ftl`
and siblings) that calls `jQuery.struts2_jquery.bind(...)`, which lazy-loads
`jquery.ui.struts2.js` and jQuery UI base modules and then attaches the click→AJAX
handler / enhances the widget. This completes **~50–110 ms after
`waitForInitialPageLoad()` returns** (measured: regular 55 ms, uncompressed 46 ms,
loadatonce 106 ms, loadfromcdn 0 ms).

When a test clicks in that gap, the element has **no handler yet** (verified:
`class=""`, `jQuery._data(el,'events') == none`). The click is a silent no-op, so:
- no AJAX fires → `jQuery.active` stays `0` → `wait.until(JQUERY_IDLE)` passes trivially,
- the result element (`#lettersList`) is never created → `NoSuchElementException`,
- or, for non-AJAX widgets, the asserted text never changes → assertion mismatch.

Key facts that shape the fix:
- The wiring is **eventually-consistent** (reliably appears within ~110 ms), so a
  condition-based wait on the precondition fixes it. No production change required.
- struts2-jquery publishes **no global "all wired" event**, so there is no single
  signal to wait on; the wait must target the element about to be used.

## Affected tests

Group 1 — click an AJAX-wired `sj:` element then `JQUERY_IDLE` then assert (identical
pattern to `ATagIT`): `ATagIT`, `SubmitTagIT`, `MenuTagIT`, `DivTagIT` (topicsLink),
`TabbedpanelTagIT`, `TreeTagIT` (sj:submit).

Group 2 — interact with a jQuery-UI widget that must be enhanced first:
`SliderTagIT` (`ui-slider-handle`), `SpinnerTagIT` (up/down arrows),
`AccordionTagIT`, `DialogTagIT`, `AutocompleterTagIT`, `ProgressbarTagIT`.

Low risk (server-rendered, no enhancement dependency): `CheckboxlistTagIT`,
`RadioTagIT`, `SelectTagIT`. Not changed.

## Design: targeted precondition wait

Wait on the actual precondition — "the element I am about to use is wired" — using a
condition-based poll (no `Thread.sleep`).

### New condition class

`com.jgeppert.jquery.selenium.ElementWiredCondition implements ExpectedCondition<WebElement>`

Predicate (single, unified — covers both groups): the element exists **and** either has
a bound jQuery event handler **or** carries a `ui-*` class. Uses `findElements` (not
`findElement`) internally so it does not collide with the implicit wait while polling.

```java
public class ElementWiredCondition implements ExpectedCondition<WebElement> {
    private final By locator;
    public ElementWiredCondition(By locator) { this.locator = locator; }

    @Override
    public WebElement apply(WebDriver driver) {
        var els = driver.findElements(locator);
        if (els.isEmpty()) return null;
        WebElement el = els.get(0);
        Boolean wired = (Boolean) ((JavascriptExecutor) driver).executeScript(
            "var el = arguments[0];" +
            "if (!el || typeof jQuery === 'undefined') return false;" +
            "var ev = jQuery._data ? jQuery._data(el, 'events') : null;" +
            "if (ev) { for (var k in ev) return true; }" +
            "var c = el.className || '';" +
            "return /(^|\\s)ui-/.test(c);", el);
        return Boolean.TRUE.equals(wired) ? el : null;
    }
}
```

### Helper in `AbstractJQueryTest`

```java
protected WebElement waitUntilWired(By locator) {
    return wait.until(new ElementWiredCondition(locator));
}
```

### Per-test application

Before the first triggering interaction, obtain the element via `waitUntilWired(...)`
instead of `driver.findElement(...)`:
- Group 1: wait on the link/submit being clicked (e.g. `ajaxjsonlink`, `formsubmit`).
- Group 2: wait on the widget root (e.g. the slider/spinner/accordion container,
  the dialog open-link, the autocompleter input) before interacting with it or its
  widget-generated children.

One line changes per affected interaction; intent is explicit at the call site.

## Out of scope

- No change to production templates or JS (`head.ftl`, `jquery.struts2.js`, etc.).
- Existing `Thread.sleep(500)` calls for jstree node expansion in `TreeTagIT` are a
  separate pre-existing workaround; only the `sj:submit` interaction there is touched.
- `CheckboxlistTagIT`, `RadioTagIT`, `SelectTagIT` unchanged.

## Verification

Repeat-run the affected suite under the HTMLUnit profile multiple times (≥3) and
confirm consistently green:

```
mvn -pl struts2-jquery-integration-tests -am verify \
  -Dit.test='ATagIT,SubmitTagIT,MenuTagIT,DivTagIT,TabbedpanelTagIT,TreeTagIT,SliderTagIT,SpinnerTagIT,AccordionTagIT,DialogTagIT,AutocompleterTagIT,ProgressbarTagIT'
```

Done when the previously-flaky tests pass across all repeated runs.
