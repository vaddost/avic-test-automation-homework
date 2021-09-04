package pages;

import components.MainNavigationComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waiters;

public class HomePage {
    private final WebDriver driver;
    private final MainNavigationComponent mainNavigation;
    private final By searchInput = By.xpath("//input[@id='input_search']");
    private final By searchButton = By.xpath("//button[@class='button-reset search-btn']");

    public HomePage(WebDriver driver){
        this.driver = driver;
        mainNavigation = new MainNavigationComponent(driver);
    }

    public SearchResultPage getSearchResultPage(String searchPhrase){
        driver.findElement(searchInput).sendKeys(searchPhrase);
        driver.findElement(searchButton).click();
        Waiters.waitUntilPageIsLoaded(driver);
        return new SearchResultPage(driver);
    }

    public MainNavigationComponent getMainNavigation() {
        return mainNavigation;
    }
}
