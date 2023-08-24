package resources;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonMethods {
    WebDriver driver;


    public CommonMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void jsClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void customWaitVisibilityOf(WebElement element, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void customWaitVisibilityOf(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebElement element) {
        customWaitVisibilityOf(element, 10);
            element.click();
    }

    public boolean checkIfElementPresent(String locator, int timeout) {
        if (locator.contains("//")) { //if locator is Xpath
            try {
                customWaitVisibilityOf(driver.findElement(By.xpath(locator)),timeout);
                return true;
            }
            catch(TimeoutException e) {
                return false;
            }
        }
        else {
            try { //if locator is CSS
                customWaitVisibilityOf(driver.findElement(By.cssSelector(locator)),timeout);
                return true;
            }
            catch(TimeoutException e) {
                return false;
            }
        }
    }

    public boolean checkIfItemAttributePresent (WebElement randomItem, String locator) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            WebElement el = randomItem.findElement(By.cssSelector(locator));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            return true;
        }

        catch (NoSuchElementException e) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            return false;
        }
    }
}
