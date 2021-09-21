package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage(){
        return new HomePage(driver);
    }

    public SearchResultsPage getSearchResultsPage(){
        return new SearchResultsPage(driver);
    }

    public ProductDetailsPage getProductDetailsPage(){
        return new ProductDetailsPage(driver);
    }

    public ProductListingPage getProductListingPage(){
        return new ProductListingPage(driver);
    }

    public WishListPage getWishListPage(){
        return new WishListPage(driver);
    }

    public SignInPage getSignInPage(){
        return new SignInPage(driver);
    }
}
