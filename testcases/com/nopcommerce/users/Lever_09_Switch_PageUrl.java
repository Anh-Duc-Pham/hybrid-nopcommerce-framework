package com.nopcommerce.users;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.*;

public class Lever_09_Switch_PageUrl extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private UserLoginPageObject userLoginPage;
    private CustomerPageObject customerPage;
    private AddressPageObject addressPage;
    private BackInStockSubcriptionsPageObject backInStockSubcriptionsPage;
    private ChangePasswordPageObject changePasswordPage;
    private DownloadableProductsPageObject downloadableProductsPage;
    private MyProductReviewPageObject myProductReviewPage;
    private OrdersPageObject ordersPage;
    private RewardPointsPageObject rewardPointsPage;
    private AdminLoginPageObject adminLoginPage;
    private AdminDashboardPageObject adminDashboardPage;


    private String emailAddress = getRandomEmail();
    private String adminUrl, userUrl;

    @Parameters({"browser", "adminUrl", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String adminUrl, String userUrl) {
        this.adminUrl = adminUrl;
        this.userUrl = userUrl;
        driver = getBrowserDriver(browserName, userUrl);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void User_01_User_To_Admin() {
        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextbox("Eden");
        registerPage.enterToLastNameTextbox("Hazard");
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox("123456");
        registerPage.enterToConfirmPasswordTextbox("123456");

        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");

        homePage = registerPage.clickToNopCommerceLogo();
        //logout ra
        homePage.clickToLogoutLink();

        //Home Page( user) -> Login Page (Admin)
        homePage.openPageUrl(driver, adminUrl);

        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

        adminDashboardPage = adminLoginPage.loginToDashBoardPage("admin@yourstore.com", "admin");
        Assert.assertTrue(adminDashboardPage.isPageLoadedSuccess(driver));
    }

    @Test
    public void User_02_Admin_to_User() {
        adminLoginPage = adminDashboardPage.clickToLogoutLink();
        adminLoginPage.openPageUrl(driver, userUrl);

        homePage = PageGeneratorManager.getHomePage(driver);

        userLoginPage = homePage.clickToLoginLink();
        userLoginPage.loginToUserAccount(emailAddress, "123456");


    }

    @AfterClass
    public void afterClass() {
        closeWindow();
    }



}
