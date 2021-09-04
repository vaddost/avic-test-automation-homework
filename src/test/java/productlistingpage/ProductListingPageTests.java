package productlistingpage;

import base.BaseTests;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductListingPageTests extends BaseTests {
    @Test (priority = 1)
    public void checkPLPIsLoadedAfterClickingOnSubNavigationItem(){
        String category = "Ноутбуки и планшеты";
        String subCategory = "Графические планшеты";
        var productListingPage = homePage.getMainNavigation()
                .clickOnSecondNavItem(category, subCategory);
        String pageTitle = productListingPage.getTitle();
        assertEquals(pageTitle, subCategory);
    }

    @Test (priority = 2)
    public void checkFilteringByManufacturer(){
        String category = "Ноутбуки и планшеты";
        String subCategory = "Графические планшеты";
        var productListingPage = homePage.getMainNavigation()
                .clickOnSecondNavItem(category, subCategory);

        productListingPage.getFilterNavigation().filterByManufacturer("Wacom");

        assertTrue(productListingPage.getPageUrl().contains("--wacom"));
    }
}
