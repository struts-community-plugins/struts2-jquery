package com.jgeppert.jquery.div;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jgeppert.jquery.AbstractJQueryTest;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Tag("HTMLUnit")
@Tag("CI-HTMLUnit")
public class DivTagIT extends AbstractJQueryTest {
    @ParameterizedTest
    @MethodSource("data")
    @Tag("PhantomJS")
    public void testAjaxDiv(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/div/ajax-div.action");

        waitForInitialPageLoad();

        WebElement ajaxDiv = driver.findElement(By.id("ajaxdiv"));

        wait.until(JQUERY_IDLE);

        assertEquals("This is simple text from an ajax call.", ajaxDiv.getText());
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testEvents(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/div/events.action");

        Thread.sleep(100);
        wait.until(DOCUMENT_READY);
        wait.until(JQUERY_DEFINED);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        assertEquals("Before div", alert.getText());

        alert.accept();

        alert = wait.until(ExpectedConditions.alertIsPresent());

        assertEquals("Complete div", alert.getText());

        alert.accept();

        WebElement ajaxDiv = driver.findElement(By.id("ajaxdiv"));

        assertEquals("This is simple text from an ajax call.", ajaxDiv.getText());
    }

    @ParameterizedTest
    @MethodSource("data")
    @Tag("PhantomJS")
    public void testListenTopics(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/div/listen-topics.action");

        waitForInitialPageLoad();

        WebElement ajaxDiv = driver.findElement(By.id("ajaxdiv"));
        WebElement topicsLink = driver.findElement(By.id("topicslink"));

        assertEquals("ajax div", ajaxDiv.getText());

        topicsLink.click();
        wait.until(JQUERY_IDLE);

        assertEquals("This is simple text from an ajax call.", ajaxDiv.getText());
    }
}
