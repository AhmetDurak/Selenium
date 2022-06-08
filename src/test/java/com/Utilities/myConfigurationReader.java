package com.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class myConfigurationReader {
    private static Properties properties;

    static {
        try {
            String path = "myConfig.properties";

            FileInputStream file = new FileInputStream(path);

            properties = new Properties();

            properties.load(file);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String keyName){
        return properties.getProperty(keyName);
    }
}
