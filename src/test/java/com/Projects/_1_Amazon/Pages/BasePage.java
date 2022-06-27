package com.Projects._1_Amazon.Pages;

import com.Utilities.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (css = "div#nav-main>div>a")
    public WebElement clickAll;

    @FindBy (xpath = "//a[@data-csa-c-content-id='nav_cs_kindle_books']")
    public WebElement kindleBooks;



}
