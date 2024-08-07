package com.facebook.home;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.facebook.HomePageObject;
import pageObjects.facebook.PageGeneratorManager;

public class Lever_20_Undisplayed extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String pageUrl) {
        driver = getBrowserDriver(browserName, pageUrl);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void Home_01_Element_Displayed() {
        homePage.clickToCreateAccountButton();

        verifyTrue(homePage.isNameTextboxDisplayed());
        verifyTrue(homePage.isSurNameTextboxDisplayed());
        verifyTrue(homePage.isEmailTextboxDisplayed());
        verifyTrue(homePage.isPasswordTextboxDisplayed());

        homePage.enterToGmailTextbox("edenhazard@gmail.com");

        verifyTrue(homePage.isConfirmEmailTextboxDisplayed());

    }
    @Test
    public void Home_02_Element_Undisplayed_In_HTML() {
        homePage.enterToGmailTextbox("");
        verifyTrue(homePage.isConfirmEmailTextboxDisplayed());
    }
    @Test
    public void Home_03_Element_Undisplayed_Not_In_HTML() {
        homePage.clickToCloseButton();

        verifyTrue(homePage.isNameTextboxUndisplayed());
        verifyTrue(homePage.isSurNameTextboxUndisplayed());
        verifyTrue(homePage.isEmailTextboxUndisplayed());
        verifyTrue(homePage.isPasswordTextboxUndisplayed());
    }






    @AfterClass
    public void afterClass() {
        closeWindow();
    }



}
