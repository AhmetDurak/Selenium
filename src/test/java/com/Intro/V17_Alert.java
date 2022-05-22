package com.Intro;


import com.Utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class V17_Alert {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

    @Test
    public void alert() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/alerts");
        driver.findElement(By.id("alertButton")).click();

        Thread.sleep(2000);

        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        driver.close();
    }
    @Test
    public void alert5SecLater() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/alerts");
        driver.findElement(By.id("timerAlertButton")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());

        Thread.sleep(2000);

        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        driver.close();
    }
    @Test
    public  void alertBox_and_getText() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/alerts");
        driver.findElement(By.id("confirmButton")).click();
        // GET TEXT
        System.out.println(driver.switchTo().alert().getText());

        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);

        driver.close();
    }
    @Test
    public void promptBox() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/alerts");
        driver.findElement(By.id("promtButton")).click();

        // We can use also Alert object to shorten the code
        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText());

        Thread.sleep(2000);

        alert.sendKeys("Hello World");

        Thread.sleep(2000);
        alert.accept();

        driver.close();
    }
}
