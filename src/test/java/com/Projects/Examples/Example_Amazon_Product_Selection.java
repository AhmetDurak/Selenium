package com.Projects.Examples;

import com.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Example_Amazon_Product_Selection {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.amazon.com/");

        goAmazon(driver);

    }
    public static void goAmazon(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement menuAll = driver.findElement(By.id("nav-hamburger-menu"));
        menuAll.click();

        driver.findElement(new By.ByCssSelector("a[data-menu-id='5']")).click();
        driver.findElement(new By.ByCssSelector("div#hmenu-content>ul:nth-child(5)>li:nth-child(7)")).click();



    }
}
