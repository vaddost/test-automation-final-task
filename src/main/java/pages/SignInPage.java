package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    @FindBy(xpath = "//input[@name='Username']")
    private WebElement emailInput;

    @FindBy(xpath = "//span[@id='EmailAddress-error']")
    private WebElement emailError;

    @FindBy(xpath = "//li[@id='loginErrorMessage']")
    private WebElement loginError;

    @FindBy(xpath = "//input[@name='Password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='signin']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[@id='Password-error']")
    private WebElement passwordError;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void enterValueToEmailField(final String email){
        emailInput.sendKeys(email, Keys.TAB);
    }

    public boolean isEmailErrorDisplayed(){
        return isElementDisplayed(emailError);
    }

    public String getEmailErrorMessage(){
        return emailError.getText();
    }

    public void enterValueToPasswordField(final String password){
        passwordInput.sendKeys(password, Keys.TAB);
    }

    public boolean isLoginErrorDisplayed(){
        return isElementDisplayed(loginError);
    }

    public String getLoginErrorMessage(){
        return loginError.getText();
    }

    public void clickSignInButton(){
        signInButton.click();
    }

    public boolean isPasswordErrorDisplayed(){
        return isElementDisplayed(passwordError);
    }

    public String getPasswordErrorMessage(){
        return passwordError.getText();
    }
}
