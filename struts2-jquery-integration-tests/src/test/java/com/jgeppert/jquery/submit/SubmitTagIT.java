package com.jgeppert.struts2.jquery.a;

import com.jgeppert.struts2.jquery.selenium.JQueryIdleCondition;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
public class SubmitTagIT {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 { "http://localhost:8080/regular" }, 
                 { "http://localhost:8080/uncompressed" },
                 { "http://localhost:8080/loadatonce" }, 
                 { "http://localhost:8080/loadfromgoogle" }  
           });
    }
    
    private static final JQueryIdleCondition JQUERY_IDLE = new JQueryIdleCondition();

    private String baseUrl;        

    public SubmitTagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Test
    public void testSimpleFormSubmit() {
        WebDriver driver = new HtmlUnitDriver(true);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/submit/simple-form.action");
        WebElement formResult = driver.findElement(By.id("formResult"));
        WebElement echoInput = driver.findElement(By.id("echo"));
        WebElement ajaxSubmit = driver.findElement(By.id("formsubmit"));

        Assert.assertEquals("formResult div", formResult.getText());
        Assert.assertEquals("something to echo", echoInput.getAttribute("value"));

        ajaxSubmit.click();

        wait.until(JQUERY_IDLE);

        Assert.assertEquals("Echo : something to echo", formResult.getText());

        echoInput.clear();
        echoInput.sendKeys("userinput to echo");
        ajaxSubmit.click();

        wait.until(JQUERY_IDLE);

        Assert.assertEquals("Echo : userinput to echo", formResult.getText());
    }

    @Test
    public void testFormSubmitOutside() {
        WebDriver driver = new HtmlUnitDriver(true);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/submit/form-outside.action");
        WebElement formResult = driver.findElement(By.id("formResult"));
        WebElement echoInput = driver.findElement(By.id("echo"));
        WebElement ajaxSubmit = driver.findElement(By.id("formsubmit"));

        Assert.assertEquals("formResult div", formResult.getText());
        Assert.assertEquals("something to echo", echoInput.getAttribute("value"));

        ajaxSubmit.click();

        wait.until(JQUERY_IDLE);

        Assert.assertEquals("Echo : something to echo", formResult.getText());

        echoInput.clear();
        echoInput.sendKeys("userinput to echo");
        ajaxSubmit.click();

        wait.until(JQUERY_IDLE);

        Assert.assertEquals("Echo : userinput to echo", formResult.getText());
    }

    @Test
    public void testFormSubmitEvents() {
        WebDriver driver = new HtmlUnitDriver(true);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/submit/events.action");
        WebElement formResult = driver.findElement(By.id("formResult"));
        WebElement echoInput = driver.findElement(By.id("echo"));
        WebElement ajaxSubmit = driver.findElement(By.id("formsubmit"));

        Assert.assertEquals("formResult div", formResult.getText());
        Assert.assertEquals("something to echo", echoInput.getAttribute("value"));

        ajaxSubmit.click();

        wait.until(JQUERY_IDLE);
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals("ajax submit clicked", alert.getText());

        alert.accept();

        wait.until(JQUERY_IDLE);
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();

        Assert.assertEquals("ajax submit complete", alert.getText());

        alert.accept();

        Assert.assertEquals("Echo : something to echo", formResult.getText());
    }
 
    @Test
    public void testFormSubmitListenTopics() {
        WebDriver driver = new HtmlUnitDriver(true);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/submit/listen.action");
        WebElement result1 = driver.findElement(By.id("result1"));
        WebElement result2 = driver.findElement(By.id("result2"));
        WebElement echoInput1 = driver.findElement(By.id("echo1"));
        WebElement echoInput2 = driver.findElement(By.id("echo2"));
        WebElement ajaxSubmit1 = driver.findElement(By.id("formsubmit1"));

        Assert.assertEquals("formResult div 1", result1.getText());
        Assert.assertEquals("formResult div 2", result2.getText());
        Assert.assertEquals("firstform", echoInput1.getAttribute("value"));
        Assert.assertEquals("secondform", echoInput2.getAttribute("value"));

        ajaxSubmit1.click();

        wait.until(JQUERY_IDLE);

        Assert.assertEquals("Echo : firstform", result1.getText());
        Assert.assertEquals("Echo : secondform", result2.getText());
    }
}

