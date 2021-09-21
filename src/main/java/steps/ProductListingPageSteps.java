package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import pages.ProductListingPage;

public class ProductListingPageSteps {
    private static final long DEFAULT_TIMEOUT = 30;

    BeforeAfterSteps beforeAfterSteps;
    ProductListingPage productListingPage;

    public ProductListingPageSteps(BeforeAfterSteps beforeAfterSteps) {
        this.beforeAfterSteps = beforeAfterSteps;
    }

    @Given("User is redirected to the Product Listing page")
    public void userRedirectedToProductListingPage() {
        productListingPage = beforeAfterSteps.pageFactoryManager.getProductListingPage();
        productListingPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Given("User clicks on the <product_id> product tile")
    public void clickOnProductWithId(@Named("product_id") final String productId) {
        productListingPage.clickOnProductWithId(productId);
    }

    @When("User clicks on Wishlist icon")
    public void whenUserClicksOnWishlistIcon() {

    }
}
