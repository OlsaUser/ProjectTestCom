package com.ProjectTestCom.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertyLoader {
    private static Properties properties = new Properties();
    private static BufferedReader propertyFile;


    public static String getProperty(String propertyFilePath, String index) {
        try {
            propertyFile = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(propertyFilePath), "UTF8"));
            properties.load(propertyFile);

            return properties.getProperty(index);
        }
        catch (IOException e) {
            return e.getMessage();
        }
    }
}
