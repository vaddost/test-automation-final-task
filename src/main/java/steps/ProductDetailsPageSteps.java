package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import pages.ProductDetailsPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductDetailsPageSteps {

    private static final long DEFAULT_TIMEOUT = 30;
    BeforeAfterSteps beforeAfterSteps;
    ProductDetailsPage productDetailsPage;

    public ProductDetailsPageSteps(BeforeAfterSteps beforeAfterSteps) {
        this.beforeAfterSteps = beforeAfterSteps;
    }

    @Given("Product Details Page is opened")
    @Then("Product Details Page is opened")
    public void checkProductDetailsPageOpened() {
        productDetailsPage = beforeAfterSteps.pageFactoryManager.getProductDetailsPage();
        productDetailsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);

        assertTrue("Product Gallery is not displayed",
                productDetailsPage.isProductGalleryDisplayed());
        assertTrue("Product Title is not displayed",
                productDetailsPage.isProductTitleDisplayed());
        assertTrue("Add To Cart button is not displayed",
                productDetailsPage.isAddToCartButtonDisplayed());
        assertTrue("Add to Wishlist is not displayed",
                productDetailsPage.isAddToWishListButtonDisplayed());
        assertTrue("Delivery Section is not displayed",
                productDetailsPage.isDeliverySectionDisplayed());
        assertTrue("Product Description Section is not displayed",
                productDetailsPage.isProductDescriptionSectionDisplayed());
    }

    @When("User selects <size> size")
    public void selectSizeFromDropdown(@Named("size") String size) {
        productDetailsPage.selectSizeFromDropdown(size);
    }

    @When("User clicks on Add to Cart button")
    public void clickAddToCart() {
        productDetailsPage.clickAddToCartButton();
    }

    @Then("Mini Cart pop-up is displayed")
    public void checkIfMiniCartDisplayed() {
        assertTrue("Mini Cart pop-up is not shown",
                productDetailsPage.isMiniCartPopUpDisplayed());
    }

    @Then("the product with <size> and <variant_id> is added to the Cart")
    public void checkIfProductAddedToCart(@Named("size") final String size, @Named("variant_id") String variant) {
        assertTrue("Product is not displayed in Mini Cart",
                productDetailsPage.isProductPresentInMiniBag(size, variant));
    }

    @When("User adds product to the Wishlist")
    public void addProductToWishlist() {
        productDetailsPage.clickAddToWishlistButton();
    }

    @When("User clicks on Wishlist icon")
    public void clickOnWishListIconFromHeader() {
        productDetailsPage.clickSavedItemsIcon();
    }

    @Then("error message is displayed")
    public void checkSelectSizeErrorDisplayed() {
        assertTrue("The error message is not displayed",
                productDetailsPage.isSelectSizeErrorDisplayed());
    }

    @Then("error message text is '<error_message_text>'")
    public void checkSelectSizeErrorMessage(@Named("error_message_text") final String errorMessage) {
        assertEquals(errorMessage, productDetailsPage.getSelectSizeErrorText());
    }
}
