package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.PersonalDetailsUI;
import pojoData.PIM.EmployeeData;

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

    public void enterToDatePickerByName(String name, String value) {
        waitForElementVisible(driver, PersonalDetailsUI.DYNAMIC_DATE_PICKER_BY_NAME, name);
        sendKeyToElement(driver, PersonalDetailsUI.DYNAMIC_DATE_PICKER_BY_NAME, value, name);
    }


    public void enterToNationalityCustomDropDown(String nation) {
        waitForElementClickable(driver, PersonalDetailsUI.NATION_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, PersonalDetailsUI.NATION_DROPDOWN_PARENT, PersonalDetailsUI.CHILDREN_DROPDOWN, nation);

    }

    public void enterToMaritalStatusCustomDropDown(String maritalStatus) {
        waitForElementClickable(driver, PersonalDetailsUI.MARITAL_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, PersonalDetailsUI.MARITAL_DROPDOWN_PARENT, PersonalDetailsUI.CHILDREN_DROPDOWN, maritalStatus);

    }


    public void clickToSaveButton() {
        waitForElementClickable(driver, PersonalDetailsUI.SAVE_BUTTON);
        clickToElement(driver, PersonalDetailsUI.SAVE_BUTTON);
    }

    public String getLicenseNumberText() {
        waitForElementVisible(driver, PersonalDetailsUI.LICENSE_NUMBER);
        return getElementAttribute(driver, PersonalDetailsUI.LICENSE_NUMBER, "value");
    }



    public String getDatePickerByNameValueByName(String datePickerName) {
        waitForElementVisible(driver, PersonalDetailsUI.DYNAMIC_DATE_PICKER_BY_NAME, datePickerName);
        return  getElementAttribute(driver, PersonalDetailsUI.DYNAMIC_DATE_PICKER_BY_NAME, "value",datePickerName);
    }



    public String getNationDropDownValue() {
        waitForElementVisible(driver, PersonalDetailsUI.NATION_DROPDOWN_TXT);
        return getElementText(driver, PersonalDetailsUI.NATION_DROPDOWN_TXT);
    }

    public String getMaritalDropDownValue() {
        waitForElementVisible(driver, PersonalDetailsUI.MARITAL_DROPDOWN_TXT);
        return getElementText(driver, PersonalDetailsUI.MARITAL_DROPDOWN_TXT);
    }

    public void setPersonalDetail(EmployeeData employeeData) {
        enterToLicenseNumber(employeeData.getLicenseNumber());

        enterToDatePickerByName("License Expiry Date", employeeData.getLicenseExpireDate());
        enterToNationalityCustomDropDown(employeeData.getNation());
        enterToMaritalStatusCustomDropDown(employeeData.getMaritalStatus());
        enterToDatePickerByName("Date of Birth", employeeData.getDateOfBirth());
        clickToRadioButtonByName("Male");
    }
}
