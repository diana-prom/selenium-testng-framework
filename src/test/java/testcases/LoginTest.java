package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

public class LoginTest extends BaseTest {
    private String validEmail = "random@email.com";
    private String incorrectPassword = "!@df";

    @Test
    public void validateLoginInputFieldsAndButton() {
        loginPage.open();
        boolean inputFieldsAndButton = loginPage.loginInputFieldsExist();
        if (inputFieldsAndButton) {
            System.out.println("Email field, Password field and Login button are displayed on Sign In page");
        } else {
            System.out.println("Email field, Password field and Login button did not load");
        }

    }

    @Test
    public void enterInvalidLoginCredentials() {
        loginPage.open();
        loginPage.enterCredentials(validEmail, incorrectPassword);
        loginPage.submitCredentials();
    }

    @Test
    public void findsErrorMessageAfterFailedLogin() throws InterruptedException {
        loginPage.open();
        loginPage.enterCredentials(validEmail, incorrectPassword);
        loginPage.submitCredentials();
        Thread.sleep(4000);
        String message = loginPage.incorrectEmailMsg();
        System.out.println("Unable to log in. " + message);
    }

    @Test
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
