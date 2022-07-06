package com.jgeppert.jquery.submit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jgeppert.jquery.AbstractJQueryTest;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Tag("HTMLUnit")
@Tag("PhantomJS")
public class SubmitTagIT extends AbstractJQueryTest {
    @ParameterizedTest
    @MethodSource("data")
    public void testSimpleFormSubmit(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/submit/simple-form.action");

        waitForInitialPageLoad();

        WebElement formResult = driver.findElement(By.id("formResult"));
        WebElement echoInput = driver.findElement(By.id("echo"));
        WebElement ajaxSubmit = driver.findElement(By.id("formsubmit"));

        assertEquals("formResult div", formResult.getText());
        assertEquals("something to echo", echoInput.getAttribute("value"));

        ajaxSubmit.click();

        wait.until(JQUERY_IDLE);

        assertEquals("Echo : something to echo", formResult.getText());

        echoInput.clear();
        echoInput.sendKeys("userinput to echo");
        ajaxSubmit.click();

        wait.until(JQUERY_IDLE);

        assertEquals("Echo : userinput to echo", formResult.getText());
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testFormSubmitOutside(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/submit/form-outside.action");

        waitForInitialPageLoad();

        WebElement formResult = driver.findElement(By.id("formResult"));
        WebElement echoInput = driver.findElement(By.id("echo"));
        WebElement ajaxSubmit = driver.findElement(By.id("formsubmit"));

        assertEquals("formResult div", formResult.getText());
        assertEquals("something to echo", echoInput.getAttribute("value"));

        ajaxSubmit.click();

        wait.until(JQUERY_IDLE);

        assertEquals("Echo : something to echo", formResult.getText());

        echoInput.clear();
        echoInput.sendKeys("userinput to echo");
        ajaxSubmit.click();

        wait.until(JQUERY_IDLE);

        assertEquals("Echo : userinput to echo", formResult.getText());
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testFormSubmitEvents(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/submit/events.action");

        waitForInitialPageLoad();

        WebElement formResult = driver.findElement(By.id("formResult"));
        WebElement echoInput = driver.findElement(By.id("echo"));
        WebElement ajaxSubmit = driver.findElement(By.id("formsubmit"));

        assertEquals("formResult div", formResult.getText());
        assertEquals("something to echo", echoInput.getAttribute("value"));

        ajaxSubmit.click();

        wait.until(JQUERY_IDLE);

        wait.until(JQUERY_IDLE);

        WebElement ajaxeventsdiv = driver.findElement(By.id("ajaxeventsdiv"));
        assertEquals("ajax submit clickedajax submit complete", ajaxeventsdiv.getText());
        assertEquals("Echo : something to echo", formResult.getText());
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testFormSubmitListenTopics(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/submit/listen.action");

        waitForInitialPageLoad();

        WebElement result1 = driver.findElement(By.id("result1"));
        WebElement result2 = driver.findElement(By.id("result2"));
        WebElement echoInput1 = driver.findElement(By.id("echo1"));
        WebElement echoInput2 = driver.findElement(By.id("echo2"));
        WebElement ajaxSubmit1 = driver.findElement(By.id("formsubmit1"));

        assertEquals("formResult div 1", result1.getText());
        assertEquals("formResult div 2", result2.getText());
        assertEquals("firstform", echoInput1.getAttribute("value"));
        assertEquals("secondform", echoInput2.getAttribute("value"));

        ajaxSubmit1.click();

        wait.until(JQUERY_IDLE);

        assertEquals("Echo : firstform", result1.getText());
        assertEquals("Echo : secondform", result2.getText());
    }
}
