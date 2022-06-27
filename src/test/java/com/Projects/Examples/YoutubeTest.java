package com.Projects.Examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YoutubeTest {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "C:/Users/volka/IdeaProjects/Selenium-Automation/drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver  = new ChromeDriver();

        driver.get("https://www.youtube.com");

        WebElement consent = driver.findElement(By.xpath("//div[2]/ytd-button-renderer[2]"));
        consent.click();

        WebElement search = driver.findElement(new By.ByCssSelector("input[id='search']"));
        search.click();
        search.sendKeys("how to change display language on windows 10");

        WebElement searchButton = driver.findElement(new By.ByCssSelector("button[id='search-icon-legacy']"));
        searchButton.click();



    }
}
