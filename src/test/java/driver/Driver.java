package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Driver implements WebDriver {
    private WebDriver driver = null;

    Driver() {
        String type = DriverProperties.getBrowserType().toUpperCase();
        if (driver == null) {
            switch (DriverType.valueOf(type)) {
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", DriverProperties.getDriverExecutablePath());
                    driver = new FirefoxDriver();
                    break;

                case CHROME:
                    System.setProperty("webdriver.chrome.driver", DriverProperties.getDriverExecutablePath());
                    driver = new ChromeDriver();
                    break;

                default:
                    System.setProperty("webdriver.gecko.driver", DriverProperties.getDriverExecutablePath());
                    driver = new FirefoxDriver();
                    break;
            }

            int timeout = DriverProperties.implicitTimeout();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        }
    }

    public void get(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public void close() {
        driver.close();
    }

    public void quit() {
        driver.quit();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public WebDriver.TargetLocator switchTo() {
        return driver.switchTo();
    }

    public WebDriver.Navigation navigate() {
        return driver.navigate();
    }

    public WebDriver.Options manage() {
        return driver.manage();
    }
}
