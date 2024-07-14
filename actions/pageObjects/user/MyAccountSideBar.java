package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.user.MyAccountSideBarUI;

public class MyAccountSideBar extends BasePage {
    private WebDriver driver;

    public MyAccountSideBar(WebDriver driver) {
        this.driver = driver;
    }

    public CustomerPageObject openCustomerInfoPage () {
        waitForElementClickable(driver, MyAccountSideBarUI.CUSTOMER_INFO_LINK);
        clickToElement(driver, MyAccountSideBarUI.CUSTOMER_INFO_LINK);
        return new CustomerPageObject(driver);
    }
    public AddressPageObject openAddressPage () {
        waitForElementClickable(driver, MyAccountSideBarUI.ADDRESSES_LINK);
        clickToElement(driver, MyAccountSideBarUI.ADDRESSES_LINK);
        return new AddressPageObject(driver);
    }
    public OrdersPageObject openOrdersPage () {
        waitForElementClickable(driver, MyAccountSideBarUI.ORDERS_LINK);
        clickToElement(driver, MyAccountSideBarUI.ORDERS_LINK);
        return new OrdersPageObject(driver);
    }
    public DownloadableProductsPageObject openDownloadableProductsPage () {
        waitForElementClickable(driver, MyAccountSideBarUI.DOWNLOADABLE_PRODUCTS_LINK);
        clickToElement(driver, MyAccountSideBarUI.DOWNLOADABLE_PRODUCTS_LINK);
        return new DownloadableProductsPageObject(driver);
    }
    public BackInStockSubcriptionsPageObject openBackInStockSubscriptionsPage () {
        waitForElementClickable(driver, MyAccountSideBarUI.BACK_IN_STOCK_SUBSCRIPTIONS_LINK);
        clickToElement(driver, MyAccountSideBarUI.BACK_IN_STOCK_SUBSCRIPTIONS_LINK);
        return new BackInStockSubcriptionsPageObject(driver);
    }
    public RewardPointsPageObject openRewardPointsPage () {
        waitForElementClickable(driver, MyAccountSideBarUI.REWARD_POINTS_LINK);
        clickToElement(driver, MyAccountSideBarUI.REWARD_POINTS_LINK);
        return new RewardPointsPageObject(driver);
    }
    public ChangePasswordPageObject openChangePasswordPage () {
        waitForElementClickable(driver, MyAccountSideBarUI.CHANGE_PASSWORD_LINK);
        clickToElement(driver, MyAccountSideBarUI.CHANGE_PASSWORD_LINK);
        return new ChangePasswordPageObject(driver);
    }
    public MyProductReviewPageObject openMyProductReviewPage () {
        waitForElementClickable(driver, MyAccountSideBarUI.MY_PRODUCT_REVIEW_LINK);
        clickToElement(driver, MyAccountSideBarUI.MY_PRODUCT_REVIEW_LINK);
        return new MyProductReviewPageObject(driver);
    }

}
