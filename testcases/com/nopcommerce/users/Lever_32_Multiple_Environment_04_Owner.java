package com.nopcommerce.users;

import commons.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.EnvironmentConfig;

public class Lever_32_Multiple_Environment_04_Owner extends BaseTest {
    private WebDriver driver;
    private EnvironmentConfig environmentConfig;


    @Parameters({"browser", "server"})
    @BeforeClass
    public void beforeClass(String browserName, String serverName) {
        ConfigFactory.setProperty("server", serverName);
        environmentConfig = ConfigFactory.create(EnvironmentConfig.class);
        System.out.println(environmentConfig.appUrl());
        System.out.println(environmentConfig.appUserName());
        System.out.println(environmentConfig.appPassword());
        System.out.println(environmentConfig.dbUrl());

        driver = getBrowserDriver(browserName, environmentConfig.appUrl());
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
