package com.jgeppert.jquery.radio;

import com.jgeppert.jquery.AbstractJQueryTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("HTMLUnit")
@Tag("PhantomJS")
@Tag("CI-CHROME")
@Tag("CI-HTMLUnit")
public class RadioTagIT extends AbstractJQueryTest {
    @ParameterizedTest
    @MethodSource("data")
    public void testInlineData(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/radio/inlinedata.action");

        waitForInitialPageLoad();
        debugWidgetState("radiobuttonset");

        List<WebElement> radiobuttons = driver.findElements(By.xpath("//div[@id='radiobuttonset']/input[@type='radio'][@name='day']"));

        assertEquals(7, radiobuttons.size());
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testRemoteListData(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/radio/remotelist.action");
        
        waitForInitialPageLoad();
        debugWidgetState("radiobuttonset");

        List<WebElement> radiobuttons = driver.findElements(By.xpath("//div[@id='radiobuttonset']/input[@type='radio'][@name='letter']"));

        assertEquals(26, radiobuttons.size());
    }
}

