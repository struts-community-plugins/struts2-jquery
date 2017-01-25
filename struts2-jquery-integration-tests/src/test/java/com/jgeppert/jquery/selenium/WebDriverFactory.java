package com.jgeppert.jquery.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public final class WebDriverFactory {
    public static WebDriver getWebDriver() {
        final String webDriverName = System.getProperty("webDriverName");
        
        if ("HtmlUnit".equalsIgnoreCase(webDriverName)) {
            return new HtmlUnitDriver(true);
        } else if ("PhantomJS".equalsIgnoreCase(webDriverName)) {
            return new PhantomJSDriver();
        } else {
            throw new RuntimeException("unknown webDriverName systempropery value");
        }
    }
}
