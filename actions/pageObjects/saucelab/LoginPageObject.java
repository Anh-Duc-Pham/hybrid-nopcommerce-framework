package pageObjects.saucelab;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.BaseActions;
import pageUIs.saucelab.LoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToUserTxt(String userName) {
        waitForElementVisible(driver, LoginPageUI.USERNAME_TXT);
        sendKeyToElement(driver, LoginPageUI.USERNAME_TXT, userName);
    }

    public void enterToPassword(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TXT);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TXT, password);
    }

    public ProductPageObject clickToLoginBtn() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BTN);
        clickToElement(driver, LoginPageUI.LOGIN_BTN);
        return PageGeneratorManager.getProductPageObject(driver);
    }
}
