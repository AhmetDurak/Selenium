package com.Utilities.HomeWorks;

import com.Utilities.BrowserUtils;
import com.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day7 {
    // Check BrowserUtils for tasks of this day

    @BeforeClass
    public void setUp() {
        System.out.println("Setup");
    }

    @Test
    public void TC1_WindowHandlingTest() {
        Driver.get().get("https://www.amazon.com");
        windowHandling("https://www.google.com");
    }

    @Test
    public void TC2_Create_a_Utility_Method(){
        BrowserUtils.switchWindowAndVerify("https://www.google.com", "google");
    }

    @Test
    public void TC3_Login_Scenario(){
        Driver.get().get("http://login1.nextbasecrm.com/ ");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement username = Driver.get().findElement(new By.ByCssSelector("input[name='USER_LOGIN']"));
        WebElement password = Driver.get().findElement(new By.ByCssSelector("input[name='USER_PASSWORD']"));
        WebElement login = Driver.get().findElement(new By.ByCssSelector("input[type='submit'"));

        username.click();
        username.sendKeys("helpdesk1@cybertekschool.com");
        password.click();
        password.sendKeys("UserUser");
        login.click();

        //BrowserUtils
        BrowserUtils.sleep(3);
        BrowserUtils.verifyTitle("Portal");

    }

    //username : helpdesk1@cybertekschool.com
    //password : UserUser
    @Test
    public void TC4_Create_a_Utility_Method_Login(){
        //BrowserUtils.crm_login();
        BrowserUtils.crm_login("helpdesk1@cybertekschool.com","UserUser");
        BrowserUtils.verifyTitle("Portal");
    }

    public void windowHandling(String newTabURL) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        js.executeScript("window.open('" + newTabURL + "','_blank');");
    }

}
