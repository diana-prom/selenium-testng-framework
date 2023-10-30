package testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;


public class LoginTest extends BaseTest {
    private String validEmail = "random@email.com";
    private String incorrectPassword = "!@df";


    @Test(priority = 0, dataProvider = "LoginInfo", groups = {"Regression"})
    public void Login(String email, String password, String isButtonDisplayed) throws InterruptedException{
        loginPage.open();
        loginPage.enterCredentials(email, password);
        boolean expected = Boolean.parseBoolean(isButtonDisplayed);
        Assert.assertEquals(loginPage.loginButtonExists(), expected);
        loginPage.submitCredentials();
    }

    @Test(priority = 3, groups = {"Smoke"})
    public void validateLoginInputFieldsAndButton() {
        loginPage.open();
        boolean inputFieldsAndButton = loginPage.loginInputFieldsExist();
        if (inputFieldsAndButton) {
            System.out.println("Email field, Password field and Login button are displayed on Sign In page");
        } else {
            System.out.println("Email field, Password field and Login button did not load");
        }

    }

    @Test(priority = 4, groups = {"Regression"})
    public void enterInvalidLoginCredentials() {
        loginPage.open();
        loginPage.enterCredentials(validEmail, incorrectPassword);
        loginPage.submitCredentials();
    }

    @Test(priority = 5, groups = {"Regression"})
    public void findsErrorMessageAfterFailedLogin() {
        loginPage.open();
        loginPage.enterCredentials(validEmail, incorrectPassword);
        loginPage.submitCredentials();
        WebDriverWait waitForErrorToLoad = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForErrorToLoad.until(ExpectedConditions.visibilityOfElementLocated(loginPage.incorrectEmailError));
        String message = loginPage.incorrectEmailMsg();
        System.out.println("Unable to log in. " + message);
    }

    @Test(priority = 2, groups = {"Smoke, Regression"})
    public void validateCheckboxIsSelectedByDefault() {
        loginPage.open();
        boolean isRememberMeSelected = loginPage.checkboxIsSelected();
        if (isRememberMeSelected) {
            System.out.println("Remember me checkbox is checked by default");
        } else {
            System.out.println("Remember me checkbox is NOT checked by default");
        }
    }

    @Test(priority = 1, groups = {"Regression"})
    public void urlVerification() {
        SoftAssert softAssert = new SoftAssert();
        Integer expected = 200;
        loginPage.open();
        List<Integer> codes = loginPage.urlVerification();
        System.out.println(codes);
        for(Integer code: codes){
            softAssert.assertEquals(code, expected);
        }
        softAssert.assertAll();
    }
}
