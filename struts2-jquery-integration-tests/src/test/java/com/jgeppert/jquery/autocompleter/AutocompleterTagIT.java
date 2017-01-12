package com.jgeppert.struts2.jquery.autocompleter;

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
public class AutocompleterTagIT {
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

    public AutocompleterTagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Test
    public void testListData() throws InterruptedException {
        WebDriver driver = new HtmlUnitDriver(true);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/autocompleter/list.action");

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
        WebDriver driver = new HtmlUnitDriver(true);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/autocompleter/ajaxarray.action");

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
        WebDriver driver = new HtmlUnitDriver(true);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/autocompleter/ajaxarrayinsideobject.action");

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
        WebDriver driver = new HtmlUnitDriver(true);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/autocompleter/ajaxmapinsideobject.action");

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
        WebDriver driver = new HtmlUnitDriver(true);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/autocompleter/ajaxobjectsinsideobject.action");

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

