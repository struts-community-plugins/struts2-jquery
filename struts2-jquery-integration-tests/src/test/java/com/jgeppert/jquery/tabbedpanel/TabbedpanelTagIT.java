package com.jgeppert.jquery.tabbedpanel;

import com.jgeppert.jquery.AbstractJQueryTest;
import com.jgeppert.jquery.junit.category.HtmlUnitCategory;
import com.jgeppert.jquery.junit.category.PhantomJSCategory;


import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@RunWith(Parameterized.class)
@Category({ PhantomJSCategory.class, HtmlUnitCategory.class })
public class TabbedpanelTagIT extends AbstractJQueryTest {
    private String baseUrl;

    public TabbedpanelTagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Test
    public void testLocal() throws InterruptedException {
        driver.get(baseUrl + "/tabbedpanel/local.action");

        waitForInitialPageLoad();

        WebElement tab1Link = driver.findElement(By.id("tab1")).findElement(By.tagName("a"));
        WebElement tab2Link = driver.findElement(By.id("tab2")).findElement(By.tagName("a"));
        WebElement tabcontent1 = driver.findElement(By.id("tabcontent1"));
        WebElement tabcontent2 = driver.findElement(By.id("tabcontent2"));

        Assert.assertTrue(tabcontent1.isDisplayed());
        Assert.assertFalse(tabcontent2.isDisplayed());

        tab2Link.click();

        Assert.assertFalse(tabcontent1.isDisplayed());
        Assert.assertTrue(tabcontent2.isDisplayed());

        tab1Link.click();

        Assert.assertTrue(tabcontent1.isDisplayed());
        Assert.assertFalse(tabcontent2.isDisplayed());
    }

    @Test
    public void testRemote() throws InterruptedException {
        driver.get(baseUrl + "/tabbedpanel/remote.action");

        waitForInitialPageLoad();

        WebElement tab1 = driver.findElement(By.id("tab1"));
        WebElement tab2 = driver.findElement(By.id("tab2"));
        WebElement tab1Link = tab1.findElement(By.tagName("a"));
        WebElement tab2Link = tab2.findElement(By.tagName("a"));
        WebElement tabcontent1 = driver.findElement(By.id(tab1.getAttribute("aria-controls")));
        WebElement tabcontent2 = driver.findElement(By.id(tab2.getAttribute("aria-controls")));

        Assert.assertTrue(tabcontent1.isDisplayed());
        Assert.assertFalse(tabcontent2.isDisplayed());
        Assert.assertEquals("This is simple text from an ajax call.", tabcontent1.getText());

        tab2Link.click();
        wait.until(JQUERY_IDLE);

        Assert.assertFalse(tabcontent1.isDisplayed());
        Assert.assertTrue(tabcontent2.isDisplayed());
        Assert.assertEquals("Echo : something to echo", tabcontent2.getText());

        tab1Link.click();
        wait.until(JQUERY_IDLE);

        Assert.assertTrue(tabcontent1.isDisplayed());
        Assert.assertFalse(tabcontent2.isDisplayed());
    }
}
