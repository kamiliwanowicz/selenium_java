package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CommonMethods;
import pages.GymsharkPage;
import resources.base;

public class gymSharkSteps extends base {

    private World world;

    public gymSharkSteps(World world) {
        this.world = world;
    }
    WebDriver driver;
    CommonMethods common;
    GymsharkPage gp;

    String url = "https://uk.shop.gymshark.com/";

    @Before
    public void initialization() {
        driver = initializeDriver();
        common = new CommonMethods(driver);
        gp = new GymsharkPage(driver);
    }

    @After
    public void teardown() {

        driver.close();
    }


    @Given("I go to {string} New Releases")
    public void iGoToNewReleases(String cat) throws InterruptedException {
        GymsharkPage gp = new GymsharkPage(driver);
        driver.get(url);
        gp.acceptCookies();
        gp.getCategory(cat);
    }

    @And("I select a random item")
    public void iSelectARandomItem() {
        world.randomItemDetails = gp.selectRandomItem();
    }

    @And("I verify details on Product page")
    public void iVerifyDetailsOnProductPage() {
        gp.verifyDetailsOnProductPage(world.randomItemDetails);
    }

    @And("I select a random size")
    public void iSelectARandomSize() {
        world.randSize = gp.selectRandomSize();
    }

    @When("I add the item to the basket")
    public void iAddTheItemToTheBasket() {
        gp.addToBag();
    }

    @Then("I verify item has been added successfully to Summary page")
    public void iVerifyItemHasBeenAddedSuccessfullyToSummaryPage() throws InterruptedException {
        gp.verifyDetailsOnSummaryPage(world.randomItemDetails, world.randSize);
    }

    @And("I close the summary")
    public void iCloseTheSummary() {
        gp.closeSummary();
    }

    @And("I expect the basket icon to display number {string}")
    public void iExpectTheBasketIconToDisplayNumber(String str1) {
        gp.verifyNumberOfItemsInBasket(str1);
    }

    @And("I click on basket icon")
    public void iClickOnBasketIcon() throws InterruptedException {
        gp.clickOnBasket();
    }

    @And("I verify values on Full Bag page")
    public void iVerifyValuesOnFullBagPage() {
        gp.verifyValuesOnFullBagPage(world.randomItemDetails, world.randSize);
    }

    @And("I verify values on Checkout page")
    public void iVerifyValuesOnCheckoutPage() {
        gp.verifyValuesOnCheckoutPage(world.randomItemDetails, world.randSize);
    }
}

