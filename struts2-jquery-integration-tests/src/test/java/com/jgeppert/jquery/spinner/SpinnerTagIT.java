package com.jgeppert.jquery.spinner;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jgeppert.jquery.AbstractJQueryTest;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Tag("HTMLUnit")
@Tag("PhantomJS")
@Tag("CI-HTMLUnit")
public class SpinnerTagIT extends AbstractJQueryTest {
    @ParameterizedTest
    @MethodSource("data")
    public void testSimple(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/spinner/simple.action");

        waitForInitialPageLoad();

        WebElement spinnerInput = driver.findElement(By.id("mySpinner"));
        WebElement spinnerUp = driver.findElement(By.className("ui-spinner-up"));
        WebElement spinnerDown = driver.findElement(By.className("ui-spinner-down"));

        assertNull(spinnerInput.getAttribute("aria-valuenow"));

        spinnerUp.click();

        assertEquals("1", spinnerInput.getAttribute("aria-valuenow"));

        spinnerDown.click();

        assertEquals("0", spinnerInput.getAttribute("aria-valuenow"));
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testMaximum(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/spinner/maximum.action");
        
        waitForInitialPageLoad();

        WebElement spinnerInput = driver.findElement(By.id("mySpinner"));
        WebElement spinnerUp = driver.findElement(By.className("ui-spinner-up"));
        WebElement spinnerDown = driver.findElement(By.className("ui-spinner-down"));

        assertEquals("6", spinnerInput.getAttribute("aria-valuenow"));

        spinnerUp.click();

        assertEquals("8", spinnerInput.getAttribute("aria-valuenow"));

        spinnerUp.click();

        assertEquals("9", spinnerInput.getAttribute("aria-valuenow"));

        spinnerUp.click();

        assertEquals("9", spinnerInput.getAttribute("aria-valuenow"));

        spinnerDown.click();

        assertEquals("8", spinnerInput.getAttribute("aria-valuenow"));
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testMinimum(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/spinner/minimum.action");
        
        waitForInitialPageLoad();

        WebElement spinnerInput = driver.findElement(By.id("mySpinner"));
        WebElement spinnerUp = driver.findElement(By.className("ui-spinner-up"));
        WebElement spinnerDown = driver.findElement(By.className("ui-spinner-down"));

        assertEquals("6", spinnerInput.getAttribute("aria-valuenow"));

        spinnerDown.click();

        assertEquals("5", spinnerInput.getAttribute("aria-valuenow"));

        spinnerDown.click();

        assertEquals("3", spinnerInput.getAttribute("aria-valuenow"));

        spinnerDown.click();

        assertEquals("3", spinnerInput.getAttribute("aria-valuenow"));

        spinnerUp.click();

        assertEquals("5", spinnerInput.getAttribute("aria-valuenow"));
    }
}
