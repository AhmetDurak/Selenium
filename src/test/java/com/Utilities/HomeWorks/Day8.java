package com.Utilities.HomeWorks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.Utilities.*;

import java.util.concurrent.TimeUnit;

public class Day8 {
    @BeforeClass
    public void setUp(){
        Driver.get().get("https://practice.cydeo.com/web-tables");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void TC1_Web_Table_Practice(){
        //1. Go to: https://practice.cydeo.com/web-tables
        //2. Verify Bob’s name is listed as expected.
        WebElement bobMartin = Driver.get().findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']"));
        //Expected: “Bob Martin”
        String actualResult = bobMartin.getText();
        String expectedResult = "Bob Martin";
        Assert.assertEquals(actualResult, expectedResult);
        //3. Verify Bob Martin’s order date is as expected
        String date = "//table[@class='SampleTable']//td[.='Bob Martin']/following-sibling::td[3]";
        WebElement bobMartinDate = Driver.get().findElement(By.xpath(date));
        //Expected: 12/31/2021
        String expectedDate = "12/31/2021";
        String actualDate = bobMartinDate.getText();
        Assert.assertEquals(actualDate,expectedDate);
    }

    @Test
    public void TC2_WebTable_Utils(){
        System.out.println(WebTableUtils.returnOrderDate("Bart Fisher"));
        WebTableUtils.orderVerify("Bart Fisher","01/16/2021");
    }

    @Test
    public void TC3_getTableGetEmail(){
        Driver.get().get("https://practice.cydeo.com/tables");

        System.out.println(WebTableUtils.getTableGetEmail(2, "Frank"));
    }
}
