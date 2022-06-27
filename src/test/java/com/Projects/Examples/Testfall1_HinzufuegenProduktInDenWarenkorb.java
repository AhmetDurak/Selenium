package com.Projects.Examples;


import com.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Testfall1_HinzufuegenProduktInDenWarenkorb {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://amazon.de");


        //Click the cookies Akzeptieren
        WebElement akzeptierenCookies = driver.findElement(By.cssSelector("input#sp-cc-accept"));
        akzeptierenCookies.click();
    }
    @AfterClass
    public void tearDown(){
        //driver.close();
    }

    @Test
    void test1_startSeiteVerifizieren() throws InterruptedException {
        String homePage = driver.getTitle();
        homePage = homePage.substring(0,homePage.indexOf(":"));
        Thread.sleep(2000);
        String expectedResult = "Amazon.de";
        Assert.assertEquals(expectedResult, homePage,"Die Amazon Startseite wird erfolgreich aufgerufen");
    }

    @Test
    void test2_inputSearchBoxAdidasSchuhe() throws InterruptedException {
        //3#Suche nach : Adidas schuhe in input Box
        WebElement inputData = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        inputData.sendKeys("Adidas schuhe");
        // Search for inputData
        inputData.sendKeys(Keys.ENTER);

        // Stück von Ergebnisse
        List<WebElement> alleErgebnisse =  driver.findElements(By.cssSelector("h5[class=\"s-line-clamp-1\"]"));

        WebElement element ;


        Assert.assertTrue(alleErgebnisse.size() >= 5, "Sollergebnis für erste Schuhe: Es werden mindestens 5 Schuhe angezeigt.");
        //4#Selektiere das erste Ergebnis
        //Sollerergebnis: Das Produkt wird erfolgreich aufgerufen

        boolean sponsorCheck = false;
        try {
            WebElement sponsorProduct = driver.findElement(By.xpath("//div[2]/div/div/div/div/div/div/div[2]/div[2]/span/a/span[1]/span"));
            System.out.println("Sponsor Product ist aufgetaucht");
        }catch (Exception ignored){
            System.out.println("Es gibt kein Sponsor Product");
            sponsorCheck = true;
            WebElement selectErgebnis = driver.findElement(By.xpath("//a[@class='a-link-normal s-no-outline']"));
            // Info:es gibt 60 class Attribute aber ich sollte erste Ergebnisse laut Voraussetzung selektieren.Deshalb kann
            // ich class attribute benutzen
            selectErgebnis.click();
        }

        if (!sponsorCheck){
            Thread.sleep(3000);

            List<WebElement> elementList2 = driver.findElements(By.xpath("//a[@class='a-link-normal s-no-outline']"));
            elementList2.get(1).click();
        }





    }


}
























