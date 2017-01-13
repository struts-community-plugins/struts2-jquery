package com.jgeppert.struts2.jquery.dialog;

import com.jgeppert.struts2.jquery.selenium.JQueryIdleCondition;
import com.jgeppert.struts2.jquery.selenium.JQueryNoAnimations;

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
public class DialogTagIT {
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
    private static final JQueryNoAnimations JQUERY_NO_ANIMATIONS = new JQueryNoAnimations();

    private String baseUrl;        

    public DialogTagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Test
    public void testLocalContent() throws InterruptedException {
        WebDriver driver = new HtmlUnitDriver(true);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/dialog/localcontent.action");

        WebElement dialog = driver.findElement(By.xpath("//div[@role='dialog']"));
        WebElement dialogTitle = dialog.findElement(By.className("ui-dialog-title"));
        WebElement dialogCloseButton = dialog.findElement(By.className("ui-dialog-titlebar-close"));
        WebElement dialogContent = dialog.findElement(By.className("ui-dialog-content"));

        Assert.assertTrue(dialog.isDisplayed());
        Assert.assertEquals("Dialog with local content", dialogTitle.getText());
        Assert.assertEquals("This is the local content.", dialogContent.getText());

        dialogCloseButton.click();

        Assert.assertFalse(dialog.isDisplayed());
    }

    @Test
    public void testLocalContentOnClick() throws InterruptedException {
        WebDriver driver = new HtmlUnitDriver(true);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/dialog/localcontent-onclick.action");

        WebElement dialogOpenLink = driver.findElement(By.id("modalOpenLink"));
        WebElement dialog = driver.findElement(By.xpath("//div[@role='dialog']"));
        WebElement dialogTitle = dialog.findElement(By.className("ui-dialog-title"));
        WebElement dialogCloseButton = dialog.findElement(By.className("ui-dialog-titlebar-close"));
        WebElement dialogContent = dialog.findElement(By.className("ui-dialog-content"));

        Assert.assertFalse(dialog.isDisplayed());

	dialogOpenLink.click();

        Assert.assertTrue(dialog.isDisplayed());
        Assert.assertEquals("Dialog with local content", dialogTitle.getText());
        Assert.assertEquals("This is the local content.", dialogContent.getText());

        dialogCloseButton.click();

        Assert.assertFalse(dialog.isDisplayed());
    }

    @Test
    public void testRemoteContent() throws InterruptedException {
        WebDriver driver = new HtmlUnitDriver(true);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/dialog/remotecontent.action");

        wait.until(JQUERY_IDLE);

        WebElement dialog = driver.findElement(By.xpath("//div[@role='dialog']"));
        WebElement dialogTitle = dialog.findElement(By.className("ui-dialog-title"));
        WebElement dialogCloseButton = dialog.findElement(By.className("ui-dialog-titlebar-close"));
        WebElement dialogContent = dialog.findElement(By.className("ui-dialog-content"));

        Assert.assertTrue(dialog.isDisplayed());
        Assert.assertEquals("Dialog with remote content", dialogTitle.getText());
        Assert.assertEquals("This is simple text from an ajax call.", dialogContent.getText());

        dialogCloseButton.click();

        Assert.assertFalse(dialog.isDisplayed());
    }
}

