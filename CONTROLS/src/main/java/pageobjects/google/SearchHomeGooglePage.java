package pageobjects.google;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchHomeGooglePage extends BasePage
{
    @FindBy(xpath = "//input[@id='lst-ib']")
    private WebElement searchInputField;

    @FindBy(xpath = "//input[@type='submit' and @name='btnK']")
    private WebElement searchSubmitButton;

    @FindBy(xpath = "//cite")
    private List<WebElement> siteLinkList;

    public SearchHomeGooglePage()
    {
        driver.get("http://www.google.com");
        PageFactory.initElements(driver, this);
    }

    public SearchHomeGooglePage fillInputField(String input)
    {
        searchInputField.click();
        searchInputField.clear();
        searchInputField.sendKeys(input);
        return this;
    }

    public SearchHomeGooglePage submit()
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

    public void dispose() {
//        driver.close();
        driver.quit();
    }
}
