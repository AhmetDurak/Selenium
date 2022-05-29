package com._4_airbnb.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Utilities.*;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }
    // LOCATORS
    @FindBy (css = "button._148dgdpk")
    public WebElement consentCookies;






}
