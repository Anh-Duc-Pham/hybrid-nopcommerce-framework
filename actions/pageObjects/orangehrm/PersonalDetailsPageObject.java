package pageObjects.orangehrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.PersonalDetailsUI;

public class PersonalDetailsPageObject extends BaseActions {
    private WebDriver driver;

    public PersonalDetailsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getTextboxValueByName(String textboxByName) {
        waitForElementVisible(driver, PersonalDetailsUI.DYNAMIC_TEXTBOX_BY_NAME, textboxByName);
        return getElementAttribute(driver, PersonalDetailsUI.DYNAMIC_TEXTBOX_BY_NAME, "value", textboxByName);
    }

    public String getEmployeeIDValue() {
        waitForElementClickable(driver, PersonalDetailsUI.EMPLOYEE_ID_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsUI.EMPLOYEE_ID_TEXTBOX, "value");
    }

    public EmployeeListPageObject clickToEmployeeListButton() {
        waitForElementClickable(driver, PersonalDetailsUI.EMPLOYEE_LIST_BUTTON);
        clickToElement(driver, PersonalDetailsUI.EMPLOYEE_LIST_BUTTON);
        return PageGeneratorManager.getEmployeeListPage(driver);
    }

    public boolean isPersonalDetailHeaderDisplayed() {
        waitForElementVisible(driver, PersonalDetailsUI.PERSONAL_DETAILS_PAGE_HEADER);
        return isElementDisplayed(driver, PersonalDetailsUI.PERSONAL_DETAILS_PAGE_HEADER);
    }

    public void enterToLicenseNumber(String licenseNumber) {
        waitForElementVisible(driver, PersonalDetailsUI.LICENSE_NUMBER);
        sendKeyToElement(driver, PersonalDetailsUI.LICENSE_NUMBER, licenseNumber);
    }

    public void enterToDatePickerByName(String licenseExpiryDate, String value) {
        waitForElementVisible(driver, PersonalDetailsUI.DYNAMIC_DATE_PICKER_BY_NAME, licenseExpiryDate);
        sendKeyToElement(driver, PersonalDetailsUI.DYNAMIC_DATE_PICKER_BY_NAME, value, licenseExpiryDate);
    }

    public void enterToCustomDropDownByName(String nationality, String value) {
    }

    public void clickTosaveButton() {
    }

    public byte[] getLicenseNumberText() {
    }

    public double getCustomDropDownValueByName(String nationality) {
    }

    public double getDatePickerByNameValueByName(String licenseExpiryDate) {
    }

    public boolean isRadioButtonSelectedByName(String male) {
    }
}
