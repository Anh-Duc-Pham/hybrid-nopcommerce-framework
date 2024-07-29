package pageUIs.jQuery;

public class HomePageUI {
    public static final String COLUMN_TEXTBOX_BY_NAME = "xpath=//div[text()='%s']//parent::div//following-sibling::input";
    public static final String PAGE_LINK_BY_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link' and text()='%s']";
    public static final String PAGE_LINK_ACTIVE_BY_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
    public static final String DYNAMIC_ROW_VALUE ="xpath=//td[@data-key='females' and text() ='%s']//following-sibling::td[@data-key='country' and text() ='%s']//following-sibling::td[@data-key='males' and text() ='%s']//following-sibling::td[@data-key='total' and text() ='%s']";
    public static final String ACTION_BY_COUNTRY_NAME = "xpath=//td[@data-key='country' and text() ='%s']//preceding-sibling::td[@class='qgrd-actions']//button[@class='qgrd-%s-row-btn']";

    public static final String ALL_PAGE_LINK = "xpath=//a[contains(@class,'qgrd-pagination-page-link')]";
    public static final String COLUMN_INDEX_BY_COLUMN_NAME ="xpath=//div[text()='%s']//ancestor::th//preceding-sibling::th";
    public static final String ALL_VALUE_BY_COLUMN_INDEX= "xpath=//tr/td[%s]";

    public static final String DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME = "xpath=//th[text()='%s']//preceding-sibling::th";
    public static final String DYNAMIC_TEXTBOX_BY_COLUMN_AND_ROW = "xpath=//tr[%s]//td[%s]//input[@type='text']";
    public static final String DYNAMIC_SELECT_BOX_BY_COLUMN_AND_ROW = "xpath=//tr[%s]//td[%s]//select";
    public static final String DYNAMIC_CHECK_BOX_BY_COLUMN_AND_ROW = "xpath=//tr[%s]//td[%s]//input[@type='checkbox']";

}
