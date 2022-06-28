package com.cydeo.Test.Day12.Page;

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
}
