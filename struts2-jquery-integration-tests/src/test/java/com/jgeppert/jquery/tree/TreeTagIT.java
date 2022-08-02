package com.jgeppert.jquery.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.jgeppert.jquery.AbstractJQueryTest;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Tag("PhantomJS")
public class TreeTagIT extends AbstractJQueryTest {
    @ParameterizedTest
    @MethodSource("data")
    @Tag("HTMLUnit")
    @Tag("CI-HTMLUnit")
    public void testLocal(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/tree/local.action");

        waitForInitialPageLoad();

        WebElement myTree = driver.findElement(By.id("myTree"));
        WebElement itemAOpenIcon = myTree.findElement(By.xpath("ul/li[1]/i"));

        assertEquals(0, myTree.findElements(By.xpath("ul/li[1]/ul")).size());
        assertEquals(0, myTree.findElements(By.xpath("ul/li[2]/ul")).size());

        itemAOpenIcon.click();
        Thread.sleep(500);

        assertTrue(myTree.findElement(By.xpath("ul/li[1]/ul/li[1]")).isDisplayed());
        assertTrue(myTree.findElement(By.xpath("ul/li[1]/ul/li[2]")).isDisplayed());
        assertEquals(0, myTree.findElements(By.xpath("ul/li[2]/ul")).size());

        itemAOpenIcon.click();
        Thread.sleep(500);


        assertFalse(myTree.findElement(By.xpath("ul/li[1]/ul/li[1]")).isDisplayed());
        assertFalse(myTree.findElement(By.xpath("ul/li[1]/ul/li[2]")).isDisplayed());
        assertEquals(0, myTree.findElements(By.xpath("ul/li[2]/ul")).size());
    }

    @ParameterizedTest
    @MethodSource("data")
    @Tag("HTMLUnit")
    @Tag("CI-HTMLUnit")
    public void testLocalObject(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/tree/local-object.action");

        waitForInitialPageLoad();

        WebElement myTree = driver.findElement(By.id("myTree"));

        assertEquals(0, myTree.findElements(By.id("A")).size());
        assertEquals(0, myTree.findElements(By.id("B")).size());
        assertEquals(0, myTree.findElements(By.id("AA")).size());
        assertEquals(0, myTree.findElements(By.id("AB")).size());
        assertEquals(0, myTree.findElements(By.id("BA")).size());
        assertEquals(0, myTree.findElements(By.id("BB")).size());

        myTree.findElement(By.id("ROOT")).findElement(By.xpath("i")).click();
        Thread.sleep(500);

        assertTrue(myTree.findElement(By.id("A")).isDisplayed());
        assertTrue(myTree.findElement(By.id("B")).isDisplayed());
        assertEquals(0, myTree.findElements(By.id("AA")).size());
        assertEquals(0, myTree.findElements(By.id("AB")).size());
        assertEquals(0, myTree.findElements(By.id("BA")).size());
        assertEquals(0, myTree.findElements(By.id("BB")).size());

        myTree.findElement(By.id("A")).findElement(By.xpath("i")).click();
        Thread.sleep(500);

        assertTrue(myTree.findElement(By.id("A")).isDisplayed());
        assertTrue(myTree.findElement(By.id("AB")).isDisplayed());
        assertTrue(myTree.findElement(By.id("AB")).isDisplayed());
        assertTrue(myTree.findElement(By.id("B")).isDisplayed());
        assertEquals(0, myTree.findElements(By.id("BA")).size());
        assertEquals(0, myTree.findElements(By.id("BB")).size());

        myTree.findElement(By.id("A")).findElement(By.xpath("i")).click();
        Thread.sleep(500);

        assertTrue(myTree.findElement(By.id("A")).isDisplayed());
        assertTrue(myTree.findElement(By.id("B")).isDisplayed());
        assertFalse(myTree.findElement(By.id("AA")).isDisplayed());
        assertFalse(myTree.findElement(By.id("AB")).isDisplayed());
        assertEquals(0, myTree.findElements(By.id("BA")).size());
        assertEquals(0, myTree.findElements(By.id("BB")).size());
    }

    @ParameterizedTest
    @MethodSource("data")
    @Tag("HTMLUnit")
    @Tag("CI-HTMLUnit")
    public void testCheckboxes(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/tree/checkboxes.action");

        waitForInitialPageLoad();

        WebElement myTree = driver.findElement(By.id("myTree"));
        WebElement resultDiv = driver.findElement(By.id("resultDiv"));
        WebElement submit = driver.findElement(By.id("mySubmit"));

        myTree.findElement(By.id("A_link")).findElement(By.xpath("i[contains(@class, 'checkbox')]")).click();
        submit.click();
        wait.until(JQUERY_IDLE);

        assertEquals("Echo : A,AA,AB", resultDiv.getText());

        myTree.findElement(By.id("B")).findElement(By.xpath("i")).click();
        myTree.findElement(By.id("BA_link")).findElement(By.xpath("i[contains(@class, 'checkbox')]")).click();
        submit.click();
        wait.until(JQUERY_IDLE);

        assertEquals("Echo : A,AA,AB,BA", resultDiv.getText());

        myTree.findElement(By.id("A")).findElement(By.xpath("i")).click();
        myTree.findElement(By.id("AA_link")).findElement(By.xpath("i[contains(@class, 'checkbox')]")).click();
        myTree.findElement(By.id("AB_link")).findElement(By.xpath("i[contains(@class, 'checkbox')]")).click();
        myTree.findElement(By.id("BB_link")).findElement(By.xpath("i[contains(@class, 'checkbox')]")).click();
        submit.click();
        wait.until(JQUERY_IDLE);

        assertEquals("Echo : BA,BB,B", resultDiv.getText());
    }

    @ParameterizedTest
    @MethodSource("data")
    @Tag("HTMLUnit")
    @Tag("CI-HTMLUnit")
    public void testSearch(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/tree/search.action");
        
        waitForInitialPageLoad();
        
        WebElement myTree = driver.findElement(By.id("myTree"));
        WebElement searchField = driver.findElement(By.id("searchField"));
        WebElement searchButton = driver.findElement(By.id("searchButton"));

        assertEquals(0, myTree.findElements(By.id("AA")).size());
        assertEquals(0, myTree.findElements(By.id("AB")).size());
        assertEquals(0, myTree.findElements(By.id("BA")).size());
        assertEquals(0, myTree.findElements(By.id("BB")).size());

        searchField.sendKeys("AB");
        searchButton.click();
        Thread.sleep(500);

        assertTrue(myTree.findElement(By.id("AA")).isDisplayed());
        assertTrue(myTree.findElement(By.id("AB")).isDisplayed());
        assertEquals(0, myTree.findElements(By.id("BA")).size());
        assertEquals(0, myTree.findElements(By.id("BB")).size());
        assertFalse(myTree.findElement(By.id("A_link")).getAttribute("class").contains("jstree-search"));
        assertFalse(myTree.findElement(By.id("AA_link")).getAttribute("class").contains("jstree-search"));
        assertTrue(myTree.findElement(By.id("AB_link")).getAttribute("class").contains("jstree-search"));
        assertFalse(myTree.findElement(By.id("B_link")).getAttribute("class").contains("jstree-search"));
    }

    // following test does not work with HtmlUnitDriver
    @ParameterizedTest
    @MethodSource("data")
    public void testRemote(final String baseUrl) throws InterruptedException {
        driver.get(baseUrl + "/tree/remote.action");
        
        waitForInitialPageLoad();

        WebElement myTree = driver.findElement(By.id("myTree"));

        assertEquals(0, driver.findElements(By.id("A")).size());
        assertEquals(0, driver.findElements(By.id("B")).size());
        assertEquals(0, driver.findElements(By.id("AA")).size());
        assertEquals(0, driver.findElements(By.id("AB")).size());
        assertEquals(0, driver.findElements(By.id("BA")).size());
        assertEquals(0, driver.findElements(By.id("BB")).size());

        myTree.findElement(By.id("ROOT")).findElement(By.xpath("i")).click();
        Thread.sleep(500);

        assertTrue(myTree.findElement(By.id("A")).isDisplayed());
        assertTrue(myTree.findElement(By.id("B")).isDisplayed());
        assertEquals(0, driver.findElements(By.id("AA")).size());
        assertEquals(0, driver.findElements(By.id("AB")).size());
        assertEquals(0, driver.findElements(By.id("BA")).size());
        assertEquals(0, driver.findElements(By.id("BB")).size());

        myTree.findElement(By.id("A")).findElement(By.xpath("i")).click();
        Thread.sleep(500);

        assertTrue(myTree.findElement(By.id("A")).isDisplayed());
        assertTrue(myTree.findElement(By.id("AB")).isDisplayed());
        assertTrue(myTree.findElement(By.id("AB")).isDisplayed());
        assertTrue(myTree.findElement(By.id("B")).isDisplayed());
        assertEquals(0, driver.findElements(By.id("BA")).size());
        assertEquals(0, driver.findElements(By.id("BB")).size());

        myTree.findElement(By.id("A")).findElement(By.xpath("i")).click();
        Thread.sleep(500);

        assertTrue(myTree.findElement(By.id("A")).isDisplayed());
        assertTrue(myTree.findElement(By.id("B")).isDisplayed());
        assertEquals(0, driver.findElements(By.id("AA")).size());
        assertEquals(0, driver.findElements(By.id("AB")).size());
        assertEquals(0, driver.findElements(By.id("BA")).size());
        assertEquals(0, driver.findElements(By.id("BB")).size());
    }

}
