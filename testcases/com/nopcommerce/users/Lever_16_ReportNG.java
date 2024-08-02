package com.nopcommerce.users;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.RegisterPageObject;

public class Lever_16_ReportNG extends BaseTest {
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
        Assert.assertFalse(homePage.isRegisterLinkDisplayed());

        log.info("User_ 01 - Step 02: Click to Register Link");
        registerPage = homePage.clickToRegisterLink();

        log.info("User_ 01 - Step 03: Click to Register Button");
        registerPage.clickToRegisterButton();

        log.info("User_ 01 - Step 04: Verify error message at FirstName textbox");
        Assert.assertEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");

        log.info("User_ 01 - Step 05: Verify error message at LastName textbox");
        Assert.assertEquals(registerPage.getLastNameErrorMessageText(), "Last name is required");

    }
    @Test
    public void User_02_Register_Validate() {
        log.info("User_ 01 - Step 01: Enter to FirstName textbox");
        registerPage.enterToFirstNameTextbox("Eden");

        log.info("User_ 01 - Step 02: Enter to LastName textbox");
        registerPage.enterToLastNameTextbox("Hazard");

        log.info("User_ 01 - Step 03: Enter to Email textbox");
        registerPage.enterToEmailTextbox(emailAddress);

        log.info("User_ 01 - Step 04: Enter to Password textbox");
        registerPage.enterToPasswordTextbox("123456");

        log.info("User_ 01 - Step 5: Enter to Confirm Password textbox");
        registerPage.enterToConfirmPasswordTextbox("123456");

        log.info("User_ 01 - Step 6: Click to Register Button");
        registerPage.clickToRegisterButton();

        log.info("User_ 01 - Step 7: Verify success message is displayed");//Verify Faild
        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed.");
    }




    @AfterClass
    public void afterClass() {
        closeWindow();
    }



}
