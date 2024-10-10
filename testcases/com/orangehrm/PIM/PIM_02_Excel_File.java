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
import utilities.ExcelConfig;

import java.lang.reflect.Method;

public class PIM_02_Excel_File extends BaseTest {
    private WebDriver driver;

    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private EmployeeListPageObject employeeListPage;
    private AddEmployeePageObject addEmployeePage;
    private PersonalDetailsPageObject personalDetailsPage;

    private String emailAddress, firstName, lastName, password, browserName;
    private ExcelConfig excelConfig;

    @Parameters({"url", "browser"})
    @BeforeClass
    public void beforeClass(String url, String browserName) {
        driver = getBrowserDriver(browserName, url);
        this.browserName = browserName;

        excelConfig = ExcelConfig.getExcelData();
        excelConfig.switchToSheet("UserData");


        firstName = excelConfig.getCellData("FirstName", 1);
        lastName = excelConfig.getCellData("LastName", 1);
        emailAddress = getRandomEmail(excelConfig.getCellData("EmailAddress", 1));
        password = excelConfig.getCellData("Password", 1);

        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(emailAddress);
        System.out.println(password);

    }









    @Test
    public void Employee_06_Assigned_Dependents(Method method) {
        ExtentTestManager.startTest(method.getName() + "Test on" + browserName.toUpperCase(), "Employee_06_Assigned_Dependents");

    }

    @Test
    public void Employee_07_Edit_View_Job(Method method) {
        ExtentTestManager.startTest(method.getName() + "Test on" + browserName.toUpperCase(), " Employee_07_Edit_View_Job");

    }



    @AfterClass
    public void afterClass() {
        closeWindow();
    }
}
