package pageObjects.orangehrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.AddEmployeeUI;

public class AddEmployeePageObject extends BaseActions {
    WebDriver driver;

    public AddEmployeePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterToTextboxByName(String nameText, String value) {
        waitForElementVisible(driver, AddEmployeeUI.DYNAMIC_NAME_TEXTBOX, nameText);
        sendKeyToElement(driver, AddEmployeeUI.DYNAMIC_NAME_TEXTBOX, value, nameText);
    }

    public String getEmployeeID() {
        waitForElementVisible(driver, AddEmployeeUI.EMPLOYEE_ID_TEXTBOX);
        return getElementAttribute(driver, AddEmployeeUI.EMPLOYEE_ID_TEXTBOX, "value");
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, AddEmployeeUI.SAVE_BTN);
        clickToElement(driver, AddEmployeeUI.SAVE_BTN);
    }


}
