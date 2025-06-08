package com.jgeppert.jquery;

import com.jgeppert.jquery.selenium.DocumentReadyCondition;
import com.jgeppert.jquery.selenium.JQueryDefinedCondition;
import com.jgeppert.jquery.selenium.JQueryIdleCondition;
import com.jgeppert.jquery.selenium.JQueryNoAnimations;
import com.jgeppert.jquery.selenium.Struts2JQueryDefinedCondition;
import com.jgeppert.jquery.selenium.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

public abstract class AbstractJQueryTest {
    private static final Logger log = LogManager.getLogger(AbstractJQueryTest.class);
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    public void before() {
        driver = WebDriverFactory.getWebDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"http://localhost:8080/regular"},
                {"http://localhost:8080/uncompressed"},
                {"http://localhost:8080/loadatonce"},
                {"http://localhost:8080/loadfromcdn"}
        });
    }

    protected static final JQueryIdleCondition JQUERY_IDLE = new JQueryIdleCondition();
    protected static final DocumentReadyCondition DOCUMENT_READY = new DocumentReadyCondition();
    protected static final JQueryDefinedCondition JQUERY_DEFINED = new JQueryDefinedCondition();
    protected static final Struts2JQueryDefinedCondition STRUTS2_JQUERY_DEFINED = new Struts2JQueryDefinedCondition();
    protected static final JQueryNoAnimations JQUERY_NO_ANIMATIONS = new JQueryNoAnimations();

    protected void waitForInitialPageLoad() throws InterruptedException {
        try {
            wait.until(DOCUMENT_READY);

            log.debug("\uD83D\uDD0D Current URL: {}", driver.getCurrentUrl());

            // Check if page loaded at all
            String pageSource = driver.getPageSource();
            if (pageSource.length() < 100) {
                if (log.isDebugEnabled()) {
                    log.debug("❌ Page source is too short: {} characters", pageSource.length());
                    log.debug("\uD83D\uDCC4 Page source: {}", pageSource.substring(0, Math.min(pageSource.length(), 500)));
                }
            } else {
                log.debug("✅ Page source loaded: {} characters", pageSource.length());
            }

            // Check if jQuery is referenced in the page
            boolean hasJQuery = pageSource.contains("jquery") || pageSource.contains("jQuery");
            log.debug("\uD83D\uDD0D Page contains jQuery reference: {}", hasJQuery);

            // Check if struts2-jquery is referenced
            boolean hasStruts2jQuery = pageSource.contains("struts2") && pageSource.contains("jquery");
            log.debug("\uD83D\uDD0D Page contains struts2-jquery reference: {}", hasStruts2jQuery);

            wait.until(JQUERY_DEFINED);
            wait.until(STRUTS2_JQUERY_DEFINED);
            wait.until(JQUERY_IDLE);
            wait.until(JQUERY_NO_ANIMATIONS);
        } catch (TimeoutException e) {
            // Enhanced error reporting
            log.error("❌ Timeout waiting for page load. Debug info:");
            log.warn("\uD83D\uDD0D Current URL: {}", driver.getCurrentUrl());

            try {
                // Check JavaScript console errors
                LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
                log.warn("🔍 Browser console logs:");
                for (LogEntry entry : logs) {
                    log.warn("  {}: {}", entry.getLevel(), entry.getMessage());
                }
            } catch (Exception logEx) {
                log.error("⚠\uFE0F Could not retrieve browser logs: {}", logEx.getMessage());
            }

            try {
                // Check basic JavaScript execution
                Object jQueryDefined = ((JavascriptExecutor) driver)
                        .executeScript("return typeof jQuery !== 'undefined'");
                log.warn("\uD83D\uDD0D jQuery defined: {}", jQueryDefined);

                Object documentReady = ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState");
                log.warn("\uD83D\uDD0D Document ready state: {}", documentReady);

            } catch (Exception jsEx) {
                log.error("❌ JavaScript execution failed: " + jsEx.getMessage());
            }

            // Dump a snippet of page source for debugging
            String pageSource = driver.getPageSource();
            log.debug("📄 Page source snippet (first 1000 chars):");
            if (pageSource != null) {
                log.debug(pageSource.substring(0, Math.min(pageSource.length(), 1000)));
            }

            throw e; // Re-throw the original exception
        }
    }

    // Debug widget state
    protected void debugWidgetState(String widgetId) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String debugInfo = (String) js.executeScript(
                    "var el = jQuery('#" + widgetId + "');" +
                            "return 'Element found: ' + (el.length > 0) + ', " +
                            "Classes: ' + el.attr('class') + ', " +
                            "Children: ' + el.children().length + ', " +
                            "jQuery UI data: ' + Object.keys(el.data()).join(',') + ', " +
                            "AJAX active: ' + jQuery.active"
            );
            log.debug("Widget debug [{}]: {}", widgetId, debugInfo);
        } catch (Exception e) {
            log.error("Debug failed for {}: {}", widgetId, e.getMessage());
        }
    }
}
