package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.CommonMethods;

public class summaryPageLocators {
    CommonMethods common;

    public summaryPageLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
        common = new CommonMethods(driver);
    }

    @FindBy(css = "*[class^='product-card_title']")
    public WebElement productName;

    @FindBy(css = "*[class^='product-card_featured-selection']")
    public WebElement productFit;

    @FindBy(css = "*[class^='product-card_selected-option']")
    public WebElement productColourAndSize;

    @FindBy(css = "div[class^='summary_summary-info-wrapper']:not([class*='--bold'])")
    public WebElement productPriceOneProduct;

    @FindBy(css = "p[data-locator-id^='miniBag-totalValue-read']")
    public WebElement productPriceOneTotal;

    @FindBy(css = "p[class^='product-card_price']")
    public WebElement productPriceSelectedItem;

    @FindBy(xpath = "//a[contains(text(), 'View full bag')]")
    public WebElement viewFullBagButton;

    @FindBy(css = "button[data-locator-id=miniBag-closeButton-select] i")
    public WebElement closeXIcon;

    public void clickViewFullBag() {
        common.click(viewFullBagButton);
    }

    public void clickCloseXIcon() {
        common.click(closeXIcon);
    }

}



