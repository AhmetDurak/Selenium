package com.Utilities;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

/*
 *This is the class, which we're going to store reusable methods to use in our projects
 *All methods are static, so you don't need to create an object, but it uses some memory!
 *You can add and create any method for reusing
 */
public class BrowserUtils {

    public static void sleep(int second){
        try {
            Thread.sleep(second*1000);
        }catch (InterruptedException ignored){}
    }

    public static void switchWindowAndVerify(String expectedInUrl, String expectedTitle){
        Set<String> allWindows = Driver.get().getWindowHandles();

        for (String each: allWindows){
            Driver.get().switchTo().window(each);
            //System.out.println("Current URL: " + Driver.get().getCurrentUrl());
            if (Driver.get().getCurrentUrl().contains(expectedInUrl))break;
        }
        String actualTitle = Driver.get().getTitle();
        //System.out.println("Actual Title = " + actualTitle);

        Assert.assertTrue(actualTitle.toLowerCase().contains(expectedTitle.toLowerCase()));
    }

    // This method accepts  a String  "expectedTitle" and asserts if it is true
    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(Driver.get().getTitle(), expectedTitle);
    }

}
