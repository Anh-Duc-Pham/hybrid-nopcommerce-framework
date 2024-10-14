package com.saucelab;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.saucelab.LoginPageObject;
import pageObjects.saucelab.PageGeneratorManager;
import pageObjects.saucelab.ProductPageObject;
import reportConfigs.ExtentTestManager;

import java.lang.reflect.Method;

public class Lever_30_Sort_Data extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPage;
    private ProductPageObject productPage;

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        loginPage = PageGeneratorManager.getLoginPageObject(driver);
        loginPage.enterToUserTxt("standard_user");
        loginPage.enterToPassword("secret_sauce");
        productPage = loginPage.clickToLoginBtn();
    }

    @Test
    public void User_01_Sort_String(Method method) {
        ExtentTestManager.startTest(method.getName(), "Sort String");
        productPage.selectSortFilerByName("Name (A to Z)");
        Assert.assertTrue(productPage.isProductNameSortAscending());

        productPage.selectSortFilerByName("Name (Z to A)");
        Assert.assertTrue(productPage.isProductNameSortDescending());
    }

    @Test
    public void User_02_Sort_Number(Method method) {
        ExtentTestManager.startTest(method.getName(), "Sort Number");
        productPage.selectSortFilerByName("Price (low to high)");
        Assert.assertTrue(productPage.isProductPriceSortAscending());

        productPage.selectSortFilerByName("Price (high to low)");
        Assert.assertTrue(productPage.isProductPriceSortDescending());

    }

    @AfterClass
    public void afterClass() {
        closeWindow();
    }


}
