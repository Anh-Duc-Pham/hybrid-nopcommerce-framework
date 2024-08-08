package com.nopcommerce.share;

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

public class Payment extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private CustomerPageObject customerPage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);

        loginPage = homePage.clickToLoginLink();

        loginPage.enterToEmailTextbox(Common_Register.emailAddress);
        loginPage.enterToPasswordTextbox(Common_Register.password);

        homePage = loginPage.clickToLoginButton();

        customerPage = homePage.clickToMyAccountLink();


        Assert.assertEquals(customerPage.getFirstNameTextboxAttributeValue(), Common_Register.firstName);
        Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(), Common_Register.lastName);
        Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(), Common_Register.emailAddress);

    }

    @Test
    public void Payment_01_Visa() {

    }

    @Test
    public void Payment_02_Cheque(){

    }


    @AfterClass
    public void afterClass() {
        closeWindow();
    }


}
