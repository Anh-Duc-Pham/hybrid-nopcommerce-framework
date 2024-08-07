package com.nopcommerce.users;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.CustomerPageObject;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.RegisterPageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class Lever_20_Pattern_Object extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private CustomerPageObject customerPage;

    private String emailAddress = getRandomEmail();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void User_01_Register_Empty_Data() {
        homePage.clickToHeaderLinkByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        registerPage.clickToButtonByText("Register");

        Assert.assertEquals(registerPage.getTextboxErrorMessageByID("FirstName"), "First name is required.");
        Assert.assertEquals(registerPage.getTextboxErrorMessageByID("LastName"), "Last name is required.");
        Assert.assertEquals(registerPage.getTextboxErrorMessageByID("Email"), "Email is required.");
        Assert.assertEquals(registerPage.getTextboxErrorMessageByID("ConfirmPassword"), "Password is required.");

    }

    @Test
    public void User_02_Register_Invalid_Email() {
        registerPage.clickToCommonNopCommerceLogo();
        homePage = PageGeneratorManager.getHomePage(driver);

        homePage.clickToHeaderLinkByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        registerPage.enterToTextboxByID("FirstName", "Eden");
        registerPage.enterToTextboxByID("LastName","Hazard");
        registerPage.enterToTextboxByID("Email","EdenHazard@123");
        registerPage.enterToTextboxByID("Password","123456");
        registerPage.enterToTextboxByID("ConfirmPassword","123456");

        registerPage.clickToButtonByText("Register");
        Assert.assertEquals(registerPage.getTextboxErrorMessageByID("Email"),
                "Wrong email");

    }

    @Test
    public void User_03_Register_Invalid_Password() {
        registerPage.clickToCommonNopCommerceLogo();
        homePage = PageGeneratorManager.getHomePage(driver);

        homePage.clickToHeaderLinkByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);


        registerPage.enterToTextboxByID("FirstName","Eden");
        registerPage.enterToTextboxByID("LastName","Hazard");
        registerPage.enterToTextboxByID("Email","EdenHazard@gmail.com");
        registerPage.enterToTextboxByID("Password","123");
        registerPage.enterToTextboxByID("ConfirmPassword","123");


        registerPage.clickToButtonByText("Register");
        Assert.assertEquals(registerPage.getPasswordValidationErrorMessageText(),
                "<p>Password must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");

    }

    @Test
    public void User_04_Register_Incorrect_Confirm_Password() {
        registerPage.clickToCommonNopCommerceLogo();
        homePage = PageGeneratorManager.getHomePage(driver);

        homePage.clickToHeaderLinkByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        registerPage.enterToTextboxByID("FirstName","Eden");
        registerPage.enterToTextboxByID("LastName","Hazard");
        registerPage.enterToTextboxByID("Email","EdenHazard@gmail.com");
        registerPage.enterToTextboxByID("Password","123456");
        registerPage.enterToTextboxByID("ConfirmPassword","654321");


        registerPage.clickToButtonByText("Register");
        Assert.assertEquals(registerPage.getTextboxErrorMessageByID("ConfirmPassword"), "The password and confirmation password do not match.");
    }

    @Test
    public void User_05_Register_Success() {
        registerPage.clickToCommonNopCommerceLogo();
        homePage = PageGeneratorManager.getHomePage(driver);

        homePage.clickToHeaderLinkByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        registerPage.enterToTextboxByID("FirstName","Eden");
        registerPage.enterToTextboxByID("LastName","Hazard");
        registerPage.enterToTextboxByID("Email",emailAddress);
        registerPage.enterToTextboxByID("Password","123456");
        registerPage.enterToTextboxByID("ConfirmPassword","123456");

        registerPage.clickToButtonByText("Register");
        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");
    }

    @Test
    public void User_06_Login_Success() {
        registerPage.clickToCommonNopCommerceLogo();
        homePage = PageGeneratorManager.getHomePage(driver);

        homePage.clickToHeaderLinkByName("My account");
        customerPage = PageGeneratorManager.getCustomerPage(driver);

        //verify
        Assert.assertEquals(customerPage.getTextboxAttributeByID("FirstName"), "Eden");
        Assert.assertEquals(customerPage.getTextboxAttributeByID("LastName"), "Hazard");
        Assert.assertEquals(customerPage.getTextboxAttributeByID("Email"), emailAddress);

    }


    @AfterClass
    public void afterClass() {
        closeWindow();
    }


}
