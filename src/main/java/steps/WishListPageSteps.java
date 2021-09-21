package steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import pages.WishListPage;

public class WishListPageSteps {

    private static final long DEFAULT_TIMEOUT = 30;
    BeforeAfterSteps beforeAfterSteps;
    WishListPage wishListPage;

    public WishListPageSteps(BeforeAfterSteps beforeAfterSteps) {
        this.beforeAfterSteps = beforeAfterSteps;
    }

    @When("Wishlist page is opened")
    public void setWishListPage() {
        wishListPage = beforeAfterSteps.pageFactoryManager.getWishListPage();
        wishListPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        wishListPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, wishListPage.getMoveToBag());
    }

    @When("User clicks Move to Bag button")
    public void clickMoveToBagButton() {
        wishListPage.clickMoveToBagButton();
    }

    @When("User selects <size> size for product tile")
    public void selectProductTileSize(@Named("size") String size) {
        wishListPage.selectSizeFromDropdown(size);
    }
}
