package com.jquery.upload;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.UploadPageObject;

public class Lever_13_Upload_Multiple_File extends BaseTest {
    private WebDriver driver;
    private UploadPageObject uploadPage;
    private String hanoiCity = "Ha Noi.jpg";
    private String danangCity = "Da Nang.jpg";
    private String haGiangCity = "Ha Giang.jpg";
    private String[] citys = {"Ha Noi.jpg","Da Nang.jpg","Ha Giang.jpg" };

    @Parameters({"browser", "pageUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String pageUrl) {
        driver = getBrowserDriver(browserName, pageUrl);
        uploadPage = new UploadPageObject(driver);

    }


    public void User_01_Upload_Single_File() {
        uploadPage.uploadMultipleFiles(driver, hanoiCity);
        uploadPage.uploadMultipleFiles(driver, danangCity);
        uploadPage.uploadMultipleFiles(driver, haGiangCity);
        uploadPage.sleepInSecond(1);

        Assert.assertTrue(uploadPage.isFileLoaded(hanoiCity));
        Assert.assertTrue(uploadPage.isFileLoaded(danangCity));
        Assert.assertTrue(uploadPage.isFileLoaded(haGiangCity));

        uploadPage.clickToStartUploadButtonOnEachFile();

        Assert.assertTrue(uploadPage.isUploadFileAppeer(hanoiCity));
        Assert.assertTrue(uploadPage.isUploadFileAppeer(danangCity));
        Assert.assertTrue(uploadPage.isUploadFileAppeer(haGiangCity));



    }

    @Test
    public void User_02_Upload_Multiple_Files() {
        uploadPage.uploadMultipleFiles(driver, citys);
        Assert.assertTrue(uploadPage.isFileLoaded(hanoiCity));
        Assert.assertTrue(uploadPage.isFileLoaded(danangCity));
        Assert.assertTrue(uploadPage.isFileLoaded(haGiangCity));

        uploadPage.clickToStartUploadButtonOnEachFile();

        Assert.assertTrue(uploadPage.isUploadFileAppeer(hanoiCity));
        Assert.assertTrue(uploadPage.isUploadFileAppeer(danangCity));
        Assert.assertTrue(uploadPage.isUploadFileAppeer(haGiangCity));


    }


    @Test
    public void User_06_() {


    }

    @AfterClass
    public void afterClass() {
        closeWindow();
    }


}
