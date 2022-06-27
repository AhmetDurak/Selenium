package com.Projects.Examples;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Workout {
    static ArrayList<String> tabs;
    static WebDriverWait wait;
    static String linkAttendee;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/volka/IdeaProjects/Selenium-Automation/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().setSize(new Dimension(1200, 1000));
        driver.manage().window().maximize();


        // HOW TO WAIT IN SELENIUM

        //WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExceptionMethod.)


        //OPEN AND CLOSE A TAB IN DRIVER

        driver.get("https://mconf.github.io/api-mate/#server=https://scalelite-2.mersys.io/bigbluebutton/&sharedSecret=99e418843ae712f4e586e904915ed06ed74a00a5e5d68eb5");

        WebElement create = driver.findElement(By.xpath("//div/div[2]/div/a[3]"));
        String linkCreate = create.getText();

        WebElement attendee = driver.findElement(By.xpath("//div[4]/div/a[3]"));
        linkAttendee = attendee.getText();

        newTab();
        TimeUnit.MILLISECONDS.sleep(100);
        // take the number of tabs
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(linkCreate);
        wait(1);
        driver.close();


        //Main TAB
        driver.switchTo().window(tabs.get(0));

        //Moderator TAB
        {
            WebElement moderator = driver.findElement(By.xpath("//div/div[3]/div/a[3]"));
            String linkModerator = moderator.getText();
            newTab();
            TimeUnit.MILLISECONDS.sleep(100);
            // take the number of tabs
            tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            driver.get(linkModerator);
            wait(1);

            onlyListen(driver);

            wait(3);
            driver.close();
        }

        //Attendee TAB

        // Enter your tab number
        int Tab = 300;

            for (int i = 1; i <= Tab; i++) {
                attendee(driver, i);
            }
            tabs = new ArrayList<>(driver.getWindowHandles());

            for (int i = 1; i <= Tab; i++) {
                driver.switchTo().window(tabs.get(i));
                System.out.println("Tab " + i);
                onlyListen(driver);
                TimeUnit.MILLISECONDS.sleep(100);
            }
            /*for (int i = Tab; i > 0; i--) {
                driver.switchTo().window(tabs.get(i));
                driver.close();
                TimeUnit.MILLISECONDS.sleep(100);
            }*/
    }

    public static void newTab() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_T);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void wait(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void attendee(WebDriver driver, int tabNumber) throws InterruptedException {

        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        TimeUnit.MILLISECONDS.sleep(100);

        newTab();
        TimeUnit.MILLISECONDS.sleep(100);

        // take the number of tabs
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber));
        driver.get(linkAttendee);
    }

    public static void onlyListen(WebDriver driver) {
        WebElement onlyListenElement;
        while (true) {
            wait(1);
            onlyListenElement = driver.findElement(By.xpath("//div/span/button[2]"));
            if (onlyListenElement.isEnabled()) {
                onlyListenElement.click();
                break;
            } else wait(1);
        }
    }
}
