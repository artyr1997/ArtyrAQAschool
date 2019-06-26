package rozetca.objects;

import org.testng.ReporterConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
    private static Properties prop = new Properties();

    static {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream resuorceStream = loader.getResourceAsStream("data.properties")) {
            prop.load(resuorceStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String loadProperty (String propertyName) {
        String property = prop.getProperty(propertyName);
        return (property==null) ? "": property;
    }
}
