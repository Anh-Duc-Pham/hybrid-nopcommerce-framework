package pageUIs.jQuery;

public class HomePageUI {
    public static String COLUMN_TEXTBOX_BY_NAME = "xpath=//div[text()='%s']//parent::div//following-sibling::input";
    public static String PAGE_LINK_BY_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link' and text()='%s']";
    public static String PAGE_LINK_ACTIVE_BY_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
    public static String DYNAMIC_ROW_VALUE ="xpath=//td[@data-key='females' and text() ='%s']//following-sibling::td[@data-key='country' and text() ='%s']//following-sibling::td[@data-key='males' and text() ='%s']//following-sibling::td[@data-key='total' and text() ='%s']";

}
