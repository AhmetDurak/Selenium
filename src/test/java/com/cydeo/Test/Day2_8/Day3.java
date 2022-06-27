package com.cydeo.Test.Day2_8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        task5(driver);

    }

    public static void task1(WebDriver driver){
        driver.navigate().to("https://login1.nextbasecrm.com/ ");

        WebElement userName = driver.findElement(By.name("USER_LOGIN"));
        userName.click();
        userName.sendKeys("incorrect");

        WebElement password = driver.findElement(new By.ByCssSelector("input[type='password']"));
        password.click();
        password.sendKeys("incorrect");

        WebElement submit = driver.findElement(By.className("login-btn"));
        submit.click();

        System.out.println(driver.findElement(By.className("errortext")).getText());

    }

    public static void task2(WebDriver driver){
        driver.navigate().to("https://login1.nextbasecrm.com/  ");

        WebElement label = driver.findElement(new By.ByCssSelector("label[for='USER_REMEMBER']"));
        if (label.getText().contains("Remember me on this computer")) System.out.println("Valid Label");
        else System.out.println("Invalid Label");


        WebElement forgotPass = driver.findElement(By.className("login-link-forgot-pass"));
        if (forgotPass.getText().equalsIgnoreCase("Forgot your password?")) System.out.println("Valid Text");
        else System.out.println("Invalid Text");
        if (forgotPass.getAttribute("href").contains("/?forgot_password=yes")) System.out.println("Link is matched");
        else System.out.println("Link is not matched");


    }

    public static void task3(WebDriver driver) {
        driver.navigate().to("https://login1.nextbasecrm.com/  ");

        WebElement logIn = driver.findElement(new By.ByCssSelector("input[value='Log In']"));

        if (logIn.getAttribute("value").equalsIgnoreCase("Log In")) System.out.println("Valid Text");
        else System.out.println("Invalid Text");



    }

    public static void task4(WebDriver driver) {
        driver.navigate().to("https://login1.nextbasecrm.com/?forgot_password=yes");

        WebElement resetPass = driver.findElement(By.className("login-btn"));

        if (resetPass.getAttribute("value").equalsIgnoreCase("Reset password")) System.out.println("Valid Text");
        else System.out.println("Invalid Text");


    }

    public static void task5(WebDriver driver) {
        driver.navigate().to("https://login1.nextbasecrm.com/?forgot_password=yes");
        WebElement loginBox = driver.findElement(By.name("USER_LOGIN"));
        loginBox.click();
        loginBox.sendKeys("incorrect");

        WebElement resetButton = driver.findElement(By.className("login-btn"));
        resetButton.click();

        WebElement errorLabel = driver.findElement(By.className("errortext"));
        if (errorLabel.getText().equalsIgnoreCase("Login or E-mail not found")) System.out.println("Valid Text");
        else System.out.println("Invalid Text");

    }
}
