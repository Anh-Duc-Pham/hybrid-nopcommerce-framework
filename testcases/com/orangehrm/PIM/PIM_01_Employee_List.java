package com.orangehrm.PIM;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PIM_01_Employee_List extends BaseTest {
    private WebDriver driver;

    @Parameters({"url", "browser"})
    @BeforeClass
    public void beforeClass(String url, String browserName) {
        getBrowserDriver(browserName, url);


    }
    @Test
    public void Employee_01_Add_New_Employee() {

    }
    @Test
    public void Employee_02_Upload_Avatar() {

    }
    @Test
    public void Employee_03_Personal_Details() {

    }
    @Test
    public void Employee_04_Contact_Details() {

    }
    @Test
    public void Employee_05_Emergency_Details() {

    }
    @Test
    public void Employee_06_Assigned_Dependents() {

    }
    @Test
    public void Employee_07_Edit_View_Job() {

    }
    @Test
    public void Employee_08_Edit_View_Salary() {

    }
    @Test
    public void Employee_09_Edit_View_Tax() {

    }
    @Test
    public void Employee_10_Qualification() {

    }
    @Test
    public void Employee_11_Search_Employee() {

    }




    @AfterClass
    public void afterClass() {
        closeWindow();
    }
}
