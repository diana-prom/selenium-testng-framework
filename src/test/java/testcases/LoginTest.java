package testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class LoginTest extends BaseTest {
    private String validEmail = "random@email.com";
    private String incorrectPassword = "!@df";

    @Test(priority = 2, groups = {"Smoke"})
    public void validateLoginInputFieldsAndButton() {
        loginPage.open();
        boolean inputFieldsAndButton = loginPage.loginInputFieldsExist();
        if (inputFieldsAndButton) {
            System.out.println("Email field, Password field and Login button are displayed on Sign In page");
        } else {
            System.out.println("Email field, Password field and Login button did not load");
        }

    }

    @Test(priority = 3, groups = {"Regression"})
    public void enterInvalidLoginCredentials() {
        loginPage.open();
        loginPage.enterCredentials(validEmail, incorrectPassword);
        loginPage.submitCredentials();
    }

    @Test(priority = 4, groups = {"Regression"})
    public void findsErrorMessageAfterFailedLogin() {
        loginPage.open();
        loginPage.enterCredentials(validEmail, incorrectPassword);
        loginPage.submitCredentials();
        WebDriverWait waitForErrorToLoad = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForErrorToLoad.until(ExpectedConditions.visibilityOfElementLocated(loginPage.incorrectEmailError));
        String message = loginPage.incorrectEmailMsg();
        System.out.println("Unable to log in. " + message);
    }

    @Test(priority = 1, groups = {"Smoke, Regression"})
    public void validateCheckboxIsSelectedByDefault() {
        loginPage.open();
        boolean isRememberMeSelected = loginPage.checkboxIsSelected();
        if (isRememberMeSelected) {
            System.out.println("Remember me checkbox is checked by default");
        } else {
            System.out.println("Remember me checkbox is NOT checked by default");
        }

    }



}
