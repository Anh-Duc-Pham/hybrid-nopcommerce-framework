package pageObjects.saucelab;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.saucelab.ProductPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductPageObject extends BasePage {
    WebDriver driver;

    public ProductPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectSortFilerByName(String sortOption) {
        waitForElementVisible(driver, ProductPageUI.SORT_DROPDOWN);
        selectItemInDefaultDropdown(driver, ProductPageUI.SORT_DROPDOWN, sortOption);
    }

    public boolean isProductNameSortAscending() {
        List<WebElement> productNameElement = getListWebElements(driver, ProductPageUI.PRODUCT_NAMES);
        ArrayList<String> displayedProductName = new ArrayList<String>();

        for (WebElement element : productNameElement) {
            displayedProductName.add(element.getText());
        }
        logAllStringValue(displayedProductName);

        ArrayList<String> expectedProductName = (ArrayList<String>) displayedProductName.clone();
        Collections.sort(expectedProductName);

        logAllStringValue(expectedProductName);

        return displayedProductName.equals(expectedProductName);
    }

    public boolean isProductNameSortDescending() {
        List<WebElement> productNameElement = getListWebElements(driver, ProductPageUI.PRODUCT_NAMES);
        ArrayList<String> displayedProductName = new ArrayList<String>();

        for (WebElement element : productNameElement) {
            displayedProductName.add(element.getText());
        }
        logAllStringValue(displayedProductName);

        ArrayList<String> expectedProductName = (ArrayList<String>) displayedProductName.clone();
        Collections.sort(expectedProductName);
        Collections.reverse(expectedProductName);

        logAllStringValue(expectedProductName);

        return displayedProductName.equals(expectedProductName);
    }

    public boolean isProductPriceSortAscending() {
        List<WebElement> productPriceElement = getListWebElements(driver, ProductPageUI.PRODUCT_PRICE);
        ArrayList<Float> displayedProductPrice = new ArrayList<Float>();

        for (WebElement element : productPriceElement) {
            displayedProductPrice.add(Float.parseFloat(element.getText().replace("$", "")));
        }
        logAllFloatValue(displayedProductPrice);


        ArrayList<Float> expectedProductPrice = (ArrayList<Float>) displayedProductPrice.clone();
        Collections.sort(expectedProductPrice);

        logAllFloatValue(expectedProductPrice);


        return displayedProductPrice.equals(expectedProductPrice);
    }

    public boolean isProductPriceSortDescending() {
        List<WebElement> productPriceElement = getListWebElements(driver, ProductPageUI.PRODUCT_PRICE);
        ArrayList<Float> displayedProductPrice = new ArrayList<Float>();

        for (WebElement element : productPriceElement) {
            displayedProductPrice.add(Float.parseFloat(element.getText().replace("$", "")));
        }
        logAllFloatValue(displayedProductPrice);
        ArrayList<Float> expectedProductPrice = (ArrayList<Float>) displayedProductPrice.clone();
        Collections.sort(expectedProductPrice);
        Collections.reverse(expectedProductPrice);

        logAllFloatValue(expectedProductPrice);
        return displayedProductPrice.equals(expectedProductPrice);
    }

    public void logAllStringValue(List<String> arrayStringList) {
        System.out.println("===============================");

        for (String string : arrayStringList) {
            System.out.println(string);
        }
        System.out.println("===============================");

    }

    public void logAllFloatValue(List<Float> arrayStringFloat) {
        System.out.println("===============================");

        for (Float number : arrayStringFloat) {
            System.out.println(number);
        }
        System.out.println("===============================");

    }
}
