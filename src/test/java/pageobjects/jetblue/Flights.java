package pageobjects.jetblue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.Driver;
import driver.DriverContainer;

public class Flights
{
    @FindBy(xpath = "//form[@id='AirFlightItinerarySelectForm']")
    private WebElement flightsSelectionForm;

    private By departureFlightsTable = By.xpath("//table[@id='AIR_SEARCH_RESULT_CONTEXT_ID0']");
    private By returnFlightsTable = By.xpath("//table[@id='AIR_SEARCH_RESULT_CONTEXT_ID1']");
    private By fareOptions = By.xpath("./thead/tr/td[contains(@class, 'colCost')]");

    public Flights()
    {
        Driver driver = DriverContainer.getDriver();
        PageFactory.initElements(driver, this);
    }

    private List getVisibleFareOptions(WebElement flightsTable)
    {
        List<WebElement> allElements = flightsTable.findElements(fareOptions);
        List<WebElement> visibleElements = new ArrayList<>();
        for (WebElement element : allElements)
        {
            if (element.isDisplayed())
            {// searching for visible fare options
                visibleElements.add(element);
            }
        }
        return visibleElements;
    }

    public List getVisibleDepartureFareOptions()
    {
        return getVisibleFareOptions(flightsSelectionForm.findElement(departureFlightsTable));
    }

    public List getVisibleReturnFareOptions()
    {
        return getVisibleFareOptions(flightsSelectionForm.findElement(returnFlightsTable));
    }
}
