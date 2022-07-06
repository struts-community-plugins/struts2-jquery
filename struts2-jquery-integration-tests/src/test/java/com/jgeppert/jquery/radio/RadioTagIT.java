package com.jgeppert.jquery.radio;

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
public class RadioTagIT extends AbstractJQueryTest {
    private String baseUrl;        

    public RadioTagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Test
    public void testInlineData() throws InterruptedException {
        driver.get(baseUrl + "/radio/inlinedata.action");

        waitForInitialPageLoad();

        List<WebElement> radiobuttons = driver.findElements(By.xpath("//div[@id='radiobuttonset']/input[@type='radio'][@name='day']"));

        Assert.assertEquals(7, radiobuttons.size());
    }

    @Test
    public void testRemoteListData() throws InterruptedException {
        driver.get(baseUrl + "/radio/remotelist.action");
        
        waitForInitialPageLoad();

        List<WebElement> radiobuttons = driver.findElements(By.xpath("//div[@id='radiobuttonset']/input[@type='radio'][@name='letter']"));

        Assert.assertEquals(26, radiobuttons.size());
    }
}

