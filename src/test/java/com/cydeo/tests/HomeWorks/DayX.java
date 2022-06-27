package com.cydeo.tests.HomeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import com.Utilities.*;
import org.testng.annotations.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class DayX {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https:www.webstaurantstore.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void test() throws Exception {
        try {
            WebElement accept = driver.findElement(new By.ByCssSelector("button.btn-primary"));
            wait.until(ExpectedConditions.elementToBeClickable(accept));
            accept.click();
        }catch (NoSuchElementException ignored){}

        Thread.sleep(1000);
        driver.findElement(new By.ByCssSelector("#searchval")).sendKeys("stainless work table");
        driver.findElement(new By.ByCssSelector("button[type='submit'][value='Search']")).click();
        List<WebElement> titles = driver.findElements(new By.ByCssSelector("#product_listing>div>div#details>a[data-testid='itemDescription']"));
        //System.out.println(titles.size());
        int count = 1;
        for (WebElement eachTitle : titles){
            //BrowserUtilities.scrollToElement(eachTitle);
            //System.out.println(count++ + ". " + eachTitle.getText()); // you can hide this line
            if (!eachTitle.getText().toLowerCase().contains("table")){
                throw new Exception("Title doesn't contain 'Table'");
            }
        }
        titles.get(titles.size()-1).click();
        System.out.println("Last artical is selected!");

        driver.findElement(new By.ByCssSelector("#buyButton")).click(); // add to Cart

        driver.findElement(new By.ByCssSelector("a[data-testid='cart-nav-link']")).click(); // go to cart

        driver.findElement(new By.ByCssSelector("button.emptyCartButton ")).click(); // empty cart

        driver.findElement(new By.ByCssSelector("footer>button:first-of-type")).click(); // confirmation empty cart

        BrowserUtilities.waitFor(3);
        String actualCart = driver.findElement(new By.ByCssSelector("span#cartItemCountSpan")).getText();
        String expectedCart = "0";

        Assert.assertEquals(actualCart,expectedCart,  "They are not equal");

    }

}
