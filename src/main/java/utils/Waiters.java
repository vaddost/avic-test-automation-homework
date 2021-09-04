package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {

    public static WebElement waitUntilElementToBeClickable(WebDriver driver, By locator){
        return new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitUntilPageIsLoaded(WebDriver driver) {
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).
                        executeScript("return document.readyState").equals("complete"));
    }

    public static void waitUntilPresenceOfAllElementsLocatedBy(WebDriver driver, By locator){
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(locator)
        );
    }

    public static void waitUntilElementIsVisible(WebDriver driver, WebElement element){
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOf(element)
        );
    }
}
