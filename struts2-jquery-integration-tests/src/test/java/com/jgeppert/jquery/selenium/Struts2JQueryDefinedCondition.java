package com.jgeppert.jquery.selenium;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class Struts2JQueryDefinedCondition implements ExpectedCondition<Boolean> {

    @Override
    public @Nullable Boolean apply(@Nullable WebDriver input) {
        return (Boolean) ((JavascriptExecutor) input).executeScript("return typeof jQuery !== 'undefined' && typeof jQuery.struts2_jquery !== 'undefined'");
    }
}
