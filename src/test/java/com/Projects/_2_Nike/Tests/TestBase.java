package com.Projects._2_Nike.Tests;

import com.Utilities.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    @BeforeClass
    public void setUp(){
        driver = Driver.get();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.get("nikeHomePage"));
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        //Thread.sleep(3000);
        //Driver.closeDriver();
    }
}
