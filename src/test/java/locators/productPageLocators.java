package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class productPageLocators {

    public productPageLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "*[class^='product-information_title']")
    public WebElement productName;

    @FindBy(css = "*[class^='product-information_fit']")
    public WebElement productFit;

    @FindBy(css = "*[class^='product-information_title'] span")
    public WebElement productColour;

    @FindBy(css = "*[class^='product-information_price']")
    public WebElement productPrice;

    @FindBy(css = "button[data-locator-id=pdp-addToBag-submit]")
    public WebElement addToBag;

    @FindBy(css = "*[class^='add-to-cart_sizes'] button")
    public List<WebElement> allSizes;

    @FindBy(css = "#cart-count")
    public WebElement cartCount;

    @FindBy(css = ".icon-bag")
    public WebElement iconBag;


}



