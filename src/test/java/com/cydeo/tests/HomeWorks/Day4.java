package com.cydeo.tests.HomeWorks;

import com.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day4 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void task1() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://practice.cydeo.com/forgot_password ");

        //3. Locate all the WebElements on the page using XPATH and/or CSS
        //locator only (total of 6)
        //a. “Home” link
        WebElement homeBtn = driver.findElement(new By.ByCssSelector("nav>ul>li>a"));
        System.out.println(homeBtn.getText());
        //b. “Forgot password” header
        WebElement forgotPass = driver.findElement(new By.ByCssSelector("div.example>h2"));
        System.out.println(forgotPass.getText());
        //c. “E-mail” text
        WebElement emailText = driver.findElement(new By.ByCssSelector("label[for=email]"));
        System.out.println(emailText.getText());
        //d. E-mail input box
        WebElement emailInput = driver.findElement(new By.ByCssSelector("div.large-6>input[name='email']"));
        System.out.println(emailInput.getAttribute("pattern"));
        //e. “Retrieve password” button
        WebElement retrievePass = driver.findElement(new By.ByCssSelector("form#forgot_password>button"));
        System.out.println(retrievePass.getText());
        //f. “Powered by Cydeo text
        WebElement poweredByCydeo = driver.findElement(new By.ByCssSelector("div.large-4>div"));
        System.out.println(poweredByCydeo.getText());
        //4. Verify all web elements are displayed.
        //First solve the task with using cssSelector only. Try to create 2 different
        //cssSelector if possible

        //Then solve the task using XPATH only. Try to create 2 different
        //XPATH locator if possible


    }

    @Test
    public void task2() {
        //1. Open Chrome browser
        //2. Go to http://practice.cydeo.com/multiple_buttons
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.navigate().to("http://practice.cydeo.com/multiple_buttons ");
        //3. Click on Button 1
        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        button1.click();
        //4. Verify text displayed is as expected:
        WebElement actual = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult = actual.getText();
        String expectedResult = "Clicked on button one!";
        //Expected: “Clicked on button one!”

        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
        System.out.println("actualResult = " + actualResult);
        System.out.println("expectedResult = " + expectedResult);
        Assert.assertEquals(actualResult, expectedResult, "Expected resul isn't matching with the actual result!");

    }

    @Test
    public void task3() {
        //TC #6:  XPATH LOCATOR practice
        //1. Open Chrome browser
        //2. Go to http://practice.cydeo.com/multiple_buttons
        driver.get("http://practice.cydeo.com/multiple_buttons");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //3. Click on Button 1
        driver.findElement(By.xpath("//button[1]")).click();
        //4. Verify text displayed is as expected:
        String expectedResult = "Clicked on button one!";
        String actualResult = driver.findElement(By.xpath("//p[contains(text(),'Clicked')]")).getText();
        //Expected: “Clicked on button one!”
        Assert.assertEquals(actualResult, expectedResult, "There is no match!");

    }

    @Test
    public void task4() {
        //TC #4: FindElements Task
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/abtest
        driver.navigate().to("https://practice.cydeo.com/abtest ");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //3- Locate all the links in the page.
        List<WebElement> linkList = driver.findElements(new By.ByCssSelector("body:not(body),a"));
        List<WebElement> linkList_xpath = driver.findElements(By.xpath("//body//a"));

        //4- Print out the number of the links on the page.
        System.out.println("Number of the links on the page: " + linkList.size());
        //5- Print out the texts of the links.
        List<WebElement> linkTexts = driver.findElements(new By.ByCssSelector("body:not(body),a"));
        for (WebElement each : linkTexts) {
            System.out.println(each.getText());
        }
        //6- Print out the HREF attribute values of the links
        for (WebElement each : linkTexts) {
            System.out.println(each.getAttribute("href"));
        }

    }

    @Test
    public void task5() {
        //1. Go to http://practice.cydeo.com/checkboxes
        driver.get("http://practice.cydeo.com/checkboxes");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //2. Confirm checkbox #1 is NOT selected by default
        WebElement checkbox1 = driver.findElement(By.id("box1"));
        System.out.println("Is Checkbox1 selected: " + checkbox1.isSelected());
        //3. Confirm checkbox #2 is SELECTED by default.
        WebElement checkbox2 = driver.findElement(By.id("box2"));
        System.out.println("Is Checkbox1 selected: " + checkbox2.isSelected());
        //4. Click checkbox #1 to select it.
        checkbox1.click();
        //5. Click checkbox #2 to deselect it.
        checkbox2.click();
        //6. Confirm checkbox #1 is SELECTED.
        System.out.println("Is Checkbox1 selected: " + checkbox1.isSelected());
        //7. Confirm checkbox #2 is NOT selected.
        System.out.println("Is Checkbox1 selected: " + checkbox2.isSelected());
    }

    @Test
    public void task6() {
        //TC #6: StaleElementReferenceException Task
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/abtest
        driver.navigate().to("https://practice.cydeo.com/abtest");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //3- Locate “CYDEO” link, verify it is displayed.
        WebElement cydeoLink = driver.findElement(By.linkText("CYDEO"));
        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());
        //4- Refresh the page.
        driver.navigate().refresh();
        //5- Verify it is displayed, again.
        // to prevent to get StaleElementReferenceException
        cydeoLink = driver.findElement(By.linkText("CYDEO"));
        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}














