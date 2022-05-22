package com.Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class V1_Locators {
    public static void main(String[] args) throws ElementClickInterceptedException{
        //System.setProperty("webdriver.chrome.driver", "C:/Users/volka/IdeaProjects/Selenium-Automation/drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");
       // driver.get("https://demoqa.com/checkbox");
        //driver.manage().window().maximize();

        WebElement userName = driver.findElement(By.id("userName"));
        userName.click();
        userName.sendKeys("Ahmet Durak");

        WebElement email = driver.findElement(new By.ByCssSelector("#userEmail"));
        email.click();
        email.sendKeys("durakahmet@gmail.com");

        WebElement currentAddress = driver.findElement(new By.ByCssSelector(".form-control[id='currentAddress']"));
        currentAddress.click();
        currentAddress.sendKeys("Alexanderstr. 52, 70182");

        WebElement permanentAddress = driver.findElement(By.xpath("//div/textarea[@id='permanentAddress']"));
        permanentAddress.click();
        permanentAddress.sendKeys("Germany");

        //WebElement submit = driver.findElement(By.xpath("//div/button[@id='submit']"));
        //submit.click();

        WebElement submit = driver.findElement(new By.ByCssSelector(".btn[id='submit']"));
        submit.click();






    }
}
