package components;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Waiters;

import java.util.List;
import java.util.stream.Collectors;

public class ProductGridComponent {
    private final WebDriver driver;
    private final By products = By.xpath("//div[contains(@class, 'item-prod')]");
    private final By productPrice = By.xpath(".//div[@class='prod-cart__prise-new']");
    private final By loadMoreButton = By.xpath("//a[contains(@class, 'btn-see-more')]");

    public ProductGridComponent(WebDriver driver) {
        this.driver = driver;
    }

    public int getProductsCountInGrid(){
        return getProductElementsList().size();
    }

    public int getAvailableProductsCountInGrid(){
        return getAvailableProductsList().size();
    }

    public void loadAllProducts(){
        do {
            clickLoadMoreProducts();
        } while (isLoadMoreButtonDisplayed());
    }

    public List<Integer> getProductPrices(){
        loadAllProducts();
        return getProductElementsList().stream()
                .map(x -> Integer.parseInt(x.findElement(productPrice).getText().split(" ")[0]))
                .collect(Collectors.toList());
    }

    private List<WebElement> getProductElementsList(){
        return driver.findElements(products);
    }

    private List<WebElement> getAvailableProductsList(){
        return getProductElementsList().stream()
                .filter(x -> !x.findElements(productPrice).isEmpty())
                .collect(Collectors.toList());
    }

    private boolean isLoadMoreButtonDisplayed(){
        return !driver.findElements(loadMoreButton).isEmpty();
    }

    private void clickLoadMoreProducts(){
        if (isLoadMoreButtonDisplayed()){
            Waiters.waitUntilElementToBeClickable(driver, loadMoreButton).sendKeys(Keys.RETURN);
            Waiters.waitUntilPresenceOfAllElementsLocatedBy(driver,products);
        }
    }
}
