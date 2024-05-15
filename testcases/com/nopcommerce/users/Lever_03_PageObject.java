package com.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.CustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import java.time.Duration;
import java.util.Random;

public class Lever_03_PageObject extends BasePage {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerPageObject customerPage;
    private String emailAddress = getRandomEmail();


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demo.nopcommerce.com/");

        //mở 1 url mở ra cái page nò cũng sẽ khởi tạo nó lên
        // Từ 1 page này chuyển qua page kia -> khởi tạo page đó lên
        homePage = new HomePageObject(driver);
    }

    @Test
    public void User_01_Register_Empty_Data() {
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
        driver.close();
    }

    public String getRandomEmail() {
        Random emailNumber = new Random();
        return "edenhazard" + emailNumber.nextInt(9999) + "@gmail.com";
    }

}
