package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.CustomerPageUI;

public class CustomerPageObject extends MyAccountSideBar {
    private WebDriver driver;

    public CustomerPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getFirstNameTextboxAttributeValue() {
        waitForElementVisible(driver, CustomerPageUI.FIRSTNAME_TEXTBOX);
        return getElementAttribute(driver, CustomerPageUI.FIRSTNAME_TEXTBOX, "value");
    }

    public String getLastNameTextboxAttributeValue() {
        waitForElementVisible(driver, CustomerPageUI.LASTNAME_TEXTBOX);
        return getElementAttribute(driver, CustomerPageUI.LASTNAME_TEXTBOX, "value");

    }

    public String getEmailAddressTextboxAttributeValue() {
        waitForElementVisible(driver, CustomerPageUI.EMAIL_ADDRESS_TEXTBOX);
        return getElementAttribute(driver, CustomerPageUI.EMAIL_ADDRESS_TEXTBOX, "value");
    }
}
