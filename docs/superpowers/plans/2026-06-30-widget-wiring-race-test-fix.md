# Widget-Wiring Race Test Fix Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Eliminate flaky `NoSuchElementException`/assertion failures in the Selenium integration tests caused by interacting with struts2-jquery widgets before their asynchronous wiring completes.

**Architecture:** Add a condition-based wait (`ElementWiredCondition`) plus a `waitUntilWired(By)` helper in `AbstractJQueryTest`. Before the first triggering interaction, affected tests fetch the trigger element (or its widget root) via `waitUntilWired(...)` so the test only proceeds once the element has a bound jQuery handler or a `ui-*` class. Test-only change; no production JS is touched.

**Tech Stack:** Java 17, JUnit 5 (parameterized), Selenium 4 (`HtmlUnitDriver`), Maven Failsafe, Jetty (auto-started in `pre-integration-test`).

## Global Constraints

- Test code only — do **not** modify any file under `struts2-jquery-plugin/` (templates, JS).
- New condition class lives in package `com.jgeppert.jquery.selenium` (alongside `JQueryIdleCondition`).
- Predicate: element is "wired" when it exists **and** (`jQuery._data(el,'events')` has any key **or** its `className` matches `/(^|\s)ui-/`).
- The condition MUST use `driver.findElements(locator)` (not `findElement`) internally so polling does not block on the 10s implicit wait.
- Verification gate for every task: repeat-run the touched test classes **3 times** under the default (HTMLUnit) profile; all must pass every run.
- Do not remove existing `Thread.sleep(...)` calls in `TreeTagIT` (pre-existing jstree workaround, out of scope).
- Do not change `CheckboxlistTagIT`, `RadioTagIT`, `SelectTagIT`.

---

### Task 1: Add `ElementWiredCondition` + `waitUntilWired`, prove on `ATagIT`

**Files:**
- Create: `struts2-jquery-integration-tests/src/test/java/com/jgeppert/jquery/selenium/ElementWiredCondition.java`
- Modify: `struts2-jquery-integration-tests/src/test/java/com/jgeppert/jquery/AbstractJQueryTest.java`
- Modify (test under change): `struts2-jquery-integration-tests/src/test/java/com/jgeppert/jquery/a/ATagIT.java`

**Interfaces:**
- Produces: `ElementWiredCondition(By locator) implements ExpectedCondition<WebElement>` — returns the `WebElement` once wired, else `null`.
- Produces: `protected WebElement AbstractJQueryTest.waitUntilWired(By locator)` — blocks via `wait.until(...)` and returns the wired element.
- Consumes: existing `protected WebDriverWait wait` and `protected WebDriver driver` in `AbstractJQueryTest`.

- [ ] **Step 1: Create the condition class**

Create `.../selenium/ElementWiredCondition.java`:

```java
package com.jgeppert.jquery.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

/**
 * Waits until a struts2-jquery element has finished its asynchronous wiring.
 * An element is considered "wired" once it has at least one bound jQuery event
 * handler, or it carries a jQuery UI ("ui-*") class. Uses findElements so that
 * polling never blocks on the implicit wait.
 */
public class ElementWiredCondition implements ExpectedCondition<WebElement> {

    private final By locator;

    public ElementWiredCondition(final By locator) {
        this.locator = locator;
    }

    @Override
    public WebElement apply(final WebDriver driver) {
        List<WebElement> els = driver.findElements(locator);
        if (els.isEmpty()) {
            return null;
        }
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

    @Override
    public String toString() {
        return "element located by " + locator + " to be struts2-jquery wired";
    }
}
```

- [ ] **Step 2: Add the helper to `AbstractJQueryTest`**

In `AbstractJQueryTest.java`, add these imports alongside the other selenium imports (neither `By` nor `WebElement` is currently imported there):

```java
import com.jgeppert.jquery.selenium.ElementWiredCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
```

Add this method to the class (e.g. directly after the `waitForInitialPageLoad()` method):

```java
    /** Wait until a struts2-jquery element has finished async wiring, then return it. */
    protected WebElement waitUntilWired(final By locator) {
        return wait.until(new ElementWiredCondition(locator));
    }
```

- [ ] **Step 3: Apply to all 5 `ATagIT` methods**

In `ATagIT.java`, change the trigger-element fetch from `driver.findElement(...)` to `waitUntilWired(...)`:

- `testSimpleAjaxPageLink`:
  `WebElement ajaxlink = driver.findElement(By.id("ajaxlink"));`
  → `WebElement ajaxlink = waitUntilWired(By.id("ajaxlink"));`
- `testMultipleTargets`:
  `WebElement ajaxLink = driver.findElement(By.id("ajaxlink"));`
  → `WebElement ajaxLink = waitUntilWired(By.id("ajaxlink"));`
- `testFormSubmit`:
  `WebElement ajaxFormLink = driver.findElement(By.id("ajaxformlink"));`
  → `WebElement ajaxFormLink = waitUntilWired(By.id("ajaxformlink"));`
- `testEvents`:
  `WebElement ajaxLink = driver.findElement(By.id("ajaxlink"));`
  → `WebElement ajaxLink = waitUntilWired(By.id("ajaxlink"));`
- `testJsonResult`:
  `WebElement ajaxJsonLink = driver.findElement(By.id("ajaxjsonlink"));`
  → `WebElement ajaxJsonLink = waitUntilWired(By.id("ajaxjsonlink"));`

Leave all other lines (the `result`/`div1`/`echo` fetches, clicks, asserts) unchanged.

- [ ] **Step 4: Run `ATagIT` 3 times to verify green**

Run (from repo root):

```bash
for i in 1 2 3; do echo "=== RUN $i ==="; \
  mvn -q -pl struts2-jquery-integration-tests -am verify \
    -Dit.test='ATagIT' -DfailIfNoTests=false -Dsurefire.failIfNoSpecifiedTests=false \
  || break; done
```

Expected: each run ends `Tests run: 20, Failures: 0, Errors: 0` (5 methods × 4 params) and `BUILD SUCCESS`.

- [ ] **Step 5: Commit**

```bash
git add struts2-jquery-integration-tests/src/test/java/com/jgeppert/jquery/selenium/ElementWiredCondition.java \
        struts2-jquery-integration-tests/src/test/java/com/jgeppert/jquery/AbstractJQueryTest.java \
        struts2-jquery-integration-tests/src/test/java/com/jgeppert/jquery/a/ATagIT.java
git commit -m "test: add waitUntilWired to fix widget-wiring race (ATagIT)

Co-Authored-By: Claude Opus 4.8 <noreply@anthropic.com>"
```

---

### Task 2: Apply to Group 1 tests (AJAX-wired click triggers)

**Files (modify):**
- `.../submit/SubmitTagIT.java`
- `.../div/DivTagIT.java`
- `.../menu/MenuTagIT.java`
- `.../tabbedpanel/TabbedpanelTagIT.java`
- `.../tree/TreeTagIT.java`

**Interfaces:**
- Consumes: `waitUntilWired(By)` from Task 1.

For each test below, change the listed trigger fetch from `driver.findElement(<locator>)` to `waitUntilWired(<locator>)`. Read each file first; apply only to the listed elements. Do not alter clicks, asserts, `Thread.sleep`, or other element fetches.

- [ ] **Step 1: `SubmitTagIT` — every `sj:submit` trigger**

For each test method, change every submit-button fetch:
`WebElement ajaxSubmit = driver.findElement(By.id("formsubmit"));`
→ `WebElement ajaxSubmit = waitUntilWired(By.id("formsubmit"));`

If a method fetches a differently-named submit id (e.g. `formsubmit1`, `ajaxSubmit1`), apply the same `waitUntilWired(By.id("<thatId>"))` transformation to it.

- [ ] **Step 2: `DivTagIT` — `testListenTopics` only**

`WebElement topicsLink = driver.findElement(By.id("topicslink"));`
→ `WebElement topicsLink = waitUntilWired(By.id("topicslink"));`

(`testAjaxDiv` and `testEvents` are auto-loading/alert-driven — leave unchanged.)

- [ ] **Step 3: `MenuTagIT` — wait on the enhanced menu element**

- `testLocalContent`:
  `WebElement menuItemWithSubMenu = driver.findElement(By.id("menuItem2"));`
  → `WebElement menuItemWithSubMenu = waitUntilWired(By.id("menuItem2"));`
- The other two methods that fetch `WebElement menu = driver.findElement(By.id("myMenu"));`
  → `WebElement menu = waitUntilWired(By.id("myMenu"));`

- [ ] **Step 4: `TabbedpanelTagIT` — wait on the enhanced tab**

In the method(s) that click tab links, change the `tab2` fetch:
`WebElement tab2Link = driver.findElement(By.id("tab2")).findElement(By.tagName("a"));`
→ `WebElement tab2Link = waitUntilWired(By.id("tab2")).findElement(By.tagName("a"));`

`waitUntilWired(By.id("tab2"))` returns the enhanced `<li>` (gets a `ui-*` class); chaining `.findElement(By.tagName("a"))` keeps the same link.

- [ ] **Step 5: `TreeTagIT` — wait on the `sj:submit`**

In the checkbox-tree method, change:
`WebElement submit = driver.findElement(By.id("mySubmit"));`
→ `WebElement submit = waitUntilWired(By.id("mySubmit"));`

Leave the jstree node-icon clicks and their `Thread.sleep(500)` calls unchanged.

- [ ] **Step 6: Run the 5 classes 3 times**

```bash
for i in 1 2 3; do echo "=== RUN $i ==="; \
  mvn -q -pl struts2-jquery-integration-tests -am verify \
    -Dit.test='SubmitTagIT,DivTagIT,MenuTagIT,TabbedpanelTagIT,TreeTagIT' \
    -DfailIfNoTests=false -Dsurefire.failIfNoSpecifiedTests=false \
  || break; done
```

Expected: `Failures: 0, Errors: 0` and `BUILD SUCCESS` on all 3 runs.

- [ ] **Step 7: Commit**

```bash
git add struts2-jquery-integration-tests/src/test/java/com/jgeppert/jquery/submit/SubmitTagIT.java \
        struts2-jquery-integration-tests/src/test/java/com/jgeppert/jquery/div/DivTagIT.java \
        struts2-jquery-integration-tests/src/test/java/com/jgeppert/jquery/menu/MenuTagIT.java \
        struts2-jquery-integration-tests/src/test/java/com/jgeppert/jquery/tabbedpanel/TabbedpanelTagIT.java \
        struts2-jquery-integration-tests/src/test/java/com/jgeppert/jquery/tree/TreeTagIT.java
git commit -m "test: waitUntilWired for AJAX-wired click triggers (Group 1)

Co-Authored-By: Claude Opus 4.8 <noreply@anthropic.com>"
```

---

### Task 3: Apply to Group 2 tests (jQuery-UI widget enhancement)

**Files (modify):**
- `.../slider/SliderTagIT.java`
- `.../spinner/SpinnerTagIT.java`
- `.../accordion/AccordionTagIT.java`
- `.../dialog/DialogTagIT.java`
- `.../autocompleter/AutocompleterTagIT.java`
- `.../progressbar/ProgressbarTagIT.java`

**Interfaces:**
- Consumes: `waitUntilWired(By)` from Task 1.

For widget-generated children (slider handle, spinner arrows, progressbar value div), wait on the **widget root** before fetching the child.

- [ ] **Step 1: `SliderTagIT` — wait on the slider widget root**

`WebElement sliderHandle = driver.findElement(By.id("myslider_widget")).findElement(By.className("ui-slider-handle"));`
→ `WebElement sliderHandle = waitUntilWired(By.id("myslider_widget")).findElement(By.className("ui-slider-handle"));`

- [ ] **Step 2: `SpinnerTagIT` — wait on the spinner input (gets `ui-spinner-input`)**

In each method, before fetching the up/down arrows, change the input fetch:
`WebElement spinnerInput = driver.findElement(By.id("mySpinner"));`
→ `WebElement spinnerInput = waitUntilWired(By.id("mySpinner"));`

The subsequent `By.className("ui-spinner-up")` / `ui-spinner-down` fetches then succeed because enhancement is complete.

- [ ] **Step 3: `AccordionTagIT` — wait on the enhanced header**

`WebElement accordionTitle2 = driver.findElement(By.id("accordionItem2"));`
→ `WebElement accordionTitle2 = waitUntilWired(By.id("accordionItem2"));`

Apply in every method that clicks `accordionTitle2`.

- [ ] **Step 4: `DialogTagIT` — wait on the open link**

In the method that fetches `modalOpenLink`:
`WebElement dialogOpenLink = driver.findElement(By.id("modalOpenLink"));`
→ `WebElement dialogOpenLink = waitUntilWired(By.id("modalOpenLink"));`

For the auto-open method that uses `By.xpath("//div[@role='dialog']")`: leave as-is — that element only exists after the dialog widget runs, so the implicit wait already gates correctly.

- [ ] **Step 5: `AutocompleterTagIT` — wait on the enhanced input**

In each method:
`WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));`
→ `WebElement autocompleteInputWidget = waitUntilWired(By.id("autocompleterMonths_widget"));`

- [ ] **Step 6: `ProgressbarTagIT` — wait on the trigger button**

In the method that clicks the button:
`WebElement button = driver.findElement(By.id("myButton"));`
→ `WebElement button = waitUntilWired(By.id("myButton"));`

(The `progressbarValueDiv` read via `By.className("ui-progressbar-value")` is a widget child of `myProgressbar`; the implicit wait already covers it, so leave those unchanged.)

- [ ] **Step 7: Run the 6 classes 3 times**

```bash
for i in 1 2 3; do echo "=== RUN $i ==="; \
  mvn -q -pl struts2-jquery-integration-tests -am verify \
    -Dit.test='SliderTagIT,SpinnerTagIT,AccordionTagIT,DialogTagIT,AutocompleterTagIT,ProgressbarTagIT' \
    -DfailIfNoTests=false -Dsurefire.failIfNoSpecifiedTests=false \
  || break; done
```

Expected: `Failures: 0, Errors: 0` and `BUILD SUCCESS` on all 3 runs.

- [ ] **Step 8: Commit**

```bash
git add struts2-jquery-integration-tests/src/test/java/com/jgeppert/jquery/slider/SliderTagIT.java \
        struts2-jquery-integration-tests/src/test/java/com/jgeppert/jquery/spinner/SpinnerTagIT.java \
        struts2-jquery-integration-tests/src/test/java/com/jgeppert/jquery/accordion/AccordionTagIT.java \
        struts2-jquery-integration-tests/src/test/java/com/jgeppert/jquery/dialog/DialogTagIT.java \
        struts2-jquery-integration-tests/src/test/java/com/jgeppert/jquery/autocompleter/AutocompleterTagIT.java \
        struts2-jquery-integration-tests/src/test/java/com/jgeppert/jquery/progressbar/ProgressbarTagIT.java
git commit -m "test: waitUntilWired for jQuery-UI widget tests (Group 2)

Co-Authored-By: Claude Opus 4.8 <noreply@anthropic.com>"
```

---

### Task 4: Full-suite confirmation

**Files:** none (verification only).

- [ ] **Step 1: Run the full integration-test suite once**

```bash
mvn -q -pl struts2-jquery-integration-tests -am verify
```

Expected: `BUILD SUCCESS`, no failures/errors across all `*IT` classes.

- [ ] **Step 2: If green, no commit needed.** If any flake reappears, return to systematic-debugging — capture the failing element's `jQuery._data(el,'events')` and `className` at click time and confirm whether the wait anchor for that test points at the correct enhanced element.
