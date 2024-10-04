package com.eclipTips.admin;

import jsonData.nopcommerce.UserInfoData;
import org.testng.annotations.Test;

public class Topic_01_Rest_Parameter {
    String orderLink = "a[text()='Order']";
    String sidebarLink = "a[text()='%s']";
    UserInfoData userInfoData;


    @Test
    public void TC_01() {
        clickToElement(orderLink);
        clickToElement(sidebarLink, "address");
        clickToElement(sidebarLink, "homePage");
    }
    public void clickToElement(String locator) {
        System.out.println("click to " + locator);
    }
    public void clickToElement(String locator, String pageName) {
        locator = String.format(locator, pageName);
        System.out.println("click to " + locator );
    }

    //Var Arguments = Rest Parameter
    //Với những hàng giống nhau, chỉ khác nhau về số lượng tham số

    //Hàm click vào 1 element ko cố định (dynamic) vs bất kỳ 1 tham số (1-n tham số)
    public void clickToElement(String locator, String... values) { //Mảng String[]
        locator = String.format(locator,(Object[]) values); //String.format(String, Object
        System.out.println("click to" + locator);

    }



}
