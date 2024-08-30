package pageUIs.orangehrm;

public class PersonalDetailsUI {
    public static final String DYNAMIC_TEXTBOX_BY_NAME = "css=input[name='%s']";
    public static final String EMPLOYEE_ID_TEXTBOX = "xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";
    public static final String EMPLOYEE_LIST_BUTTON = "xpath=//a[text()='Employee List']";
    public static final String PERSONAL_DETAILS_PAGE_HEADER = "xpath=//h6[text()='Personal Details']";
    public static final String LICENSE_NUMBER = "xpath=//label[text()=\"Driver's License Number\"]/parent::div/following-sibling::div/input";
    public static final String DYNAMIC_DATE_PICKER_BY_NAME = "xpath=//label[text()='%s']/parent::div/following-sibling::div//input";
    public static final String NATION_DROPDOWN_PARENT = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text--after')]";
    public static final String MARITAL_DROPDOWN_PARENT = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text--after')]";
    public static final String CHILDREN_DROPDOWN = "xpath=//div[@class='oxd-select-option']/span";

    public static final String NATION_DROPDOWN_TXT = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text-input')]";
    public static final String MARITAL_DROPDOWN_TXT = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text-input')]";



    public static final String SAVE_BUTTON = "xpath=//button[contains(string(),'Save')]";



}
