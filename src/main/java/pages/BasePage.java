package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitVisibilityOfElement(long timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementRefreshed(long timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
    }

    public void waitElementBeClickable(long timeToWait, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickWithJsExecutor(WebElement clickableElement){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", clickableElement);
    }

    public void waitNumberOfElementsMoreThanZero(long timeToWait, List<WebElement> elements){
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(webDriver -> !elements.isEmpty());
    }

    public boolean isElementDisplayed(WebElement element){
        try {
            waitVisibilityOfElement(30, element);
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }
}
