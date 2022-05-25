package com._2_Nike.Pages;

import com.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageBase {
    public PageBase(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy (css = "button[data-var='acceptBtn1']>span#hf_cookie_text_cookieAccept")
    public WebElement acceptCookies;


    @FindBy (css = "button[data-var='closeBtn']")
    public WebElement closeRegistration;

    @FindBy (css = "a[aria-label='Herren']")
    public WebElement herren;

    @FindBy (css = "div#DesktopMenu-0-1-0>div>div:nth-of-type(2)")
    public List<WebElement> schuheHerren;


}
