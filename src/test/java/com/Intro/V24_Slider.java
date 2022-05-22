package com.Intro;

import com.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class V24_Slider {
    WebDriver driver;

    @BeforeMethod
    public void SetUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/slider");
    }

    @Test
    public void slider(){
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WebElement slider = driver.findElement(new By.ByCssSelector("input[type='range']"));
        Actions action = new Actions(driver);

        action.dragAndDropBy(slider,45,0).perform();
        String valueOnSlider = slider.getAttribute("value");

        WebElement sliderValue = driver.findElement(By.id("sliderValue"));
        String valueInBox = sliderValue.getAttribute("value");

        Assert.assertEquals(valueOnSlider, "60", "No match found!");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);

        driver.close();
    }
}
