package com.Intro;

import com.Utilities.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class V12_BrokenLinksCopy {
    @BeforeClass
    public void setUp(){
        myDriver.get();

    }

    @Test
    public void httpRequest(){
        checkUrl("http://the-internet.herokuapp.com/status_codes/500");
    }

    public void checkUrl(String url){
        HttpClient client = HttpClientBuilder.create().build();
        try {
            HttpResponse response = client.execute(new HttpGet(url));
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("Status code: " + statusCode);
        } catch (IOException e) {
            System.out.println("URL couldn't be found");
        }
    }


}
class myDriver{
    private myDriver(){}
    private static WebDriver driver;

    // default chrome driver
    public static WebDriver get(){
        if (driver == null){
            String browser = myConfigurationReader.get("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions headless = new ChromeOptions();
                    headless.addArguments("headless");
                    driver = new ChromeDriver(headless);
                    break;
            }
        }return driver;
    }
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
