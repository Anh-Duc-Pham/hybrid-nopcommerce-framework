package com.orangehrm.PIM;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangehrm.*;
import reportConfigs.ExtentTestManager;

import java.lang.reflect.Method;

public class PIM_01_Employee_List extends BaseTest {
    private WebDriver driver;
    private String browserName, employeeID, firstName, lastName;

    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private EmployeeListPageObject employeeListPage;
    private AddEmployeePageObject addEmployeePage;
    private PersonalDetailsPageObject personalDetailsPage;

    private String licenseNumber, licenseExpireDate, nation, maritalStatus, dateOfBirth;

    @Parameters({"url", "browser"})
    @BeforeClass
    public void beforeClass(String url, String browserName) {
        driver = getBrowserDriver(browserName, url);
        this.browserName = browserName;
        firstName = "eden";
        lastName = "hazard";

        licenseNumber ="S999-999-999";
        licenseExpireDate = "2024-01-01";
        nation = "Albanian";
        maritalStatus = "Single";
        dateOfBirth = "1993-01-01";


        loginPage = PageGeneratorManager.getLoginPage(driver);

        loginPage.enterToUsernameTextbox(GlobalConstants.ADMIN_ORANGE_HRM_USER);
        loginPage.enterToPasswordTextbox(GlobalConstants.ADMIN_ORANGE_HRM_PASSWORD);
        dashboardPage = loginPage.clickToLoginButton();

        employeeListPage = dashboardPage.clickToPIMOnMenu();

    }
    @Test
    public void Employee_01_Add_New_Employee(Method method) {
        ExtentTestManager.startTest(method.getName() + "Test on" + browserName.toUpperCase() ," Employee_01_Add_New_Employee");
        addEmployeePage = employeeListPage.clickToAddEmployeeOnMenu();
        addEmployeePage.enterToTextboxByName("firstName", firstName);
        addEmployeePage.enterToTextboxByName("lastName", lastName);
        employeeID = addEmployeePage.getEmployeeID();

        addEmployeePage.clickToSaveButton();
        Assert.assertTrue(addEmployeePage.isSuccessMsgDisplayed("Successfully Saved"));
        addEmployeePage.waitForSpinnerInvisible();

        personalDetailsPage = PageGeneratorManager.getPersonalDetailsPage(driver);

        Assert.assertTrue(personalDetailsPage.isPersonalDetailHeaderDisplayed());
        personalDetailsPage.waitForSpinnerInvisible();

        Assert.assertEquals(personalDetailsPage.getTextboxValueByName("firstName"), firstName);
        Assert.assertEquals(personalDetailsPage.getTextboxValueByName("lastName"), lastName);
        Assert.assertEquals(personalDetailsPage.getEmployeeIDValue(), employeeID);

        employeeListPage = personalDetailsPage.clickToEmployeeListButton();

        employeeListPage.enterToEmployeeIDTextbox(employeeID);
        employeeListPage.clickToSearchButton();

        Assert.assertTrue(employeeListPage.isValueDisplayedAtColumName("Id", "1",  employeeID));
        Assert.assertTrue(employeeListPage.isValueDisplayedAtColumName("First (& Middle) Name","1", firstName));
        Assert.assertTrue(employeeListPage.isValueDisplayedAtColumName("Last Name","1", lastName));




    }
    @Test
    public void Employee_02_Upload_Avatar(Method method) {
        ExtentTestManager.startTest(method.getName() + "Test on" + browserName.toUpperCase() ,"Employee_02_Upload_Avatar");
        personalDetailsPage = employeeListPage.clickToEditIconByEmployeeID(employeeID);

        Assert.assertTrue(personalDetailsPage.isPersonalDetailHeaderDisplayed());

        Assert.assertEquals(personalDetailsPage.getTextboxValueByName("firstName"), firstName);
        Assert.assertEquals(personalDetailsPage.getTextboxValueByName("lastName"), lastName);
        Assert.assertEquals(personalDetailsPage.getEmployeeIDValue(), employeeID);

        personalDetailsPage.enterToLicenseNumber(licenseNumber);

        personalDetailsPage.enterToDatePickerByName("License Expiry Date", licenseExpireDate);
        personalDetailsPage.enterToCustomDropDownByName("Nationality", nation);
        personalDetailsPage.enterToCustomDropDownByName("Marital Status", maritalStatus);
        personalDetailsPage.enterToDatePickerByName("Date of Birth", dateOfBirth);
        personalDetailsPage.clickToRadioButtonByName("Male");

        personalDetailsPage.clickTosaveButton();

        Assert.assertTrue(addEmployeePage.isSuccessMsgDisplayed("Successfully Updated"));

        personalDetailsPage.waitForSpinnerInvisible();

        Assert.assertEquals(personalDetailsPage.getLicenseNumberText(),"");

        Assert.assertEquals(personalDetailsPage.getCustomDropDownValueByName("Nationality"),"");
        Assert.assertEquals(personalDetailsPage.getCustomDropDownValueByName("Marital Status"),"");

        Assert.assertEquals(personalDetailsPage.getDatePickerByNameValueByName("License Expiry Date"),"");
        Assert.assertEquals(personalDetailsPage.getDatePickerByNameValueByName("Date of Birth"),"");

        Assert.assertTrue(personalDetailsPage.isRadioButtonSelectedByName("Male"));










    }
    @Test
    public void Employee_03_Personal_Details(Method method) {
        ExtentTestManager.startTest(method.getName() + "Test on" + browserName.toUpperCase() ,"Employee_03_Personal_Details");


    }
    @Test
    public void Employee_04_Contact_Details(Method method) {
        ExtentTestManager.startTest(method.getName() + "Test on" + browserName.toUpperCase() ,"Employee_04_Contact_Details");


    }
    @Test
    public void Employee_05_Emergency_Details(Method method) {
        ExtentTestManager.startTest(method.getName() + "Test on" + browserName.toUpperCase() ,"Employee_05_Emergency_Details");


    }
    @Test
    public void Employee_06_Assigned_Dependents(Method method) {
        ExtentTestManager.startTest(method.getName() + "Test on" + browserName.toUpperCase() ,"Employee_06_Assigned_Dependents");

    }
    @Test
    public void Employee_07_Edit_View_Job(Method method) {
        ExtentTestManager.startTest(method.getName() + "Test on" + browserName.toUpperCase() ," Employee_07_Edit_View_Job");

    }
    @Test
    public void Employee_08_Edit_View_Salary(Method method) {
        ExtentTestManager.startTest(method.getName() + "Test on" + browserName.toUpperCase() ,"Employee_08_Edit_View_Salary");

    }
    @Test
    public void Employee_09_Edit_View_Tax(Method method) {
        ExtentTestManager.startTest(method.getName() + "Test on" + browserName.toUpperCase() ,"Employee_09_Edit_View_Tax");

    }
    @Test
    public void Employee_10_Qualification(Method method) {
        ExtentTestManager.startTest(method.getName() + "Test on" + browserName.toUpperCase() ,"Employee_10_Qualification");

    }
    @Test
    public void Employee_11_Search_Employee(Method method) {
        ExtentTestManager.startTest(method.getName() + "Test on" + browserName.toUpperCase() ,"Employee_11_Search_Employee");

    }




    @AfterClass
    public void afterClass() {
        closeWindow();
    }
}
