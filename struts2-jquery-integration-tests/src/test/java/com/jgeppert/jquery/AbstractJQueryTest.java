package com.jgeppert.jquery;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jgeppert.jquery.selenium.DocumentReadyCondition;
import com.jgeppert.jquery.selenium.JQueryDefinedCondition;
import com.jgeppert.jquery.selenium.JQueryIdleCondition;
import com.jgeppert.jquery.selenium.JQueryNoAnimations;
import com.jgeppert.jquery.selenium.WebDriverFactory;

public abstract class AbstractJQueryTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    
    @BeforeEach
    public void before() {
        driver = WebDriverFactory.getWebDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }
    
    @AfterEach
    public void after() {
        driver.quit();
    }
    
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
            { "http://localhost:8080/regular" }, 
            { "http://localhost:8080/uncompressed" },
            { "http://localhost:8080/loadatonce" }, 
            { "http://localhost:8080/loadfromgoogle" } 
        });
    }
    
    protected static final JQueryIdleCondition JQUERY_IDLE = new JQueryIdleCondition();
    protected static final DocumentReadyCondition DOCUMENT_READY = new DocumentReadyCondition();
    protected static final JQueryDefinedCondition JQUERY_DEFINED = new JQueryDefinedCondition();
    protected static final JQueryNoAnimations JQUERY_NO_ANIMATIONS = new JQueryNoAnimations();
    
    protected void waitForInitialPageLoad() throws InterruptedException {
        Thread.sleep(200);
        wait.until(DOCUMENT_READY);
        wait.until(JQUERY_DEFINED);
        wait.until(JQUERY_IDLE);
        wait.until(JQUERY_NO_ANIMATIONS);
    }
}
