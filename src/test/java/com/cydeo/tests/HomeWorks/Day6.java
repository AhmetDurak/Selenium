package com.cydeo.tests.HomeWorks;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import com.Utilities.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day6 {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    @BeforeClass
    public void setUp(){
        driver = Driver.get();
        wait = new WebDriverWait(driver, 5);
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    public void tearDown(){
        //Driver.closeDriver();
    }

    @Test
    public void test1_info_alert(){
        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.navigate().to("http://practice.cydeo.com/javascript_alerts");
        //3. Click to “Click for JS Alert” button
        WebElement jsAlertBtn = driver.findElement(new By.ByCssSelector("button:first-of-type"));
        jsAlertBtn.click();
        //4. Click to OK button from the alert
        driver.switchTo().alert().accept();
        //5. Verify “You successfully clicked an alert” text is displayed.
        Assert.assertTrue(!driver.findElement(By.id("result")).getText().isEmpty(),"There is no result!");

    }
    @Test
    public void test2_confirmation_alert(){
        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");
        //3. Click to “Click for JS Confirm” button
        driver.findElement(new By.ByCssSelector("button:nth-of-type(2)")).click();
        //4. Click to OK button from the alert
        driver.switchTo().alert().accept();
        //5. Verify “You clicked: Ok” text is displayed.
        Assert.assertTrue(driver.findElement(By.id("result")).getText().equalsIgnoreCase("You clicked: Ok"),"There is no matching result!");
    }
    @Test
    public void test3_info_alert(){
        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");
        //3. Click to “Click for JS Prompt” button
        driver.findElement(new By.ByCssSelector("button:last-of-type")).click();
        //4. Send “hello” text to alert
        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys("hello");
        //5. Click to OK button from the alert
        prompt.accept();
        //6. Verify “You entered:  hello” text is displayed.
        Assert.assertTrue(driver.findElement(By.id("result")).getText().equalsIgnoreCase("You entered: hello"),"There is no matching result");
    }
    @Test
    public void test4_Iframe(){
        //1. Create a new class called: T4_Iframes
        //2. Create new test and make set ups
        //3. Go to: https://practice.cydeo.com/iframe
        driver.get("https://practice.cydeo.com/iframe");
        //4. Assert: “Your content goes here.” Text is displayed.
        driver.switchTo().frame("mce_0_ifr");
        String content = driver.findElement(By.cssSelector("body#tinymce>p")).getText();
        String expected = "Your content goes here.";
        Assert.assertEquals(content,expected, "There is no matching result");
        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        driver.switchTo().parentFrame();
        String contentParent = driver.findElement(By.tagName("h3")).getText();
        String expectedParent = "An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(contentParent,expectedParent,"There is no matching result!");
    }
    @Test
    public void test5_Windows_Handle(){
        //1. Create a new class called: T5_WindowsPractice
        //2. Create new test and make set ups
        //3. Go to : https://practice.cydeo.com/windows
        driver.get("https://practice.cydeo.com/windows");
        //4. Assert: Title is “Windows”
        Assert.assertTrue(driver.getTitle().equals("Windows"),"There is no matching result");
        //5. Click to: “Click Here” link
        driver.findElement(new By.ByCssSelector("div.example>a")).click();
        //6. Switch to new Window.
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        //7. Assert: Title is “New Window”
        Assert.assertTrue(driver.getTitle().equals("New Window"),"There is no matching result");

    }

}
