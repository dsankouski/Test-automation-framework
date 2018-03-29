import org.testng.annotations.Test
import org.testng.asserts.SoftAssert
import pageobjects.google.SearchHomeGooglePage
import test.BaseTest
/**
 * Created by Dzmitry_Sankouski
 */
@Test(groups=["Regression", "lsdfa"])
class GoogleSearchTest extends BaseTest{

    void main() {
        SoftAssert softAssert = new SoftAssert()
        SearchHomeGooglePage homeGoogle = new SearchHomeGooglePage()

        homeGoogle.fillInputField("tut")
        homeGoogle.submit()

        softAssert.assertFalse(!homeGoogle.getSitesFound().findAll({ it.contains("tut.by") }).isEmpty(),
                "No google search results by the query 'tut'")

        homeGoogle.dispose()
        softAssert.assertAll()
        softAssertions.assertAll()
    }

}
