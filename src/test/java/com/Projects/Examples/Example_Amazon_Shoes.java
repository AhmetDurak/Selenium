package com.Projects.Examples;

import com.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Example_Amazon_Shoes {
    WebDriver driver;
    @BeforeMethod
    public void setUP(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setSize(new Dimension(1800,1800));
        //driver.manage().window().fullscreen();
        String url = "https://www.amazon.de/Seajure-Vendicari-Shoes-Leather-Nubuck/dp/B09PHWJLZM/ref=sr_1_4_sspa?c=ts&keywords=Herren+Boots-+und+Deckschuhe&qid=1653046139&s=shoes&sr=1-4-spons&ts_id=1760368031&psc=1";
        driver.navigate().to(url);
    }

    @Test
    public void test1(){
        driver.findElement(By.id("sp-cc-accept")).click();

        try {
            firstOption();
        }catch (Exception ignored){
            System.out.println("Second option is active");
            try {
                secondOption();
            }catch (Exception ignored2){
                System.out.println("Second option is failed as well");
            }
        }

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        //driver.close();
    }

    void firstOption(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[name='dropdown_selected_size_name']")));
        WebElement shoesNumber = driver.findElement(By.cssSelector("select[name='dropdown_selected_size_name']"));
        Select number = new Select(shoesNumber);
        number.selectByIndex(4);
    }

    void secondOption(){
        List<WebElement> numbers = driver.findElements(new By.ByCssSelector("li.swatch-list-item-text.inline-twister-swatch.slots-hidden"));

        for (WebElement each: numbers){
            System.out.println(each.getAttribute("data-idxintoggleswatchlist"));
        }
    }
}
