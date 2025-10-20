package com.jgeppert.jquery.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class DocumentReadyCondition implements ExpectedCondition<Boolean> {

    @Override
    public Boolean apply(WebDriver input) {
        return ((JavascriptExecutor) input).executeScript("return document.readyState").equals("complete");
    }

}
