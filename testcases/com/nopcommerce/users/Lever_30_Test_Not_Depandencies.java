package com.nopcommerce.users;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.RegisterPageObject;
import pageObjects.nopCommerce.user.SearchPageObject;
import reportConfigs.ExtentTestManager;
import utilities.ExcelConfig;

import java.lang.reflect.Method;

public class Lever_30_Test_Not_Depandencies extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private SearchPageObject searchPage;


    @Parameters("browser")
    @BeforeMethod
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);

        searchPage = homePage.clickToSearchIcon();

        //Sử dụng before method đẻ khởi tạo cho từng testcase

    }

    @Test
    public void SearchWithEmptyData() {

    }
    @Test
    public void SearchByProductNameNotExist() {
    }

    @Test
    public void SearchWithContainProductName() {

    }


    @AfterMethod
    public void afterClass() {
        closeWindow();
    }



}
