package com._3_nopcommerce.Pages;

import com.Utilities.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(), this);
    }
    // LOCATORS
    @FindBy (id = "small-searchterms")
    public WebElement searchBox;






}
