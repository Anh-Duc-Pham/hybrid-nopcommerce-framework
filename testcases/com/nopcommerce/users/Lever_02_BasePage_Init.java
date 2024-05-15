package com.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Lever_02_BasePage_Init {
    private WebDriver driver;
    //Vi phạm nguyên tắc không khởi tạo trực tiếp trên class test
    //Nên che giấu/ ẩn giấu nó điLever_02_BasePage_Init
    private BasePage basePage = new BasePage() ;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @Test
    public void TC_01_Register_Empty_Data() {
        basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
        basePage.clickToElement(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"),"First name is required.");
        Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"),"Last name is required.");
        Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"),"Email is required.");
        Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),"Password is required.");

    }

    @Test
    public void TC_02_Invalid_Email() {
        basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.sendKeyToElement(driver,"//input[@id='FirstName']","Eden");
        basePage.sendKeyToElement(driver,"//input[@id='LastName']","Hazard");
        basePage.sendKeyToElement(driver,"//input[@id='Email']","EdenHazard@123");
        basePage.sendKeyToElement(driver,"//input[@id='Password']","123456");
        basePage.sendKeyToElement(driver,"//input[@id='ConfirmPassword']","123456");

        basePage.clickToElement(driver, "//button[@id='register-button']");
        Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"),"Wrong email");

    }

    @Test
    public void TC_03_Invalid_Password() {
        basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.sendKeyToElement(driver,"//input[@id='FirstName']","Eden");
        basePage.sendKeyToElement(driver,"//input[@id='LastName']","Hazard");
        basePage.sendKeyToElement(driver,"//input[@id='Email']","EdenHazard@gmail.com");
        basePage.sendKeyToElement(driver,"//input[@id='Password']","123");
        basePage.sendKeyToElement(driver,"//input[@id='ConfirmPassword']","123");

        basePage.clickToElement(driver, "//button[@id='register-button']");
        Assert.assertEquals(basePage.getElementText(driver, "//span[@class='field-validation-error']"),
                "<p>Password must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");

    }

    @Test
    public void TC_04_Incorrect_Confirm_Password() {
        basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.sendKeyToElement(driver,"//input[@id='FirstName']","Eden");
        basePage.sendKeyToElement(driver,"//input[@id='LastName']","Hazard");
        basePage.sendKeyToElement(driver,"//input[@id='Email']","EdenHazard@gmail.com");
        basePage.sendKeyToElement(driver,"//input[@id='Password']","123456");
        basePage.sendKeyToElement(driver,"//input[@id='ConfirmPassword']","654321");

        basePage.clickToElement(driver, "//button[@id='register-button']");
        Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),"The password and confirmation password do not match.");
    }

    @Test
    public void TC_05_Success() {
        basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.sendKeyToElement(driver,"//input[@id='FirstName']","Eden");
        basePage.sendKeyToElement(driver,"//input[@id='LastName']","Hazard");
        basePage.sendKeyToElement(driver,"//input[@id='Email']",getRandomEmail());
        basePage.sendKeyToElement(driver,"//input[@id='Password']","123456");
        basePage.sendKeyToElement(driver,"//input[@id='ConfirmPassword']","123456");

        basePage.clickToElement(driver, "//button[@id='register-button']");
        Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"),"Your registration completed");

    }


    @AfterClass
    public void afterClass() {
        driver.close();
    }

    public String getRandomEmail() {
        Random emailNumber = new Random();
        return "edenhazard" + emailNumber.nextInt(9999) + "@gmail.com";
    }

}
