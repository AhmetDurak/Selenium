package com.Intro;

import com.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class V25_ProgressBar {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/progress-bar");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void  progressBar() throws Exception {
        WebElement startStopButton = driver.findElement(new By.ByCssSelector("button.mt-3"));
        startStopButton.click();

        WebElement progressBar = driver.findElement(new By.ByCssSelector("div#progressBar>div"));

        WebDriverWait wait = new WebDriverWait(driver, 25);

        // here we're trying to get live value from progress bar
        //wait.pollingEvery(Duration.ofMillis(100))
        //        .until(ExpectedConditions.attributeToBe(progressBar, "aria-valuenow","50"));

        //startStopButton.click();
        //System.out.println("Progress Bar: " + progressBar.getAttribute("aria-valuenow"));


        //here we're getting Stale element error, in order to avoid from it, we need find its element one more time.
        wait.until(ExpectedConditions.attributeToBe(new By.ByCssSelector("button.mt-3"),"id","resetButton"));
        startStopButton = driver.findElement(new By.ByCssSelector("button.mt-3"));
        startStopButton.click();

    }

    @AfterMethod
    public void Teardown() throws InterruptedException {
        Thread.sleep(3000);

        driver.close();
    }
}
