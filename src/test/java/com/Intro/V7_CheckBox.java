package com.Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class V7_CheckBox {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "C:/Users/volka/IdeaProjects/Selenium-Automation/drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //driver.get("https://demoqa.com/checkbox");
        driver.get("https://demoqa.com/automation-practice-form");


        //WebElement nameText = driver.findElement(new By.ByCssSelector(".mb-1[id='name']"));  // //div/p[@id='name'] <--- if you want to bring it with xpath method
        //System.out.println(nameText.getText());
//
        //String homeCheckBoxCssValue = "label[for='tree-node-home'] span.rct-checkbox svg";
//
        //WebElement homeCheckBox = driver.findElement(new By.ByCssSelector(homeCheckBoxCssValue));
        //homeCheckBox.click();
//
        //homeCheckBox = driver.findElement(new By.ByCssSelector(homeCheckBoxCssValue));
//
        //String homeCheckBoxClassName = homeCheckBox.getAttribute("class");
//
        //if (homeCheckBoxClassName.equals("rct-icon rct-icon-check")) System.out.println("Checkbox is checked");
        //else System.out.println("Checkbox is unchecked");

        // -----------------------

        WebElement hobbySport = driver.findElement(By.id("hobbies-checkbox-1"));
        WebElement HobbySport = driver.findElement(new By.ByCssSelector("label[for='hobbies-checkbox-1']"));


        //---->HOW TO CLICK CHECKBOX AND HOW TO FORCE CLICKING IF IT DOESN'T WORK

        // ---> Try actions class -> it works without exception handling

        if (hobbySport.isEnabled()){ // if it can be clickable
            try{
                System.out.println("Entered try block");
                hobbySport.click();
            }catch (ElementClickInterceptedException e){
                HobbySport.click();
                System.out.println("Entered catch block");
            }
        }
        System.out.println(hobbySport.isSelected());        // if it is selected

        WebElement reading = driver.findElement(By.id("hobbies-checkbox-2"));
        WebElement reading2 = driver.findElement(new By.ByCssSelector("label[for='hobbies-checkbox-2']"));
//
        try{
            reading.click();
        }catch(ElementClickInterceptedException e){
          reading2.click();
          System.out.println("entered catch block");
        }

    }
}
