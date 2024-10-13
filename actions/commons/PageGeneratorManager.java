package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.*;

public class PageGeneratorManager {
    public static CustomerPageObject getCustomerPage(WebDriver driver) {
        return new CustomerPageObject(driver);
    }

    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }

    public static RegisterPageObject getRegisterPage(WebDriver driver) {
        return new RegisterPageObject(driver);
    }

    public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
        return new UserLoginPageObject(driver);
    }
    public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPageObject(driver);
    }
    public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
        return new AdminDashboardPageObject(driver);
    }
    public static AddressPageObject getAddressPage (WebDriver driver) {
        return new AddressPageObject(driver);
    }
    public static OrdersPageObject getOrderPage (WebDriver driver) {
        return new OrdersPageObject(driver);
    }
    public static DownloadableProductsPageObject getDownloadableProductPage (WebDriver driver) {
        return new DownloadableProductsPageObject(driver);
    }
    public static BackInStockSubcriptionsPageObject getBackInStockSubscriptionPage (WebDriver driver) {
        return new BackInStockSubcriptionsPageObject(driver);
    }
    public static RewardPointsPageObject getRewardPointPage (WebDriver driver) {
        return new RewardPointsPageObject(driver);
    }
    public static ChangePasswordPageObject getChangePasswordPage (WebDriver driver) {
        return new ChangePasswordPageObject(driver);
    }
    public static SearchPageObject getSearchPage(WebDriver driver) {
        return new SearchPageObject(driver);
    }
}
