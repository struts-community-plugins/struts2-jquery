package com.jgeppert.jquery.a;

import com.jgeppert.jquery.selenium.JQueryIdleCondition;
import com.jgeppert.jquery.selenium.WebDriverFactory;
import com.jgeppert.jquery.junit.category.HtmlUnitCategory;
import com.jgeppert.jquery.junit.category.PhantomJSCategory;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
@Category({HtmlUnitCategory.class, PhantomJSCategory.class})
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
    private WebDriver driver;        

    public SubmitTagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Before
    public void before() {
        driver = WebDriverFactory.getWebDriver();
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void testSimpleFormSubmit() {
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
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/submit/events.action");
        WebElement formResult = driver.findElement(By.id("formResult"));
        WebElement echoInput = driver.findElement(By.id("echo"));
        WebElement ajaxSubmit = driver.findElement(By.id("formsubmit"));

        Assert.assertEquals("formResult div", formResult.getText());
        Assert.assertEquals("something to echo", echoInput.getAttribute("value"));

        ajaxSubmit.click();

        wait.until(JQUERY_IDLE);

        wait.until(JQUERY_IDLE);

	WebElement ajaxeventsdiv = driver.findElement(By.id("ajaxeventsdiv"));
        Assert.assertEquals("ajax submit clickedajax submit complete", ajaxeventsdiv.getText());
        Assert.assertEquals("Echo : something to echo", formResult.getText());
    }
 
    @Test
    public void testFormSubmitListenTopics() {
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

