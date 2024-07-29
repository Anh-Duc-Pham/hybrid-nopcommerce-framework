package com.jquery.upload;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;

import java.util.ArrayList;
import java.util.List;

public class Lever_13_Upload_Multiple_File extends BaseTest {
    private WebDriver driver;


    @Parameters({"browser", "pageUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String pageUrl) {
        driver = getBrowserDriver(browserName, pageUrl);


    }


    public void User_01_() {


    }


    public void User_02_() {


    }

    public void User_03_() {

    }

    public void User_04_() {

    }


    public void User_05_() {
    }

    @Test
    public void User_06_() {


    }

    @AfterClass
    public void afterClass() {
        //closeWindow();
    }



}
