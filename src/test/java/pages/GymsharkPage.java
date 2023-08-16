package pages;

import locators.homePageLocators;
import locators.productPageLocators;
import locators.summaryPageLocators;
import locators.checkoutPageLocators;
import locators.fullBagLocators;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class GymsharkPage {
    WebDriver driver;

    homePageLocators homePage;
    productPageLocators productPage;
    summaryPageLocators summaryPage;
    CommonMethods common;
    fullBagLocators fullBagPage;
    checkoutPageLocators checkoutPage;

    public GymsharkPage(WebDriver driver) {
        this.driver = driver;
        common = new CommonMethods(driver);
        homePage = new homePageLocators(driver);
        productPage = new productPageLocators(driver);
        summaryPage = new summaryPageLocators(driver);
        fullBagPage = new fullBagLocators(driver);
        checkoutPage = new checkoutPageLocators(driver);
    }

    public void getCategory(String cat) throws InterruptedException {
        String categoryCSS = String.format("[id^=%s]", cat);
        common.click(driver.findElement(By.cssSelector(categoryCSS)));
        Thread.sleep(2000);
        common.scrollToElement(homePage.desktopNewReleasesXpath);
        common.jsClick(homePage.desktopNewReleasesXpath);
        common.customWaitVisibilityOf(homePage.newReleasesHeaderXpath, 10);
    }

    public String[] selectRandomItem() {
        String itemFit = "None";
        List<WebElement> allItems = homePage.allItemsList;
        Random random = new Random();
        int randomInt = random.nextInt(1, allItems.size());
        WebElement randomItem = allItems.get(randomInt);
        common.scrollToElement(randomItem);
        String itemName = randomItem.findElement(By.cssSelector(homePage.itemNameCSS)).getText().toLowerCase();
        if (common.checkIfItemAttributePresent(randomItem, homePage.itemFitCSS)) {
            itemFit = randomItem.findElement(By.cssSelector("p[class^='product-card_product-fit']")).getText();
        }

        String itemColour = randomItem.findElement(By.cssSelector(homePage.itemColourCSS)).getText();
        String itemPrice = randomItem.findElement(By.cssSelector(homePage.itemPriceCSS)).getText();
        randomItem.click();
        common.customWaitVisibilityOf(productPage.addToBag, 10);
        return new String[]{itemName, itemFit, itemColour, itemPrice};
    }

    public void verifyDetailsOnProductPage(String[] itemDetails) {
        String itemFit = "None";
        String itemName = productPage.productName.getText().split("\n")[0].toLowerCase();
        if (!itemDetails[1].equals("None")) {
            itemFit = productPage.productFit.getText();
        }
        String itemColour = productPage.productColour.getText();
        String itemPrice = productPage.productPrice.getText();
        String[] productPageDetails = {itemName, itemFit, itemColour, itemPrice};
        assertArrayEquals(itemDetails, productPageDetails);
    }

    public void verifyDetailsOnSummaryPage(String[] itemDetails, String size) throws InterruptedException {
        String itemFit = "None";
        common.customWaitVisibilityOf(summaryPage.viewFullBagButton, 10);
        Thread.sleep(2000);
        String itemName = summaryPage.productName.getText().toLowerCase();
        if (!itemDetails[1].equals("None")) {
            itemFit = summaryPage.productFit.getText();
        }
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
        String randomSize = "None";
        List<WebElement> allSizes = productPage.allSizes;
        if (allSizes.size() > 0) {
            Random rnd = new Random();
            int i = rnd.nextInt(allSizes.size());
            randomSize = allSizes.get(i).getText();
            common.click(allSizes.get(i));
        }
        return randomSize;
    }

    public void addToBag() {
        common.click(productPage.addToBag);
    }

    public void acceptCookies() {common.click(homePage.acceptCookies);
    }

    public void closeSummary() {common.click(summaryPage.closeXIcon);
    }

    public void verifyNumberOfItemsInBasket(String str1) {
        String count = productPage.cartCount.getText();
        assertEquals(str1, count);
    }

    public void clickOnBasket() throws InterruptedException {
        Thread.sleep(1000);
        common.click(productPage.iconBag);
    }

    public void verifyValuesOnFullBagPage(String [] randomItemDetails, String randSize) {
        common.click(summaryPage.viewFullBagButton);
        String itemFit = "None", summarySize = "None";
        String itemName = fullBagPage.productName.getText().toLowerCase();
        if (!randomItemDetails[1].equals("None")) {
            common.customWaitVisibilityOf(fullBagPage.productFit, 5);
            itemFit = fullBagPage.productFit.getText();
        }
        common.customWaitVisibilityOf(fullBagPage.productColourAndSize, 5);
        String colourAndPrice = fullBagPage.productColourAndSize.getText();
        String colour = colourAndPrice.split("\\|")[0].strip();
        if (!randSize.equals("None")) {
            summarySize = colourAndPrice.split("\\|")[1].strip();
        }
        String productPriceOneProduct = fullBagPage.priceOneProduct.getText().split("\n")[1];
        String productPriceTotal = fullBagPage.priceTotal.getText();
        String productPriceSelectedItem = fullBagPage.priceSelectedItem.getText();

        assertEquals(productPriceOneProduct, productPriceTotal, productPriceSelectedItem);
        assertEquals(itemName, randomItemDetails[0]);
        assertEquals(itemFit, randomItemDetails[1]);
        assertEquals(colour, randomItemDetails[2].strip());
        assertEquals(productPriceOneProduct, randomItemDetails[3]);
        assertEquals(summarySize, randSize);
    }

    public void verifyValuesOnCheckoutPage (String [] randomItemDetails, String randSize) {
        common.click(fullBagPage.checkoutButton);
        String itemFit = "None", summarySize = "None";
        if (!randomItemDetails[1].equals("None")) {
            itemFit = checkoutPage.productFit.getText();
        }
        String productNameAndColour = checkoutPage.productNameAndColour.getText().toLowerCase();
        if (!randSize.equals("None")) {
            summarySize = checkoutPage.productSize.getText();
        }
        String productPriceOneProduct = checkoutPage.priceOneProduct.getText();
        String productPriceTotal = checkoutPage.priceTotal.getText();
        String priceSubtotal = checkoutPage.priceSubtotal.getText();
        assertTrue(productNameAndColour.contains(randomItemDetails[0])); //productName
        assertTrue(productNameAndColour.contains(randomItemDetails[2].toLowerCase())); //productColour
        assertEquals(productPriceOneProduct, productPriceTotal, priceSubtotal);
        assertEquals(itemFit, randomItemDetails[1]);
        assertEquals(productPriceOneProduct.split("\\.")[0], randomItemDetails[3]);
        assertTrue(summarySize.contains(randSize));

    }
}
