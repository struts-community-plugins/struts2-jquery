package com.jgeppert.jquery.checkboxlist;

import com.jgeppert.jquery.AbstractJQueryTest;
import com.jgeppert.jquery.junit.category.HtmlUnitCategory;
import com.jgeppert.jquery.junit.category.PhantomJSCategory;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@RunWith(Parameterized.class)
@Category({HtmlUnitCategory.class, PhantomJSCategory.class})
public class CheckboxlistTagIT extends AbstractJQueryTest {
    private String baseUrl;        

    public CheckboxlistTagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Test
    public void testInlineData() throws InterruptedException {
        driver.get(baseUrl + "/checkboxlist/inlinedata.action");

        waitForInitialPageLoad();

        List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@id='checkboxbuttonset']/input[@type='checkbox'][@name='days']"));

        Assert.assertEquals(7, checkboxes.size());
    }

    @Test
    public void testRemoteListData() throws InterruptedException {
        driver.get(baseUrl + "/checkboxlist/remotelist.action");

        waitForInitialPageLoad();

        List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@id='checkboxbuttonset']/input[@type='checkbox'][@name='letters']"));

        Assert.assertEquals(26, checkboxes.size());
    }
}

