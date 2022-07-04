package com.jgeppert.jquery.menu;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

@RunWith(Parameterized.class)
@Category({HtmlUnitCategory.class, PhantomJSCategory.class})
public class MenuTagIT extends AbstractJQueryTest{
    private String baseUrl;        

    public MenuTagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Test
    public void testLocalContent() throws InterruptedException {
        driver.get(baseUrl + "/menu/localcontent.action");
        
        waitForInitialPageLoad();

        WebElement menuItemWithSubMenu = driver.findElement(By.id("menuItem2"));
        WebElement submenu = driver.findElement(By.id("mySubmenu"));
        WebElement submenuItemWithAjaxLink = driver.findElement(By.id("submenuItem2"));
        WebElement resultDiv = driver.findElement(By.id("resultDiv"));

        Assert.assertFalse(submenu.isDisplayed());
        Assert.assertEquals("This is the result div.", resultDiv.getText());

        (new Actions(driver)).moveToElement(menuItemWithSubMenu).build().perform();
        wait.until(ExpectedConditions.visibilityOf(submenu));

        Assert.assertTrue(submenu.isDisplayed());
        Assert.assertEquals("This is the result div.", resultDiv.getText());

        (new Actions(driver)).moveToElement(submenuItemWithAjaxLink).click().build().perform();

        wait.until(JQUERY_IDLE);

        Assert.assertEquals("This is simple text from an ajax call.", resultDiv.getText());
    }

    @Test
    public void testLocalContentList() throws InterruptedException {
        driver.get(baseUrl + "/menu/localcontent-list.action");
        
        waitForInitialPageLoad();

        WebElement menu = driver.findElement(By.id("myMenu"));
        List<WebElement> menuItems = menu.findElements(By.tagName("li"));
        WebElement item2Link = menuItems.get(1).findElement(By.tagName("a"));
        WebElement resultDiv = driver.findElement(By.id("resultDiv"));

        Assert.assertEquals(3, menuItems.size());
        Assert.assertEquals("This is the result div.", resultDiv.getText());

        item2Link.click();

        wait.until(JQUERY_IDLE);

        Assert.assertEquals("Echo : Item 2", resultDiv.getText());
    }

    @Test
    public void testLocalContentMap() throws InterruptedException {
        driver.get(baseUrl + "/menu/localcontent-map.action");
        
        waitForInitialPageLoad();

        WebElement menu = driver.findElement(By.id("myMenu"));
        List<WebElement> menuItems = menu.findElements(By.tagName("li"));
        WebElement item2Link = menuItems.get(1).findElement(By.tagName("a"));
        WebElement resultDiv = driver.findElement(By.id("resultDiv"));

        Assert.assertEquals(3, menuItems.size());
        Assert.assertEquals("This is the result div.", resultDiv.getText());

        item2Link.click();

        wait.until(JQUERY_IDLE);

        Assert.assertEquals("Echo : 2", resultDiv.getText());
    }
}

