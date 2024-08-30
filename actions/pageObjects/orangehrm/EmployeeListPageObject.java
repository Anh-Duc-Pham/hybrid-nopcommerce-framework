package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.EmployeeListUI;

public class EmployeeListPageObject extends BaseActions {
    WebDriver driver;

    public EmployeeListPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public AddEmployeePageObject clickToAddEmployeeOnMenu() {
        waitForElementClickable(driver, EmployeeListUI.ADD_EMPLOYEE_BTN);
        clickToElement(driver, EmployeeListUI.ADD_EMPLOYEE_BTN);
        waitForSpinnerInvisible();
        return PageGeneratorManager.getAddEmployeePage(driver);
    }

    public void enterToEmployeeIDTextbox(String employeeID) {
        waitForElementVisible(driver, EmployeeListUI.EMPLOYEE_ID_TEXTBOX);
        sendKeyToElement(driver, EmployeeListUI.EMPLOYEE_ID_TEXTBOX, employeeID);
    }

    public void clickToSearchButton() {
        waitForElementClickable(driver, EmployeeListUI.SEARCH_BTN);
        clickToElement(driver, EmployeeListUI.SEARCH_BTN);
        waitForSpinnerInvisible();
    }

}
