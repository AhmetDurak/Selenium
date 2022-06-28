package com.cydeo.Test.Day12.Tests;

import com.cydeo.Test.Day12.Pages.BasePage;
import com.cydeo.Test.Day12.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Utilities.*;

public class Homeworks extends TestBase{
    LoginPage login = new LoginPage();

    @Test
    public void ErrorMessageTest(){
        //TC #1: Required field error message test
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.get().get(ConfigurationReader.get("cydeo"));
        //3- Do not enter any information
        //4- Click to “Sign in” button
        login.signIn.click();
        //5- Verify expected error is displayed:
        //Expected: This field is required.
        Assert.assertTrue(login.errorMessage.isDisplayed());

        //NOTE: FOLLOW POM DESIGN PATTERN
    }

    @Test
    public void invalidEmailFormatErrorTest(){
        //TC #2: Invalid email format error message test
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.get().get(ConfigurationReader.get("cydeo"));
        //3- Enter invalid email format
        login.userEmail.sendKeys("asödkjfalkdm");
        login.signIn.click();
        //4- Verify expected error is displayed:
        Assert.assertTrue(login.errorMessage.isDisplayed());
        //Expected: Please enter a valid email address.
        String expectedResult = "Please enter a valid email address.";
        Assert.assertEquals(expectedResult,login.errorMessage.getText());


        //NOTE: FOLLOW POM DESIGN PATTERN
    }
}
