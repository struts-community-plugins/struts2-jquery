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
    private WebDriver driver;        

    public ATagIT(final String baseUrl) {
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
    public void testSimpleAjaxPageLink() {
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

    @Test
    public void testEvents() {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/a/events.action");
        WebElement result = driver.findElement(By.id("result"));
        WebElement ajaxLink = driver.findElement(By.id("ajaxlink"));

        Assert.assertEquals("result div", result.getText());

        ajaxLink.click();

        wait.until(JQUERY_IDLE);

	WebElement ajaxeventsdiv = driver.findElement(By.id("ajaxeventsdiv"));
        Assert.assertEquals("ajax link clickedajax link complete", ajaxeventsdiv.getText());
        Assert.assertEquals("This is simple text from an ajax call.", result.getText());
    }

    @Test
    public void testJsonResult() {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/a/json-result.action");
        WebElement result = driver.findElement(By.id("result"));
        WebElement ajaxJsonLink = driver.findElement(By.id("ajaxjsonlink"));

        Assert.assertEquals("result div", result.getText());

        ajaxJsonLink.click();
        wait.until(JQUERY_IDLE);

        WebElement lettersList = result.findElement(By.id("lettersList"));
        List<WebElement> listItems = lettersList.findElements(By.tagName("li"));

        Assert.assertEquals(26, listItems.size());
        Assert.assertEquals("a", listItems.get(0).getText());
        Assert.assertEquals("z", listItems.get(25).getText());
    }
}

