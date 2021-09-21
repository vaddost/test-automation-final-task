package steps;

import org.jbehave.core.annotations.*;
import pages.HomePage;

public class HomePageSteps{
    private static final long DEFAULT_TIMEOUT = 30;
    HomePage homePage;
    BeforeAfterSteps beforeAfterSteps;

    public HomePageSteps(BeforeAfterSteps beforeAfterSteps){
        this.beforeAfterSteps = beforeAfterSteps;
    }

    @Given("User opens <homepage> page")
    public void openHomePage(@Named("homepage") final String homeUrl){
        homePage = beforeAfterSteps.pageFactoryManager.getHomePage();
        homePage.openHomePage(homeUrl);
    }

    @When("User enters <search_phrase> in the search field")
    public void enterSearchPhraseToSearchField(@Named("search_phrase") final String searchPhrase) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.enterSearchPhraseInSearchField(searchPhrase);
    }

    @When("User clicks on Search button")
    public void clickSearchButton() {
        homePage.clickOnSearchButton();
    }

    @Given("User clicks on <gender> category")
    public void clickOnGenderCategory(@Named("gender") final String gender) {
        homePage.clickOnGenderCategory(gender);
    }

    @Given("User hovers on <category> category from the navigation")
    public void clickOnPrimaryCategory(@Named("category") String category) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickOnPrimaryCategory(category);
    }

    @Given("User clicks on <subcategory> subcategory from the dropdown")
    public void clickOnSecondLevelCategory(@Named("subcategory") String subcategory) {
        homePage.clickOnSecondaryCategory(subcategory);
    }

    @Given("User clicks on My Account icon")
    public void clickMyAccountIcon() {
        homePage.clickMyAccountIcon();
    }

    @Given("User clicks on Sign in link")
    public void clickSignInLink() {
        homePage.waitElementBeClickable(DEFAULT_TIMEOUT, homePage.getSignInLink());
        homePage.clickSignInLink();
    }
}
