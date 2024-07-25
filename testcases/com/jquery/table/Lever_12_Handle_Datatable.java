package com.jquery.table;

import commons.BaseTest;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
        homePage.inputToSearchTextbox("Females", "283821");

        homePage.inputToSearchTextbox("Country", "Albania");

        homePage.inputToSearchTextbox("Males", "60681000");

        homePage.inputToSearchTextbox("Total", "687522");
        homePage.pressKeyToKeyboard(Keys.ENTER);

    }

    @Test
    public void User_02_Click_Page_Number() {
        homePage.clickToPageByNumber("6");
        homePage.clickToPageByNumber("7");
        Assert.assertTrue(homePage.isPageNumberActive("7"));

    }
    @Test
    public void User_03_Row_Value_Displayed() {
        Assert.assertTrue(homePage.isRowValueDisplayed("351445","Caribbean","363661","715106"));

    }
    @AfterClass
    public void afterClass() {
        closeWindow();
    }



}
