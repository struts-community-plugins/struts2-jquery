package com.jgeppert.jquery.checkboxlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.jgeppert.jquery.AbstractJQueryTest;


@Tag("HTMLUnit")
@Tag("PhantomJS")
public class CheckboxlistTagIT extends AbstractJQueryTest {
    @ParameterizedTest
    @MethodSource("data")
    public void testInlineData(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/checkboxlist/inlinedata.action");

        waitForInitialPageLoad();

        List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@id='checkboxbuttonset']/input[@type='checkbox'][@name='days']"));

        assertEquals(7, checkboxes.size());
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testRemoteListData(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/checkboxlist/remotelist.action");

        waitForInitialPageLoad();

        List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@id='checkboxbuttonset']/input[@type='checkbox'][@name='letters']"));

        assertEquals(26, checkboxes.size());
    }
}

