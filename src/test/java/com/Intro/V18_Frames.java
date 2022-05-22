package com.Intro;

import com.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class V18_Frames {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

    @Test
    public void indexFrame() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/frames");
        // SWITCHING TO THE FRAME
        driver.switchTo().frame(0);

        Thread.sleep(1000);
        WebElement heading = driver.findElement(By.id("sampleHeading"));
        System.out.println(heading.getText());

        //Thread.sleep(3000);

    }
    @Test
    public void idFrame() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/frames");
        // SWITCHING TO THE FRAME
        driver.switchTo().frame("frame1");  // using frame id

        WebElement heading = driver.findElement(By.id("sampleHeading"));
        System.out.println(heading.getText() + "\n");

        Thread.sleep(1000);

        // to got to upper frame
        driver.switchTo().parentFrame();
        WebElement text = driver.findElement(new By.ByCssSelector("#framesWrapper>div:first-child"));
        System.out.println(text.getText() + "\n");

        //List<WebElement> elementsList = driver.findElements(new By.ByCssSelector("#framesWrapper>div"));
        //String paragraph = elementsList.get(0).getText();
        //System.out.println(paragraph);

        Thread.sleep(1000);

        // in order to switch another sub-frame, we should go to parent frame, then another one
        driver.switchTo().frame("frame2");
        WebElement headingAtFrame2 = driver.findElement(By.id("sampleHeading"));
        System.out.println(headingAtFrame2.getText() + "\n");

        Thread.sleep(1000);

        driver.close();
    }
}
