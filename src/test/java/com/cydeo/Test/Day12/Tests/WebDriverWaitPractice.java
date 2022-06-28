package com.cydeo.Test.Day12.Tests;

import com.Utilities.ConfigurationReader;
import com.Utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriverWaitPractice extends TestBase2{
    @Test
    public void dynamicallyLoadedPageTest() throws InterruptedException {
        //TC#4 : Dynamically Loaded Page Elements 7
        //1. Go to https://practice.cydeo.com/dynamic_loading/7
        Driver.get().get(ConfigurationReader.get("dynamicLoading"));
        //2. Wait until title is “Dynamic title”
        wait.until(ExpectedConditions.titleIs("Dynamic title"));
        //3. Assert: Message “Done” is displayed.
        Assert.assertTrue(dynamicTitle.alert.isDisplayed());
        //4. Assert: Image is displayed.
        Thread.sleep(500);
        Assert.assertTrue(dynamicTitle.spongeBobImage.isDisplayed());
        //        Note: Follow POM
    }

    @Test
    public void dynamicallyLoadedPageTest2(){
       //TC#5 : Dynamically Loaded Page Elements 1
       //1. Go to https://practice.cydeo.com/dynamic_loading/1
        Driver.get().navigate().to("https://practice.cydeo.com/dynamic_loading/1");
       //2. Click to start
        dynamicTitle.startBtn.click();
       //3. Wait until loading bar disappears
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(dynamicTitle.loadingBar)));
       //4. Assert username inputbox is displayed
        Assert.assertTrue(dynamicTitle.username.isDisplayed());
       //5. Enter username: tomsmith
        dynamicTitle.username.sendKeys("tomsmith");
       //6. Enter password: incorrectpassword
        dynamicTitle.passwordDy.sendKeys("incorrectpassword");
       //7. Click to Submit button
        dynamicTitle.submitBtn.click();
       //8. Assert “Your password is invalid!” text is displayed.
        Assert.assertTrue(dynamicTitle.flashAlert.isDisplayed());
       //        Note: Follow POM Design Pattern
    }
}
