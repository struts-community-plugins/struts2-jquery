package com.jgeppert.jquery.progressbar;

import com.jgeppert.jquery.selenium.JQueryIdleCondition;
import com.jgeppert.jquery.selenium.JQueryNoAnimations;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
@Category({HtmlUnitCategory.class})
public class ProgressbarTagIT {
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

    public ProgressbarTagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Test
    @Category({PhantomJSCategory.class})
    public void testLocal() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/progressbar/local.action");

        WebElement progressbar = driver.findElement(By.id("myProgressbar"));
        WebElement progressbarValueDiv = progressbar.findElement(By.className("ui-progressbar-value"));

        Assert.assertEquals("width: 42%;", progressbarValueDiv.getAttribute("style").trim());
    }

    @Test
    public void testLocalEvents() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/progressbar/local-events.action");

        WebElement progressbar = driver.findElement(By.id("myProgressbar"));
        WebElement progressbarValueDiv = progressbar.findElement(By.className("ui-progressbar-value"));
        WebElement button = driver.findElement(By.id("myButton"));

        Assert.assertEquals("width: 42%;", progressbarValueDiv.getAttribute("style").trim());

        button.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        Assert.assertEquals("value changed to : 84", alert.getText());

        alert.accept();

        Assert.assertEquals("width: 84%;", progressbarValueDiv.getAttribute("style"));
    }
}

