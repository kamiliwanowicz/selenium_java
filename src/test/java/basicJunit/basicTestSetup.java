package basicJunit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.GymsharkPage;
import resources.base;

public class basicTestSetup extends base {
    WebDriver driver;
    String url = "https://uk.shop.gymshark.com/";

    @Before
    public void driverSetup() throws Exception {
        driver = initializeDriver();
    }

    @Test
    public void gymSHarkTest() throws Exception {
        GymsharkPage gp = new GymsharkPage(driver);
        driver.get(url);
        gp.acceptCookies();
        gp.getMensReleases();
        String[] randomItem = gp.selectRandomItem();
        gp.verifyDetailsOnProductPage(randomItem);
        String randSize = gp.selectRandomSize();
        gp.addToBag();
        gp.verifyDetailsOnSummaryPage(randomItem, randSize);
    }

    @After
    public void teardown() throws Exception {
        driver.close();

    }
}
