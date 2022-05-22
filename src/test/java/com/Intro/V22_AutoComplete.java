package com.Intro;

import com.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class V22_AutoComplete {

    @Test
    public void autoComplete() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://demoqa.com/auto-complete");

        WebElement input = driver.findElement(By.id("autoCompleteSingleInput"));
        input.sendKeys("r");

        Thread.sleep(10);

        List<WebElement> suggestions = driver.findElements(new By.ByCssSelector("div.auto-complete__option"));

        for (WebElement suggestion: suggestions){
            //System.out.println(suggestion.getText());

            String text = suggestion.getText();
            if (text.toLowerCase().contains("red")){
                System.out.println(suggestion.getText() + " is selected");
                suggestions.get(0).click();
                break;
            }
        }

        driver.close();
    }
}
