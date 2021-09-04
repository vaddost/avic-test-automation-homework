package pages;

import components.FilterNavigationComponent;
import components.ProductGridComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {
    private final WebDriver driver;
    private final FilterNavigationComponent filterNav;
    private final ProductGridComponent productGrid;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        filterNav = new FilterNavigationComponent(driver);
        productGrid = new ProductGridComponent(driver);
    }

    public FilterNavigationComponent getFilterNav(){
        return filterNav;
    }

    public ProductGridComponent getProductGrid(){
        return productGrid;
    }
}
