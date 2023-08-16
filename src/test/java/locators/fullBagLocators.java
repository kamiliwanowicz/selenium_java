package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class fullBagLocators {

    public fullBagLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "*[class^='product-card_title']")
    public WebElement productName;

    @FindBy(css = "*[class^='product-card_featured-selection']")
    public WebElement productFit;

    @FindBy(css = "*[class^='product-card_selected-option']")
    public WebElement productColourAndSize;

    @FindBy(css = "div[class^='cart-page_right'] div[class^='summary_summary-info-wrapper']:not([class*='--bold'])")
    public WebElement priceOneProduct;

    @FindBy(css = "div[class^='cart-page_right'] p[data-locator-id^='bag-totalValue-read']")
    public WebElement priceTotal;

    @FindBy(css = "div[class^='cart-page_items'] p[class^='product-card_price']")
    public WebElement priceSelectedItem;

    @FindBy(css = "a[data-locator-id=bag-checkout-select]")
    public WebElement checkoutButton;

}



