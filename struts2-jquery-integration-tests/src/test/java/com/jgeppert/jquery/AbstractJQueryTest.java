package com.jgeppert.jquery;

import com.jgeppert.jquery.selenium.DocumentReadyCondition;
import com.jgeppert.jquery.selenium.JQueryDefinedCondition;
import com.jgeppert.jquery.selenium.JQueryIdleCondition;
import com.jgeppert.jquery.selenium.JQueryNoAnimations;
import com.jgeppert.jquery.selenium.Struts2JQueryDefinedCondition;
import com.jgeppert.jquery.selenium.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

public abstract class AbstractJQueryTest {
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
            wait.until(JQUERY_DEFINED);
            wait.until(STRUTS2_JQUERY_DEFINED);
            wait.until(JQUERY_IDLE);
            wait.until(JQUERY_NO_ANIMATIONS);
        } catch (Exception e) {
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                String debugInfo = (String) js.executeScript(
                        "return 'ReadyState: ' + document.readyState + " +
                                "', jQuery: ' + (typeof jQuery !== 'undefined') + " +
                                "', Struts2jQuery: ' + (typeof jQuery !== 'undefined' && typeof jQuery.struts2_jquery !== 'undefined') + " +
                                "', Active: ' + (typeof jQuery !== 'undefined' ? jQuery.active : 'N/A') + " +
                                "', URL: ' + window.location.href"
                );
                System.err.println("Page load debug info: " + debugInfo);
            } catch (Exception debugE) {
                System.err.println("Debug failed: " + debugE.getMessage());
            }
            throw e;
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
            System.out.println("Widget debug [" + widgetId + "]: " + debugInfo);
        } catch (Exception e) {
            System.err.println("Debug failed for " + widgetId + ": " + e.getMessage());
        }
    }
}
