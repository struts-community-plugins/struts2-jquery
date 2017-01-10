package com.jgeppert.struts2.jquery.select;

import com.jgeppert.struts2.jquery.selenium.JQueryIdleCondition;

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
public class SelectTagIT {
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

    private String baseUrl;        

    public SelectTagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Test
    public void testStringlistData() {
        WebDriver driver = new HtmlUnitDriver(true);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/select/stringlist.action");

        wait.until(JQUERY_IDLE);

	WebElement selectElement = driver.findElement(By.id("myselect"));
        List<WebElement> options = selectElement.findElements(By.tagName("option"));

        Assert.assertEquals("letter", selectElement.getAttribute("name"));
        Assert.assertEquals(26, options.size());
	Assert.assertEquals("a", options.get(0).getText());
	Assert.assertEquals("a", options.get(0).getAttribute("value"));
	Assert.assertEquals("z", options.get(25).getText());
	Assert.assertEquals("z", options.get(25).getAttribute("value"));
    }

    @Test
    public void testMapData() {
        WebDriver driver = new HtmlUnitDriver(true);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/select/map.action");

        wait.until(JQUERY_IDLE);

	WebElement selectElement = driver.findElement(By.id("myselect"));
        List<WebElement> options = selectElement.findElements(By.tagName("option"));

        Assert.assertEquals("letter", selectElement.getAttribute("name"));
        Assert.assertEquals(26, options.size());
	Assert.assertEquals("a", options.get(0).getText());
	Assert.assertEquals("97", options.get(0).getAttribute("value"));
	Assert.assertEquals("z", options.get(25).getText());
	Assert.assertEquals("122", options.get(25).getAttribute("value"));
    }
}

