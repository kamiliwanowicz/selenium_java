package locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class homePageLocators {

    public homePageLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button#onetrust-accept-btn-handler")
    public WebElement acceptCookies;

    @FindBy(css = "#men")
    public WebElement menCSS;

    @FindBy(xpath = "//div[contains(@class, 'hero-block_desktop')] /a[contains(text(), 'SHOP NEW RELEASES')]")
    public WebElement desktopNewReleasesXpath;

    @FindBy(xpath = "//h4[contains(text(), 'New Releases')]")
    public WebElement newReleasesHeaderXpath;

    @FindBy(css = "*[class^='product-grid_grid'] article")
    public List<WebElement> allItemsList;

    @FindBy(css = "h4[class^='product-card_product-title']")
    public List<WebElement> itemName;

    @FindBy(css = "p[class^='product-card_product-fit']")
    public List<WebElement> itemFit;

    @FindBy(css = "p[class^='product-card_product-colour']")
    public List<WebElement> itemColour;

    @FindBy(css = "span[class^='product-card_product-price']")
    public List<WebElement> itemPrice;


}



