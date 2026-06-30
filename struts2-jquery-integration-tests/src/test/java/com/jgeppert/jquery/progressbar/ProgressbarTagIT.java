package com.jgeppert.jquery.progressbar;

import com.jgeppert.jquery.AbstractJQueryTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("HTMLUnit")
@Tag("CI-CHROME")
@Tag("CI-HTMLUnit")
public class ProgressbarTagIT extends AbstractJQueryTest {
    @ParameterizedTest
    @MethodSource("data")
    public void testLocal(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/progressbar/local.action");
        
        waitForInitialPageLoad();
        debugWidgetState("myProgressbar");

        WebElement progressbar = driver.findElement(By.id("myProgressbar"));
        WebElement progressbarValueDiv = progressbar.findElement(By.className("ui-progressbar-value"));

        assertEquals("width: 42%;", progressbarValueDiv.getAttribute("style").trim());
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testLocalEvents(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/progressbar/local-events.action");
        
        waitForInitialPageLoad();
        debugWidgetState("myProgressbar");

        WebElement progressbar = driver.findElement(By.id("myProgressbar"));
        WebElement progressbarValueDiv = progressbar.findElement(By.className("ui-progressbar-value"));
        WebElement button = waitUntilWired(By.id("myButton"));

        assertEquals("width: 42%;", progressbarValueDiv.getAttribute("style").trim());

        button.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        assertEquals("value changed to : 84", alert.getText());

        alert.accept();

        assertEquals("width: 84%;", progressbarValueDiv.getAttribute("style"));
    }
}

