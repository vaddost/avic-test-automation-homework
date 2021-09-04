package pages;

import components.FilterNavigationComponent;
import components.ProductGridComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductListingPage {
    private final WebDriver driver;
    private final FilterNavigationComponent filterNavigation;
    private final By pageTitle = By.xpath("//div[contains(@class, 'page-title')]");

    public ProductListingPage(WebDriver driver) {
        this.driver = driver;
        filterNavigation = new FilterNavigationComponent(driver);
    }

    public String getTitle(){
        return driver.findElement(pageTitle).getText();
    }

    public FilterNavigationComponent getFilterNavigation(){
        return filterNavigation;
    }

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }

}
