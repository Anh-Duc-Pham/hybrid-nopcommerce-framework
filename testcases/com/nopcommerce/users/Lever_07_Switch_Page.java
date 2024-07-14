package com.nopcommerce.users;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.*;

public class Lever_07_Switch_Page extends BaseTest {
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

    @Parameters({"browser", "adminUrl", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String adminUrl, String userUrl) {
        driver = getBrowserDriver(browserName, userUrl);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void User_01_Register_Success() {
        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextbox("Eden");
        registerPage.enterToLastNameTextbox("Hazard");
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox("123456");
        registerPage.enterToConfirmPasswordTextbox("123456");

        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");
    }

    @Test
    public void User_02_Login_Success() {
        homePage = registerPage.clickToNopCommerceLogo();

        customerPage = homePage.clickToMyAccountLink();

        //verify
        Assert.assertEquals(customerPage.getFirstNameTextboxAttributeValue(), "Eden");
        Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(), "Hazard");
        Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(), emailAddress);

    }
    @Test
    public void User_03_Switch_Page() {
//        addressPageObject = customerPage.openAddressPage(driver);
//
//        ordersPageObject = addressPageObject.openOrdersPage(driver);
//
//        downloadableProductsPageObject = ordersPageObject.openDownloadableProductsPage(driver);
//
//        backInStockSubcriptionsPageObject = downloadableProductsPageObject.openBackInStockSubscriptionsPage(driver);
//
//        rewardPointsPageObject = backInStockSubcriptionsPageObject.openRewardPointsPage(driver);
//
//        changePasswordPageObject = rewardPointsPageObject.openChangePasswordPage(driver);
//
//        myProductReviewPageObject = changePasswordPageObject.openMyProductReviewPage(driver);
//
//        customerPage = myProductReviewPageObject.openCustomerInfoPage(driver);

    }


    @AfterClass
    public void afterClass() {
        closeWindow();
    }



}
