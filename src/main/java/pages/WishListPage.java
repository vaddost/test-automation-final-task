package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class WishListPage extends BasePage{

    @FindBy(xpath = "//button[contains(@class, 'toBagButton')]")
    private WebElement moveToBagButton;

    @FindBy(xpath = "//select[contains(@aria-label, 'Size')]")
    private WebElement selectSizeDropdown;

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    public void clickMoveToBagButton(){
        moveToBagButton.click();
    }

    public WebElement getMoveToBag(){
        return moveToBagButton;
    }

    public void selectSizeFromDropdown(final String size){
        Select select = new Select(selectSizeDropdown);
        select.selectByVisibleText(size);
    }
}
