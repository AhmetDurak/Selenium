package com.Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import com.Utilities.*;
import org.testng.annotations.Test;

public class WebTables {
    @BeforeClass
    public void setUp(){
        Driver.get().get("https://practice.cydeo.com/tables");
    }

    @Test
    public void tables(){
        WebElement table = Driver.get().findElement(new By.ByCssSelector("table#table1"));
        WebElement row3 = Driver.get().findElement(new By.ByCssSelector("table#table1>tbody>tr"));
        WebElement allRows = Driver.get().findElement(new By.ByCssSelector("table#table1>tbody>tr>td"));
        WebElement column3 = Driver.get().findElement(new By.ByCssSelector("table#table1>tbody>tr>td:nth-of-type(3)"));
        WebElement frank = Driver.get().findElement(new By.ByCssSelector("//table[@id='table1']//td[.='Frank']"));

        // it will always return the due amount covers $100.00
        WebElement dueFrank = Driver.get().findElement(new By.ByCssSelector("//table[@id='table1']//td[.='$100.00']"));

        // This is important! -> it always returns Jason's due regardless of the location of him.
        // Here first we find location of Jason then go parent and looks for due value.
        WebElement dueJason = Driver.get().findElement(new By.ByCssSelector("//table[@id='table1']//td[.='Jason']//../td[4]"));
        // Here is another option -> following-sibling
        dueJason = Driver.get().findElement(new By.ByCssSelector("//table[@id='table1']//td[.='Jason']/following-sibling::td[2]"));


        //Q -> write a locator that returns Tim's last name based on tim's name
        WebElement lastNameTim = Driver.get().findElement(new By.ByCssSelector("//table[@id='table1']//td[.='Tim']/preceding-sibling::td[1]"));
        lastNameTim = Driver.get().findElement(new By.ByCssSelector("//table[@id='table1']//td[.='Tim']/../td[1]"));

        //Q -> write  a locator that returns all emails that has $50 Due date

        WebElement $50emails = Driver.get().findElement(new By.ByCssSelector("//table[@id='table1']//td[.='$50.00']/../td[3]"));
        $50emails = Driver.get().findElement(new By.ByCssSelector("//table[@id='table1']//td[.='$50.00']/preceding-sibling::td[1]"));



    }
}
