
package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends BaseMain {
    public LoginPage(ChromeDriver driver) {

        super(driver);
    }

    public String loginUrl = "https://test.my-fork.com/login";
    private By emailInputField = By.xpath("//input[@id='email']");
    private By passInputField = By.xpath("//input[@id='password']");
    public By loginButton = By.xpath("//button[contains(text(),'Log In')]");
    public By rememberMeCheckbox = By.xpath("//input[@id='auth-page-remember-me']");
    //error messages on login page
    public By incorrectEmailError = By.xpath("//p[contains(text(),'Error: email is incorrect')]");


    public void open() {

        driver.get(loginUrl);
    }

    public void enterCredentials(String validEmail, String incorrectPassword) {
        driver.findElement(emailInputField).sendKeys(validEmail);
        driver.findElement(passInputField).sendKeys(incorrectPassword);

    }

    public void submitCredentials() {
        driver.findElement(loginButton).isDisplayed();
        driver.findElement(loginButton).click();
    }

    public boolean loginInputFieldsExist() {
        boolean emailInput = driver.findElement(emailInputField).isDisplayed();
        boolean passwordInput = driver.findElement(passInputField).isDisplayed();
        boolean loginBtn = driver.findElement(loginButton).isDisplayed();
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
