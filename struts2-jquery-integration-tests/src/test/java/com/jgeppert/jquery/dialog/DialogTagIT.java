package com.jgeppert.jquery.dialog;

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
public class DialogTagIT extends AbstractJQueryTest {
    private String baseUrl;

    public DialogTagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Test
    public void testLocalContent() throws InterruptedException {
        driver.get(baseUrl + "/dialog/localcontent.action");

        waitForInitialPageLoad();

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
        driver.get(baseUrl + "/dialog/localcontent-onclick.action");

        waitForInitialPageLoad();

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
        driver.get(baseUrl + "/dialog/remotecontent.action");

        waitForInitialPageLoad();

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

    @Test
    public void testRemoteContentOnClick() throws InterruptedException {
        driver.get(baseUrl + "/dialog/remotecontent-onclick.action");

        waitForInitialPageLoad();

        WebElement dialogOpenLink = driver.findElement(By.id("modalOpenLink"));
        WebElement dialog = driver.findElement(By.xpath("//div[@role='dialog']"));
        WebElement dialogTitle = dialog.findElement(By.className("ui-dialog-title"));
        WebElement dialogCloseButton = dialog.findElement(By.className("ui-dialog-titlebar-close"));
        WebElement dialogContent = dialog.findElement(By.className("ui-dialog-content"));

        Assert.assertFalse(dialog.isDisplayed());

        dialogOpenLink.click();
        wait.until(JQUERY_IDLE);

        Assert.assertTrue(dialog.isDisplayed());
        Assert.assertEquals("Dialog with remote content", dialogTitle.getText());
        Assert.assertEquals("This is simple text from an ajax call.", dialogContent.getText());

        dialogCloseButton.click();

        Assert.assertFalse(dialog.isDisplayed());
    }
}
