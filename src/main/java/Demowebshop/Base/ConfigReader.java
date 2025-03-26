package Demowebshop.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties props;

    static {
        try {
            FileInputStream file = new FileInputStream("src\\test\\resources\\config.properties");
            props = new Properties();
            props.load(file);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        return props.getProperty(key);
    }
}

