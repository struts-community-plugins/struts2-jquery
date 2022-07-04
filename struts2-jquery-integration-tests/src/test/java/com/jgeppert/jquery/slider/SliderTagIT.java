package com.jgeppert.jquery.slider;

import com.jgeppert.jquery.AbstractJQueryTest;
import com.jgeppert.jquery.junit.category.PhantomJSCategory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@RunWith(Parameterized.class)
@Category({PhantomJSCategory.class})
public class SliderTagIT extends AbstractJQueryTest {
    private String baseUrl;        

    public SliderTagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Test
    public void testLocal() throws InterruptedException {
        driver.get(baseUrl + "/slider/simple.action");
        
        waitForInitialPageLoad();

        WebElement sliderInput = driver.findElement(By.id("myslider"));
        WebElement sliderHandle = driver.findElement(By.id("myslider_widget")).findElement(By.className("ui-slider-handle"));

        Assert.assertEquals("110", sliderInput.getAttribute("value"));

        (new Actions(driver)).dragAndDropBy(sliderHandle, 50, 10).build().perform();

        Assert.assertEquals("160", sliderInput.getAttribute("value"));
    }
}

