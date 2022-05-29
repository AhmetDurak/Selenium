package com._4_airbnb.Tests;

import com._4_airbnb.Pages.airbnbFunctionalities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.Utilities.*;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    airbnbFunctionalities login;

    @BeforeClass
    public void setUp(){
        driver = Driver.get();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,5);
        driver.get(ConfigurationReader_Airbnb.get("url"));
        login = new airbnbFunctionalities();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @AfterClass
    public void tearDown() throws InterruptedException {
        //Thread.sleep(3000);
        //Driver.closeDriver();
    }
}
