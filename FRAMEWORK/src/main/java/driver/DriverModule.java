package driver;

import com.google.inject.AbstractModule;
import org.openqa.selenium.WebDriver;

/**
 * Created by Dzmitry_Sankouski
 */
public class DriverModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(WebDriver.class).to(Driver.class);
    }
}
