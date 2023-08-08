
package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.logging.Logger;

public class LoginPage extends BaseMain {
    public LoginPage(ChromeDriver driver, Logger log) {

        super(driver, log);
    }

    public String loginUrl = "https://test.my-fork.com/login";
    public String emailInputField = "//input[@id='email']";
    public String passInputField = "//input[@id='password']";
    public String loginButton = "//button[contains(text(),'Log In')]";
    public By rememberMeCheckbox = By.xpath("//input[@id='auth-page-remember-me']");
    //error messages on login page
    public By incorrectEmailError = By.xpath("//p[contains(text(),'Error: email is incorrect')]");


    public void open() {

        driver.get(loginUrl);
    }

    public void enterCredentials(String validEmail, String incorrectPassword) {
        typeUsingXpath(emailInputField, " email input field ", validEmail);
        typeUsingXpath(passInputField, " password input field ", incorrectPassword);
    }


    public void submitCredentials() {
        isDisplayedUsingXpath(loginButton, "login button");
        clickUsingXpath(loginButton, "login button");
    }

    public void userLogsIn(String correctEmail, String correctPassword) {
        typeUsingXpath(emailInputField, " email input field ", correctEmail);
        typeUsingXpath(passInputField, " password input field ", correctPassword);
        submitCredentials();
    }

    public boolean loginInputFieldsExist() {
        boolean emailInput = isDisplayedUsingXpath(emailInputField, "email input field");
        boolean passwordInput = isDisplayedUsingXpath(passInputField, "password input field");
        boolean loginBtn = isDisplayedUsingXpath(loginButton, "login button");
        return emailInput && passwordInput && loginBtn;
    }

    public String incorrectEmailMsg() {
        String errMessage = driver.findElement(incorrectEmailError).getText();
        return errMessage;
    }

    public boolean checkboxIsSelected() {
        boolean rememberMeIsSelected = driver.findElement(rememberMeCheckbox).isSelected();
        return rememberMeIsSelected;
    }

}
