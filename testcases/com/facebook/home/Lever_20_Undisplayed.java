package com.facebook.home;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.RegisterPageObject;

public class Lever_20_Undisplayed extends BaseTest {
    private WebDriver driver;


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String pageUrl) {
        driver = getBrowserDriver(browserName, pageUrl);
    }

    @Test
    public void Home_01_Element_Displayed() {
    }
    @Test
    public void Home_02_Element_Undisplayed_In_HTML() {
    }
    @Test
    public void Home_01_Element_Undisplayed_Not_In_HTML() {
    }






    @AfterClass
    public void afterClass() {
        closeWindow();
    }



}
