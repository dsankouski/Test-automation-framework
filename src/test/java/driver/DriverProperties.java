package driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DriverProperties {
    private static Properties prop;

    static {
        prop = new Properties();

        if (!isDriverPropertiesLoaded()){
            loadPropertiesFromSystem();
        }
        if (!isDriverPropertiesLoaded()){
            loadPropertiesFromFile();
        }
        if (!isDriverPropertiesLoaded()){
            loadDefaultProperties();
        }
    }

    private static void loadPropertiesFromSystem() {
        try {
            prop.setProperty("browser", System.getProperty("browser"));
            prop.setProperty("driverExecutablePath", System.getProperty("driverExecutablePath"));
            prop.setProperty("implicitTimeout", System.getProperty("implicitTimeout"));
        } catch (NullPointerException e) {
            System.out.println("There is no properties in System class");
        }
    }

    private static void loadPropertiesFromFile() {
        // reading config file
        InputStream input = null;
        try {
            input = new FileInputStream("src/test/resources/driver_settings.properties");
            // load a properties file
            prop.load(input);
        } catch (FileNotFoundException e) {
            System.out.println("web driver config not found");
        } catch (IOException ex) {
            System.out.println("error while reading web driver config");
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void loadDefaultProperties() {
        prop.setProperty("browser", "firefox");
        prop.setProperty("browser", "src/test/resources/geckodriver.exe");
        System.out.println("default properties was loaded");
    }

    private static boolean isDriverPropertiesLoaded() {
        return isNoEmptyEntries(
                getDriverExecutablePath(),
                getBrowserType(),
                prop.getProperty("implicitTimeout")
        );
    }

    private static boolean isNoEmptyEntries(String... entries) {
        for (String entry :
                entries) {
            if (entry == null || entry.isEmpty()) {
                return false;
            }
        }
        return true;
    }


    public static String getDriverExecutablePath() {
        return prop.getProperty("driverExecutablePath");
    }

    public static String getBrowserType() {
        return prop.getProperty("browser");
    }

    public static int implicitTimeout() {
        return Integer.parseInt(prop.getProperty("implicitTimeout"));
    }
}