package com.Projects._3_nopcommerce.Tests;

import com.Projects._3_nopcommerce.Pages.LoginFunctionality;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.Utilities.*;

public class TestBase {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    LoginFunctionality login;

    @BeforeClass
    public void setUp(){
        driver = Driver.get();
        wait = new WebDriverWait(driver,10);
        actions = new Actions(driver);
        login = new LoginFunctionality();
    }

    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }

}
