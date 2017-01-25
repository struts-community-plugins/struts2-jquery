package com.jgeppert.jquery.selenium;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JQueryNoAnimations implements ExpectedCondition<Boolean>{

    @Override
    public Boolean apply(final WebDriver driver) {
        try {
            return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery(':animated').length") == 0);
        } catch (final Exception e) {
            return true;
        }
    }

}
