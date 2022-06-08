package com.Learning_Topics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.Utilities.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MyTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-us");

        driver = new ChromeDriver(options);

    }


    @Test
    public void test() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.airbnb.de/book/stays/432044?numberOfAdults=1&numberOfChildren=0&numberOfInfants=0&checkin=2022-09-22&checkout=2022-09-29&guestCurrency=EUR&productId=432044&isWorkTrip=false&numberOfGuests=1&numberOfPets=0");
        driver.findElement(new By.ByCssSelector("button._148dgdpk")).click();
        driver.findElement(new By.ByCssSelector("button[data-testid*='google']")).click();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        System.out.println(tabs.size());
        driver.switchTo().window(tabs.get(1));

        Thread.sleep(1000);
        WebElement email = driver.findElement(new By.ByCssSelector("input[autocomplete='username']"));
        Thread.sleep(5000);
        email.sendKeys("volkaff51@gmail.com");
        Thread.sleep(2000);
        email.sendKeys(Keys.ENTER);

    }
}
