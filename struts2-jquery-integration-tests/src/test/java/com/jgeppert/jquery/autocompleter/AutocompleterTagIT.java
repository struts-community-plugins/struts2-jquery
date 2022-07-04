package com.jgeppert.jquery.autocompleter;

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
public class AutocompleterTagIT extends AbstractJQueryTest {
    private String baseUrl;

    public AutocompleterTagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Test
    public void testListData() throws InterruptedException {
        driver.get(baseUrl + "/autocompleter/list.action");

        waitForInitialPageLoad();

        WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));

        autocompleteInputWidget.sendKeys("j");
        Thread.sleep(1000);
        Assert.assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        Thread.sleep(1000);
        Assert.assertEquals(2, driver.findElements(By.tagName("li")).size());

        driver.findElements(By.tagName("li")).get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals("June", autocompleteInput.getAttribute("value"));
    }

    @Test
    public void testAjaxArray() throws InterruptedException {
        driver.get(baseUrl + "/autocompleter/ajaxarray.action");
        
        waitForInitialPageLoad();

        WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));

        autocompleteInputWidget.sendKeys("j");
        Thread.sleep(1000);
        Assert.assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        Thread.sleep(1000);
        Assert.assertEquals(2, driver.findElements(By.tagName("li")).size());

        driver.findElements(By.tagName("li")).get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals("June", autocompleteInput.getAttribute("value"));
    }

    @Test
    public void testAjaxArrayInsideObject() throws InterruptedException {
        driver.get(baseUrl + "/autocompleter/ajaxarrayinsideobject.action");
        
        waitForInitialPageLoad();

        WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));

        autocompleteInputWidget.sendKeys("j");
        Thread.sleep(1000);
        Assert.assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        Thread.sleep(1000);
        Assert.assertEquals(2, driver.findElements(By.tagName("li")).size());

        driver.findElements(By.tagName("li")).get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals("June", autocompleteInput.getAttribute("value"));
    }

    @Test
    public void testAjaxMapInsideObject() throws InterruptedException {
        driver.get(baseUrl + "/autocompleter/ajaxmapinsideobject.action");
        
        waitForInitialPageLoad();

        WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));

        autocompleteInputWidget.sendKeys("j");
        Thread.sleep(1000);
        Assert.assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        Thread.sleep(1000);
        Assert.assertEquals(2, driver.findElements(By.tagName("li")).size());

        driver.findElements(By.tagName("li")).get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals("6", autocompleteInput.getAttribute("value"));
    }

    @Test
    public void testAjaxObjectsInsideObject() throws InterruptedException {
        driver.get(baseUrl + "/autocompleter/ajaxobjectsinsideobject.action");
        
        waitForInitialPageLoad();

        WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));

        autocompleteInputWidget.sendKeys("j");
        Thread.sleep(1000);
        Assert.assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        Thread.sleep(1000);
        Assert.assertEquals(2, driver.findElements(By.tagName("li")).size());

        driver.findElements(By.tagName("li")).get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals("6", autocompleteInput.getAttribute("value"));
    }
}
