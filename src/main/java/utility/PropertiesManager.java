package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

public class PropertiesManager {

    public static String filePath = "src/main/resources/settings.properties";

    public static Properties loadPropertiesIntoSystem() throws IOException {
        Properties properties = new Properties();
        FileInputStream input = new FileInputStream(filePath);
        properties.load(input);
        System.getProperties().putAll(properties);
        return properties;
    }

    public static String getPropertiesValue(String key){
        return System.getProperty(key);
    }
}
