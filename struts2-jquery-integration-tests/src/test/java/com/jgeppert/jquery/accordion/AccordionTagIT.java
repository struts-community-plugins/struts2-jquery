package com.jgeppert.jquery.accordion;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
@Category({HtmlUnitCategory.class, PhantomJSCategory.class})
public class AccordionTagIT {
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

    public AccordionTagIT(final String baseUrl) {
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

        driver.get(baseUrl + "/accordion/inlinedata.action");

        wait.until(JQUERY_NO_ANIMATIONS);

        WebElement accordionTitle1 = driver.findElement(By.id("accordionItem1"));
        WebElement accordionTitle2 = driver.findElement(By.id("accordionItem2"));
        WebElement accordionItem1 = driver.findElement(By.id("accordionItem1_div"));
        WebElement accordionItem2 = driver.findElement(By.id("accordionItem2_div"));

        Assert.assertTrue(accordionItem1.isDisplayed());
        Assert.assertFalse(accordionItem2.isDisplayed());

        accordionTitle2.click();

        wait.until(JQUERY_NO_ANIMATIONS);

        Assert.assertFalse(accordionItem1.isDisplayed());
        Assert.assertTrue(accordionItem2.isDisplayed());
    }

    @Test
    public void testHashmapData() {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/accordion/hashmap.action");

        wait.until(JQUERY_NO_ANIMATIONS);

        WebElement accordionTitle1 = driver.findElement(By.xpath("//div[@id='accordion']/h3[1]"));
        WebElement accordionTitle2 = driver.findElement(By.xpath("//div[@id='accordion']/h3[2]"));
        WebElement accordionItem1 = driver.findElement(By.xpath("//div[@id='accordion']/div[1]"));
        WebElement accordionItem2 = driver.findElement(By.xpath("//div[@id='accordion']/div[2]"));

        Assert.assertTrue(accordionItem1.isDisplayed());
        Assert.assertFalse(accordionItem2.isDisplayed());

        accordionTitle2.click();

        wait.until(JQUERY_NO_ANIMATIONS);

        Assert.assertFalse(accordionItem1.isDisplayed());
        Assert.assertTrue(accordionItem2.isDisplayed());
    }

    @Test
    public void testRemotecontentData() {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/accordion/remotecontent.action");

        wait.until(JQUERY_NO_ANIMATIONS);
        wait.until(JQUERY_IDLE);

        WebElement accordionTitle1 = driver.findElement(By.xpath("//div[@id='accordion']/h3[1]"));
        WebElement accordionTitle2 = driver.findElement(By.xpath("//div[@id='accordion']/h3[2]"));
        WebElement accordionItem1 = driver.findElement(By.xpath("//div[@id='accordion']/div[1]"));
        WebElement accordionItem2 = driver.findElement(By.xpath("//div[@id='accordion']/div[2]"));

        Assert.assertTrue(accordionItem1.isDisplayed());
        Assert.assertEquals("Echo : Content for accordion item 1", accordionItem1.getText());
        Assert.assertFalse(accordionItem2.isDisplayed());

        accordionTitle2.click();

        wait.until(JQUERY_NO_ANIMATIONS);
        wait.until(JQUERY_IDLE);

        Assert.assertFalse(accordionItem1.isDisplayed());
        Assert.assertTrue(accordionItem2.isDisplayed());
        Assert.assertEquals("Echo : Content for accordion item 2", accordionItem2.getText());
    }
}

