package com.jgeppert.jquery.autocompleter;

import com.jgeppert.jquery.AbstractJQueryTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("HTMLUnit")
@Tag("PhantomJS")
@Tag("CI-CHROME")
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
        wait.until(JQUERY_IDLE);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("li"), 3));
        assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        wait.until(JQUERY_IDLE);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("li"), 2));
        assertEquals(2, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys(Keys.DOWN);
        autocompleteInputWidget.sendKeys(Keys.ENTER);
        wait.until(JQUERY_IDLE);
        wait.until(ExpectedConditions.domAttributeToBe(autocompleteInput, "value", "June"));
        assertEquals("June", autocompleteInput.getDomAttribute("value"));
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testAjaxArray(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/autocompleter/ajaxarray.action");
        
        waitForInitialPageLoad();

        WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));

        autocompleteInputWidget.sendKeys("j");
        wait.until(JQUERY_IDLE);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("li"), 3));
        assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        wait.until(JQUERY_IDLE);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("li"), 2));
        assertEquals(2, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys(Keys.DOWN);
        autocompleteInputWidget.sendKeys(Keys.ENTER);
        wait.until(JQUERY_IDLE);
        wait.until(ExpectedConditions.domAttributeToBe(autocompleteInput, "value", "June"));
        assertEquals("June", autocompleteInput.getDomAttribute("value"));
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testAjaxArrayInsideObject(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/autocompleter/ajaxarrayinsideobject.action");
        
        waitForInitialPageLoad();

        WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));

        autocompleteInputWidget.sendKeys("j");
        wait.until(JQUERY_IDLE);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("li"), 3));
        assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        wait.until(JQUERY_IDLE);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("li"), 2));
        assertEquals(2, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys(Keys.DOWN);
        autocompleteInputWidget.sendKeys(Keys.ENTER);
        wait.until(JQUERY_IDLE);
        wait.until(ExpectedConditions.domAttributeToBe(autocompleteInput, "value", "June"));
        assertEquals("June", autocompleteInput.getDomAttribute("value"));
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testAjaxMapInsideObject(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/autocompleter/ajaxmapinsideobject.action");
        
        waitForInitialPageLoad();

        WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));

        autocompleteInputWidget.sendKeys("j");
        wait.until(JQUERY_IDLE);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("li"), 3));
        assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        wait.until(JQUERY_IDLE);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("li"), 2));
        assertEquals(2, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys(Keys.DOWN);
        autocompleteInputWidget.sendKeys(Keys.ENTER);
        wait.until(JQUERY_IDLE);
        wait.until(ExpectedConditions.domAttributeToBe(autocompleteInput, "value", "6"));
        assertEquals("6", autocompleteInput.getDomAttribute("value"));
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testAjaxObjectsInsideObject(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/autocompleter/ajaxobjectsinsideobject.action");
        
        waitForInitialPageLoad();

        WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));

        autocompleteInputWidget.sendKeys("j");
        wait.until(JQUERY_IDLE);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("li"), 3));
        assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        wait.until(JQUERY_IDLE);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("li"), 2));
        assertEquals(2, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys(Keys.DOWN);
        autocompleteInputWidget.sendKeys(Keys.ENTER);
        wait.until(JQUERY_IDLE);
        wait.until(ExpectedConditions.domAttributeToBe(autocompleteInput, "value", "6"));
        assertEquals("6", autocompleteInput.getDomAttribute("value"));
    }
}
