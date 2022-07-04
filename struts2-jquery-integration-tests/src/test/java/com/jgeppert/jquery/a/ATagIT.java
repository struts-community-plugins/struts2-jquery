package com.jgeppert.jquery.a;

import com.jgeppert.jquery.AbstractJQueryTest;
import com.jgeppert.jquery.junit.category.HtmlUnitCategory;
import com.jgeppert.jquery.junit.category.PhantomJSCategory;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@RunWith(Parameterized.class)
@Category({ HtmlUnitCategory.class, PhantomJSCategory.class })
public class ATagIT extends AbstractJQueryTest{
    private String baseUrl;

    public ATagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Test
    public void testSimpleAjaxPageLink() throws InterruptedException {
        driver.get(baseUrl + "/a/simple-ajax-link.action");
        
        waitForInitialPageLoad();

        WebElement resultDiv = driver.findElement(By.id("result"));
        WebElement ajaxlink = driver.findElement(By.id("ajaxlink"));

        Assert.assertEquals("Click on the link bellow.", resultDiv.getText());
        ajaxlink.click();

        wait.until(JQUERY_IDLE);

        Assert.assertEquals("This is simple text from an ajax call.", resultDiv.getText());
    }

    @Test
    public void testMultipleTargets() throws InterruptedException {
        driver.get(baseUrl + "/a/multiple-targets.action");
        
        waitForInitialPageLoad();
        
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
    public void testFormSubmit() throws InterruptedException {
        driver.get(baseUrl + "/a/form-submit.action");
        
        waitForInitialPageLoad();
        
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
    public void testEvents() throws InterruptedException {
        driver.get(baseUrl + "/a/events.action");
        
        waitForInitialPageLoad();
        
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
    public void testJsonResult() throws InterruptedException {
        driver.get(baseUrl + "/a/json-result.action");
        
        waitForInitialPageLoad();
        
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
