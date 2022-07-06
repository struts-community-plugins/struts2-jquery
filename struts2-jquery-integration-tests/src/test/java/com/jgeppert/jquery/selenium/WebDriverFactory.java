package com.jgeppert.jquery.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public final class WebDriverFactory {
    public static WebDriver getWebDriver() {
        return new HtmlUnitDriver(true);
    }
}
