package com.jgeppert.jquery.radio;

import com.jgeppert.jquery.selenium.JQueryIdleCondition;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
@Category({HtmlUnitCategory.class, PhantomJSCategory.class})
public class RadioTagIT {
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
    private WebDriver driver;        

    public RadioTagIT(final String baseUrl) {
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
    public void testInlineData() {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/radio/inlinedata.action");

        wait.until(JQUERY_IDLE);

        List<WebElement> radiobuttons = driver.findElements(By.xpath("//div[@id='radiobuttonset']/input[@type='radio'][@name='day']"));

        Assert.assertEquals(7, radiobuttons.size());
    }

    @Test
    public void testRemoteListData() {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/radio/remotelist.action");

        wait.until(JQUERY_IDLE);

        List<WebElement> radiobuttons = driver.findElements(By.xpath("//div[@id='radiobuttonset']/input[@type='radio'][@name='letter']"));

        Assert.assertEquals(26, radiobuttons.size());
    }
}

