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
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            return new ChromeDriver(options);
        } else {
            HtmlUnitDriver driver = new HtmlUnitDriver(true);
            driver.getWebClient().getOptions().setTimeout(30000); // Longer timeout for CI
            driver.getWebClient().getOptions().setJavaScriptEnabled(true);
            driver.getWebClient().getOptions().setCssEnabled(true);
            driver.getWebClient().getOptions().setThrowExceptionOnFailingStatusCode(false);

            return driver;
        }
    }
}
