package com.jgeppert.jquery.spinner;

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
public class SpinnerTagIT extends AbstractJQueryTest {
    private String baseUrl;

    public SpinnerTagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Test
    public void testSimple() throws InterruptedException {
        driver.get(baseUrl + "/spinner/simple.action");

        waitForInitialPageLoad();

        WebElement spinnerInput = driver.findElement(By.id("mySpinner"));
        WebElement spinnerUp = driver.findElement(By.className("ui-spinner-up"));
        WebElement spinnerDown = driver.findElement(By.className("ui-spinner-down"));

        Assert.assertNull(spinnerInput.getAttribute("aria-valuenow"));

        spinnerUp.click();

        Assert.assertEquals("1", spinnerInput.getAttribute("aria-valuenow"));

        spinnerDown.click();

        Assert.assertEquals("0", spinnerInput.getAttribute("aria-valuenow"));
    }

    @Test
    public void testMaximum() throws InterruptedException {
        driver.get(baseUrl + "/spinner/maximum.action");
        
        waitForInitialPageLoad();

        WebElement spinnerInput = driver.findElement(By.id("mySpinner"));
        WebElement spinnerUp = driver.findElement(By.className("ui-spinner-up"));
        WebElement spinnerDown = driver.findElement(By.className("ui-spinner-down"));

        Assert.assertEquals("6", spinnerInput.getAttribute("aria-valuenow"));

        spinnerUp.click();

        Assert.assertEquals("8", spinnerInput.getAttribute("aria-valuenow"));

        spinnerUp.click();

        Assert.assertEquals("9", spinnerInput.getAttribute("aria-valuenow"));

        spinnerUp.click();

        Assert.assertEquals("9", spinnerInput.getAttribute("aria-valuenow"));

        spinnerDown.click();

        Assert.assertEquals("8", spinnerInput.getAttribute("aria-valuenow"));
    }

    @Test
    public void testMinimum() throws InterruptedException {
        driver.get(baseUrl + "/spinner/minimum.action");
        
        waitForInitialPageLoad();

        WebElement spinnerInput = driver.findElement(By.id("mySpinner"));
        WebElement spinnerUp = driver.findElement(By.className("ui-spinner-up"));
        WebElement spinnerDown = driver.findElement(By.className("ui-spinner-down"));

        Assert.assertEquals("6", spinnerInput.getAttribute("aria-valuenow"));

        spinnerDown.click();

        Assert.assertEquals("5", spinnerInput.getAttribute("aria-valuenow"));

        spinnerDown.click();

        Assert.assertEquals("3", spinnerInput.getAttribute("aria-valuenow"));

        spinnerDown.click();

        Assert.assertEquals("3", spinnerInput.getAttribute("aria-valuenow"));

        spinnerUp.click();

        Assert.assertEquals("5", spinnerInput.getAttribute("aria-valuenow"));
    }
}
