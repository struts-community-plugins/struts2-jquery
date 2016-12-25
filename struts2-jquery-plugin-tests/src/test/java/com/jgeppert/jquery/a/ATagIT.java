package com.jgeppert.struts2.jquery.a;

import com.jgeppert.struts2.jquery.selenium.JQueryIdleCondition;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
public class ATagIT {
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

    public ATagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Test
    public void testSimpleAjaxPageLink() {
        WebDriver driver = new HtmlUnitDriver(true);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/a/simple-ajax-link.action");
        WebElement resultDiv = driver.findElement(By.id("result"));
        WebElement ajaxlink = driver.findElement(By.id("ajaxlink"));
	
        Assert.assertEquals("Click on the link bellow.", resultDiv.getText());
        ajaxlink.click();

        wait.until(JQUERY_IDLE);

        Assert.assertEquals("This is simple text from an ajax call.", resultDiv.getText());
    }
    
    @Test
    public void testMultipleTargets() {
        WebDriver driver = new HtmlUnitDriver(true);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/a/multiple-targets.action");
        WebElement div1 = driver.findElement(By.id("div1"));
        WebElement div2 = driver.findElement(By.id("div2"));
        WebElement ajaxLink = driver.findElement(By.id("ajaxlink"));

        Assert.assertEquals("Div 1", div1.getText());
        Assert.assertEquals("Div 2", div2.getText());

        ajaxLink.click();

        wait.until(JQUERY_IDLE);

        Assert.assertEquals("This is simple text from an ajax call.", div1.getText());
        Assert.assertEquals("This is simple text from an ajax call.", div2.getText());
    }

    @Test
    public void testFormSubmit() {
        WebDriver driver = new HtmlUnitDriver(true);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/a/form-submit.action");
        WebElement formResult = driver.findElement(By.id("formResult"));
        WebElement echoInput = driver.findElement(By.id("echo"));
        WebElement ajaxFormLink = driver.findElement(By.id("ajaxformlink"));

        Assert.assertEquals("formResult div", formResult.getText());
        Assert.assertEquals("something to echo", echoInput.getAttribute("value"));

        ajaxFormLink.click();

        wait.until(JQUERY_IDLE);

        Assert.assertEquals("Echo : something to echo", formResult.getText());
        Assert.assertEquals("", echoInput.getAttribute("value"));

        echoInput.sendKeys("userinput to echo");
        ajaxFormLink.click();

        wait.until(JQUERY_IDLE);

        Assert.assertEquals("Echo : userinput to echo", formResult.getText());
        Assert.assertEquals("", echoInput.getAttribute("value"));
    }
}

