package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by Dzmitry_Sankouski
 */
public class BaseTest {

    @BeforeClass
    public static void initDriver() {
//        Guice.createInjector(new driver.DriverModule());

//        DriverContainer.init();
    }

    @AfterClass
    public void closeResources() {

    }

}
