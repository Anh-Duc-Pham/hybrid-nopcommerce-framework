package pageObject.factory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends BasePageFactory {
    private WebDriver driver;
    @FindBy(xpath = "//input[@id='FirstName']")
    private WebElement firstNameTextbox;
    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement lastNameTextbox;
    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailTextbox;
    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordTextbox;
    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    private WebElement confirmPasswordTextbox;
    @FindBy(xpath = "//button[@id='register-button']")
    private WebElement registerButton;
    @FindBy(xpath = "//span[@id='FirstName-error']")
    private WebElement firstNameErrorMsg;
    @FindBy(xpath = "//span[@id='LastName-error']")
    private WebElement lastNameErrorMsg;
    @FindBy(xpath = "//span[@id='Email-error']")
    private WebElement emailErrorMsg;
    @FindBy(xpath = "//span[@class='field-validation-error']")
    private WebElement passwordValidationErrorMsg;
    @FindBy(xpath = "//span[@id='ConfirmPassword-error']")
    private WebElement confirmPasswordErrorMsg;
    @FindBy(xpath = "//div[@class='result']")
    private WebElement registrationCompleteMsg;
    @FindBy(xpath = "//img[@alt='nopCommerce demo store']")
    private WebElement nopCommerceLogo;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, registerButton);
        clickToElement(registerButton);
    }

    public String getFirstNameErrorMessageText() {
        waitForElementVisible(driver, firstNameErrorMsg);
        return getElementText(firstNameErrorMsg);
    }

    public String getLastNameErrorMessageText() {
        waitForElementVisible(driver, lastNameErrorMsg);
        return getElementText(lastNameErrorMsg);
    }

    public String getEmailErrorMessageText() {
        waitForElementVisible(driver,emailErrorMsg);
        return getElementText(emailErrorMsg);
    }

    public String getConfirmPasswordErrorMessageText() {
        waitForElementVisible(driver, confirmPasswordErrorMsg);
        return getElementText(confirmPasswordErrorMsg);
    }

    public void clickToNopCommerceLogo() {
        waitForElementClickable(driver, nopCommerceLogo);
        clickToElement(nopCommerceLogo);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, firstNameTextbox);
        sendKeyToElement(firstNameTextbox, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, lastNameTextbox);
        sendKeyToElement(lastNameTextbox, lastName);
    }

    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver, emailTextbox);
        sendKeyToElement(emailTextbox, email);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, passwordTextbox);
        sendKeyToElement(passwordTextbox, password);
    }

    public void enterToConfirmPasswordTextbox(String password) {
        waitForElementVisible(driver,confirmPasswordTextbox);
        sendKeyToElement(confirmPasswordTextbox, password);
    }

    public String getPasswordValidationErrorMessageText() {
        waitForElementVisible(driver, passwordValidationErrorMsg);
        return getElementText(passwordValidationErrorMsg);
    }

    public String getRegisterSuccessMessageText() {
        waitForElementVisible(driver, registrationCompleteMsg);
        return getElementText(registrationCompleteMsg);
    }
}
