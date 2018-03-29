package pageobjects.google;

import com.google.inject.Guice;
import com.google.inject.Inject;
import driver.DriverModule;
import org.openqa.selenium.WebDriver;

/**
 * Created by Dzmitry_Sankouski
 */
public class BasePage {

    @Inject
    WebDriver driver;

    public BasePage() {
        Guice.createInjector(new DriverModule()).injectMembers(this);
    }

}
