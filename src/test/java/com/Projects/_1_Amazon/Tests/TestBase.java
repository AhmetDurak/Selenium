package com.Projects._1_Amazon.Tests;


import com.Utilities.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);

        driver.get(ConfigurationReader.get("url"));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);

        Driver.closeDriver();
    }
}
