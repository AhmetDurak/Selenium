package com.Intro;

import com.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class V23_DataPicker {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @Test
    public void dataPicker() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/date-picker");

        driver.findElement(By.id("datePickerMonthYearInput")).click();

        WebElement month = driver.findElement(new By.ByCssSelector(".react-datepicker__month-select"));
        Select select = new Select(month);
        select.selectByValue("0");

        WebElement year = driver.findElement(new By.ByCssSelector(".react-datepicker__year-select"));
        select = new Select(year);
        select.selectByValue("1994");

        List<WebElement> days = driver.findElements(new By.ByCssSelector(".react-datepicker__day"));
        for (WebElement day: days){
            System.out.print(day.getText() + " ");
        }
        // try to make a binarySearch for month selector


        for (WebElement day: days){
            if (day.getText().equals("16")){
                day.click();
                break;
            }
        }
        System.out.println("\n" + driver.findElement(By.id("datePickerMonthYearInput")).getAttribute("value"));

        //driver.close();
    }
}
