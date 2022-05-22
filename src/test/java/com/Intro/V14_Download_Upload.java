package com.Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class V14_Download_Upload {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demoqa.com/upload-download");

        //download(driver);
        upload(driver);
    }
    public static void download(WebDriver driver) throws InterruptedException{
        WebElement download = driver.findElement(By.id("downloadButton"));
        download.click();

        String path = "C:/Users/volka/Downloads";
        String fileName = "sampleFile.jpeg";

        Thread.sleep(2000); // Download needs time to complete!!
        boolean isTrue = isFileDownloaded(path,fileName);
        System.out.println(isTrue);
    }

    public static boolean isFileDownloaded(String path, String fileName) {
        File[] files = new File(path).listFiles();
        for (File element: files){
            //System.out.println(element.getName());
            if (element.getName().equalsIgnoreCase(fileName)) {
                element.delete();
                return true;
            }
        }return false;
    }

    // UPLOAD--------->>>

    public static void upload(WebDriver driver){
        WebElement uploadFile = driver.findElement(By.id("uploadFile"));
        uploadFile.sendKeys("C:/Users/volka/Downloads/sampleFile.jpeg");

    }

}
