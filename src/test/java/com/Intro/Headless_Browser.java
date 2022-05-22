package com.Intro;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Headless_Browser {
    public static void main(String[] args) throws InterruptedException {
       runOverChrome();
    }

    public static void runOverHtmlUnitDriver() {
        //HtmlUnitDriver driver = new HtmlUnitDriver(true);
        HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);
        driver.navigate().to("https://demoqa.com/");
        System.out.println("Title of the website is : " + driver.getTitle());

        driver.close();
    }

    public static void runOverChrome() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        ChromeDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://demoqa.com/alerts");


        driver.findElement(By.id("confirmButton")).click();
        Thread.sleep(200);

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());

        alert.accept();
        System.out.println("You said 'confirm'");

        driver.close();    }

    public static void runOverFireFox() throws InterruptedException{
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("headless");
        FirefoxDriver driver = new FirefoxDriver();

        driver.navigate().to("https://demoqa.com/alerts");


        driver.findElement(By.id("confirmButton")).click();
        Thread.sleep(200);

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());

        alert.accept();

        driver.close();
    }
}
