package com._1_Amazon.Tests;

import com._1_Amazon.Pages.PageAllMenu;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class FirstClass extends TestBase {
    WebDriver driver;

    @Test
    public void test1() {
        PageAllMenu pageAllMenu = new PageAllMenu();
        pageAllMenu.clickAll.click();
    }

}
