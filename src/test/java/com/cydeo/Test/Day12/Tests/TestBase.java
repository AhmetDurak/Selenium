package com.cydeo.Test.Day12.Tests;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.Utilities.*;

import java.util.concurrent.TimeUnit;

public class TestBase {
    Actions actions;
    WebDriverWait wait;

    @BeforeClass
    public void setUp(){
        Driver.get();
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        actions = new Actions(Driver.get());
        wait = new WebDriverWait(Driver.get(), 10);
    }

    @AfterClass
    public void tearDown(){
        //Driver.closeDriver();
    }
}
