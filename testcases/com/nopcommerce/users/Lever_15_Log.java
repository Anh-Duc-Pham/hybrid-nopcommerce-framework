package com.nopcommerce.users;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.*;

public class Lever_15_Log extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;

    private String emailAddress = getRandomEmail();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void User_01_Register_Success() {
        log.info("User_01 - Step 01: Verify Register link is displayed");
        verifyFalse(homePage.isRegisterLinkDisplayed());

        log.info("User_ 01 - Step 02: Click to Register Link");
        registerPage = homePage.clickToRegisterLink();

        log.info("User_ 01 - Step 03: Click to Register Button");
        registerPage.clickToRegisterButton();

        log.info("User_ 01 - Step 04: Verify error message at FirstName textbox");
        verifyEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");

        log.info("User_ 01 - Step 05: Verify error message at LastName textbox");
        verifyEquals(registerPage.getLastNameErrorMessageText(), "Last name is required");

        log.info("User_ 01 - Step 06: Enter to FirstName textbox");
        registerPage.enterToFirstNameTextbox("Eden");

        log.info("User_ 01 - Step 07: Enter to LastName textbox");
        registerPage.enterToLastNameTextbox("Hazard");

        log.info("User_ 01 - Step 08: Enter to Email textbox");
        registerPage.enterToEmailTextbox(emailAddress);

        log.info("User_ 01 - Step 09: Enter to Password textbox");
        registerPage.enterToPasswordTextbox("123456");

        log.info("User_ 01 - Step 10: Enter to Confirm Password textbox");
        registerPage.enterToConfirmPasswordTextbox("123456");

        log.info("User_ 01 - Step 11: Click to Register Button");
        registerPage.clickToRegisterButton();

        log.info("User_ 01 - Step 12: Verify success message is displayed");//Verify Faild
        verifyEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed.");
    }




    @AfterClass
    public void afterClass() {
        closeWindow();
    }



}
