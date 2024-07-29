package com.nopcommerce.users;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.*;

public class Lever_14_Verify_Assert extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private CustomerPageObject customerPage;
    private AddressPageObject addressPageObject;
    private BackInStockSubcriptionsPageObject backInStockSubcriptionsPageObject;
    private ChangePasswordPageObject changePasswordPageObject;
    private DownloadableProductsPageObject downloadableProductsPageObject;
    private MyProductReviewPageObject myProductReviewPageObject;
    private OrdersPageObject ordersPageObject;
    private RewardPointsPageObject rewardPointsPageObject;

    private String emailAddress = getRandomEmail();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void User_01_Register_Success() {
        //Verify Register link displayed -> FAILED
        verifyFalse(homePage.isRegisterLinkDisplayed());

        registerPage = homePage.clickToRegisterLink();

        registerPage.clickToRegisterButton();

        //Verify error message at Firstname textbox -> PASSED
        verifyEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");

        //Verify error message at Lastname textbox -> FAILED
        verifyEquals(registerPage.getLastNameErrorMessageText(), "Last name is required");

        registerPage.enterToFirstNameTextbox("Eden");
        registerPage.enterToLastNameTextbox("Hazard");
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox("123456");
        registerPage.enterToConfirmPasswordTextbox("123456");

        registerPage.clickToRegisterButton();

        //Verify Faild
        verifyEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed.");
    }




    @AfterClass
    public void afterClass() {
        closeWindow();
    }



}
