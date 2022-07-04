package com.jgeppert.jquery.accordion;

import com.jgeppert.jquery.AbstractJQueryTest;
import com.jgeppert.jquery.junit.category.HtmlUnitCategory;
import com.jgeppert.jquery.junit.category.PhantomJSCategory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@RunWith(Parameterized.class)
@Category({HtmlUnitCategory.class, PhantomJSCategory.class})
public class AccordionTagIT extends AbstractJQueryTest {
    private String baseUrl;        

    public AccordionTagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Test
    public void testInlineData() throws InterruptedException {
        driver.get(baseUrl + "/accordion/inlinedata.action");

        waitForInitialPageLoad();

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
    public void testHashmapData() throws InterruptedException {
        driver.get(baseUrl + "/accordion/hashmap.action");

        waitForInitialPageLoad();

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
    public void testRemotecontentData() throws InterruptedException {
        driver.get(baseUrl + "/accordion/remotecontent.action");

        waitForInitialPageLoad();

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

