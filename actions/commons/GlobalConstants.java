package commons;

import java.io.File;

public class GlobalConstants {
    //Server Url: Dev/ Testing/ Staging/ Product
    //Database: Dev/ Testing/ Staging/ Product
    //Timeout: Short/ Long
    //Username/ Pass
    //Third Party: Sandbox paypal
    //Download / Upload Folder
    //Relative Project Path
    //OS Name
    //Cloud Testing:Browserstack/ Saucelab/ CrossbrowserTesting (Access Token/ ID)
    public static final String DEV_USER_URL = "https://demo.nopcommerce.com/";
    public static final String DEV_ADMIN_URL = "https://admin-demo.nopcommerce.com/";
    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 15;
    public static final String DEV_ADMIN_USERNAME = "admin@yourstore.com";
    public static final String DEV_ADMIN_PASSWORD = "admin";
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String RELATIVE_PROJECT_PATH = System.getProperty("user.dir");
    public static final String UPLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
    public static final String DOWNLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "downloadFiles" + File.separator ;
    public static final String REPORTING_IMAGE_PATH = RELATIVE_PROJECT_PATH + File.separator + "reportNGImage" + File.separator ;
    public static final String BROWSER_LOGS = RELATIVE_PROJECT_PATH + File.separator + "browserLogs" + File.separator ;
    public static final String RESOURCE_PATH = RELATIVE_PROJECT_PATH + File.separator + "resources" + File.separator ;
    public static final String DATA_PATH = RELATIVE_PROJECT_PATH + File.separator + "dataTest" + File.separator ;


    public static final String JAVA_VERSION = System.getProperty("java.version");


}
