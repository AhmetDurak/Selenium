package com.cydeo.Test.Day12.Tests;

import com.cydeo.Test.Day12.Pages.LoginPage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.Utilities.*;

import java.util.concurrent.TimeUnit;

public class TestBase {
    LoginPage login;
    Actions actions;
    WebDriverWait wait;

    @BeforeClass
    public void setUp(){
        Driver.get().get(ConfigurationReader.get("cydeo"));
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        login = new LoginPage();
        actions = new Actions(Driver.get());
        wait = new WebDriverWait(Driver.get(), 10);
    }

    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }
}

// this testBase is for the WebDriverWaitPractice
class TestBase2{
    LoginPage dynamicTitle;
    Actions actions;
    WebDriverWait wait;

    @BeforeClass
    public void setUp(){
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        dynamicTitle = new LoginPage();
        actions = new Actions(Driver.get());
        wait = new WebDriverWait(Driver.get(), 10);
    }

    @AfterClass
    public void tearDown(){
       // Driver.closeDriver();
    }
}
