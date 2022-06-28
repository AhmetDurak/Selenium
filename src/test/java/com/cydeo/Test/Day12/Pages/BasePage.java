package com.cydeo.Test.Day12.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Utilities.*;

public abstract class BasePage {
    //#1 - initialize the driver instance and object of the class
    public BasePage(){
        //initElements method will create connection in between the current driver
        //session (instance) and the object of the current class.
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy (tagName = "button")
    public WebElement signIn;

    @FindBy (id = "inputEmail-error")
    public WebElement errorMessage;

    @FindBy (id = "inputEmail")
    public WebElement userEmail;

    @FindBy (id = "inputPassword")
    public WebElement password;

    @FindBy (css = ".alert.alert-danger")
    public WebElement errorMessage2;

    @FindBy (id = "alert")
    public WebElement alert;

    @FindBy (tagName = "img")
    public WebElement spongeBobImage;

    @FindBy (css = "#start>button")
    public WebElement startBtn;

    @FindBy (id = "loading")
    public WebElement loadingBar;

    @FindBy (id = "username")
    public WebElement username;

    @FindBy (id = "pwd")
    public WebElement passwordDy;

    @FindBy (css = "button[type='submit']")
    public WebElement submitBtn;

    @FindBy (id = "flash")
    public WebElement flashAlert;
}
