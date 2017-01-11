package com.jgeppert.struts2.jquery.accordion;

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

    public AccordionTagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Test
    public void testInlineData() {
        WebDriver driver = new HtmlUnitDriver(true);
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
        WebDriver driver = new HtmlUnitDriver(true);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/accordion/hashmap.action");

        wait.until(JQUERY_NO_ANIMATIONS);
        wait.until(JQUERY_IDLE);

        WebElement accordionTitle1 = driver.findElement(By.xpath("//div[@id='accordion']/h3[1]"));
        WebElement accordionTitle2 = driver.findElement(By.xpath("//div[@id='accordion']/h3[2]"));
        WebElement accordionItem1 = driver.findElement(By.xpath("//div[@id='accordion']/div[1]"));
        WebElement accordionItem2 = driver.findElement(By.xpath("//div[@id='accordion']/div[2]"));

        Assert.assertTrue(accordionItem1.isDisplayed());
        Assert.assertFalse(accordionItem2.isDisplayed());

        accordionTitle2.click();

        wait.until(JQUERY_NO_ANIMATIONS);
        wait.until(JQUERY_IDLE);

        Assert.assertFalse(accordionItem1.isDisplayed());
        Assert.assertTrue(accordionItem2.isDisplayed());
    }

    @Test
    public void testRemotecontentData() {
        WebDriver driver = new HtmlUnitDriver(true);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/accordion/remotecontent.action");

        wait.until(JQUERY_NO_ANIMATIONS);

        WebElement accordionTitle1 = driver.findElement(By.xpath("//div[@id='accordion']/h3[1]"));
        WebElement accordionTitle2 = driver.findElement(By.xpath("//div[@id='accordion']/h3[2]"));
        WebElement accordionItem1 = driver.findElement(By.xpath("//div[@id='accordion']/div[1]"));
        WebElement accordionItem2 = driver.findElement(By.xpath("//div[@id='accordion']/div[2]"));

        Assert.assertTrue(accordionItem1.isDisplayed());
        Assert.assertEquals("Echo : Content for accordion item 1", accordionItem1.getText());
        Assert.assertFalse(accordionItem2.isDisplayed());

        accordionTitle2.click();

        wait.until(JQUERY_NO_ANIMATIONS);

        Assert.assertFalse(accordionItem1.isDisplayed());
        Assert.assertTrue(accordionItem2.isDisplayed());
        Assert.assertEquals("Echo : Content for accordion item 2", accordionItem2.getText());
    }
}

