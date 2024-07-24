package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.CustomerPageObject;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.RegisterPageObject;

public class Lever_06_Page_Manager_1 extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private CustomerPageObject customerPage;
    private String emailAddress = getRandomEmail();

    @Parameters({"browser", "adminUrl", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String adminUrl, String userUrl) {
        driver = getBrowserDriver(browserName, userUrl);
    }

    @Test
    public void User_01_Register_Empty_Data() {
        homePage = new HomePageObject(driver);

        homePage.clickToRegisterLink();
        // TỪ home page click vào register link nó sẽ mở ra homePage
        registerPage = new RegisterPageObject(driver);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");
        Assert.assertEquals(registerPage.getLastNameErrorMessageText(), "Last name is required.");
        Assert.assertEquals(registerPage.getEmailErrorMessageText(), "Email is required.");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMessageText(), "Password is required.");

    }

    @Test
    public void User_02_Register_Invalid_Email() {
        registerPage.clickToNopCommerceLogo();

        //Đang từ Register page ấn vào image logo thì nó mở ra trang home page
        homePage = new HomePageObject(driver);
        homePage.clickToRegisterLink();
        // Từ Home Page click vào register link để mở trang Register page
        registerPage = new RegisterPageObject(driver);
        registerPage.enterToFirstNameTextbox("Eden");
        registerPage.enterToLastNameTextbox("Hazard");
        registerPage.enterToEmailTextbox("EdenHazard@123");
        registerPage.enterToPasswordTextbox("123456");
        registerPage.enterToConfirmPasswordTextbox("123456");

        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getEmailErrorMessageText(),
                "Wrong email");

    }

    @Test
    public void User_03_Register_Invalid_Password() {
        registerPage.clickToNopCommerceLogo();

        homePage = new HomePageObject(driver);

        homePage.clickToRegisterLink();
        // Từ Home Page click vào register link để mở trang Register page
        registerPage = new RegisterPageObject(driver);
        registerPage.enterToFirstNameTextbox("Eden");
        registerPage.enterToLastNameTextbox("Hazard");
        registerPage.enterToEmailTextbox("EdenHazard@gmail.com");
        registerPage.enterToPasswordTextbox("123");
        registerPage.enterToConfirmPasswordTextbox("123");

        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getPasswordValidationErrorMessageText(),
                "<p>Password must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");

    }

    @Test
    public void User_04_Register_Incorrect_Confirm_Password() {
        registerPage.clickToNopCommerceLogo();

        //Đang từ Register page ấn vào image logo thì nó mở ra trang home page
        homePage = new HomePageObject(driver);

        homePage.clickToRegisterLink();
        // Từ Home Page click vào register link để mở trang Register page
        registerPage = new RegisterPageObject(driver);
        registerPage.enterToFirstNameTextbox("Eden");
        registerPage.enterToLastNameTextbox("Hazard");
        registerPage.enterToEmailTextbox("EdenHazard@gmail.com");
        registerPage.enterToPasswordTextbox("123456");
        registerPage.enterToConfirmPasswordTextbox("654321");

        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMessageText(), "The password and confirmation password do not match.");
    }

    @Test
    public void User_05_Register_Success() {
        registerPage.clickToNopCommerceLogo();

        homePage = new HomePageObject(driver);

        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);
        registerPage.enterToFirstNameTextbox("Eden");
        registerPage.enterToLastNameTextbox("Hazard");
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox("123456");
        registerPage.enterToConfirmPasswordTextbox("123456");

        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");
    }

    @Test
    public void User_06_Login_Success() {
        registerPage.clickToNopCommerceLogo();

        homePage = new HomePageObject(driver);
        homePage.clickToMyAccountLink();

        customerPage = new CustomerPageObject(driver);

        //verify
        Assert.assertEquals(customerPage.getFirstNameTextboxAttributeValue(), "Eden");
        Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(), "Hazard");
        Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(), emailAddress);

    }


    @AfterClass
    public void afterClass() {
        closeWindow();
    }



}
