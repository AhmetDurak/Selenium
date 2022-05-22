package com.Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class V9_ActionClass {
    public static void main(String[] args) {
       // System.setProperty("webdriver.chrome.driver", "C:/Users/volka/IdeaProjects/Selenium-Automation/drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Launch the Application
        driver.get("https://demoqa.com/buttons");
        //driver.manage().window().maximize();

        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));

        Actions action = new Actions(driver);
        action.doubleClick(doubleClickButton).perform();                    //perform methodu islemi gerceklestirir.

        WebElement message = driver.findElement(new By.ByCssSelector("#doubleClickMessage"));
        System.out.println(message.getText());

        WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));
        action.contextClick(rightClickButton).perform();

        WebElement messageRightClick = driver.findElement(By.id("rightClickMessage"));
        System.out.println(messageRightClick.getText());

        // Dynamic element's id is always changed when the website is refreshed.
        // Using the CssSelector method will be not useful in this case.
        // in order to choose very specific value of element, we can use xpath method,
        // but it's not always preferable,
        // because it needs more time to reach the target

        //WebElement click = driver.findElement(By.id("vlEcn"));
        //action.click(click).perform();

        //https://www.guru99.com/using-contains-sbiling-ancestor-to-find-element-in-selenium.html#6
        //WebElement clickMe = driver.findElement(By.xpath("//div/button[starts-with(text(),'Click Me')]"));
        //   //div/button[contains(text(),'Click Me')]   --> xPath contains method
        //action.click(clickMe).perform();
        //  if it's the last element in div block, we can use this button.
        WebElement dynamicButton = driver.findElement(By.xpath("//div[last()]/button"));
        //WebElement clickMe = driver.findElement(By.xpath("//div/button[starts-with(text(),'Click Me')]");
        action.click(dynamicButton).perform();

        WebElement messageDynamicButton = driver.findElement(By.xpath("//div/p[@id='dynamicClickMessage']"));
        System.out.println(messageDynamicButton.getText());

    }
}
