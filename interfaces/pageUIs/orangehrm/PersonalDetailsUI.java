package pageUIs.orangehrm;

public class PersonalDetailsUI {
    public static final String DYNAMIC_TEXTBOX_BY_NAME = "css=input[name='%s']";
    public static final String EMPLOYEE_ID_TEXTBOX = "xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";
    public static final String EMPLOYEE_LIST_BUTTON = "xpath=//a[text()='Employee List']";
    public static final String PERSONAL_DETAILS_PAGE_HEADER = "xpath=//h6[text()='Personal Details']";
    public static final String LICENSE_NUMBER = "//label[text()=\"Driver's License Number\"]/parent::div/following-sibling::div/input";
    public static final String DYNAMIC_DATE_PICKER_BY_NAME = "//label[text()='%s']/parent::div/following-sibling::div//input";
    public static final String DYNAMIC_DROP_DOWN_BUTTON_BY_NAME = "//label[text()='%s']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text--after')]";
    public static final String SAVE_BUTTON = "//button[contains(string(),'Save')]";



}
