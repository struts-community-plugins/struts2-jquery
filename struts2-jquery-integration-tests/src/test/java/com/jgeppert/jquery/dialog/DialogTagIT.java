package com.jgeppert.jquery.dialog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.jgeppert.jquery.AbstractJQueryTest;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Tag("HTMLUnit")
@Tag("PhantomJS")
public class DialogTagIT extends AbstractJQueryTest {
    @ParameterizedTest
    @MethodSource("data")
    public void testLocalContent(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/dialog/localcontent.action");

        waitForInitialPageLoad();

        WebElement dialog = driver.findElement(By.xpath("//div[@role='dialog']"));
        WebElement dialogTitle = dialog.findElement(By.className("ui-dialog-title"));
        WebElement dialogCloseButton = dialog.findElement(By.className("ui-dialog-titlebar-close"));
        WebElement dialogContent = dialog.findElement(By.className("ui-dialog-content"));

        assertTrue(dialog.isDisplayed());
        assertEquals("Dialog with local content", dialogTitle.getText());
        assertEquals("This is the local content.", dialogContent.getText());

        dialogCloseButton.click();

        assertFalse(dialog.isDisplayed());
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testLocalContentOnClick(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/dialog/localcontent-onclick.action");

        waitForInitialPageLoad();

        WebElement dialogOpenLink = driver.findElement(By.id("modalOpenLink"));
        WebElement dialog = driver.findElement(By.xpath("//div[@role='dialog']"));
        WebElement dialogTitle = dialog.findElement(By.className("ui-dialog-title"));
        WebElement dialogCloseButton = dialog.findElement(By.className("ui-dialog-titlebar-close"));
        WebElement dialogContent = dialog.findElement(By.className("ui-dialog-content"));

        assertFalse(dialog.isDisplayed());

        dialogOpenLink.click();

        assertTrue(dialog.isDisplayed());
        assertEquals("Dialog with local content", dialogTitle.getText());
        assertEquals("This is the local content.", dialogContent.getText());

        dialogCloseButton.click();

        assertFalse(dialog.isDisplayed());
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testRemoteContent(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/dialog/remotecontent.action");

        waitForInitialPageLoad();

        wait.until(JQUERY_IDLE);

        WebElement dialog = driver.findElement(By.xpath("//div[@role='dialog']"));
        WebElement dialogTitle = dialog.findElement(By.className("ui-dialog-title"));
        WebElement dialogCloseButton = dialog.findElement(By.className("ui-dialog-titlebar-close"));
        WebElement dialogContent = dialog.findElement(By.className("ui-dialog-content"));

        assertTrue(dialog.isDisplayed());
        assertEquals("Dialog with remote content", dialogTitle.getText());
        assertEquals("This is simple text from an ajax call.", dialogContent.getText());

        dialogCloseButton.click();

        assertFalse(dialog.isDisplayed());
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testRemoteContentOnClick(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/dialog/remotecontent-onclick.action");

        waitForInitialPageLoad();

        WebElement dialogOpenLink = driver.findElement(By.id("modalOpenLink"));
        WebElement dialog = driver.findElement(By.xpath("//div[@role='dialog']"));
        WebElement dialogTitle = dialog.findElement(By.className("ui-dialog-title"));
        WebElement dialogCloseButton = dialog.findElement(By.className("ui-dialog-titlebar-close"));
        WebElement dialogContent = dialog.findElement(By.className("ui-dialog-content"));

        assertFalse(dialog.isDisplayed());

        dialogOpenLink.click();
        wait.until(JQUERY_IDLE);

        assertTrue(dialog.isDisplayed());
        assertEquals("Dialog with remote content", dialogTitle.getText());
        assertEquals("This is simple text from an ajax call.", dialogContent.getText());

        dialogCloseButton.click();

        assertFalse(dialog.isDisplayed());
    }
}
