package pageobjects.jetblue;

import bean.SearchData;
import driver.Driver;
import driver.DriverContainer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home
{

    @FindBy(xpath = "//input[@id='jbBookerDepart']")
    private WebElement departureInputField;

    @FindBy(xpath = "//input[@id='jbBookerArrive']")
    private WebElement arriveInputField;

    @FindBy(xpath = "//input[@id='jbBookerCalendarDepart']")
    private WebElement departureDateInputField;

    @FindBy(xpath = "//input[@id='jbBookerCalendarReturn']")
    private WebElement returnDateInputField;

    @FindBy(xpath = "//input[@class='piejs' and @type='submit']")
    private WebElement searchSubmitButton;

    public Home()
    {
        Driver driver = DriverContainer.getDriver();
        driver.get("https://www.jetblue.com/");
        PageFactory.initElements(driver, this);
    }

    public Home fillDeparture(String city)
    {
        departureInputField.click();
        departureInputField.clear();
        departureInputField.sendKeys(city);
        return this;
    }

    public Home fillArrive(String city)
    {
        arriveInputField.click();
        arriveInputField.clear();
        arriveInputField.sendKeys(city);
        return this;
    }

    public Home fillDepartureDate(String date)
    {
        departureDateInputField.click();
        departureDateInputField.clear();
        departureDateInputField.sendKeys(date);
        return this;
    }

    public Home fillReturnDate(String date)
    {
        returnDateInputField.click();
        returnDateInputField.clear();
        returnDateInputField.sendKeys(date);
        return this;
    }

    public Home fillAll(String departureCity, String arriveCity, String departureDate, String returnDate)
    {
        return this.fillDeparture(departureCity).fillArrive(arriveCity).fillDepartureDate(departureDate)
                .fillReturnDate(returnDate);
    }

    public Home fillAll(SearchData data)
    {
        return fillAll(
                data.getOriginCity(),
                data.getDestinationCity(),
                data.getDepartureDate(),
                data.getReturnDate()
                );
    }

    public Flights submit()
    {
        searchSubmitButton.click();
        return new Flights();
    }
}
