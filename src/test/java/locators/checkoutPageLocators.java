package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutPageLocators {

    public checkoutPageLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "*[class^='product__description__name order-summary']")
    public WebElement productNameAndColour;

    @FindBy(css = ".product__description > :nth-child(3)")
    public WebElement productFit;

    @FindBy(css = ".product__description__variant")
    public WebElement productSize;

    @FindBy(css = ".product__price > .order-summary__emphasis")
    public WebElement priceOneProduct;

    @FindBy(css = ".total-line__price > .order-summary__emphasis")
    public WebElement priceSubtotal;

    @FindBy(css = ".payment-due__price")
    public WebElement priceTotal;


}



