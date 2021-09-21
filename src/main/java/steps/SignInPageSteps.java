package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import pages.SignInPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SignInPageSteps {

    private static final long DEFAULT_TIMEOUT = 30;
    BeforeAfterSteps beforeAfterSteps;
    SignInPage signInPage;

    public SignInPageSteps(BeforeAfterSteps beforeAfterSteps) {
        this.beforeAfterSteps = beforeAfterSteps;
    }

    @Then("User is redirected on Sign in page")
    @Given("User is redirected on Sign in page")
    public void setSignInPage() {
        signInPage = beforeAfterSteps.pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @When("User enters <email> email address")
    public void enterEmailAddress(@Named("email") final String email) {
        signInPage.enterValueToEmailField(email);
    }

    @Then("The email field validation error message with <email_error_text> text is displayed")
    public void checkEmailValidationError(@Named("email_error_text") final String emailErrorText) {
        assertTrue("Email error message is not displayed",
                signInPage.isEmailErrorDisplayed());
        assertEquals(emailErrorText, signInPage.getEmailErrorMessage());
    }

    @When("User enters <password> password")
    public void enterPassword(@Named("password") String password) {
        signInPage.enterValueToPasswordField(password);
    }

    @When("User clicks Sign in button")
    public void clickSignInButton() {
        signInPage.clickSignInButton();
    }

    @Then("The error message indicated about not successful login with <error_text> text is present")
    public void checkLoginErrorMessage(@Named("error_text") final String errorText) {
        assertTrue("Login Error message is not displayed",
                signInPage.isLoginErrorDisplayed());
        assertEquals(errorText, signInPage.getLoginErrorMessage());
    }

    @Then("the password field validation message with <password_error_text> text is displayed")
    public void checkPasswordValidationMessage(@Named("password_error_text") final String passwordErrorText) {
        assertTrue("Password Validation Error is not displayed",
                signInPage.isPasswordErrorDisplayed());
        assertEquals(passwordErrorText, signInPage.getPasswordErrorMessage());
    }
}
