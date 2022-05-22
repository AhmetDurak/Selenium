package com.Intro;

import com.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class v20_Modal {
    WebDriver driver = WebDriverFactory.getDriver("chrome");
    @Test
    public void modal()throws InterruptedException {

        driver.navigate().to("https://demoqa.com/modal-dialogs");

        WebElement smallModalBtn = driver.findElement(By.id("showSmallModal"));
        smallModalBtn.click();

        WebElement modalText = driver.findElement(By.cssSelector(".modal-body"));
        System.out.println(modalText.getText());

        Thread.sleep(2000);

        WebElement closeSmallModal = driver.findElement(By.id("closeSmallModal"));
        closeSmallModal.click();

    }
}
