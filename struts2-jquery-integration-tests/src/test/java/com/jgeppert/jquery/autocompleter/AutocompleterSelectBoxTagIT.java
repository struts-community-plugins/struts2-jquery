package com.jgeppert.jquery.autocompleter;

import static org.hamcrest.CoreMatchers.containsString;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jgeppert.jquery.junit.category.PhantomJSCategory;
import com.jgeppert.jquery.selenium.JQueryIdleCondition;
import com.jgeppert.jquery.selenium.JQueryNoAnimations;
import com.jgeppert.jquery.selenium.WebDriverFactory;

/**
 *
 * Test cases for autocompleter in selectBox mode.
 *
 * TODO See if how we can make it working with HtmlUnit too.
 *
 */
@RunWith(Parameterized.class)
@Category({PhantomJSCategory.class})
public class AutocompleterSelectBoxTagIT {
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

    public AutocompleterSelectBoxTagIT(final String baseUrl) {
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
    public void testListDataWithSelectbox() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get(baseUrl + "/autocompleter/list.action?selectBox=true");

        WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
        WebElement autocompleteInputWidget = wait.until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.className("s2j-combobox-input"))).get(0);
        WebElement autocompleteSelectButton = driver.findElement(By.className("s2j-combobox-toggle"));
        Actions builder = new Actions(driver);

        builder.moveToElement(autocompleteInputWidget).click().perform();
        Assert.assertEquals(0, driver.findElements(By.tagName("li")).size());

        autocompleteSelectButton.click();

        Assert.assertTrue( driver.findElement(By.cssSelector("ul.ui-autocomplete")).isDisplayed());
        Assert.assertEquals(12, driver.findElements(By.tagName("li")).size());

        autocompleteSelectButton.click();

        Assert.assertFalse( driver.findElement(By.cssSelector("ul.ui-autocomplete")).isDisplayed());

        autocompleteInputWidget.sendKeys("j");
        Thread.sleep(1000);
        Assert.assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        Thread.sleep(1000);
        Assert.assertEquals(2, driver.findElements(By.tagName("li")).size());

        WebElement li = driver.findElements(By.tagName("li")).get(0);
        String expected = li.getText();

        builder.moveToElement(li).click().perform();
        Assert.assertFalse( driver.findElement(By.cssSelector("ul.ui-autocomplete")).isDisplayed());

        Assert.assertEquals(expected, autocompleteInput.getAttribute("value"));

      //verify #46 - handling of cssClass attribute
        Assert.assertThat(autocompleteInputWidget.getAttribute("class"), containsString("extra-class"));
    }

    @Test
    public void testListDataWithCssErrorClass() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        this.testListDataWithSelectbox();
        driver.get(baseUrl + "/autocompleter/list.action?selectBox=true&addError=true");

        WebElement autocompleteInputWidget = wait.until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.className("s2j-combobox-input"))).get(0);
        WebElement autocompleteSelectButton = driver.findElement(By.className("s2j-combobox-toggle"));

        //verify #46 - handling of cssErrorClass attribute
        Assert.assertThat(autocompleteInputWidget.getAttribute("class"), containsString("error-class"));
    }

    @Test
    public void testAjaxSelectbox() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get(baseUrl + "/autocompleter/list.action?selectBox=true");

        WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
        WebElement autocompleteInputWidget = wait.until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.className("s2j-combobox-input"))).get(0);
        Actions builder = new Actions(driver);

        builder.moveToElement(autocompleteInputWidget).click().perform();
        Assert.assertEquals(0, driver.findElements(By.tagName("li")).size());

        Assert.assertFalse( driver.findElement(By.cssSelector("ul.ui-autocomplete")).isDisplayed());

        autocompleteInputWidget.sendKeys("j");
        Thread.sleep(1000);
        Assert.assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        Thread.sleep(1000);
        Assert.assertEquals(2, driver.findElements(By.tagName("li")).size());

        WebElement li = driver.findElements(By.tagName("li")).get(0);
        String expected = li.getText();

        builder.moveToElement(li).click().perform();
        Assert.assertFalse( driver.findElement(By.cssSelector("ul.ui-autocomplete")).isDisplayed());

        Assert.assertEquals(expected, autocompleteInput.getAttribute("value"));

      //verify #46 - handling of cssClass attribute
        Assert.assertThat(autocompleteInputWidget.getAttribute("class"), containsString("extra-class"));
    }


}

