package com.jgeppert.jquery.accordion;

import com.jgeppert.jquery.AbstractJQueryTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("HTMLUnit")
@Tag("PhantomJS")
@Tag("CI-CHROME")
@Tag("CI-HTMLUnit")
public class AccordionTagIT extends AbstractJQueryTest {
    @ParameterizedTest
    @MethodSource("data")
    public void testInlineData(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/accordion/inlinedata.action");

        waitForInitialPageLoad();

        WebElement accordionTitle1 = driver.findElement(By.id("accordionItem1"));
        WebElement accordionTitle2 = waitUntilWired(By.id("accordionItem2"));
        WebElement accordionItem1 = driver.findElement(By.id("accordionItem1_div"));
        WebElement accordionItem2 = driver.findElement(By.id("accordionItem2_div"));

        assertTrue(accordionItem1.isDisplayed());
        assertFalse(accordionItem2.isDisplayed());

        accordionTitle2.click();

        // jQuery UI accordion slide animations do not complete under HtmlUnit, so the
        // collapsed panel never reaches display:none; assert on the ARIA state, which
        // jQuery UI toggles correctly regardless of animation.
        wait.until(ExpectedConditions.attributeToBe(accordionItem1, "aria-hidden", "true"));
        wait.until(ExpectedConditions.attributeToBe(accordionItem2, "aria-hidden", "false"));

        assertEquals("true", accordionItem1.getDomAttribute("aria-hidden"));
        assertEquals("false", accordionItem2.getDomAttribute("aria-hidden"));
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testHashmapData(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/accordion/hashmap.action");

        waitForInitialPageLoad();

        WebElement accordionTitle1 = driver.findElement(By.xpath("//div[@id='accordion']/h3[1]"));
        WebElement accordionTitle2 = waitUntilWired(By.xpath("//div[@id='accordion']/h3[2]"));
        WebElement accordionItem1 = driver.findElement(By.xpath("//div[@id='accordion']/div[1]"));
        WebElement accordionItem2 = driver.findElement(By.xpath("//div[@id='accordion']/div[2]"));

        assertTrue(accordionItem1.isDisplayed());
        assertFalse(accordionItem2.isDisplayed());

        accordionTitle2.click();

        // See testInlineData: assert ARIA state (animation does not complete under HtmlUnit).
        wait.until(ExpectedConditions.attributeToBe(accordionItem1, "aria-hidden", "true"));
        wait.until(ExpectedConditions.attributeToBe(accordionItem2, "aria-hidden", "false"));

        assertEquals("true", accordionItem1.getDomAttribute("aria-hidden"));
        assertEquals("false", accordionItem2.getDomAttribute("aria-hidden"));
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testRemotecontentData(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/accordion/remotecontent.action");

        waitForInitialPageLoad();

        WebElement accordionTitle1 = driver.findElement(By.xpath("//div[@id='accordion']/h3[1]"));
        WebElement accordionTitle2 = waitUntilWired(By.xpath("//div[@id='accordion']/h3[2]"));
        WebElement accordionItem1 = driver.findElement(By.xpath("//div[@id='accordion']/div[1]"));
        WebElement accordionItem2 = driver.findElement(By.xpath("//div[@id='accordion']/div[2]"));

        wait.until(ExpectedConditions.textToBePresentInElement(accordionItem1, "Echo : Content for accordion item 1"));

        assertTrue(accordionItem1.isDisplayed());
        assertEquals("Echo : Content for accordion item 1", accordionItem1.getText());
        assertFalse(accordionItem2.isDisplayed());

        accordionTitle2.click();

        // See testInlineData: assert ARIA state (animation does not complete under HtmlUnit).
        wait.until(ExpectedConditions.attributeToBe(accordionItem1, "aria-hidden", "true"));
        wait.until(ExpectedConditions.attributeToBe(accordionItem2, "aria-hidden", "false"));
        wait.until(ExpectedConditions.textToBePresentInElement(accordionItem2, "Echo : Content for accordion item 2"));

        assertEquals("true", accordionItem1.getDomAttribute("aria-hidden"));
        assertEquals("false", accordionItem2.getDomAttribute("aria-hidden"));
        assertEquals("Echo : Content for accordion item 2", accordionItem2.getText());
    }
}
