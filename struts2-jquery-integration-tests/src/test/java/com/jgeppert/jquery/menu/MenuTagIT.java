package com.jgeppert.jquery.menu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.jgeppert.jquery.AbstractJQueryTest;

import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Tag("HTMLUnit")
@Tag("PhantomJS")
@Tag("CI-HTMLUnit")
public class MenuTagIT extends AbstractJQueryTest{
    @ParameterizedTest
    @MethodSource("data")
    public void testLocalContent(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/menu/localcontent.action");
        
        waitForInitialPageLoad();

        WebElement menuItemWithSubMenu = driver.findElement(By.id("menuItem2"));
        WebElement submenu = driver.findElement(By.id("mySubmenu"));
        WebElement submenuItemWithAjaxLink = driver.findElement(By.id("submenuItem2"));
        WebElement resultDiv = driver.findElement(By.id("resultDiv"));

        assertFalse(submenu.isDisplayed());
        assertEquals("This is the result div.", resultDiv.getText());

        (new Actions(driver)).moveToElement(menuItemWithSubMenu).build().perform();
        wait.until(ExpectedConditions.visibilityOf(submenu));

        assertTrue(submenu.isDisplayed());
        assertEquals("This is the result div.", resultDiv.getText());

        (new Actions(driver)).moveToElement(submenuItemWithAjaxLink).click().build().perform();

        wait.until(JQUERY_IDLE);

        assertEquals("This is simple text from an ajax call.", resultDiv.getText());
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testLocalContentList(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/menu/localcontent-list.action");
        
        waitForInitialPageLoad();

        WebElement menu = driver.findElement(By.id("myMenu"));
        List<WebElement> menuItems = menu.findElements(By.tagName("li"));
        WebElement item2Link = menuItems.get(1).findElement(By.tagName("a"));
        WebElement resultDiv = driver.findElement(By.id("resultDiv"));

        assertEquals(3, menuItems.size());
        assertEquals("This is the result div.", resultDiv.getText());

        item2Link.click();

        wait.until(JQUERY_IDLE);

        assertEquals("Echo : Item 2", resultDiv.getText());
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testLocalContentMap(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/menu/localcontent-map.action");
        
        waitForInitialPageLoad();

        WebElement menu = driver.findElement(By.id("myMenu"));
        List<WebElement> menuItems = menu.findElements(By.tagName("li"));
        WebElement item2Link = menuItems.get(1).findElement(By.tagName("a"));
        WebElement resultDiv = driver.findElement(By.id("resultDiv"));

        assertEquals(3, menuItems.size());
        assertEquals("This is the result div.", resultDiv.getText());

        item2Link.click();

        wait.until(JQUERY_IDLE);

        assertEquals("Echo : 2", resultDiv.getText());
    }
}

