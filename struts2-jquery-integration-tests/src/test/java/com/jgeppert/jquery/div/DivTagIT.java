package com.jgeppert.jquery.div;

import com.jgeppert.jquery.AbstractJQueryTest;
import com.jgeppert.jquery.junit.category.HtmlUnitCategory;
import com.jgeppert.jquery.junit.category.PhantomJSCategory;


import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@RunWith(Parameterized.class)
@Category({ HtmlUnitCategory.class })
public class DivTagIT extends AbstractJQueryTest {
    private String baseUrl;

    public DivTagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Test
    @Category({ PhantomJSCategory.class })
    public void testAjaxDiv() throws InterruptedException {
        driver.get(baseUrl + "/div/ajax-div.action");

        waitForInitialPageLoad();

        WebElement ajaxDiv = driver.findElement(By.id("ajaxdiv"));

        wait.until(JQUERY_IDLE);

        Assert.assertEquals("This is simple text from an ajax call.", ajaxDiv.getText());
    }

    @Test
    public void testEvents() throws InterruptedException {
        driver.get(baseUrl + "/div/events.action");

        Thread.sleep(100);
        wait.until(DOCUMENT_READY);
        wait.until(JQUERY_DEFINED);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals("Before div", alert.getText());

        alert.accept();

        alert = wait.until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals("Complete div", alert.getText());

        alert.accept();

        WebElement ajaxDiv = driver.findElement(By.id("ajaxdiv"));

        Assert.assertEquals("This is simple text from an ajax call.", ajaxDiv.getText());
    }

    @Test
    @Category({ PhantomJSCategory.class })
    public void testListenTopics() throws InterruptedException {
        driver.get(baseUrl + "/div/listen-topics.action");

        waitForInitialPageLoad();

        WebElement ajaxDiv = driver.findElement(By.id("ajaxdiv"));
        WebElement topicsLink = driver.findElement(By.id("topicslink"));

        Assert.assertEquals("ajax div", ajaxDiv.getText());

        topicsLink.click();
        wait.until(JQUERY_IDLE);

        Assert.assertEquals("This is simple text from an ajax call.", ajaxDiv.getText());
    }
}
