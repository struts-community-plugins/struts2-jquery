package com.jgeppert.jquery.tabbedpanel;

import com.jgeppert.jquery.selenium.JQueryIdleCondition;
import com.jgeppert.jquery.selenium.JQueryNoAnimations;
import com.jgeppert.jquery.selenium.WebDriverFactory;
import com.jgeppert.jquery.junit.category.HtmlUnitCategory;
import com.jgeppert.jquery.junit.category.PhantomJSCategory;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
@Category({PhantomJSCategory.class, HtmlUnitCategory.class})
public class TabbedpanelTagIT {
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
    private WebDriver driver;        

    public TabbedpanelTagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Before
    public void before() {
        driver = WebDriverFactory.getWebDriver();
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void testLocal() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/tabbedpanel/local.action");

        WebElement tab1Link = driver.findElement(By.id("tab1")).findElement(By.tagName("a"));
        WebElement tab2Link = driver.findElement(By.id("tab2")).findElement(By.tagName("a"));
        WebElement tabcontent1 = driver.findElement(By.id("tabcontent1"));
        WebElement tabcontent2 = driver.findElement(By.id("tabcontent2"));

        Assert.assertTrue(tabcontent1.isDisplayed());
        Assert.assertFalse(tabcontent2.isDisplayed());

        tab2Link.click();

        Assert.assertFalse(tabcontent1.isDisplayed());
        Assert.assertTrue(tabcontent2.isDisplayed());

        tab1Link.click();

        Assert.assertTrue(tabcontent1.isDisplayed());
        Assert.assertFalse(tabcontent2.isDisplayed());
    }

    @Test
    public void testRemote() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/tabbedpanel/remote.action");

        WebElement tab1 = driver.findElement(By.id("tab1"));
        WebElement tab2 = driver.findElement(By.id("tab2"));
        WebElement tab1Link = tab1.findElement(By.tagName("a"));
        WebElement tab2Link = tab2.findElement(By.tagName("a"));
        WebElement tabcontent1 = driver.findElement(By.id(tab1.getAttribute("aria-controls")));
        WebElement tabcontent2 = driver.findElement(By.id(tab2.getAttribute("aria-controls")));

	wait.until(JQUERY_IDLE);

        Assert.assertTrue(tabcontent1.isDisplayed());
        Assert.assertFalse(tabcontent2.isDisplayed());
        Assert.assertEquals("This is simple text from an ajax call.", tabcontent1.getText());

        tab2Link.click();
	wait.until(JQUERY_IDLE);

        Assert.assertFalse(tabcontent1.isDisplayed());
        Assert.assertTrue(tabcontent2.isDisplayed());
        Assert.assertEquals("Echo : something to echo", tabcontent2.getText());

        tab1Link.click();
	wait.until(JQUERY_IDLE);

        Assert.assertTrue(tabcontent1.isDisplayed());
        Assert.assertFalse(tabcontent2.isDisplayed());
    }
}

