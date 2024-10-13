package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.PropertiesConfig;

public class Lever_32_Multiple_Environment_03_Java_Properties extends BaseTest {
    private WebDriver driver;
    private PropertiesConfig propertiesConfig;


    @Parameters({"browser", "server"})
    @BeforeClass
    public void beforeClass(String browserName, String serverName) {
        propertiesConfig = PropertiesConfig.getProperties(serverName);
        System.out.println(propertiesConfig.getApplicationUserName());
        System.out.println(propertiesConfig.getApplicationPassword());
        driver = getBrowserDriver(browserName, propertiesConfig.getApplicationUrl());
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
