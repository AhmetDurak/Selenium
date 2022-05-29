package com.HomeWorks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.Utilities.*;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day7 {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    @BeforeClass
    public void setUp(){
        driver = Driver.get();
        wait = new WebDriverWait(driver, 10);
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @AfterClass
    public void tearDown(){
        //Driver.closeDriver();
    }

    @Test
    public void test1_window_handle(){

    }
}
