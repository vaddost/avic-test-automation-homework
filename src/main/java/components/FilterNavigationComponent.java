package components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waiters;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class FilterNavigationComponent {
    private final WebDriver driver;
    private final By onlyAvailableProductsCheckbox = By.xpath("//aside//input[@id='fltr-1']");
    private final By showProductsByPriceLink = By.xpath("//div[contains(@class, 'open-filter-tooltip')]//a[contains(@class,'filter-tooltip')]");
    private final By minPriceInput = By.xpath("//input[contains(@class, 'form-control-min')]");
    private final By maxPriceInput = By.xpath("//input[contains(@class, 'form-control-max')]");
    private final By manufacturerCheckboxes = By.xpath("//input[contains(@id, 'fltr-proizvoditel')]");

    public FilterNavigationComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void showAvailableProductsOnly(){
        WebElement checkboxAvailable = driver.findElement(onlyAvailableProductsCheckbox);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", checkboxAvailable);
        Waiters.waitUntilPageIsLoaded(driver);
    }

    public void filterByPriceRange(int minPriceRange, int maxPriceRange){
        WebElement minPriceInputElement = driver.findElement(minPriceInput);
        WebElement maxPriceInputElement = driver.findElement(maxPriceInput);

        minPriceInputElement.clear();
        minPriceInputElement.sendKeys(Integer.toString(minPriceRange));

        maxPriceInputElement.clear();
        maxPriceInputElement.sendKeys(Integer.toString(maxPriceRange));

        Waiters.waitUntilElementToBeClickable(driver, showProductsByPriceLink).click();

        Waiters.waitUntilPageIsLoaded(driver);
    }

    public void filterByManufacturer(String manufacturer){
        List<WebElement> manufacturerList = driver.findElements(manufacturerCheckboxes);
        WebElement manufacturerElement = manufacturerList.stream()
                .filter(x -> x.getAttribute("value").equals(manufacturer.toLowerCase()))
                .findFirst().orElse(null);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", manufacturerElement);

        Waiters.waitUntilPageIsLoaded(driver);
    }
}
