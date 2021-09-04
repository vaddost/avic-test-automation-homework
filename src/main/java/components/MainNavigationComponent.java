package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.ProductListingPage;
import utils.Waiters;

import java.util.List;

public class MainNavigationComponent {
    private final WebDriver driver;
    private final By firstLevel = By.xpath("//div[contains(@class, 'first-level')]");

    public MainNavigationComponent(WebDriver driver) {
        this.driver = driver;
    }

    public ProductListingPage clickOnSecondNavItem(String category, String subcategory){
        WebElement navigation = driver.findElement(firstLevel);
        Actions move = new Actions(driver);
        WebElement navItem = navigation.findElement(By.xpath(".//span[contains(text(),'" + category +"')]"));
        move.moveToElement(navItem).build().perform();
        WebElement subNavItem = navigation.findElement(By.xpath(".//a[contains(text(),'" + subcategory +"')]"));
        Waiters.waitUntilElementIsVisible(driver, subNavItem);
        move.moveToElement(subNavItem).build().perform();
        move.click().build().perform();

        Waiters.waitUntilPageIsLoaded(driver);
        return new ProductListingPage(driver);
    }
}
