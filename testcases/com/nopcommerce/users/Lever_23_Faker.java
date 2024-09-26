package com.nopcommerce.users;

import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.RegisterPageObject;
import reportConfigs.ExtentTestManager;
import utilities.FakerConfig;

import java.lang.reflect.Method;

public class Lever_23_Faker extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;

    private String firstName, lastName, emailAddress, password;
    private FakerConfig fakerConfig;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);
        registerPage = PageGeneratorManager.getRegisterPage(driver);
        fakerConfig = FakerConfig.getFaker();

        firstName = fakerConfig.firstName();
        lastName = fakerConfig.lastName();
        emailAddress = fakerConfig.emailAddress();
        password = fakerConfig.password();

    }

    @Test
    public void User_01_Register_Success(Method method) {
        ExtentTestManager.startTest(method.getName(),"Register to system with Email and Password");
        ExtentTestManager.getTest().log(Status.INFO,"Register - Step 01: Click to Register Link ");
        registerPage = homePage.clickToRegisterLink();

        ExtentTestManager.getTest().log(Status.INFO,"Register - Step 02: Click to Register Button ");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO,"Register - Step 03: Check Error Msg of First Name text");
        verifyEquals(registerPage.getFirstNameErrorMessageText(), "First name is required");

        ExtentTestManager.getTest().log(Status.INFO,"Register - Step 04: Check Error Msg of Last Name text ");
        verifyEquals(registerPage.getLastNameErrorMessageText(), "Last name is required");

    }
//    @Test
    public void User_02_Register_Validate(Method method) {
        ExtentTestManager.startTest(method.getName(),"Register to system with Email and Password");
        ExtentTestManager.getTest().log(Status.INFO,"Register - Step 01: Enter to FirstName textbox");
        registerPage.enterToFirstNameTextbox(firstName);

        ExtentTestManager.getTest().log(Status.INFO,"Register - Step 02: Enter to LastName textbox");
        registerPage.enterToLastNameTextbox(lastName);

        ExtentTestManager.getTest().log(Status.INFO,"Register - Step 03: Enter to Email Textbox ");
        registerPage.enterToEmailTextbox(emailAddress);

        ExtentTestManager.getTest().log(Status.INFO,"Register - Step 04: Enter to Password textbox ");
        registerPage.enterToPasswordTextbox(password);

        ExtentTestManager.getTest().log(Status.INFO,"Register - Step 05: Enter to Confirm password textbox ");
        registerPage.enterToConfirmPasswordTextbox(password);

        ExtentTestManager.getTest().log(Status.INFO,"Register - Step 06: Click to Register Button ");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO,"Register - Step 07: Check register success mes");
        verifyEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed.");
    }




    @AfterClass
    public void afterClass() {
        closeWindow();
    }



}
