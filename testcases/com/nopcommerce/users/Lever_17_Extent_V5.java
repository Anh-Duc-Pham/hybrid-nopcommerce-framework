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

public class Lever_17_Extent_V5 extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;

    private String emailAddress = getRandomEmail();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);
        registerPage = PageGeneratorManager.getRegisterPage(driver);
    }

    @Test
    public void User_01_Register_Success() {
        Assert.assertFalse(homePage.isRegisterLinkDisplayed());

        registerPage = homePage.clickToRegisterLink();

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");

        Assert.assertEquals(registerPage.getLastNameErrorMessageText(), "Last name is required");

    }
    @Test
    public void User_02_Register_Validate() {
        registerPage.enterToFirstNameTextbox("Eden");

        registerPage.enterToLastNameTextbox("Hazard");

        registerPage.enterToEmailTextbox(emailAddress);

        registerPage.enterToPasswordTextbox("123456");

        registerPage.enterToConfirmPasswordTextbox("123456");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed.");
    }




    @AfterClass
    public void afterClass() {
        closeWindow();
    }



}
