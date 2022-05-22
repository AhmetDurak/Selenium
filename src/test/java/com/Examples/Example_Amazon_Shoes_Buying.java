package com.Examples;

import com.Utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Example_Amazon_Shoes_Buying {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().window().setSize(new Dimension(800, 800));
        driver.get("https://www.amazon.de/");
    }
    @Test
    void amazon2() throws InterruptedException {
        driver.get("https://www.amazon.de/Nike-Herren-Court-Volley-Tennisschuh/dp/B08X4QJDCL/ref=sr_1_8?__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=PY64BMCE4EQO&keywords=shoes%2Bfor%2Bmen&qid=1653077099&sprefix=%2Caps%2C65&sr=8-8&th=1&psc=1");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("sp-cc-accept")).click();

        WebDriverFactory.scrollDown(driver,0,700);
        Thread.sleep(3000);

        try {
            firstOption();
        } catch (NoSuchElementException ignored) {
            System.out.println("NoSuchElementException");
            secondOption();
        } catch (TimeoutException ignored) {
            System.out.println("TimeoutException");
            secondOption();
        }

        Thread.sleep(5000);
         driver.findElement(By.id("buy-now-button")).click();

    }

    @Test
    void amazon3() throws InterruptedException {
        driver.get("https://www.amazon.de/ap/signin?_encoding=UTF8&openid.assoc_handle=amazon_checkout_de&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.de%2Fgp%2Fcheckoutportal%2Fenter-checkout.html%3Fie%3DUTF8%26asin%3DB08X4KSBKW%26buyNow%3D1%26cartCustomerID%3D0%26fromSignIn%3D1%26fulfillmentType%3D%26isBuyBack%3D%26isGift%3D0%26offeringID%3DWHX9E%25252BDqk%25252FptMrGfROEKl6X2lw69uFs8bMq59s8wEugxjiJygo09lEw5C1M3eEETKEnM1sYAeS8Rf5nhYRtdESVi3gTgb%25252BcWM7TDBzWy1znZxCBiT%25252FNAIowuWWawgMgEiuasdapkMaS0M%25252BkFxqucI2IoXDF7busxUoHe0yhJZ%25252Blz4z2xqXOrHnCyXNh3s7X%25252B%26pickupAddressId%3D%26pickupStoreChainId%3D%26pickupStoreChainOwnerId%3D%26purchaseInputs%3DHASH%25280xaafe4348%2529%26quantity%3D1%26sessionID%3D257-5765255-1754060&pageId=amazon_checkout_de&showRmrMe=0&siteState=IMBMsgs.&suppressSignInRadioButtons=0");


        WebElement email = driver.findElement(By.id("ap_email"));
        email.click();
        email.sendKeys("example@gmail.com");

        driver.findElement(By.id("continue")).click();

        WebElement password = driver.findElement(By.id("ap_password"));
        password.click();

        Thread.sleep(1000);
        password.sendKeys("password");
        driver.findElement(By.id("signInSubmit")).click();
        Thread.sleep(5000);
        password = driver.findElement(By.id("ap_password"));
        password.click();
        password.sendKeys("password");
        driver.findElement(By.id("signInSubmit")).click();
    }

    @AfterMethod
    public void TearDown() throws InterruptedException {
        Thread.sleep(3000);
        // driver.close();
    }

    void firstOption() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[name^='dropdown']")));

        WebElement shoesNumberList = driver.findElement(By.cssSelector("select[name^='dropdown']"));
        Select number = new Select(shoesNumberList);
        number.selectByIndex(3);
    }
    void secondOption(){
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String locator = "//ul[contains(@class,'a-unordered-list')]//span[contains(text(),'42')]";
        WebElement shoesNumber;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

            shoesNumber = driver.findElement(By.xpath(locator));

        } catch (NoSuchElementException ignored) {
            System.out.println("Second try is failed");
            try {
                driver.findElement(By.id("a.a-link-emphasis.tp-side-sheet-link")).click();
            } catch (NoSuchElementException ignored2) {
                System.out.println("NoSuchElementExceptiond");
            }
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        }
        shoesNumber = driver.findElement(By.xpath(locator));
        actions.click(shoesNumber).perform();
        String numberOfShoes = shoesNumber.getText();

        Assert.assertEquals(numberOfShoes, "42 EU");
    }
}
