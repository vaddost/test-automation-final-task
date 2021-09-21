package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductDetailsPage extends BasePage{

    @FindBy(xpath = "//div[contains(@class, 'product-gallery')]")
    private WebElement productGallery;

    @FindBy(xpath = "//div[contains(@class, 'product-hero')]")
    private WebElement productTitle;

    @FindBy(xpath = "//button[@id='product-add-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//button[contains(@class, 'save-button')]")
    private WebElement addToWishlistButton;

    @FindBy(xpath = "//div[contains(@class, 'delivery-box')]")
    private WebElement deliverySection;

    @FindBy(xpath = "//section[contains(@class, 'product-description')]")
    private WebElement productDescriptionSection;

    @FindBy(xpath = "//select[contains(@id, 'main-size-select')]")
    private WebElement selectSizeDropdown;

    @FindBy(xpath = "//div[@id='minibag-dropdown']")
    private WebElement miniBagDropdown;

    @FindBy(xpath = "//div[@id='minibag-dropdown']//a[contains(@aria-label, 'Name')]")
    private List<WebElement> productLinksInMiniBagList;

    @FindBy(xpath = "//a[@data-testid='savedItemsIcon']")
    private WebElement savedItemsLink;

    @FindBy(xpath = "//span[@id='selectSizeError']")
    private WebElement selectSizeError;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductGalleryDisplayed(){
        return isElementDisplayed(productGallery);
    }

    public boolean isProductTitleDisplayed(){
        return isElementDisplayed(productTitle);
    }

    public boolean isAddToCartButtonDisplayed(){
        return isElementDisplayed(addToCartButton);
    }

    public boolean isAddToWishListButtonDisplayed(){
        return isElementDisplayed(addToWishlistButton);
    }

    public boolean isDeliverySectionDisplayed(){
        return isElementDisplayed(deliverySection);
    }

    public boolean isProductDescriptionSectionDisplayed(){
        return isElementDisplayed(productDescriptionSection);
    }

    public void selectSizeFromDropdown(final String size){
        Select select = new Select(selectSizeDropdown);
        select.selectByVisibleText(size);
    }

    public void clickAddToCartButton(){
        addToCartButton.click();
    }

    public boolean isMiniCartPopUpDisplayed(){
        return isElementDisplayed(miniBagDropdown);
    }

    public boolean isProductPresentInMiniBag(final String size, final String variant){
        waitNumberOfElementsMoreThanZero(30, productLinksInMiniBagList);
        for (var productLink : productLinksInMiniBagList){
            String productLinkText = productLink.getText();
            String productLinkHref = productLink.getAttribute("href");
            if (productLinkHref.contains(variant) && productLinkText.contains(size)){
                return true;
            }
        }
        return false;
    }

    public void clickAddToWishlistButton(){
        addToWishlistButton.click();
    }

    public void clickSavedItemsIcon(){
        savedItemsLink.click();
    }

    public boolean isSelectSizeErrorDisplayed(){
        return isElementDisplayed(selectSizeError);
    }

    public String getSelectSizeErrorText(){
        return selectSizeError.getText();
    }
}
