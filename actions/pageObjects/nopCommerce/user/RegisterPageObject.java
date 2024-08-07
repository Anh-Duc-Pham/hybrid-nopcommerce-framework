package pageObjects.nopCommerce.user;

import commons.BaseElement;
import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class RegisterPageObject extends BaseElement {
    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click to Register Button")
    public void clickToRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    public String getFirstNameErrorMessageText() {
        waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_ERROR_MSG);
        return getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR_MSG);
    }

    public String getLastNameErrorMessageText() {
        waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR_MSG);
        return getElementText(driver, RegisterPageUI.LASTNAME_ERROR_MSG);
    }

    public String getEmailErrorMessageText() {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MSG);
        return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MSG);
    }

    public String getPasswordValidationErrorMessageText() {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_VALIDATION_ERROR_MSG);
        return getElementText(driver, RegisterPageUI.PASSWORD_VALIDATION_ERROR_MSG);
    }

    public String getConfirmPasswordErrorMessageText() {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
        return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
    }

    public HomePageObject clickToNopCommerceLogo() {
        waitForElementClickable(driver, RegisterPageUI.NOP_COMMERCE_LOGO);
        clickToElement(driver, RegisterPageUI.NOP_COMMERCE_LOGO);
        return PageGeneratorManager.getHomePage(driver);
    }

    @Step("Enter to First Name textbox with value is {0}")
    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
    }
    @Step("Enter to Last Name textbox with value is {0}")
    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
    }

    @Step("Enter to Email textbox with value is {0}")
    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
    }

    @Step("Enter to Password textbox with value is {0}")
    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Enter to Confirm Password textbox with value is {0}")
    public void enterToConfirmPasswordTextbox(String password) {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }

    public String getRegisterSuccessMessageText() {
        waitForElementVisible(driver, RegisterPageUI.REGISTRATION_COMPLETED_MSG);
        return getElementText(driver, RegisterPageUI.REGISTRATION_COMPLETED_MSG);
    }
}
