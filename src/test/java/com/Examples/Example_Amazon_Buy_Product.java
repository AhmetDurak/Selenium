package com.Examples;


import com.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Example_Amazon_Buy_Product {
    WebDriver driver = WebDriverFactory.getDriver("chrome");

    @BeforeMethod
    void setUp() {
        driver.navigate().to("https://www.amazon.de/");
    }

    @Test
    public void buy_Product() throws Exception {
        WebElement consent = driver.findElement(By.id("sp-cc-accept"));
        consent.click();

        WebElement searchProduct = driver.findElement(By.id("twotabsearchtextbox"));
        searchProduct.click();
        searchProduct.sendKeys("xaomi mi 34 zoll");

        driver.findElement(By.id("nav-search-submit-button")).click();
        //WebDriverFactory.scrollDown(driver, 0, 3000);

        driver.findElement(By.xpath("//div[@id='p_n_feature_six_browse-bin-title']/following-sibling::ul[1]//label")).click();


        //List<WebElement> searchList = driver.findElements(new By.ByCssSelector(".s-main-slot.s-result-list.s-search-results.sg-row>div"));
        //WebElement definitionOfProduct = driver.findElement(By.xpath("//div[@data-component-type='s-search-result'][1]//span[@class='a-size-medium a-color-base a-text-normal']"));
        //WebElement priceOfProduct = driver.findElement(By.xpath("//div[@data-component-type='s-search-result'][1]//span[contains(@class,'a-price-whole')]"));


        WebDriverWait wait = new WebDriverWait(driver, 10);
        ArrayList<String> listOfProduct = new ArrayList<>();
        ArrayList<WebElement> listOfElements = new ArrayList<>();
        int counter = 1;

            runMyMethod(listOfElements, listOfProduct, wait, counter);

        System.out.println(listOfProduct.size());
        //for (String each: listOfProduct){
        //    System.out.println(each);
        //}

        int cheapestProduct = 10000000;
        int indexOfCheapestProduct = 1;

        WebElement cheapestElement = null;

        for (int i = 0, j = 1; i < listOfProduct.size(); i++, j++) {
            String price = listOfProduct.get(i).substring((listOfProduct.get(i).indexOf("Price:") + 7));
            price = price.substring(0, price.indexOf(",")).replace(".", "");
            int priceInt = Integer.parseInt(price);
            System.out.println(j + ". price: " + priceInt);
            if (priceInt < cheapestProduct) {
                cheapestProduct = priceInt;
                indexOfCheapestProduct = i;
                cheapestElement = listOfElements.get(i);
            }
        }

        System.out.println("\n\nLowest Product: " + listOfProduct.get(indexOfCheapestProduct));


    }

    @AfterMethod
    void tearDown() throws InterruptedException {
        Thread.sleep(1000);
    }

    void runMyMethod(ArrayList<WebElement> listOfElements, ArrayList<String> listOfProduct, WebDriverWait wait, int counter) throws InterruptedException {
        while (true) {
            try {
                String productPath = "//div[@data-component-type='s-search-result'][" + counter + "]//span[@class='a-size-medium a-color-base a-text-normal']";
                WebElement product = driver.findElement(By.xpath(productPath));
                //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(productPath)));
                wait.until(ExpectedConditions.visibilityOf(product));
                String productPrice = "//div[@data-component-type='s-search-result'][" + counter + "]//span[contains(@class,'a-price-whole')]";
                WebElement price = driver.findElement(By.xpath(productPrice));
                //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(productPrice)));
                wait.until(ExpectedConditions.visibilityOf(price));
                listOfProduct.add(product.getText() + "\nPrice: " + price.getText());

                listOfElements.add(product);

                WebDriverFactory.scrollDown(driver, 0, counter * 240);
                TimeUnit.MILLISECONDS.sleep(100);

                counter++;
            } catch (Exception e) {
                System.out.println("Border is reached");
                break;
            }
        }
    }
}
