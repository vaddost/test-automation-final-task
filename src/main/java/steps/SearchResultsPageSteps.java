package steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import pages.SearchResultsPage;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class SearchResultsPageSteps {
    private static final long DEFAULT_TIMEOUT = 30;
    BeforeAfterSteps beforeAfterSteps;
    SearchResultsPage searchResultsPage;

    public SearchResultsPageSteps(BeforeAfterSteps beforeAfterSteps) {
        this.beforeAfterSteps = beforeAfterSteps;
    }

    @When("The Search Results Page is opened")
    @Then("The Search Results Page is opened")
    public void checkSearchResultsPageOpened() {
        searchResultsPage = beforeAfterSteps.pageFactoryManager.getSearchResultsPage();
        String expectedText = "search";
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue("Page title doesn't contain '" + expectedText + "' text",
                searchResultsPage.getPageTitle().toLowerCase().contains(expectedText));
    }

    @Then("page URL contains <search_query>")
    public void isPageUrlContainsSearchQuery(@Named("search_query") final String searchQuery) {
        assertTrue("Page URL doesn't contain " + searchQuery,
                searchResultsPage.getPageUrl().contains(searchQuery));
    }

    @Then("search term banner contains <search_phrase>")
    public void isSearchBannerContainsSearchPhrase(@Named("search_phrase") final String searchPhrase) {
        assertTrue("Search Term Banner doesn't contains " + searchPhrase,
                searchResultsPage.getSearchTermFromSearchTermBanner().toLowerCase()
                .contains(searchPhrase));
    }

    @Then("product count is displayed")
    public void isProductCountDisplayed() {
        assertTrue("Product count text is not displayed",
                searchResultsPage.isProductsCountDisplayed());
    }

    @Then("Filters section is displayed")
    public void isFiltersSectionDisplayed() {
        assertTrue("Filters section is not displayed or empty",
                searchResultsPage.isFiltersDisplayed());
    }

    @Then("Product Grid is not empty")
    public void isProductGridNotEmpty() {
        assertTrue("Products are not displayed",
                searchResultsPage.isProductsListDisplayed());
    }

    @Then("progress bar is displayed")
    public void isProgressBarDisplayed() {
        assertTrue("Progress bar is not displayed or doesn't contains all required elements",
                searchResultsPage.isProgressBarDisplayed());
    }

    @When("User filters products by <brand> brand")
    public void filterProductsByBrand(@Named("brand") final String brand) {
        searchResultsPage.clickOnBrandDropdown();
        searchResultsPage.clickOnBrandFilter(brand);
    }

    @Then("The <brand> brand filter is selected")
    public void isBrandSelected(@Named("brand") final String brand) {
        searchResultsPage.waitElementRefreshed(DEFAULT_TIMEOUT, searchResultsPage.getBrandsSelectedElement());

        assertTrue("Brand filter is not selected",
                searchResultsPage.getSelectedBrands().contains(brand));
        searchResultsPage.clickOnBrandDropdown();
    }

    @Then("products are filtered by <brand> brand")
    public void checkThatProductsFilteredByBrand(@Named("brand") final String brand) {
        List<String> productNamesNotContainBrand = searchResultsPage.getProductNames()
                .stream()
                .filter(x -> !x.contains(brand))
                .collect(Collectors.toList());

        assertTrue("Some products don't contain '" + "' brand: " + productNamesNotContainBrand,
                productNamesNotContainBrand.isEmpty());

    }

    @When("User clicks on the first product on the page")
    public void whenUserClicksOnTheFirstProductOnThePage() {
        searchResultsPage.clickOnFirstProduct();
    }
}
