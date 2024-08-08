package com.nopcommerce.share;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.RegisterPageObject;

public class Common_Register extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;

    public static String emailAddress, password, firstName, lastName;

    @Parameters("browser")
    @BeforeTest
    public void beforeTest(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);

        emailAddress = getRandomEmail();
        password = "123456";
        firstName = "eden";
        lastName = "hazard";


        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);

        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");
        closeWindow();
    }

}
