package search;

import base.BaseTests;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class SearchResultPageTests extends BaseTests {
    @Test (priority = 1)
    public void checkShowAvailableProductsOnlyFilter(){
        var searchResultPage = homePage.getSearchResultPage("Gembird");
        searchResultPage.getFilterNav().showAvailableProductsOnly();
        searchResultPage.getProductGrid().loadAllProducts();
        assertEquals(searchResultPage.getProductGrid().getProductsCountInGrid(),
                searchResultPage.getProductGrid().getAvailableProductsCountInGrid());
    }

    @Test (priority = 2)
    public void checkShowProductsWithPriceFilter(){
        int minPrice = 20000;
        int maxPrice = 21000;
        var searchResultPage = homePage.getSearchResultPage("iPhone12");
        searchResultPage.getFilterNav().showAvailableProductsOnly();
        searchResultPage.getFilterNav().filterByPriceRange(minPrice, maxPrice);
        List<Integer> productPrices = searchResultPage.getProductGrid().getProductPrices();
        int count = (int) productPrices.stream()
                .filter(x -> x >= minPrice && x <= maxPrice)
                .count();
        assertEquals(productPrices.size(), count);
    }
}
