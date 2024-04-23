package org.example.dbconnecrion;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DbPropertiesLoader {
    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {
        try (InputStream inputStream = DbPropertiesLoader.
                class.getClassLoader().getResourceAsStream("dbProperties.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String propertyKey) {
        return PROPERTIES.getProperty(propertyKey);
    }


}
