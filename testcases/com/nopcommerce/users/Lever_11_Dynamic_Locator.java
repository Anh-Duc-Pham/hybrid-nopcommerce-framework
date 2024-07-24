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

public class Lever_11_Dynamic_Locator extends BaseTest {
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
        addressPageObject = (AddressPageObject) customerPage.openDynamicSideBarPage("Addresses");

        ordersPageObject = (OrdersPageObject) addressPageObject.openDynamicSideBarPage("Orders");

        downloadableProductsPageObject = (DownloadableProductsPageObject) ordersPageObject.openDynamicSideBarPage("Downloadable products");

        backInStockSubcriptionsPageObject = (BackInStockSubcriptionsPageObject) downloadableProductsPageObject.openDynamicSideBarPage("Back in stock subscriptions");

        rewardPointsPageObject = (RewardPointsPageObject) backInStockSubcriptionsPageObject.openDynamicSideBarPage("Reward points");

        changePasswordPageObject = (ChangePasswordPageObject) rewardPointsPageObject.openDynamicSideBarPage("Change password");

        myProductReviewPageObject = (MyProductReviewPageObject) changePasswordPageObject.openDynamicSideBarPage("My product reviews");

        customerPage = (CustomerPageObject) myProductReviewPageObject.openDynamicSideBarPage("Customer info");

    }
    @Test
    public void User_04_Switch_Page() {
        customerPage.clickDynamicSideBarPage("Addresses");
        addressPageObject = PageGeneratorManager.getAddressPage(driver);

        addressPageObject.clickDynamicSideBarPage("Orders");
        ordersPageObject = PageGeneratorManager.getOrderPage(driver);

        ordersPageObject.clickDynamicSideBarPage("Downloadable products");
        downloadableProductsPageObject = PageGeneratorManager.getDownloadableProductPage(driver);

        downloadableProductsPageObject.clickDynamicSideBarPage("Back in stock subscriptions");
        backInStockSubcriptionsPageObject = PageGeneratorManager.getBackInStockSubscriptionPage(driver);

        backInStockSubcriptionsPageObject.clickDynamicSideBarPage("Reward points");
        rewardPointsPageObject = PageGeneratorManager.getRewardPointPage(driver);

        rewardPointsPageObject.clickDynamicSideBarPage("Change password");
        changePasswordPageObject = PageGeneratorManager.getChangePasswordPage(driver);

        changePasswordPageObject.clickDynamicSideBarPage("My product reviews");
        myProductReviewPageObject = PageGeneratorManager.getMyProductReviewPage(driver);

        myProductReviewPageObject.clickDynamicSideBarPage("Customer info");
        customerPage = PageGeneratorManager.getCustomerPage(driver);

    }


    @AfterClass
    public void afterClass() {
        closeWindow();
    }



}
