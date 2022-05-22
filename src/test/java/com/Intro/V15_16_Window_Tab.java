package com.Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class V15_16_Window_Tab {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demoqa.com/browser-windows");

        newWindow(driver);
    }

    // There is no difference between newTab and newWindow
    // After creating a new Tab, we need to create a current tabs list
    // Then we can switch to the other one

    public static void newTab(WebDriver driver) throws InterruptedException {
        WebElement newTabBtn = driver.findElement(By.id("tabButton"));
        newTabBtn.click();

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
        driver.close();
    }

    public static void newWindow(WebDriver driver) throws InterruptedException{
        WebElement newWindowBtn = driver.findElement(By.id("windowButton"));
        newWindowBtn.click();

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
        driver.close();
    }
}
