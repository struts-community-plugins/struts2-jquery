package com.jgeppert.jquery.slider;

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
public class TreeTagIT {
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

    public TreeTagIT(final String baseUrl) {
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

        driver.get(baseUrl + "/tree/local.action");

        WebElement myTree = driver.findElement(By.id("myTree"));
        WebElement itemAOpenIcon = myTree.findElement(By.xpath("ul/li[1]/i"));

        Assert.assertEquals(0, myTree.findElements(By.xpath("ul/li[1]/ul")).size());
        Assert.assertEquals(0, myTree.findElements(By.xpath("ul/li[2]/ul")).size());

        itemAOpenIcon.click();

        Assert.assertTrue(myTree.findElement(By.xpath("ul/li[1]/ul/li[1]")).isDisplayed());
        Assert.assertTrue(myTree.findElement(By.xpath("ul/li[1]/ul/li[2]")).isDisplayed());
        Assert.assertEquals(0, myTree.findElements(By.xpath("ul/li[2]/ul")).size());

        itemAOpenIcon.click();

        Assert.assertEquals(0, myTree.findElements(By.xpath("ul/li[1]/ul")).size());
        Assert.assertEquals(0, myTree.findElements(By.xpath("ul/li[2]/ul")).size());
    }
}

