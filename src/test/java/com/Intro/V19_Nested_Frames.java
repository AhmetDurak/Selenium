package com.Intro;

import com.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class V19_Nested_Frames {
    WebDriver driver = WebDriverFactory.getDriver("chrome");

    @Test
    public void nested_Frames(){
        driver.navigate().to("https://demoqa.com/nestedframes");

        driver.switchTo().frame("frame1");
        System.out.println("Parent body: " + driver.findElement(By.tagName("body")).getText());

        driver.switchTo().frame(0);
        System.out.println("Child body: " + driver.findElement(By.tagName("body")).getText());

    }
}
