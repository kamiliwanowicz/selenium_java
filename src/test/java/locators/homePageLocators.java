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


    @FindBy(xpath = "//div[starts-with(@class, 'hero-block_desktop')] //a[contains(text(), 'Shop New')]")
    public WebElement desktopNewReleasesXpath;

    @FindBy(xpath = "//h4[contains(text(), 'New Releases')]")
    public WebElement newReleasesHeaderXpath;

    @FindBy(css = "*[class^='product-grid_grid'] article")
    public List<WebElement> allItemsList;

    public String itemNameCSS = "h4[class^='product-card_product-title']";
    public String itemFitCSS = "p[class^='product-card_product-fit']";
    public String itemColourCSS = "p[class^='product-card_product-colour']";
    public String itemPriceCSS = "span[class^='product-card_product-price']";




}



