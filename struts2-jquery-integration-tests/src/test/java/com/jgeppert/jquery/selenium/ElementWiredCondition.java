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
