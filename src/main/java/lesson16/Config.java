package lesson16;

import lombok.SneakyThrows;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private Config() {
    }

    private static Properties PROPERTIES = null;

    @SneakyThrows
    public static Properties getProperties() {
        if (PROPERTIES == null) {
            PROPERTIES = new Properties();
            final ClassLoader loader = Thread.currentThread().getContextClassLoader();
            final InputStream stream = loader.getResourceAsStream("config.properties");
            PROPERTIES.load(stream);
        }
        return PROPERTIES;
    }
}
