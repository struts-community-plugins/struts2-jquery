package com.jgeppert.jquery.progressbar;

import com.jgeppert.jquery.AbstractJQueryTest;
import com.jgeppert.jquery.junit.category.HtmlUnitCategory;
import com.jgeppert.jquery.junit.category.PhantomJSCategory;


import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@RunWith(Parameterized.class)
@Category({HtmlUnitCategory.class})
public class ProgressbarTagIT extends AbstractJQueryTest {
    private String baseUrl;        

    public ProgressbarTagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Test
    @Category({PhantomJSCategory.class})
    public void testLocal() throws InterruptedException {
        driver.get(baseUrl + "/progressbar/local.action");
        
        waitForInitialPageLoad();

        WebElement progressbar = driver.findElement(By.id("myProgressbar"));
        WebElement progressbarValueDiv = progressbar.findElement(By.className("ui-progressbar-value"));

        Assert.assertEquals("width: 42%;", progressbarValueDiv.getAttribute("style").trim());
    }

    @Test
    public void testLocalEvents() throws InterruptedException {
        driver.get(baseUrl + "/progressbar/local-events.action");
        
        waitForInitialPageLoad();

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

