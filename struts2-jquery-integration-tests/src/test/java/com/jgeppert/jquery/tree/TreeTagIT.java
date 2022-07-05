package com.jgeppert.jquery.tree;

import com.jgeppert.jquery.AbstractJQueryTest;
import com.jgeppert.jquery.junit.category.HtmlUnitCategory;
import com.jgeppert.jquery.junit.category.PhantomJSCategory;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Ignore
@RunWith(Parameterized.class)
@Category({ PhantomJSCategory.class })
public class TreeTagIT extends AbstractJQueryTest {
    private String baseUrl;

    public TreeTagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Test
    @Category({ HtmlUnitCategory.class })
    public void testLocal() throws InterruptedException {
        driver.get(baseUrl + "/tree/local.action");

        waitForInitialPageLoad();

        WebElement myTree = driver.findElement(By.id("myTree"));
        WebElement itemAOpenIcon = myTree.findElement(By.xpath("ul/li[1]/i"));

        Assert.assertEquals(0, myTree.findElements(By.xpath("ul/li[1]/ul")).size());
        Assert.assertEquals(0, myTree.findElements(By.xpath("ul/li[2]/ul")).size());

        itemAOpenIcon.click();
        Thread.sleep(500);

        Assert.assertTrue(myTree.findElement(By.xpath("ul/li[1]/ul/li[1]")).isDisplayed());
        Assert.assertTrue(myTree.findElement(By.xpath("ul/li[1]/ul/li[2]")).isDisplayed());
        Assert.assertEquals(0, myTree.findElements(By.xpath("ul/li[2]/ul")).size());

        itemAOpenIcon.click();
        Thread.sleep(500);

        Assert.assertEquals(0, myTree.findElements(By.xpath("ul/li[1]/ul")).size());
        Assert.assertEquals(0, myTree.findElements(By.xpath("ul/li[2]/ul")).size());
    }

    @Test
    @Category({ HtmlUnitCategory.class })
    public void testLocalObject() throws InterruptedException {
        driver.get(baseUrl + "/tree/local-object.action");

        waitForInitialPageLoad();

        WebElement myTree = driver.findElement(By.id("myTree"));

        Assert.assertEquals(0, myTree.findElements(By.id("A")).size());
        Assert.assertEquals(0, myTree.findElements(By.id("B")).size());
        Assert.assertEquals(0, myTree.findElements(By.id("AA")).size());
        Assert.assertEquals(0, myTree.findElements(By.id("AB")).size());
        Assert.assertEquals(0, myTree.findElements(By.id("BA")).size());
        Assert.assertEquals(0, myTree.findElements(By.id("BB")).size());

        myTree.findElement(By.id("ROOT")).findElement(By.xpath("i")).click();
        Thread.sleep(500);

        Assert.assertTrue(myTree.findElement(By.id("A")).isDisplayed());
        Assert.assertTrue(myTree.findElement(By.id("B")).isDisplayed());
        Assert.assertEquals(0, myTree.findElements(By.id("AA")).size());
        Assert.assertEquals(0, myTree.findElements(By.id("AB")).size());
        Assert.assertEquals(0, myTree.findElements(By.id("BA")).size());
        Assert.assertEquals(0, myTree.findElements(By.id("BB")).size());

        myTree.findElement(By.id("A")).findElement(By.xpath("i")).click();
        Thread.sleep(500);

        Assert.assertTrue(myTree.findElement(By.id("A")).isDisplayed());
        Assert.assertTrue(myTree.findElement(By.id("AB")).isDisplayed());
        Assert.assertTrue(myTree.findElement(By.id("AB")).isDisplayed());
        Assert.assertTrue(myTree.findElement(By.id("B")).isDisplayed());
        Assert.assertEquals(0, myTree.findElements(By.id("BA")).size());
        Assert.assertEquals(0, myTree.findElements(By.id("BB")).size());

        myTree.findElement(By.id("A")).findElement(By.xpath("i")).click();
        Thread.sleep(500);

        Assert.assertTrue(myTree.findElement(By.id("A")).isDisplayed());
        Assert.assertTrue(myTree.findElement(By.id("B")).isDisplayed());
        Assert.assertEquals(0, myTree.findElements(By.id("AA")).size());
        Assert.assertEquals(0, myTree.findElements(By.id("AB")).size());
        Assert.assertEquals(0, myTree.findElements(By.id("BA")).size());
        Assert.assertEquals(0, myTree.findElements(By.id("BB")).size());
    }

    @Test
    @Category({ HtmlUnitCategory.class })
    public void testCheckboxes() throws InterruptedException {
        driver.get(baseUrl + "/tree/checkboxes.action");

        waitForInitialPageLoad();

        WebElement myTree = driver.findElement(By.id("myTree"));
        WebElement resultDiv = driver.findElement(By.id("resultDiv"));
        WebElement submit = driver.findElement(By.id("mySubmit"));

        myTree.findElement(By.id("A_link")).findElement(By.xpath("i[contains(@class, 'checkbox')]")).click();
        submit.click();
        wait.until(JQUERY_IDLE);

        Assert.assertEquals("Echo : A,AA,AB", resultDiv.getText());

        myTree.findElement(By.id("B")).findElement(By.xpath("i")).click();
        myTree.findElement(By.id("BA_link")).findElement(By.xpath("i[contains(@class, 'checkbox')]")).click();
        submit.click();
        wait.until(JQUERY_IDLE);

        Assert.assertEquals("Echo : A,AA,AB,BA", resultDiv.getText());

        myTree.findElement(By.id("A")).findElement(By.xpath("i")).click();
        myTree.findElement(By.id("AA_link")).findElement(By.xpath("i[contains(@class, 'checkbox')]")).click();
        myTree.findElement(By.id("AB_link")).findElement(By.xpath("i[contains(@class, 'checkbox')]")).click();
        myTree.findElement(By.id("BB_link")).findElement(By.xpath("i[contains(@class, 'checkbox')]")).click();
        submit.click();
        wait.until(JQUERY_IDLE);

        Assert.assertEquals("Echo : BA,BB,B", resultDiv.getText());
    }

    @Test
    @Category({ HtmlUnitCategory.class })
    public void testSearch() throws InterruptedException {
        driver.get(baseUrl + "/tree/search.action");
        
        waitForInitialPageLoad();
        
        WebElement myTree = driver.findElement(By.id("myTree"));
        WebElement searchField = driver.findElement(By.id("searchField"));
        WebElement searchButton = driver.findElement(By.id("searchButton"));

        Assert.assertEquals(0, myTree.findElements(By.id("AA")).size());
        Assert.assertEquals(0, myTree.findElements(By.id("AB")).size());
        Assert.assertEquals(0, myTree.findElements(By.id("BA")).size());
        Assert.assertEquals(0, myTree.findElements(By.id("BB")).size());

        searchField.sendKeys("AB");
        searchButton.click();
        Thread.sleep(500);

        Assert.assertTrue(myTree.findElement(By.id("AA")).isDisplayed());
        Assert.assertTrue(myTree.findElement(By.id("AB")).isDisplayed());
        Assert.assertEquals(0, myTree.findElements(By.id("BA")).size());
        Assert.assertEquals(0, myTree.findElements(By.id("BB")).size());
        Assert.assertFalse(myTree.findElement(By.id("A_link")).getAttribute("class").contains("jstree-search"));
        Assert.assertFalse(myTree.findElement(By.id("AA_link")).getAttribute("class").contains("jstree-search"));
        Assert.assertTrue(myTree.findElement(By.id("AB_link")).getAttribute("class").contains("jstree-search"));
        Assert.assertFalse(myTree.findElement(By.id("B_link")).getAttribute("class").contains("jstree-search"));
    }

    // following test does not work with HtmlUnitDriver
    @Test
    public void testRemote() throws InterruptedException {
        driver.get(baseUrl + "/tree/remote.action");
        
        waitForInitialPageLoad();

        WebElement myTree = driver.findElement(By.id("myTree"));

        Assert.assertEquals(0, driver.findElements(By.id("A")).size());
        Assert.assertEquals(0, driver.findElements(By.id("B")).size());
        Assert.assertEquals(0, driver.findElements(By.id("AA")).size());
        Assert.assertEquals(0, driver.findElements(By.id("AB")).size());
        Assert.assertEquals(0, driver.findElements(By.id("BA")).size());
        Assert.assertEquals(0, driver.findElements(By.id("BB")).size());

        myTree.findElement(By.id("ROOT")).findElement(By.xpath("i")).click();
        Thread.sleep(500);

        Assert.assertTrue(myTree.findElement(By.id("A")).isDisplayed());
        Assert.assertTrue(myTree.findElement(By.id("B")).isDisplayed());
        Assert.assertEquals(0, driver.findElements(By.id("AA")).size());
        Assert.assertEquals(0, driver.findElements(By.id("AB")).size());
        Assert.assertEquals(0, driver.findElements(By.id("BA")).size());
        Assert.assertEquals(0, driver.findElements(By.id("BB")).size());

        myTree.findElement(By.id("A")).findElement(By.xpath("i")).click();
        Thread.sleep(500);

        Assert.assertTrue(myTree.findElement(By.id("A")).isDisplayed());
        Assert.assertTrue(myTree.findElement(By.id("AB")).isDisplayed());
        Assert.assertTrue(myTree.findElement(By.id("AB")).isDisplayed());
        Assert.assertTrue(myTree.findElement(By.id("B")).isDisplayed());
        Assert.assertEquals(0, driver.findElements(By.id("BA")).size());
        Assert.assertEquals(0, driver.findElements(By.id("BB")).size());

        myTree.findElement(By.id("A")).findElement(By.xpath("i")).click();
        Thread.sleep(500);

        Assert.assertTrue(myTree.findElement(By.id("A")).isDisplayed());
        Assert.assertTrue(myTree.findElement(By.id("B")).isDisplayed());
        Assert.assertEquals(0, driver.findElements(By.id("AA")).size());
        Assert.assertEquals(0, driver.findElements(By.id("AB")).size());
        Assert.assertEquals(0, driver.findElements(By.id("BA")).size());
        Assert.assertEquals(0, driver.findElements(By.id("BB")).size());
    }

}
