package com.Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class V1_RegisterToolQA {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1100,1100));
        driver.navigate().to("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(new By.ByCssSelector(".mr-sm-2[placeholder='Full Name']"));
        fullName.click();
        fullName.sendKeys("Ahmet Durak");

        WebElement email = driver.findElement(By.id("userEmail"));
        email.click();
        email.sendKeys("durakahmet@gmail.com");

        WebElement currentAddress = driver.findElement(By.tagName("textarea"));
        currentAddress.click();
        currentAddress.sendKeys("Alexanderstr.52");

        WebElement permanentAddress = driver.findElement(By.xpath("//div/textarea[@id='permanentAddress']"));
        permanentAddress.click();
        permanentAddress.sendKeys("Germany");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        WebElement name = driver.findElement(new By.ByCssSelector(".mb-1[id='name']"));
        String nameSubmit = name.getText();
        nameSubmit = nameSubmit.substring(nameSubmit.indexOf(":") + 1);
        System.out.println(nameSubmit);

    }
}
