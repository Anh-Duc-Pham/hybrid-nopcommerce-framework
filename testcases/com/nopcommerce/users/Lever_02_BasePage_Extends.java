package com.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Lever_02_BasePage_Extends extends BasePage {
    private WebDriver driver;
    //Vi phạm nguyên tắc không khởi tạo trực tiếp trên class test
    //Nên che giấu/ ẩn giấu nó điLever_02_BasePage_Init


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @Test
    public void TC_01_Register_Empty_Data() {
        openPageUrl(driver, "https://demo.nopcommerce.com/");
        clickToElement(driver, "//a[@class='ico-register']");
        clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"),"First name is required.");
        Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"),"Last name is required.");
        Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"),"Email is required.");
        Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"),"Password is required.");

    }

    @Test
    public void TC_02_Invalid_Email() {
        openPageUrl(driver, "https://demo.nopcommerce.com/");
        clickToElement(driver, "//a[@class='ico-register']");

        sendKeyToElement(driver,"//input[@id='FirstName']","Eden");
        sendKeyToElement(driver,"//input[@id='LastName']","Hazard");
        sendKeyToElement(driver,"//input[@id='Email']","EdenHazard@123");
        sendKeyToElement(driver,"//input[@id='Password']","123456");
        sendKeyToElement(driver,"//input[@id='ConfirmPassword']","123456");

        clickToElement(driver, "//button[@id='register-button']");
        Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"),"Wrong email");

    }

    @Test
    public void TC_03_Invalid_Password() {
        openPageUrl(driver, "https://demo.nopcommerce.com/");
        clickToElement(driver, "//a[@class='ico-register']");

        sendKeyToElement(driver,"//input[@id='FirstName']","Eden");
        sendKeyToElement(driver,"//input[@id='LastName']","Hazard");
        sendKeyToElement(driver,"//input[@id='Email']","EdenHazard@gmail.com");
        sendKeyToElement(driver,"//input[@id='Password']","123");
        sendKeyToElement(driver,"//input[@id='ConfirmPassword']","123");

        clickToElement(driver, "//button[@id='register-button']");
        Assert.assertEquals(getElementText(driver, "//span[@class='field-validation-error']"),
                "<p>Password must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");

    }

    @Test
    public void TC_04_Incorrect_Confirm_Password() {
        openPageUrl(driver, "https://demo.nopcommerce.com/");
        clickToElement(driver, "//a[@class='ico-register']");

        sendKeyToElement(driver,"//input[@id='FirstName']","Eden");
        sendKeyToElement(driver,"//input[@id='LastName']","Hazard");
        sendKeyToElement(driver,"//input[@id='Email']","EdenHazard@gmail.com");
        sendKeyToElement(driver,"//input[@id='Password']","123456");
        sendKeyToElement(driver,"//input[@id='ConfirmPassword']","654321");

        clickToElement(driver, "//button[@id='register-button']");
        Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"),"The password and confirmation password do not match.");
    }

    @Test
    public void TC_05_Success() {
        openPageUrl(driver, "https://demo.nopcommerce.com/");
        clickToElement(driver, "//a[@class='ico-register']");

        sendKeyToElement(driver,"//input[@id='FirstName']","Eden");
        sendKeyToElement(driver,"//input[@id='LastName']","Hazard");
        sendKeyToElement(driver,"//input[@id='Email']",getRandomEmail());
        sendKeyToElement(driver,"//input[@id='Password']","123456");
        sendKeyToElement(driver,"//input[@id='ConfirmPassword']","123456");

        clickToElement(driver, "//button[@id='register-button']");
        Assert.assertEquals(getElementText(driver, "//div[@class='result']"),"Your registration completed");

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
