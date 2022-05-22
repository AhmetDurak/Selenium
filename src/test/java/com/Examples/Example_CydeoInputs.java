package com.Examples;

import com.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Example_CydeoInputs {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setSize(new Dimension(1100,1100));
        WebDriverWait wait = new WebDriverWait(driver, 5);


        driver.navigate().to("https://practice.cydeo.com/inputs");

        WebElement home = driver.findElement(By.className("nav-link"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        home.click();

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if (expectedTitle.contains(expectedTitle)){
            System.out.println("Title is valid");
        }else System.out.println("Title is invalid");

    }
}
