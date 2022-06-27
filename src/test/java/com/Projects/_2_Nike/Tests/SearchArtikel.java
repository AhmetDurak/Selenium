package com.Projects._2_Nike.Tests;

import com.Projects._2_Nike.Pages.AcceptCookies;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SearchArtikel extends TestBase{
    @Test
    public void Test() throws InterruptedException {
        AcceptCookies acceptCookies = new AcceptCookies();
        acceptCookies.acceptCookies.click();
        //acceptCookies.closeRegistration.click();

        Thread.sleep(3000);
        actions.moveToElement(acceptCookies.herren).perform();


        for (WebElement option: acceptCookies.schuheHerren){
            System.out.println(option.getText());
        }
    }
}
