package com.jquery.table;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;

public class Lever_12_Handle_Datatable extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;


    @Parameters({"browser", "pageUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String pageUrl) {
        driver = getBrowserDriver(browserName, pageUrl);
        homePage = PageGeneratorManager.getHomePage(driver);


    }

    @Test
    public void User_01_() {
    }

    @Test
    public void User_02_Login_Success() {

    }
    @Test
    public void User_03_Switch_Page() {

    }
    @AfterClass
    public void afterClass() {
        closeWindow();
    }



}
