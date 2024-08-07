package pageUIs.nopCommerce.user;

public class BaseElementUI {
    public static final String NOP_COMMERCE_LOGO = "xpath=//img[@alt='nopCommerce demo store']";//6 locator header (truoc/ sau khi login)
    public static final String DYNAMIC_HEADER_LINK_BY_NAME = "xpath=//div[@class='header-links']//a[contains(string(),'%s')]";
    public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
    public static final String DYNAMIC_TEXTBOX_ERROR_MSG_BY_ID = "xpath=//span[@id='%s-error']";;
    public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";


}
