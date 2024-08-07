package commons;

import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.BaseElementUI;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class BaseElement extends BasePage {
    private WebDriver driver;

    public BaseElement(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToHeaderLinkByName(String pageName) {
        waitForElementClickable(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);
        clickToElement(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);
    }

    public void clickToButtonByText(String buttonText) {
        waitForElementClickable(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
        clickToElement(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);

    }

    public String getTextboxErrorMessageByID(String errorMsgID) {
        waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_ERROR_MSG_BY_ID, errorMsgID);
        return getElementText(driver, BaseElementUI.DYNAMIC_TEXTBOX_ERROR_MSG_BY_ID, errorMsgID);
    }

    public void clickToCommonNopCommerceLogo() {
        waitForElementClickable(driver, BaseElementUI.NOP_COMMERCE_LOGO);
        clickToElement(driver, BaseElementUI.NOP_COMMERCE_LOGO);
    }

    public void enterToTextboxByID(String textboxID, String valueToSend) {
        waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
        sendKeyToElement(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, valueToSend, textboxID);
    }

    public String getTextboxAttributeByID(String textboxID) {
        waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
        return getElementAttribute(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, "value", textboxID);
    }
}
