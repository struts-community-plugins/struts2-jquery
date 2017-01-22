package com.jgeppert.jquery.div;

import com.jgeppert.jquery.selenium.JQueryIdleCondition;
import com.jgeppert.jquery.selenium.WebDriverFactory;
import com.jgeppert.jquery.junit.category.HtmlUnitCategory;
import com.jgeppert.jquery.junit.category.PhantomJSCategory;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
@Category({HtmlUnitCategory.class})
public class DivTagIT {
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

    public DivTagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Test
    @Category({PhantomJSCategory.class})
    public void testAjaxDiv() {
        WebDriver driver = WebDriverFactory.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/div/ajax-div.action");
        WebElement ajaxDiv = driver.findElement(By.id("ajaxdiv"));

        wait.until(JQUERY_IDLE);
	
        Assert.assertEquals("This is simple text from an ajax call.", ajaxDiv.getText());
    }

    @Test
    public void testEvents() {
        WebDriver driver = WebDriverFactory.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/div/events.action");
        WebElement ajaxDiv = driver.findElement(By.id("ajaxdiv"));

        wait.until(JQUERY_IDLE);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        Assert.assertEquals("Before div", alert.getText());

        alert.accept();

        wait.until(JQUERY_IDLE);
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();

        Assert.assertEquals("Complete div", alert.getText());

        alert.accept();

        Assert.assertEquals("This is simple text from an ajax call.", ajaxDiv.getText());
    }

    @Test
    @Category({PhantomJSCategory.class})
    public void testListenTopics() {
        WebDriver driver = WebDriverFactory.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/div/listen-topics.action");
        WebElement ajaxDiv = driver.findElement(By.id("ajaxdiv"));
        WebElement topicsLink = driver.findElement(By.id("topicslink"));
	
        Assert.assertEquals("ajax div", ajaxDiv.getText());

	topicsLink.click();
        wait.until(JQUERY_IDLE);

        Assert.assertEquals("This is simple text from an ajax call.", ajaxDiv.getText());
    }
}

