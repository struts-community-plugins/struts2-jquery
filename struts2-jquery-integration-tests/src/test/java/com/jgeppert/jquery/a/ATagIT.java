package com.jgeppert.jquery.a;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jgeppert.jquery.AbstractJQueryTest;

import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Tag("HTMLUnit")
@Tag("PhantomJS")
public class ATagIT extends AbstractJQueryTest{
    @ParameterizedTest
    @MethodSource("data")
    public void testSimpleAjaxPageLink(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/a/simple-ajax-link.action");
        
        waitForInitialPageLoad();

        WebElement resultDiv = driver.findElement(By.id("result"));
        WebElement ajaxlink = driver.findElement(By.id("ajaxlink"));

        assertEquals("Click on the link bellow.", resultDiv.getText());
        ajaxlink.click();

        wait.until(JQUERY_IDLE);

        assertEquals("This is simple text from an ajax call.", resultDiv.getText());
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testMultipleTargets(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/a/multiple-targets.action");
        
        waitForInitialPageLoad();
        
        WebElement div1 = driver.findElement(By.id("div1"));
        WebElement div2 = driver.findElement(By.id("div2"));
        WebElement ajaxLink = driver.findElement(By.id("ajaxlink"));

        assertEquals("Div 1", div1.getText());
        assertEquals("Div 2", div2.getText());

        ajaxLink.click();

        wait.until(JQUERY_IDLE);

        assertEquals("This is simple text from an ajax call.", div1.getText());
        assertEquals("This is simple text from an ajax call.", div2.getText());
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testFormSubmit(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/a/form-submit.action");
        
        waitForInitialPageLoad();
        
        WebElement formResult = driver.findElement(By.id("formResult"));
        WebElement echoInput = driver.findElement(By.id("echo"));
        WebElement ajaxFormLink = driver.findElement(By.id("ajaxformlink"));

        assertEquals("formResult div", formResult.getText());
        assertEquals("something to echo", echoInput.getAttribute("value"));

        ajaxFormLink.click();

        wait.until(JQUERY_IDLE);

        assertEquals("Echo : something to echo", formResult.getText());
        assertEquals("", echoInput.getAttribute("value"));

        echoInput.sendKeys("userinput to echo");
        ajaxFormLink.click();

        wait.until(JQUERY_IDLE);

        assertEquals("Echo : userinput to echo", formResult.getText());
        assertEquals("", echoInput.getAttribute("value"));
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testEvents(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/a/events.action");
        
        waitForInitialPageLoad();
        
        WebElement result = driver.findElement(By.id("result"));
        WebElement ajaxLink = driver.findElement(By.id("ajaxlink"));

        assertEquals("result div", result.getText());

        ajaxLink.click();

        wait.until(JQUERY_IDLE);

        WebElement ajaxeventsdiv = driver.findElement(By.id("ajaxeventsdiv"));
        assertEquals("ajax link clickedajax link complete", ajaxeventsdiv.getText());
        assertEquals("This is simple text from an ajax call.", result.getText());
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testJsonResult(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/a/json-result.action");
        
        waitForInitialPageLoad();
        
        WebElement result = driver.findElement(By.id("result"));
        WebElement ajaxJsonLink = driver.findElement(By.id("ajaxjsonlink"));

        assertEquals("result div", result.getText());

        ajaxJsonLink.click();
        wait.until(JQUERY_IDLE);

        WebElement lettersList = result.findElement(By.id("lettersList"));
        List<WebElement> listItems = lettersList.findElements(By.tagName("li"));

        assertEquals(26, listItems.size());
        assertEquals("a", listItems.get(0).getText());
        assertEquals("z", listItems.get(25).getText());
    }
}
