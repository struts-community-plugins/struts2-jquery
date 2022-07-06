package com.jgeppert.jquery.tabbedpanel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.jgeppert.jquery.AbstractJQueryTest;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Tag("HTMLUnit")
@Tag("PhantomJS")
public class TabbedpanelTagIT extends AbstractJQueryTest {
    @ParameterizedTest
    @MethodSource("data")
    public void testLocal(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/tabbedpanel/local.action");

        waitForInitialPageLoad();

        WebElement tab1Link = driver.findElement(By.id("tab1")).findElement(By.tagName("a"));
        WebElement tab2Link = driver.findElement(By.id("tab2")).findElement(By.tagName("a"));
        WebElement tabcontent1 = driver.findElement(By.id("tabcontent1"));
        WebElement tabcontent2 = driver.findElement(By.id("tabcontent2"));

        assertTrue(tabcontent1.isDisplayed());
        assertFalse(tabcontent2.isDisplayed());

        tab2Link.click();

        assertFalse(tabcontent1.isDisplayed());
        assertTrue(tabcontent2.isDisplayed());

        tab1Link.click();

        assertTrue(tabcontent1.isDisplayed());
        assertFalse(tabcontent2.isDisplayed());
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testRemote(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/tabbedpanel/remote.action");

        waitForInitialPageLoad();

        WebElement tab1 = driver.findElement(By.id("tab1"));
        WebElement tab2 = driver.findElement(By.id("tab2"));
        WebElement tab1Link = tab1.findElement(By.tagName("a"));
        WebElement tab2Link = tab2.findElement(By.tagName("a"));
        WebElement tabcontent1 = driver.findElement(By.id(tab1.getAttribute("aria-controls")));
        WebElement tabcontent2 = driver.findElement(By.id(tab2.getAttribute("aria-controls")));

        assertTrue(tabcontent1.isDisplayed());
        assertFalse(tabcontent2.isDisplayed());
        assertEquals("This is simple text from an ajax call.", tabcontent1.getText());

        tab2Link.click();
        wait.until(JQUERY_IDLE);

        assertFalse(tabcontent1.isDisplayed());
        assertTrue(tabcontent2.isDisplayed());
        assertEquals("Echo : something to echo", tabcontent2.getText());

        tab1Link.click();
        wait.until(JQUERY_IDLE);

        assertTrue(tabcontent1.isDisplayed());
        assertFalse(tabcontent2.isDisplayed());
    }
}
