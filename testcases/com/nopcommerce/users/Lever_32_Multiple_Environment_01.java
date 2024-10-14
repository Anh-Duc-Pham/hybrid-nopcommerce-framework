package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Lever_32_Multiple_Environment_01 extends BaseTest {
    private WebDriver driver;


    @Parameters({"browser", "server"})
    @BeforeClass
    public void beforeClass(String browserName, String serverName) {
        driver = getBrowserEnvironment(browserName, serverName);
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
