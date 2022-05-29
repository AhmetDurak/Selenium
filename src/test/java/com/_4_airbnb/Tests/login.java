package com._4_airbnb.Tests;

import org.testng.annotations.Test;

public class login extends TestBase{

    @Test
    public void test1(){
        // accepting Cookies
        login.consentCookies.click();
    }
}
