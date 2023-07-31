package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CommonMethods;
import pages.GymsharkPage;
import resources.base;

public class gymSharkSteps extends base {
    WebDriver driver;
    CommonMethods common;

    String url = "https://uk.shop.gymshark.com/";

    @Before
    public void initialization() {
        driver = initializeDriver();
        common = new CommonMethods(driver);

    }


    @After
    public void teardown() {
        driver.close();
    }

    @Given("Run some methods {string}")
    public void runSomeMethods(String str1) throws InterruptedException {
        GymsharkPage gp = new GymsharkPage(driver);
        driver.get(url);
        gp.acceptCookies();
        gp.getMensReleases();
        String[] randomItem = gp.selectRandomItem();
        gp.verifyDetailsOnProductPage(randomItem);
        String randSize = gp.selectRandomSize();
        gp.addToBag();
        gp.verifyDetailsOnSummaryPage(randomItem, randSize);
        System.out.println("ok");
    }

    @Given("I go to {string} New Releases")
    public void iGoToNewReleases(String arg0) {
    }
}

