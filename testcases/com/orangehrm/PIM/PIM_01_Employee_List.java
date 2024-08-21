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
    private String browserName, employeeID;

    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private EmployeeListPageObject employeeListPage;
    private AddEmployeePageObject addEmployeePage;
    private PersonalDetailsPageObject personalDetailsPage;

    @Parameters({"url", "browser"})
    @BeforeClass
    public void beforeClass(String url, String browserName) {
        driver = getBrowserDriver(browserName, url);
        this.browserName = browserName;
        loginPage = PageGeneratorManager.getLoginPage(driver);

        loginPage.enterToUsernameTextbox("Admin");
        loginPage.enterToPasswordTextbox("admin123");
        loginPage.clickToLoginButton();

        dashboardPage = PageGeneratorManager.getDashboardPage(driver);
        employeeListPage = dashboardPage.clickToPIMOnMenu();

    }
    @Test
    public void Employee_01_Add_New_Employee(Method method) {
        ExtentTestManager.startTest(method.getName() + "Test on" + browserName.toUpperCase() ," Employee_01_Add_New_Employee");
        addEmployeePage = employeeListPage.clickToAddEmployeeOnMenu();
        addEmployeePage.enterToTextboxByName("firstName", "Eden");
        addEmployeePage.enterToTextboxByName("lastName", "");

        employeeID = addEmployeePage.getEmployeeID();
        addEmployeePage.clickToSaveButton();
        addEmployeePage.isSuccessMsgDisplayed("Successfully Saved");
        //p[contains(@class,'oxd-text--toast-message') and text()='Successfully Saved']
        personalDetailsPage = PageGeneratorManager.getPersonalDetailsPage(driver);

        Assert.assertEquals(personalDetailsPage.getTextboxValueByName("firstName"), "Eden");
        Assert.assertEquals(personalDetailsPage.getTextboxValueByName("lastName"), "");
        Assert.assertEquals(personalDetailsPage.getEmployeeIDValue(), employeeID);

        employeeListPage = personalDetailsPage.clickToEmployeeListButton();

        employeeListPage.enterToEmployeeIDTextbox(employeeID);
        employeeListPage.clickToSearchButton();

        Assert.assertTrue(employeeListPage.isValueDisplayedAtColumName("Id", employeeID));
        Assert.assertTrue(employeeListPage.isValueDisplayedAtColumName("First (& Middle) Name", "Eden"));
        Assert.assertTrue(employeeListPage.isValueDisplayedAtColumName("Last Name", ""));




    }
    @Test
    public void Employee_02_Upload_Avatar(Method method) {
        ExtentTestManager.startTest(method.getName() + "Test on" + browserName.toUpperCase() ,"Employee_02_Upload_Avatar");


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
