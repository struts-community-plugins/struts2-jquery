package com.jgeppert.jquery.autocompleter;

import com.jgeppert.jquery.selenium.JQueryIdleCondition;
import com.jgeppert.jquery.selenium.JQueryNoAnimations;
import com.jgeppert.jquery.selenium.WebDriverFactory;
import com.jgeppert.jquery.junit.category.HtmlUnitCategory;
import com.jgeppert.jquery.junit.category.PhantomJSCategory;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
<<<<<<< Upstream, based on origin/release/4.0.3
=======
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
>>>>>>> 7ccdda6 trying to use WebDriverWait instead of Thread.sleep

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
@Category({HtmlUnitCategory.class, PhantomJSCategory.class})
public class AutocompleterTagIT {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 { "http://localhost:8080/regular" }, 
                 { "http://localhost:8080/uncompressed" },
                 { "http://localhost:8080/loadatonce" }, 
                 { "http://localhost:8080/loadfromgoogle" }  
           });
    }
    
    private static final JQueryIdleCondition JQUERY_IDLE = new JQueryIdleCondition();
    private static final JQueryNoAnimations JQUERY_NO_ANIMATIONS = new JQueryNoAnimations();

    private String baseUrl;        
    private WebDriver driver;        

    public AutocompleterTagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Before
    public void before() {
        driver = WebDriverFactory.getWebDriver();
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void testListData() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/autocompleter/list.action");

        WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));

        autocompleteInputWidget.sendKeys("j");
        Thread.sleep(1000);
        Assert.assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        Thread.sleep(1000);
        Assert.assertEquals(2, driver.findElements(By.tagName("li")).size());

        driver.findElements(By.tagName("li")).get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals("June", autocompleteInput.getAttribute("value"));
    }

    @Test
    public void testAjaxArray() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/autocompleter/ajaxarray.action");

        WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));

        autocompleteInputWidget.sendKeys("j");
        Thread.sleep(1000);
        Assert.assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        Thread.sleep(1000);
        Assert.assertEquals(2, driver.findElements(By.tagName("li")).size());

        driver.findElements(By.tagName("li")).get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals("June", autocompleteInput.getAttribute("value"));
    }

    @Test
    public void testAjaxArrayInsideObject() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/autocompleter/ajaxarrayinsideobject.action");

        WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));

        autocompleteInputWidget.sendKeys("j");
        Thread.sleep(1000);
        Assert.assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        Thread.sleep(1000);
        Assert.assertEquals(2, driver.findElements(By.tagName("li")).size());

        driver.findElements(By.tagName("li")).get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals("June", autocompleteInput.getAttribute("value"));
    }

    @Test
    public void testAjaxMapInsideObject() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/autocompleter/ajaxmapinsideobject.action");

        WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));

        autocompleteInputWidget.sendKeys("j");
        Thread.sleep(1000);
        Assert.assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        Thread.sleep(1000);
        Assert.assertEquals(2, driver.findElements(By.tagName("li")).size());

        driver.findElements(By.tagName("li")).get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals("6", autocompleteInput.getAttribute("value"));
    }

    @Test
    public void testAjaxObjectsInsideObject() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/autocompleter/ajaxobjectsinsideobject.action");

        WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));

        autocompleteInputWidget.sendKeys("j");
        Thread.sleep(1000);
        Assert.assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        Thread.sleep(1000);
        Assert.assertEquals(2, driver.findElements(By.tagName("li")).size());

        driver.findElements(By.tagName("li")).get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals("6", autocompleteInput.getAttribute("value"));
    }
<<<<<<< Upstream, based on origin/release/4.0.3
=======

    @Test
    public void testAjaxArrayErrorTopic() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/autocompleter/ajaxarrayerrortopic.action");

        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));
        WebElement errorContainer = driver.findElement(By.id("errorContainer"));

        autocompleteInputWidget.sendKeys("j");
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(errorContainer, By.tagName("p")));
        Assert.assertEquals(0, driver.findElements(By.tagName("li")).size());

        List<WebElement> ps = errorContainer.findElements(By.tagName("p"));
        Assert.assertEquals(2, ps.size());

        List<String> result = new ArrayList<>();
        for (WebElement p : ps) {
            result.add(p.getText());
        }

        Assert.assertThat(result, containsInAnyOrder("topic1", "topic2"));

    }

    @Test
    public void testAjaxArrayInsideObjectErrorTopic() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/autocompleter/ajaxarrayinsideobjecterrortopic.action");

        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));
        WebElement errorContainer = driver.findElement(By.id("errorContainer"));

        autocompleteInputWidget.sendKeys("j");
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(errorContainer, By.tagName("p")));

        List<WebElement> ps = errorContainer.findElements(By.tagName("p"));
        Assert.assertEquals(2, ps.size());

        List<String> result = new ArrayList<>();
        for (WebElement p : ps) {
            result.add(p.getText());
        }

        Assert.assertThat(result, containsInAnyOrder("topic1", "topic2"));

    }
>>>>>>> 7ccdda6 trying to use WebDriverWait instead of Thread.sleep
}
