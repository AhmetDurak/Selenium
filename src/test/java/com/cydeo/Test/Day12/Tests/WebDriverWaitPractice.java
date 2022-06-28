package com.cydeo.Test.Day12.Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriverWaitPractice extends TestBase2{
    @Test
    public void dynamicallyLoadedPageTest() throws InterruptedException {
        //TC#4 : Dynamically Loaded Page Elements 7
        //1. Go to https://practice.cydeo.com/dynamic_loading/7
        //2. Wait until title is “Dynamic title”
        wait.until(ExpectedConditions.titleIs("Dynamic title"));
        //3. Assert: Message “Done” is displayed.
        Assert.assertTrue(dynamicTitle.alert.isDisplayed());
        //4. Assert: Image is displayed.
        Thread.sleep(500);
        Assert.assertTrue(dynamicTitle.squarePants.isDisplayed());
        //        Note: Follow POM
    }
}
