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
            // Try to use system ChromeDriver first
            String systemChromeDriver = findSystemChromeDriver();
            if (systemChromeDriver != null) {
                System.setProperty("webdriver.chrome.driver", systemChromeDriver);
            } else {
                // Fallback to WebDriverManager
                WebDriverManager.chromedriver().setup();
            }
            return new ChromeDriver(getChromeOptions());
        } else {
            HtmlUnitDriver driver = new HtmlUnitDriver(true);
            driver.getWebClient().getOptions().setTimeout(30000); // Longer timeout for CI
            driver.getWebClient().getOptions().setJavaScriptEnabled(true);
            driver.getWebClient().getOptions().setCssEnabled(true);
            driver.getWebClient().getOptions().setThrowExceptionOnFailingStatusCode(false);

            return driver;
        }
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();

        // Essential headless arguments
        options.addArguments("--headless=new"); // Use new headless mode
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-plugins");
        options.addArguments("--disable-images");
        options.addArguments("--disable-javascript-harmony-shipping");
        options.addArguments("--disable-background-timer-throttling");
        options.addArguments("--disable-renderer-backgrounding");
        options.addArguments("--disable-backgrounding-occluded-windows");
        options.addArguments("--disable-ipc-flooding-protection");

        // Window and display settings
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--start-maximized");
        options.addArguments("--force-device-scale-factor=1");

        // Network and security
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--ignore-ssl-errors");
        options.addArguments("--ignore-certificate-errors-spki-list");
        options.addArguments("--ignore-ssl-errors-spki-list");

        // Performance optimizations
        options.addArguments("--memory-pressure-off");
        options.addArguments("--max_old_space_size=4096");

        // Logging
        options.addArguments("--enable-logging");
        options.addArguments("--log-level=0");
        options.addArguments("--v=1");

        options.setAcceptInsecureCerts(true);
        return options;
    }

    private static String findSystemChromeDriver() {
        String[] possiblePaths = {
                "/opt/homebrew/bin/chromedriver",
                "/usr/local/bin/chromedriver",
                "/usr/bin/chromedriver"
        };

        for (String path : possiblePaths) {
            if (new java.io.File(path).exists()) {
                return path;
            }
        }
        return null;
    }
}
