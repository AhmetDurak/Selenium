package com.cydeo.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Utilities.*;

// This PageBase covers Tests from Day10(included)

public abstract class PageBase {
    public PageBase(){
        PageFactory.initElements(Driver.get(), this);
    }

    //@FindBy(css = "div#nav-main>div>a")
    //public WebElement clickAll;


}
