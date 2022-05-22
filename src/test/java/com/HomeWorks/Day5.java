package com.HomeWorks;

import com.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day5 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test1(){
        //TC #1: StaleElementReferenceException handling
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");
        //3. Click to “Add Element” button
        driver.findElement(new By.ByCssSelector("div.example>button")).click();
        //4. Verify “Delete” button is displayed after clicking.
        Assert.assertTrue(driver.findElement(new By.ByCssSelector("div#elements>button")).isDisplayed());
        //5. Click to “Delete” button.
        driver.findElement(new By.ByCssSelector("div#elements>button")).click();
        //6. Verify “Delete” button is NOT displayed after clicking.
        try {
            driver.findElement(new By.ByCssSelector("div#elements>button"));
        }catch (Exception ignored){
            Assert.assertTrue(true, "Element couldn't find");
        }

        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
    }

    @Test
    public void test2(){
        //TC #2: Radiobutton handling
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");
        //3. Click to “Hockey” radio button
        WebElement hockey = driver.findElement(By.id("hockey"));
        hockey.click();
        //4. Verify “Hockey” radio button is selected after clicking.
        Assert.assertTrue(hockey.isSelected(), "Hockey is selected");
        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
    }

    @Test
    public void test3(){
        //TC #3: Utility method task for (continuation of Task2)
        //    1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.navigate().to("https://practice.cydeo.com/radio_buttons");
        //3. Click to “Hockey” radio button
        List<WebElement> radioList = driver.findElements(By.xpath("//br[4]/following-sibling::div/input"));
        WebElement selected = null;
        for (WebElement each: radioList){
            if (each.getAttribute("id").contains("hockey")){
                selected = each;
                each.click();
            }
        }
        //4. Verify “Hockey” radio button is selected after clicking.
        Assert.assertTrue(selected.isSelected(), "Hockey isn't selected");


        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

        /*Create a utility method to handle above logic.
        Method name: clickAndVerifyRadioButton
        Return type: void or boolean
        Method args:
        1. WebDriver
        2. Name attribute as String (for providing which group of radio buttons)
        3. Id attribute as String (for providing which radio button to be clicked)

        Method should loop through the given group of radio buttons. When it finds the
        matching option, it should click and verify option is Selected.
                Print out verification: true*/
    }

    @Test
    public void test4(){
        //TC#4: Verifying “Simple dropdown” and “State selection” dropdown
        //default values
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        driver.navigate().to("https://practice.cydeo.com/dropdown");
        //3. Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”
        Select select1 = new Select(driver.findElement(By.id("dropdown")));

        String actualResult = select1.getOptions().get(0).getText();//Getting text of first option from selection list
        String expectedResult = "Please select an option";
        Assert.assertEquals(actualResult,expectedResult);
        //4. Verify “State selection” default selected value is correct
        Select selectAState = new Select(driver.findElement(By.id("state")));
        //Expected: “Select a State”
        String actualResult2 = selectAState.getOptions().get(0).getText();//Getting text of first option from selection list
        String expectedResult2 = "Select a State";
        Assert.assertEquals(actualResult2,expectedResult2);
    }

    @Test
    public void test5(){
        //TC #5: Selecting state from State dropdown and verifying result
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.navigate().to("http://practice.cybertekschool.com/dropdown");
        WebElement stateSelection = driver.findElement(By.id("state"));
        stateSelection.click();
        Select options = new Select(stateSelection);
        //3. Select Illinois
        options.selectByValue("Illinois");
        //4. Select Virginia
        options.selectByValue("Virginia");
        //5. Select California
        options.selectByValue("California");
        //6. Verify final selected option is California.
        //Use all Select options. (visible text, value, index)
    }

    @Test
    public void test6(){
        //TC #6: Selecting date on dropdown and verifying
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        //3. Select “December 1st, 1923” and verify it is selected.
        //        Select year using  : visible text
        //Select month using   : value attribute
        //Select day using : index number
    }

    @Test
    public void test7(){
        //TC #7: Selecting value from non-select dropdown
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        //3. Click to non-select dropdown
        //4. Select Facebook from dropdown
        //5. Verify title is “Facebook - Log In or Sign Up”
    }

    @Test
    public void test8(){
        //TC #8: Selecting value from multiple select dropdown
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        //3. Select all the options from multiple select dropdown.
        //4. Print out all selected values.
        //5. Deselect all values.
    }


}
