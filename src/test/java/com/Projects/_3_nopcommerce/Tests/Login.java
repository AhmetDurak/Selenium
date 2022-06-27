package com.Projects._3_nopcommerce.Tests;

import org.testng.annotations.Test;

public class Login extends TestBase{
    @Test
    public void Test(){
        driver.get("https://demo.nopcommerce.com/");


        login.searchBox.click();
        login.searchBox.sendKeys("");
    }
}
