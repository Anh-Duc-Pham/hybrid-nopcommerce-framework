package pageObjects.nopCommerce.admin;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
    private WebDriver driver;

    public AdminLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TXT);
        sendKeyToElement(driver, AdminLoginPageUI.EMAIL_TXT, email);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TXT);
        sendKeyToElement(driver, AdminLoginPageUI.EMAIL_TXT, password);
    }

    public AdminDashboardPageObject clickToLoginButton() {
        waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getAdminDashboardPage(driver);
    }

    public AdminDashboardPageObject loginToDashBoardPage(String email, String password) {
        enterToEmailTextbox(email);
        enterToPasswordTextbox(email);
        return clickToLoginButton();
    }
}
