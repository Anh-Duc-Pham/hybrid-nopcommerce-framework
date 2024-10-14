package javaBasic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Topic_10_Properties {
    public static void main(String[] args) {
        String environmentPath = System.getProperty("user.dir") + File.separator + "environmentConfig" + File.separator;

        try (InputStream input = new FileInputStream(environmentPath  + "dev.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("App.Url"));
            System.out.println(prop.getProperty("App.User"));
            System.out.println(prop.getProperty("App.Pass"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}
