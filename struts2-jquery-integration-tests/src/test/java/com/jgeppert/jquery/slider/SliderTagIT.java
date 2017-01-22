package com.jgeppert.jquery.slider;

import com.jgeppert.jquery.selenium.JQueryIdleCondition;
import com.jgeppert.jquery.selenium.JQueryNoAnimations;
import com.jgeppert.jquery.selenium.WebDriverFactory;
import com.jgeppert.jquery.junit.category.PhantomJSCategory;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
@Category({PhantomJSCategory.class})
public class SliderTagIT {
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

    public SliderTagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Test
    public void testLocal() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/slider/simple.action");

        WebElement sliderInput = driver.findElement(By.id("myslider"));
        WebElement sliderHandle = driver.findElement(By.id("myslider_widget")).findElement(By.className("ui-slider-handle"));

        Assert.assertEquals("110", sliderInput.getAttribute("value"));

        (new Actions(driver)).dragAndDropBy(sliderHandle, 50, 10).build().perform();

        Assert.assertEquals("160", sliderInput.getAttribute("value"));
    }
}

