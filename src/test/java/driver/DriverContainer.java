package driver;

public class DriverContainer
{
    private static Driver driver;

    public static void init()
    {
        driver = new Driver();
    }

    public static void destroy()
    {
        driver.quit();
    }

    public static Driver getDriver()
    {
        return driver;
    }
}
