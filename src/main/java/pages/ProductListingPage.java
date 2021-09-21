package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductListingPage extends BasePage{

    @FindBy(xpath = "//article[@data-auto-id='productTile']//a")
    private List<WebElement> productLinksList;

    @FindBy(xpath = "//a[@data-auto-id='loadMoreProducts']")
    private WebElement loadMoreButton;

    public ProductListingPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnProductWithId(String id){
        loadAllProducts();
        for (var productLink : productLinksList){
            if (productLink.getAttribute("href").contains(id)){
                waitElementBeClickable(30, productLink);
                clickWithJsExecutor(productLink);
                break;
            }
        }
    }

    private void loadAllProducts(){
        while(isElementDisplayed(loadMoreButton)){
            clickWithJsExecutor(loadMoreButton);
        }
    }
}
