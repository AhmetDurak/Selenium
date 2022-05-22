package com.Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class V11_DynamicElement {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1400, 1000));
        driver.get("https://demoqa.com/dynamic-properties");

        WebElement textElement = driver.findElement(By.xpath("//div/p[contains(text(),'This text has random Id')]"));
        System.out.println(textElement.getText());

        firstButton(driver);

    }
    public static void firstButton(WebDriver driver){
        WebElement firstButton = driver.findElement(By.id("enableAfter"));

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(firstButton));
        firstButton.click();
    }

    public static void changeColor(WebDriver driver){
        WebElement colorChangeButton = driver.findElement(By.id("colorChange"));
        String className = colorChangeButton.getAttribute("class");
        System.out.println("Before change: " + className);
        WebDriverWait wait1 = new WebDriverWait(driver, 5);
        wait1.until(ExpectedConditions.attributeToBe(colorChangeButton, "class", "mt-4 text-danger btn btn-primary"));
        System.out.println("After change: " + colorChangeButton.getAttribute("class"));
    }

    public static void lastButton(WebDriver driver){
        WebDriverWait wait2 = new WebDriverWait(driver, 5);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));

        WebElement lastButton = driver.findElement(By.id("visibleAfter"));
        lastButton.click();
        System.out.println(lastButton.getText());
    }
}
