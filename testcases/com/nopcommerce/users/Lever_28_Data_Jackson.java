package com.nopcommerce.users;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import jsonData.nopcommerce.UserInfoData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.RegisterPageObject;
import pojoData.nopcommerce.UserInfo;
import reportConfigs.ExtentTestManager;

import java.lang.reflect.Method;

public class Lever_28_Data_Jackson extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;

    private String emailAddress, firstName, lastName, password;
    private UserInfoData userInfo;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        userInfo = UserInfoData.getUserInfo();

        emailAddress = getRandomEmail(userInfo.getEmail());
        userInfo.setEmail(emailAddress);

        firstName = userInfo.getFirstName();
        lastName = userInfo.getLastName();
        password = userInfo.getPassword();

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

        ExtentTestManager.getTest().log(Status.INFO,"Register - Step 01: Enter to User Info");
        registerPage.enterToProfileFileJson(userInfo);

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
