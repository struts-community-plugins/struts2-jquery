package com.jgeppert.jquery.autocompleter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jgeppert.jquery.AbstractJQueryTest;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Disabled
@Tag("HTMLUnit")
@Tag("PhantomJS")
@Tag("CI-HTMLUnit")
public class AutocompleterTagIT extends AbstractJQueryTest {
    @ParameterizedTest
    @MethodSource("data")
    public void testListData(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/autocompleter/list.action");

        waitForInitialPageLoad();

        WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));

        autocompleteInputWidget.sendKeys("j");
        Thread.sleep(500);
        assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        Thread.sleep(500);
        assertEquals(2, driver.findElements(By.tagName("li")).size());

        driver.findElements(By.tagName("li")).get(0).click();
        Thread.sleep(500);
        assertEquals("June", autocompleteInput.getAttribute("value"));
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testAjaxArray(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/autocompleter/ajaxarray.action");
        
        waitForInitialPageLoad();

        WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));

        autocompleteInputWidget.sendKeys("j");
        Thread.sleep(1000);
        assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        Thread.sleep(1000);
        assertEquals(2, driver.findElements(By.tagName("li")).size());

        driver.findElements(By.tagName("li")).get(0).click();
        Thread.sleep(1000);
        assertEquals("June", autocompleteInput.getAttribute("value"));
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testAjaxArrayInsideObject(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/autocompleter/ajaxarrayinsideobject.action");
        
        waitForInitialPageLoad();

        WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));

        autocompleteInputWidget.sendKeys("j");
        Thread.sleep(1000);
        assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        Thread.sleep(1000);
        assertEquals(2, driver.findElements(By.tagName("li")).size());

        driver.findElements(By.tagName("li")).get(0).click();
        Thread.sleep(1000);
        assertEquals("June", autocompleteInput.getAttribute("value"));
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testAjaxMapInsideObject(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/autocompleter/ajaxmapinsideobject.action");
        
        waitForInitialPageLoad();

        WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));

        autocompleteInputWidget.sendKeys("j");
        Thread.sleep(1000);
        assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        Thread.sleep(1000);
        assertEquals(2, driver.findElements(By.tagName("li")).size());

        driver.findElements(By.tagName("li")).get(0).click();
        Thread.sleep(1000);
        assertEquals("6", autocompleteInput.getAttribute("value"));
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testAjaxObjectsInsideObject(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/autocompleter/ajaxobjectsinsideobject.action");
        
        waitForInitialPageLoad();

        WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));

        autocompleteInputWidget.sendKeys("j");
        Thread.sleep(1000);
        assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        Thread.sleep(1000);
        assertEquals(2, driver.findElements(By.tagName("li")).size());

        driver.findElements(By.tagName("li")).get(0).click();
        Thread.sleep(1000);
        assertEquals("6", autocompleteInput.getAttribute("value"));
    }
}
