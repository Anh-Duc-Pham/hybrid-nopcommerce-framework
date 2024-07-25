package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToSearchTextbox (String textboxName, String value) {
        waitForElementVisible(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, textboxName);
        sendKeyToElement(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, value, textboxName);
    }
    public void pressKeyToKeyboard(Keys keyName) {
        pressKeyToKeyboard(driver, keyName);
    }

    public void clickToPageByNumber(String pageNumber) {
        waitForElementClickable(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
        clickToElement(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
    }

    public boolean isPageNumberActive (String pageNumber) {
        waitForElementVisible(driver, HomePageUI.PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
        return isElementDisplayed(driver, HomePageUI.PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
    }
    public boolean isRowValueDisplayed (String femaleNumber, String country, String maleNumber, String total) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_ROW_VALUE, femaleNumber, country, maleNumber, total);
        return isElementDisplayed(driver, HomePageUI.DYNAMIC_ROW_VALUE, femaleNumber, country, maleNumber, total);
    }
}
