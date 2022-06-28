package com.cydeo.Test.Day12.Tests;

import org.testng.annotations.Test;
import com.Utilities.*;

public class Homeworks extends TestBase{

    @Test
    public void ErrorMessageTest(){
        //TC #1: Required field error message test
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.get().get(ConfigurationReader.get("cydeo"));
        //3- Do not enter any information

        //4- Click to “Sign in” button
        //5- Verify expected error is displayed:
        //Expected: This field is required.

        //NOTE: FOLLOW POM DESIGN PATTERN
    }
}
