package com.Intro;

import com.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class V21_Accordion {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void accordion() throws InterruptedException {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("https://demoqa.com/accordian");

        Thread.sleep(2000);

        WebElement firstCard = driver.findElement(new By.ByCssSelector(".card:first-child>div:last-child"));
        System.out.println(firstCard.getAttribute("class"));

        Thread.sleep(2000);

        WebElement accordion1 = driver.findElement(By.id("section1Heading"));
        accordion1.click();

        System.out.println(firstCard.getAttribute("class"));

        Thread.sleep(1000);

        System.out.println(firstCard.getAttribute("class"));

        Thread.sleep(1000);

        //driver.close();
    }
}
