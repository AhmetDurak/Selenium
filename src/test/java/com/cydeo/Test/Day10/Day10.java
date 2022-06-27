package com.cydeo.Test.Day10;

import com.Utilities.*;
import com.cydeo.Test.TestBase.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day10 extends TestBase {
    @Test
    public void Task1() {
        //TC#1: Registration form confirmation
        //Note: Use JavaFaker OR read from configuration.properties file when possible.
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        Driver.get().get(ConfigurationReader.get("javaFaker"));
        Faker faker = new Faker();
        //3. Enter first name
        Driver.get().findElement(new By.ByCssSelector("input[name='firstname']")).sendKeys(faker.name().firstName());
        //4. Enter last name
        Driver.get().findElement(new By.ByCssSelector("input[name='lastname']")).sendKeys(faker.name().lastName());
        //5. Enter username
        Driver.get().findElement(new By.ByCssSelector("input[name='username']")).sendKeys(faker.name().username().replace(".", ""));
        //6. Enter email address
        Driver.get().findElement(new By.ByCssSelector("input[name='email']")).sendKeys(faker.internet().emailAddress());
        //7. Enter password
        Driver.get().findElement(new By.ByCssSelector("input[name='password']")).sendKeys(faker.internet().password());
        //8. Enter phone number
        Driver.get().findElement(new By.ByCssSelector("input[name='phone']")).sendKeys(faker.numerify("571-###-####"));
        //9. Select a gender from radio buttons
        Driver.get().findElement(new By.ByCssSelector("input[name='gender']")).click();
        //10. Enter date of birth
        Driver.get().findElement(new By.ByCssSelector("input[name='birthday']")).sendKeys("11/11/1993");
        //11. Select Department/Office
        Select select = new Select(Driver.get().findElement(new By.ByCssSelector("select[name='department']")));
        select.selectByValue("DE");
        //12. Select Job Title
        select = new Select(Driver.get().findElement(new By.ByCssSelector("select[name='job_title']")));
        select.selectByIndex(4);
        //13. Select programming language from checkboxes
        Driver.get().findElement(By.id("inlineCheckbox2")).click();
        Driver.get().findElement(By.id("inlineCheckbox3")).click();
        Driver.get().findElement(By.id("wooden_spoon")).click();

        //14. Click to sign up button
        //15. Verify success message “You’ve successfully completed registration.” is
        //displayed.

        //        Note:
        //1. Use new Driver utility class and method
        //2. User JavaFaker when possible
        //3. User ConfigurationReader when it makes sense

    }

    @Test
    public void Task2() {
        //TC #2 Upload Test
        //1. Go to https://practice.cydeo.com/upload
        Driver.get().get(ConfigurationReader.get("upload"));
        //2. Find some small file from your computer, and get the path of it.
        String path = "C:/Users/volka/Downloads/HTML Input Types.jpg";
        Driver.get().findElement(By.id("file-upload")).sendKeys(path);
        //3. Upload the file.
        Driver.get().findElement(By.id("file-submit")).click();
        //4. Assert:
        //-File uploaded text is displayed on the page
        String expectedResult = "File Uploaded!";
        String actualResult = Driver.get().findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(expectedResult, actualResult);


    }

    @Test
    public void Task3() {
        //TC #3: Hover Test
        //1. Go to https://practice.cydeo.com/hovers
        Driver.get().get(ConfigurationReader.get("hover"));
        //2. Hover over to first image
        actions.moveToElement(Driver.get().findElement(new By.ByCssSelector(".figure:first-of-type"))).perform();
        //3. Assert:
        //a. “name: user1” is displayed
        WebElement name = Driver.get().findElement(new By.ByCssSelector(".example>.figure:first-of-type>.figcaption>h5"));
        Assert.assertTrue(name.isDisplayed());
        //b. “view profile” is displayed
        WebElement viewProfile = Driver.get().findElement(new By.ByCssSelector(".example>.figure:first-of-type>.figcaption>a"));
        Assert.assertTrue(viewProfile.isDisplayed());


        //4. Hover over to second image
        actions.moveToElement(Driver.get().findElement(new By.ByCssSelector(".figure:nth-of-type(2)"))).perform();
        //5. Assert:
        //a. “name: user2” is displayed
        WebElement name2 = Driver.get().findElement(new By.ByCssSelector(".example>.figure:nth-of-type(2)>.figcaption>h5"));
        Assert.assertTrue(name2.isDisplayed());
        //b. “view profile” is displayed
        WebElement viewProfile2 = Driver.get().findElement(new By.ByCssSelector(".example>.figure:nth-of-type(2)>.figcaption>a"));
        Assert.assertTrue(viewProfile2.isDisplayed());

        //6. Hover over to third image
        actions.moveToElement(Driver.get().findElement(new By.ByCssSelector(".figure:nth-of-type(3)"))).perform();

        //7. Confirm:
        //a. “name: user3” is displayed
        WebElement name3 = Driver.get().findElement(new By.ByCssSelector(".example>.figure:nth-of-type(3)>.figcaption>h5"));
        Assert.assertTrue(name3.isDisplayed());
        //b. “view profile” is displayed
        WebElement viewProfile3 = Driver.get().findElement(new By.ByCssSelector(".example>.figure:nth-of-type(3)>.figcaption>a"));
        Assert.assertTrue(viewProfile3.isDisplayed());
    }

    @Test
    public void Task4_5() throws InterruptedException {
        //TC #4: Scroll practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/
        Driver.get().get(ConfigurationReader.get("scrollPractice"));
        //3- Scroll down to “Powered by CYDEO”
        String text = "Powered by CYDEO";
        WebElement cydeo;
        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        /*while(true){
            try {
                cydeo = driver.findElement(By.xpath("//div[contains(text(),'Powered by')]"));
                break;
            }catch (NoSuchElementException ignored){
                js.executeScript("window.scrollBy(0,100)");
            }
        }*/

        // Scrolling into the view  <-----------------
        cydeo = Driver.get().findElement(By.xpath("//div[contains(text(),'Powered by')]"));
        //js.executeScript("arguments[0].scrollIntoView(true);",cydeo);

        // Page up and down keys  <-----------------

        /*int i = 0;
        while(true){
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            if(i == 5) break;
            i++;
        }
        Thread.sleep(3000);
        i = 0;
        while(true){
            actions.sendKeys(Keys.PAGE_UP).build().perform();
            if(i == 5) break;
            i++;
        }*/

        //4- Scroll using Actions class “moveTo(element)” method
        actions.moveToElement(cydeo).perform();

        //TC #5: Scroll practice 2
        //1- Continue from where the Task 4 is left in the same test.
        //2- Scroll back up to “Home” link using PageUP button
    }

    @Test
    public void Task6() throws InterruptedException {
        // TC #6: Scroll using JavascriptExecutor
        // 1- Open a chrome browser
        // 2- Go to: https://practice.cydeo.com/infinite_scroll
        Driver.get().get(ConfigurationReader.get("infiniteScroll"));
        // 3- Use below JavaScript method and scroll
        JavascriptExecutor js = (JavascriptExecutor) Driver.get();

        // a.  750 pixels down 10 times.
        // b.  750 pixels up 10 times

        //JavaScript method to use : window.scrollBy(0,0)

        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0,750)");
            if (i == 10) break;
            Thread.sleep(100);
        }
    }

    @Test
    public void Task7() throws InterruptedException {
        //TC #7: Scroll using JavascriptExecutor
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/large
        Driver.get().get(ConfigurationReader.get("largeDeepDom"));
        //3- Scroll down to “Cydeo” link
        WebElement cydeoLink = Driver.get().findElement(By.linkText("CYDEO"));
        actions.moveToElement(cydeoLink).perform();
        Thread.sleep(3000);
        //4- Scroll up to “Home” link
        WebElement homeLink = Driver.get().findElement(By.linkText("Home"));
        actions.moveToElement(homeLink).perform();

    }

    @Test
    public void Task7_1() throws InterruptedException {
        //TC #7: Scroll using JavascriptExecutor
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/large
        Driver.get().get(ConfigurationReader.get("largeDeepDom"));

        //5- Use below provided JS method only
        //JavaScript method to use : arguments[0].scrollIntoView(true)
        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        js.executeScript("arguments[0].scrollIntoView(true);",Driver.get().findElement(By.linkText("CYDEO")));
        //Note: You need to locate the links as web elements and pass them as
        //arguments into executeScript() method
        Thread.sleep(3000);
        js.executeScript("arguments[0].scrollIntoView(true);",Driver.get().findElement(By.linkText("Home")));

    }

}
