package pageObjects.orangehrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.LoginUI;

public class LoginPageObject extends BaseActions {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterToUsernameTextbox(String userName) {
        waitForElementVisible(driver, LoginUI.USER_NAME_TEXTBOX);
        sendKeyToElement(driver, LoginUI.USER_NAME_TEXTBOX, userName);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginUI.PASSWORD_TEXTBOX, password);

    }

    public DashboardPageObject clickToLoginButton() {
        waitForElementClickable(driver, LoginUI.LOGIN_BTN);
        clickToElement(driver, LoginUI.LOGIN_BTN);
        waitForSpinnerInvisible();
        return PageGeneratorManager.getDashboardPage(driver);

    }
}
