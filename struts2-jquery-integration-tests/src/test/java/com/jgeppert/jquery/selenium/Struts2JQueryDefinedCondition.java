package com.jgeppert.jquery.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class Struts2JQueryDefinedCondition implements ExpectedCondition<Boolean> {

    @Override
    public Boolean apply(WebDriver input) {
        return (Boolean) ((JavascriptExecutor) input).executeScript("return typeof jQuery !== 'undefined' && typeof jQuery.struts2_jquery !== 'undefined'");
    }
}
