package com.Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class V8_RadioButton {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        //driver.manage().window().maximize();

        WebElement yesRadioButton = driver.findElement(new By.ByCssSelector(".custom-control-label"));
        if (yesRadioButton.isEnabled()){
            System.out.println("Clicked yesRadioButton");
            yesRadioButton.click();
        }
        WebElement output = driver.findElement(new By.ByCssSelector("p.mt-3"));
        System.out.println(output.getText());

        WebElement isSelected = driver.findElement(new By.ByCssSelector("#yesRadio"));
        if (isSelected.isEnabled()) System.out.println("yesRadioButton is ");

        WebElement noRadioButton = driver.findElement(new By.ByCssSelector("#noRadio"));
        System.out.println("NoRadio Button is " + (noRadioButton.isEnabled()? "enable":"not enable"));
    }
}
