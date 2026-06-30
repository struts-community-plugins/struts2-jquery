package com.jgeppert.jquery.select;

import com.jgeppert.jquery.AbstractJQueryTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("CI-CHROME")
@Tag("HTMLUnit")
@Tag("PhantomJS")
public class SelectTagIT extends AbstractJQueryTest {

    @ParameterizedTest
    @MethodSource("data")
    public void testStringlistData(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/select/stringlist.action");

        waitForInitialPageLoad();

        WebElement selectElement = driver.findElement(By.id("myselect"));
        // The sj:select loads its options asynchronously via AJAX (href); the server-side
        // markup only contains the empty placeholder option. Wait for the options to load
        // before asserting, otherwise we race the AJAX population.
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("#myselect option"), 26));
        List<WebElement> options = selectElement.findElements(By.tagName("option"));

        assertEquals("letter", selectElement.getAttribute("name"));
        assertEquals(26, options.size());
        assertEquals("a", options.get(0).getText());
        assertEquals("a", options.get(0).getAttribute("value"));
        assertEquals("z", options.get(25).getText());
        assertEquals("z", options.get(25).getAttribute("value"));
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testMapData(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/select/map.action");

        waitForInitialPageLoad();

        WebElement selectElement = driver.findElement(By.id("myselect"));
        // The sj:select loads its options asynchronously via AJAX (href); the server-side
        // markup only contains the empty placeholder option. Wait for the options to load
        // before asserting, otherwise we race the AJAX population.
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("#myselect option"), 26));
        List<WebElement> options = selectElement.findElements(By.tagName("option"));

        assertEquals("letter", selectElement.getAttribute("name"));
        assertEquals(26, options.size());
        assertEquals("a", options.get(0).getText());
        assertEquals("97", options.get(0).getAttribute("value"));
        assertEquals("z", options.get(25).getText());
        assertEquals("122", options.get(25).getAttribute("value"));
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testObjectListData(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/select/objectlist.action");

        waitForInitialPageLoad();

        WebElement selectElement = driver.findElement(By.id("myselect"));
        // The sj:select loads its options asynchronously via AJAX (href); the server-side
        // markup only contains the empty placeholder option. Wait for the options to load
        // before asserting, otherwise we race the AJAX population.
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("#myselect option"), 26));
        List<WebElement> options = selectElement.findElements(By.tagName("option"));

        assertEquals("letter", selectElement.getAttribute("name"));
        assertEquals(26, options.size());
        assertEquals("a", options.get(0).getText());
        assertEquals("97", options.get(0).getAttribute("value"));
        assertEquals("z", options.get(25).getText());
        assertEquals("122", options.get(25).getAttribute("value"));
    }
}
