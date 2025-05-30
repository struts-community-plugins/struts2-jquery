package com.jgeppert.jquery.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public final class WebDriverFactory {
    public static WebDriver getWebDriver() {
        String driverType = System.getProperty("failsafe.webdriver.name", "HTMLUnit");
        if ("ChromeDriver".equalsIgnoreCase(driverType)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);
            options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu");
            return new ChromeDriver(options);
        } else {
            return new HtmlUnitDriver(true);
        }
    }
}
