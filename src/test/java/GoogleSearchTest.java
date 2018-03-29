import org.junit.Test;
import org.testng.Assert;
import pageobjects.google.SearchHomeGoogle;

import java.util.stream.Collectors;

/**
 * Created by Dzmitry_Sankouski
 */
public class GoogleSearchTest {

    @Test
    public static void main(String[] args) {
        SearchHomeGoogle homeGoogle = new SearchHomeGoogle();

        homeGoogle.fillInputField("tut");
        homeGoogle.submit();

        Assert.assertFalse(!homeGoogle.getSitesFound().stream().filter(s -> s.contains("tut.by")).collect(Collectors.toList()).isEmpty());
    }
}
