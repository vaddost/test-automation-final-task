package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    private static final String CATEGORY_NOT_FOUND_ERROR_MESSAGE = "The category with given name is not found";

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[contains(@data-testid, 'search-button')]")
    private WebElement searchButton;

    @FindBy(xpath = "//ul[@data-testid='floornav']//a[contains(@id, 'floor')]")
    private List<WebElement> headerGenderCategoryLinks;

    @FindBy(xpath = "//button[@data-testid='primarynav-button']")
    private List<WebElement> primaryNavButtons;

    @FindBy(xpath = "//ul[@data-testid='secondarynav-flyout']//a")
    private List<WebElement> secondaryNavLinks;

    @FindBy(xpath = "//button[@data-testid='myAccountIcon']")
    private WebElement myAccountButton;

    @FindBy(xpath = "//a[@data-testid='signin-link']")
    private WebElement signInLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(final String url){
        driver.get(url);
    }

    public void enterSearchPhraseInSearchField(final String searchPhrase){
        searchInput.sendKeys(searchPhrase);
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }

    public void clickOnGenderCategory(final String gender){
        for (WebElement categoryLink : headerGenderCategoryLinks){
            if (categoryLink.getText().equalsIgnoreCase(gender)){
                categoryLink.click();
                break;
            }
        }
    }

    public void clickOnPrimaryCategory(final String primaryCategory){
        WebElement primaryCategoryElement = findPrimaryCategory(primaryCategory);
        if (primaryCategoryElement != null){
            primaryCategoryElement.click();
        } else {
            throw new NoSuchElementException(CATEGORY_NOT_FOUND_ERROR_MESSAGE);
        }
    }

    public void clickOnSecondaryCategory(final String secondaryCategory){
        WebElement secondaryCategoryElement = findSecondaryCategory(secondaryCategory);
        if (secondaryCategoryElement != null){
            secondaryCategoryElement.click();
        } else {
            throw new NoSuchElementException(CATEGORY_NOT_FOUND_ERROR_MESSAGE);
        }
    }

    public void clickMyAccountIcon(){
        myAccountButton.click();
    }

    public void clickSignInLink(){
        signInLink.click();
    }

    public WebElement getSignInLink(){
        return signInLink;
    }

    private WebElement findPrimaryCategory(String primaryCategory){
        for (WebElement categoryButton : primaryNavButtons){
            if (categoryButton.getText().equalsIgnoreCase(primaryCategory) && categoryButton.isDisplayed()){
                return categoryButton;
            }
        }
        return null;
    }

    private WebElement findSecondaryCategory(String secondaryCategory){
        for (WebElement categoryLink : secondaryNavLinks){
            if (categoryLink.getText().equalsIgnoreCase(secondaryCategory) && categoryLink.isDisplayed()){
                return categoryLink;
            }
        }
        return null;
    }
}
