package com.jquery.table;

import commons.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;

import java.util.ArrayList;
import java.util.List;

public class Lever_12_Handle_Datatable extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    List<String> allValuesUI = new ArrayList<String>();


    @Parameters({"browser", "pageUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String pageUrl) {
        driver = getBrowserDriver(browserName, pageUrl);
        homePage = PageGeneratorManager.getHomePage(driver);


    }


    public void User_01_() {
        homePage.inputToSearchTextbox("Females", "283821");

        homePage.inputToSearchTextbox("Country", "Albania");

        homePage.inputToSearchTextbox("Males", "60681000");

        homePage.inputToSearchTextbox("Total", "687522");
        homePage.pressKeyToKeyboard(Keys.ENTER);

    }


    public void User_02_Click_Page_Number() {
        homePage.clickToPageByNumber("6");
        homePage.clickToPageByNumber("7");
        Assert.assertTrue(homePage.isPageNumberActive("7"));

    }

    public void User_03_Row_Value_Displayed() {
        Assert.assertTrue(homePage.isRowValueDisplayed("95905","Dominican Republic","97641","193547"));

    }

    public void User_04_Action_By_Row() {
        homePage.refreshPage(driver);
        homePage.clickToActionButton("Afghanistan", "remove");

        homePage.refreshPage(driver);
        homePage.clickToActionButton("Algeria", "edit");

    }


    public void User_05_Get_All_Value() {
        homePage.refreshPage(driver);
        allValuesUI = homePage.getAllPageValueByColumnName("Country");
        //
    }

    @Test
    public void User_06_Edit_Table() {
        homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
        homePage.inputToTxtByNameAndRow("Contact Person","2", "Eden Hazard");
        homePage.inputToTxtByNameAndRow("Company","1", "Chelsea");

        homePage.selectItemByNameAndRow("Country", "2", "Japan");
        homePage.selectItemByNameAndRow("Country", "3", "Malaysia");

        homePage.clickToCheckBoxByNameAndRow("NPO?", "1");


    }

    @AfterClass
    public void afterClass() {
        //closeWindow();
    }



}
