package com.Projects.Examples;


import com.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Example_closingAds_Frame {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        closeAd(driver);

    }

    public static void closeAd(WebDriver driver) throws InterruptedException{
        driver.navigate().to("https://demoqa.com/frames");
        Actions actions = new Actions(driver);

        Thread.sleep(10000);

        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        List<WebElement> list = driver.findElements(new By.ByCssSelector("iframe[id*='google_ads']"));
        for (WebElement each : list){
            System.out.println(each);
        }
        int counter = 1;
        for (WebElement each: list){
            driver.switchTo().frame(each);
            System.out.println("Frame :" + counter++);
            Thread.sleep(1000);

            try{
                WebElement closeFrame = driver.findElement(new By.ByCssSelector("label#cbb>svg>path:last-child"));
                //System.out.println(closeFrame.getAttribute("class"));
                actions.click(closeFrame).perform();

                WebElement closeFrame2 = driver.findElement(By.id("div#close_button"));
                actions.click(closeFrame2).perform();

            }catch (Exception e){
                System.out.println("Exception");
            }

            Thread.sleep(1000);

            driver.switchTo().parentFrame();
            System.out.println("You're now at Parent Frame");

            Thread.sleep(1000);
        }

        System.out.println("All ads should be showing 'SEND FEEDBACK'");
    }
}
