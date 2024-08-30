package pageObjects.orangehrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.BaseActionsUI;

public class BaseActions extends BasePage {
    WebDriver driver;

    public BaseActions(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForSpinnerInvisible() {
        waitForListElementsInvisible(driver, BaseActionsUI.SPINNER_ICON);

    }

    public boolean isSuccessMsgDisplayed(String messageContent) {
        waitForElementVisible(driver, BaseActionsUI.DYNAMIC_SUCCESS_MESSAGE, messageContent);
        return isElementDisplayed(driver, BaseActionsUI.DYNAMIC_SUCCESS_MESSAGE, messageContent);
    }

    public boolean isValueDisplayedAtColumName(String columnName, String rowIndex, String rowValue) {
        int columnIndex = getListElementSize(driver, BaseActionsUI.DYNAMIC_INDEX_BY_COLUMN_NAME, columnName) + 1;
        return isElementDisplayed(driver, BaseActionsUI.DYNAMIC_ROW_VALUE_BY_COLUMN_INDEX_ROW_INDEX, rowIndex, String.valueOf(columnIndex), rowValue);
    }
    public PersonalDetailsPageObject clickToEditIconByEmployeeID(String employeeID) {
        waitForElementClickable(driver, BaseActionsUI.EDIT_BUTTON_BY_ID, employeeID);
        clickToElement(driver,BaseActionsUI.EDIT_BUTTON_BY_ID, employeeID);
        waitForSpinnerInvisible();
        return PageGeneratorManager.getPersonalDetailsPage(driver);
    }
    public void clickToRadioButtonByName(String male) {
    }
}
