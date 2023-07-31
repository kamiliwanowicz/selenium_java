package pages;

import locators.homePageLocators;
import locators.productPageLocators;
import locators.summaryPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class GymsharkPage {
    WebDriver driver;

    homePageLocators homePage;
    productPageLocators productPage;
    summaryPageLocators summaryPage;
    CommonMethods common;

    public GymsharkPage(WebDriver driver) {
        this.driver = driver;
        common = new CommonMethods(driver);
        homePage = new homePageLocators(driver);
        productPage = new productPageLocators(driver);
        summaryPage = new summaryPageLocators(driver);
    }

    public void getMensReleases() throws InterruptedException {
        homePage.menCSS.click();
        Thread.sleep(2000);
        common.scrollToElement(homePage.desktopNewReleasesXpath);
        common.jsClick(homePage.desktopNewReleasesXpath);
        common.customWaitVisibilityOf(homePage.newReleasesHeaderXpath, 10);
    }

    public String[] selectRandomItem() {
        List<WebElement> allItems = homePage.allItemsList;
        Random random = new Random();
        int randomInt = random.nextInt(1, allItems.size());
        WebElement randomItem = allItems.get(randomInt);
        common.scrollToElement(randomItem);
        String itemName = randomItem.findElement(By.cssSelector("h4[class^='product-card_product-title']")).getText().toLowerCase();
        String itemFit = randomItem.findElement(By.cssSelector("p[class^='product-card_product-fit']")).getText();
        String itemColour = randomItem.findElement(By.cssSelector("p[class^='product-card_product-colour']")).getText();
        String itemPrice = randomItem.findElement(By.cssSelector("span[class^='product-card_product-price']")).getText();
        randomItem.click();
        common.customWaitVisibilityOf(productPage.addToBag, 10);
        return new String[] {itemName, itemFit, itemColour, itemPrice};
    }

    public void verifyDetailsOnProductPage(String[] itemDetails) {
        String itemName = productPage.productName.getText().toLowerCase();
        String itemFit = productPage.productFit.getText();
        String itemColour = productPage.productColour.getText();
        String itemPrice = productPage.productPrice.getText();
        String[] productPageDetails = {itemName, itemFit, itemColour, itemPrice};
        assertArrayEquals(itemDetails, productPageDetails);
    }

    public void verifyDetailsOnSummaryPage(String [] itemDetails, String size) throws InterruptedException {
        common.customWaitVisibilityOf(summaryPage.viewFullBagButton, 10);
        Thread.sleep(2000);
        String itemName = summaryPage.productName.getText().toLowerCase();
        String itemFit = summaryPage.productFit.getText();
        String colourAndPrice = summaryPage.productColourAndSize.getText();
        String colour = colourAndPrice.split("\\|")[0].strip();
        String summarySize = colourAndPrice.split("\\|")[1].strip();
        String productPriceOneProduct = summaryPage.productPriceOneProduct.getText().split("\n")[1];
        String productPriceOneTotal = summaryPage.productPriceOneTotal.getText();
        String productPriceSelectedItem = summaryPage.productPriceSelectedItem.getText();
        assertEquals(productPriceOneProduct, productPriceOneTotal, productPriceSelectedItem);
        assertEquals(itemName, itemDetails[0]);
        assertEquals(itemFit, itemDetails[1]);
        assertEquals(colour, itemDetails[2].strip());
        assertEquals(productPriceOneProduct, itemDetails[3]);
        assertEquals(summarySize, size);
    }

    public String selectRandomSize() {
        List<WebElement> allSizes = productPage.allSizes;
        Random rnd = new Random();
        int i = rnd.nextInt(allSizes.size());
        String randomSize = allSizes.get(i).getText();
        common.click(allSizes.get(i));
        return randomSize;
    }

    public void addToBag() {
        common.click(productPage.addToBag);
    }

    public void acceptCookies() {
        homePage.acceptCookies.click();
    }
}
