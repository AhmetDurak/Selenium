package com.cydeo.Test.Day2_8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        //homeWork1(driver);
        //homeWork2(driver);
        //homeWork3(driver);
        //homeWork4(driver);
    }
    public static void wait(int milisec){
        try {
            Thread.sleep(milisec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void homeWork1(WebDriver driver){
        driver.navigate().to("https://www.etsy.com/");

        WebElement consent = driver.findElement(By.xpath("//div[2]/div[2]/button"));
        consent.click();

        wait(1000);

        // Scroll Down
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,700)");

        WebElement searchInput = driver.findElement(By.id("global-enhancements-search-query"));
        searchInput.click();
        searchInput.sendKeys("wooden spoon");

        WebElement searchClick = driver.findElement(new By.ByCssSelector("button[class^='wt-input-btn-group']"));
        searchClick.click();

        if (driver.getTitle().compareToIgnoreCase("wooden spoon") > 0){
            System.out.println("Valid Title : " + driver.getTitle());
        }else System.out.println("Invalid Title : " + driver.getTitle());
    }

    public static void homeWork2(WebDriver driver){
        driver.navigate().to("http://zero.webappsecurity.com/login.html");


        WebElement verifyTest = driver.findElement(By.cssSelector("div[class*='page-header']>h3"));
        System.out.println(verifyTest.getText());
    }

    public static void homeWork3(WebDriver driver){
        driver.navigate().to("https://www.google.com/");

        driver.findElement(By.id("L2AGLb")).click();

        driver.findElement(By.linkText("Gmail")).click();

        if (driver.getTitle().contains("Gmail")) System.out.println("Valid Title");
        else System.out.println("Invalid Title");

        driver.navigate().back();

        if (driver.getTitle().contains("Google")) System.out.println("Valid Title");
        else System.out.println("Invalid Title");
    }

    public static void homeWork4(WebDriver driver){
        driver.navigate().to("https://practice.cydeo.com/inputs ");

        driver.findElement(By.className("nav-link")).click();

        if (driver.getTitle().contains("Practice")) System.out.println("Valid Title");
        else System.out.println("Invalid Title");
    }
}























