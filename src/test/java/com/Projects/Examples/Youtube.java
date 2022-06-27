package com.Projects.Examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Youtube {
    static void sleepMilliSeconds(int milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
    }


    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "C:/Users/volka/IdeaProjects/Selenium-Automation/drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com");
        driver.manage().window().setSize(new Dimension(1400,1000));
        //driver.manage().window().maximize();
        sleepMilliSeconds(1000);

        Actions action = new Actions(driver);
        WebElement consent;
        //consent.click();

        while (true){
            try {
                //consent = driver.findElement(new By.ByCssSelector("tp-yt-paper-button[aria-label='In die Verwendung von Cookies und anderen Daten zu den beschriebenen Zwecken einwilligen']"));
                consent = driver.findElement(By.xpath("//ytd-button-renderer[2]"));
                consent.click();
                break;
            }catch (NoSuchElementException e){
                System.out.println("Element couldn't find!");
                JavascriptExecutor js = (JavascriptExecutor)driver;
                js.executeScript("window.scrollBy(0,550)","");
                //action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();  // SCROLL DOWN IF ELEMENT DOESN'T EXIST
            }
        }

        sleepMilliSeconds(1000);

        WebElement searchArea = driver.findElement(new By.ByCssSelector("input[id='search']"));
        searchArea.click();
        searchArea.sendKeys("Hans Zimmer - Time (Inception - Live in Prague)");

        WebElement searchButton = driver.findElement(new By.ByCssSelector("button[id='search-icon-legacy']"));
        searchButton.click();

        sleepMilliSeconds(3000);

        WebElement hansZimmerTime = driver.findElement(new By.ByCssSelector("a[title='Hans Zimmer - Time (Inception - Live in Prague)']"));
        hansZimmerTime.click();

        WebElement skip;
        /*while(true) {
            try {
                skip = driver.findElement(new By.ByCssSelector("button.ytp-ad-skip-button"));
                if (skip.isEnabled()){
                    skip.click();
                    System.out.println("skip is clicked\nVideo should begin");
                    break;
                }
            } catch (NoSuchElementException | ElementNotInteractableException e) {
                if (e instanceof NoSuchElementException) System.out.println("Element didn't show up yet!");
                else System.out.println("Element not clickable");
            }
            sleepMilliSeconds(1500);
        }*/


        //FluentWait wait = new FluentWait(driver);
        //wait.withTimeout(Duration.ofSeconds(60))
        //        .pollingEvery(Duration.ofMillis(1500))
        //        .ignoring(NoSuchElementException.class)
        //        .ignoring(ElementNotInteractableException.class)
        //        .until(ExpectedConditions.elementToBeClickable(new By.ByCssSelector("button.ytp-ad-skip-button")));
        //skip = driver.findElement(new By.ByCssSelector("button.ytp-ad-skip-button"));
        //skip.click();
        //System.out.println("skip is clicked\nVideo should begin");

        WebDriverWait wait1 = new WebDriverWait(driver, 60);
        wait1.pollingEvery(Duration.ofMillis(1500))
                .until(ExpectedConditions.elementToBeClickable(new By.ByCssSelector("button.ytp-ad-skip-button")));
        skip = driver.findElement(new By.ByCssSelector("button.ytp-ad-skip-button"));
        skip.click();
        System.out.println("skip is clicked\nVideo should begin");
    }
}
