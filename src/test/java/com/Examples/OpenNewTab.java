package com.Examples;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import com.Utilities.*;
import org.testng.annotations.Test;

public class OpenNewTab {
    @BeforeClass
    public void setUp(){
        Driver.get().get("https://www.amazon.com");
    }

    @Test
    public void WindowHandlingTest(){
        windowHandling("https://www.google.com");
        BrowserUtils.switchWindowAndVerify("https://www.google.com", "google");
    }

    public void windowHandling(String newTabURL){
        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        js.executeScript("window.open('"+newTabURL+"','_blank');");
    }

}
