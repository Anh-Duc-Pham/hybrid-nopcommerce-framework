package pageObjects.facebook;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.facebook.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToCreateAccountButton() {
        waitForElementClickable(driver, HomePageUI.CREATE_ACCOUNT_BUTTON);
        clickToElement(driver,HomePageUI.CREATE_ACCOUNT_BUTTON);
    }

    public boolean isNameTextboxDisplayed() {
        waitForElementVisible(driver, HomePageUI.NAME_TEXTBOX);
        return isElementDisplayed(driver, HomePageUI.NAME_TEXTBOX);
    }

    public boolean isSurNameTextboxDisplayed() {
        waitForElementVisible(driver, HomePageUI.SURNAME_TEXTBOX);
        return isElementDisplayed(driver, HomePageUI.SURNAME_TEXTBOX);
    }

    public boolean isEmailTextboxDisplayed() {
        waitForElementVisible(driver, HomePageUI.GMAIL_TEXTBOX);
        return isElementDisplayed(driver, HomePageUI.GMAIL_TEXTBOX);
    }

    public boolean isPasswordTextboxDisplayed() {
        waitForElementVisible(driver, HomePageUI.PASSWORD_TEXTBOX);
        return isElementDisplayed(driver, HomePageUI.PASSWORD_TEXTBOX);
    }

    public void enterToGmailTextbox(String value) {
        waitForElementVisible(driver, HomePageUI.GMAIL_TEXTBOX);
        sendKeyToElement(driver, HomePageUI.GMAIL_TEXTBOX, value);
    }

    public boolean isConfirmEmailTextboxDisplayed() {
        waitForElementVisible(driver, HomePageUI.CONFIRM_EMAIL_TEXTBOX);
        return isElementDisplayed(driver, HomePageUI.CONFIRM_EMAIL_TEXTBOX);
    }

    public void clickToCloseButton() {
        waitForElementClickable(driver, HomePageUI.CLOSE_REGISTER_BUTTON);
        clickToElement(driver, HomePageUI.CLOSE_REGISTER_BUTTON);
    }

    public boolean isNameTextboxUndisplayed() {
        return isElementUndisplayed(driver, HomePageUI.NAME_TEXTBOX);
    }

    public boolean isSurNameTextboxUndisplayed() {
        return isElementUndisplayed(driver, HomePageUI.SURNAME_TEXTBOX);
    }

    public boolean isEmailTextboxUndisplayed() {
        return isElementUndisplayed(driver, HomePageUI.GMAIL_TEXTBOX);
    }

    public boolean isPasswordTextboxUndisplayed() {
        return isElementUndisplayed(driver, HomePageUI.PASSWORD_TEXTBOX);
    }
}
