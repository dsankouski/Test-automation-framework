package pageobjects.google;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.Driver;
import driver.DriverContainer;

public class SearchHomeGoogle
{
    @FindBy(xpath = "//input[@id='lst-ib']")
    private WebElement searchInputField;

    @FindBy(xpath = "//input[@type='submit' and @name='btnK']")
    private WebElement searchSubmitButton;

    @FindBy(xpath = "//cite")
    private List<WebElement> siteLinkList;

    public SearchHomeGoogle()
    {
        DriverContainer.init();
        Driver driver = DriverContainer.getDriver();
        driver.get("http://www.google.com");
        PageFactory.initElements(driver, this);
    }

    public SearchHomeGoogle fillInputField(String input)
    {
        searchInputField.click();
        searchInputField.clear();
        searchInputField.sendKeys(input);
        return this;
    }

    public SearchHomeGoogle submit()
    {
        searchSubmitButton.click();
        return this;
    }

    public List<String> getSitesFound()
    {
        List sites = new ArrayList();
        for (WebElement siteLink : siteLinkList)
        {
            sites.add(siteLink.getText());
        }

        return sites;
    }
}
