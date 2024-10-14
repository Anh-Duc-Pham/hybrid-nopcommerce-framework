package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Lever_32_Multiple_Environment_02 extends BaseTest {
    private WebDriver driver;


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
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


    @AfterClass
    public void afterClass() {
        closeWindow();
    }


}
