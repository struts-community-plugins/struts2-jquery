package com.jgeppert.jquery.submit;

import com.jgeppert.jquery.AbstractJQueryTest;
import com.jgeppert.jquery.junit.category.HtmlUnitCategory;
import com.jgeppert.jquery.junit.category.PhantomJSCategory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@RunWith(Parameterized.class)
@Category({ HtmlUnitCategory.class, PhantomJSCategory.class })
public class SubmitTagIT extends AbstractJQueryTest {
    private String baseUrl;

    public SubmitTagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Test
    public void testSimpleFormSubmit() throws InterruptedException {
        driver.get(baseUrl + "/submit/simple-form.action");

        waitForInitialPageLoad();

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
    public void testFormSubmitOutside() throws InterruptedException {
        driver.get(baseUrl + "/submit/form-outside.action");

        waitForInitialPageLoad();

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
    public void testFormSubmitEvents() throws InterruptedException {
        driver.get(baseUrl + "/submit/events.action");

        waitForInitialPageLoad();

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
    public void testFormSubmitListenTopics() throws InterruptedException {
        driver.get(baseUrl + "/submit/listen.action");

        waitForInitialPageLoad();

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
