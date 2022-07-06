package com.jgeppert.jquery.accordion;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jgeppert.jquery.AbstractJQueryTest;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Disabled
@Tag("HTMLUnit")
@Tag("PhantomJS")
public class AccordionTagIT extends AbstractJQueryTest {
    @ParameterizedTest
    @MethodSource("data")
    public void testInlineData(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/accordion/inlinedata.action");

        waitForInitialPageLoad();

        WebElement accordionTitle1 = driver.findElement(By.id("accordionItem1"));
        WebElement accordionTitle2 = driver.findElement(By.id("accordionItem2"));
        WebElement accordionItem1 = driver.findElement(By.id("accordionItem1_div"));
        WebElement accordionItem2 = driver.findElement(By.id("accordionItem2_div"));

        assertTrue(accordionItem1.isDisplayed());
        assertFalse(accordionItem2.isDisplayed());

        accordionTitle2.click();

        wait.until(JQUERY_NO_ANIMATIONS);

        assertFalse(accordionItem1.isDisplayed());
        assertTrue(accordionItem2.isDisplayed());
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testHashmapData(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/accordion/hashmap.action");

        waitForInitialPageLoad();

        WebElement accordionTitle1 = driver.findElement(By.xpath("//div[@id='accordion']/h3[1]"));
        WebElement accordionTitle2 = driver.findElement(By.xpath("//div[@id='accordion']/h3[2]"));
        WebElement accordionItem1 = driver.findElement(By.xpath("//div[@id='accordion']/div[1]"));
        WebElement accordionItem2 = driver.findElement(By.xpath("//div[@id='accordion']/div[2]"));

        assertTrue(accordionItem1.isDisplayed());
        assertFalse(accordionItem2.isDisplayed());

        accordionTitle2.click();

        wait.until(JQUERY_NO_ANIMATIONS);

        assertFalse(accordionItem1.isDisplayed());
        assertTrue(accordionItem2.isDisplayed());
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testRemotecontentData(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/accordion/remotecontent.action");

        waitForInitialPageLoad();

        WebElement accordionTitle1 = driver.findElement(By.xpath("//div[@id='accordion']/h3[1]"));
        WebElement accordionTitle2 = driver.findElement(By.xpath("//div[@id='accordion']/h3[2]"));
        WebElement accordionItem1 = driver.findElement(By.xpath("//div[@id='accordion']/div[1]"));
        WebElement accordionItem2 = driver.findElement(By.xpath("//div[@id='accordion']/div[2]"));

        assertTrue(accordionItem1.isDisplayed());
        assertEquals("Echo : Content for accordion item 1", accordionItem1.getText());
        assertFalse(accordionItem2.isDisplayed());

        accordionTitle2.click();

        wait.until(JQUERY_NO_ANIMATIONS);
        wait.until(JQUERY_IDLE);

        assertFalse(accordionItem1.isDisplayed());
        assertTrue(accordionItem2.isDisplayed());
        assertEquals("Echo : Content for accordion item 2", accordionItem2.getText());
    }
}
