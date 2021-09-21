package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage extends BasePage{

    @FindBy(xpath = "//div[@id='search-term-banner']//p[starts-with(text(), '\"')]")
    private WebElement searchPhraseOnSearchBanner;

    @FindBy(xpath = "//ul[contains(@data-auto-id, 'mediumRefinements')]")
    private WebElement filtersSection;

    @FindBy(xpath = "//p[@data-auto-id='styleCount']")
    private WebElement styleCount;

    @FindBy(xpath = "//article[contains(@id, 'product')]//a")
    private List<WebElement> productsLinksList;

    @FindBy(xpath = "//p[@data-auto-id='productsProgressBar']")
    private WebElement progressBarText;

    @FindBy(xpath = "//p[@data-auto-id='productsProgressBar']//..//progress")
    private WebElement progressBar;

    @FindBy(xpath = "//li[@data-auto-id='brand']//button")
    private WebElement brandFilterButton;

    @FindBy(xpath = "//p[@data-auto-id='selectedFacetValueList']")
    private WebElement selectedBrands;

    @FindBy(xpath = "//div[@data-auto-id='refinementItem']//div")
    private List<WebElement> brandsFilterItemsText;

    @FindBy(xpath = "//div[@data-auto-id='productTileDescription']//p")
    private List<WebElement> productNamesList;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }

    public String getSearchTermFromSearchTermBanner(){
        return searchPhraseOnSearchBanner.getText();
    }

    public boolean isFiltersDisplayed(){
        return isElementDisplayed(filtersSection);
    }

    public boolean isProductsCountDisplayed(){
        return isElementDisplayed(styleCount);
    }

    public boolean isProductsListDisplayed(){
        return !productsLinksList.isEmpty();
    }

    public boolean isProgressBarDisplayed(){
        return isElementDisplayed(progressBar) && isElementDisplayed(progressBarText);
    }

    public void clickOnBrandDropdown(){
        brandFilterButton.click();
    }

    public void clickOnBrandFilter(final String filterText){
        for (WebElement brandFilter: brandsFilterItemsText){
            if (brandFilter.getText().contains(filterText)){
                clickWithJsExecutor(getBrandFilterCheckboxByLabel(brandFilter));
                break;
            }
        }
    }

    public String getSelectedBrands(){
        return selectedBrands.getText();
    }

    public List<String> getProductNames(){
        return productNamesList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public WebElement getBrandsSelectedElement(){
        return selectedBrands;
    }

    public void clickOnFirstProduct(){
        productsLinksList.get(0).click();
    }

    private WebElement getBrandFilterCheckboxByLabel(final WebElement currentLabel){
        return currentLabel.findElement(By.xpath(".//..//..//input[contains(@id, 'brand')]"));
    }
}
