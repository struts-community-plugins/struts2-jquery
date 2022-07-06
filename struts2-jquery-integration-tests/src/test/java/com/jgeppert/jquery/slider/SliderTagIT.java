package com.jgeppert.jquery.slider;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jgeppert.jquery.AbstractJQueryTest;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@Tag("PhantomJS")
public class SliderTagIT extends AbstractJQueryTest {
    @ParameterizedTest
    @MethodSource("data")
    public void testLocal(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/slider/simple.action");
        
        waitForInitialPageLoad();

        WebElement sliderInput = driver.findElement(By.id("myslider"));
        WebElement sliderHandle = driver.findElement(By.id("myslider_widget")).findElement(By.className("ui-slider-handle"));

        assertEquals("110", sliderInput.getAttribute("value"));

        (new Actions(driver)).dragAndDropBy(sliderHandle, 50, 10).build().perform();

        assertEquals("160", sliderInput.getAttribute("value"));
    }
}

