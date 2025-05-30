package com.jgeppert.jquery.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.HashMap;
import java.util.Map;

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

        // Core headless options
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");

        // Window and display
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--start-maximized");

        // Security and network - IMPORTANT for jQuery loading
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--ignore-ssl-errors");
        options.addArguments("--ignore-certificate-errors-spki-list");
        options.addArguments("--ignore-ssl-certificate-errors");

        // Performance and stability for CI
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-plugins");
        options.addArguments("--disable-background-timer-throttling");
        options.addArguments("--disable-renderer-backgrounding");
        options.addArguments("--disable-backgrounding-occluded-windows");
        options.addArguments("--disable-ipc-flooding-protection");

        // JavaScript and DOM handling
        options.addArguments("--enable-automation");
        options.addArguments("--disable-blink-features=AutomationControlled");

        // CI-specific: Disable features that can cause issues
        if ("true".equals(System.getenv("CI"))) {
            options.addArguments("--disable-logging");
            options.addArguments("--log-level=3");
            options.addArguments("--silent");
            options.addArguments("--disable-crash-reporter");
            options.addArguments("--disable-in-process-stack-traces");
            options.addArguments("--memory-pressure-off");
            options.addArguments("--max_old_space_size=4096");
        }

        options.setAcceptInsecureCerts(true);

        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", java.util.Arrays.asList("enable-automation", "enable-logging"));

        // Add prefs to prevent crashes
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("profile.managed_default_content_settings.images", 2);
        options.setExperimentalOption("prefs", prefs);
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
