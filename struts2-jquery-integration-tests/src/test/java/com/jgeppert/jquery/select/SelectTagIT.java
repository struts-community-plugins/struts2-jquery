package com.jgeppert.jquery.select;

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

@RunWith(Parameterized.class)
@Category({HtmlUnitCategory.class, PhantomJSCategory.class})
public class SelectTagIT extends AbstractJQueryTest {
    private String baseUrl;    
    
    public SelectTagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Test
    public void testStringlistData() throws InterruptedException {
        driver.get(baseUrl + "/select/stringlist.action");

        waitForInitialPageLoad();

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
    public void testMapData() throws InterruptedException {
        driver.get(baseUrl + "/select/map.action");

        waitForInitialPageLoad();

        WebElement selectElement = driver.findElement(By.id("myselect"));
        List<WebElement> options = selectElement.findElements(By.tagName("option"));

        Assert.assertEquals("letter", selectElement.getAttribute("name"));
        Assert.assertEquals(26, options.size());
        Assert.assertEquals("a", options.get(0).getText());
        Assert.assertEquals("97", options.get(0).getAttribute("value"));
        Assert.assertEquals("z", options.get(25).getText());
        Assert.assertEquals("122", options.get(25).getAttribute("value"));
    }

    @Test
    public void testObjectListData() throws InterruptedException {
        driver.get(baseUrl + "/select/objectlist.action");

        waitForInitialPageLoad();
        
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

