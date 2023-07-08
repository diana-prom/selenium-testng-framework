package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaOOP {

    public ChromeDriver driver;
    public ChromeOptions options;
    private String chromeDriverKey = "webdriver.chrome.driver";
    private String chromeDriverPath = "/Users/dianatinajero/IdeaProjects/SeleniumProject/src/test/resources/executables/chromedriver";
    public String loginUrl = "https://test.my-fork.com/login";
    public String mainUrl = "https://test.my-fork.com/";

    //Landing page locators
    public String logo = "//img[@id='home-my-fork-logo']/.. ";
    public String galleryLink = "//div[@class='menu']/a[1]";
    public String goToSignInBtn = "//div[@id='log-in-button']/..";
    public String goToSignUpBtn = "//div[contains (text(),'Sign Up')]/..";

    //Login page locators
    private String emailInputField = "//input[@id='email']";
    private String passInputField = "//input[@id='password']";
    //buttons on login page
    public String loginButton = "//button[contains(text(),'Log In')]";
    //checkbox on login page
    public String rememberMeCheckbox = "//input[@id='auth-page-remember-me']";
    //error messages on login page
    public String incorrectEmailError = "//p[contains(text(),'Error: email is incorrect')]";
    //input values to log in
    private String validEmail = "random@email.com";
    private String incorrectPassword = "!@df";


    @BeforeMethod
    public void setUp() {
        System.setProperty(chromeDriverKey, chromeDriverPath);
        options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void startPage() {
        driver.get(mainUrl);
        System.out.println("Found logo: " + driver.findElement(By.xpath(logo)).isDisplayed());
        System.out.println("Found gallery link: " + driver.findElement((By.xpath(galleryLink))).isDisplayed());
        System.out.println("Found sign in button: " + driver.findElement(By.xpath(goToSignInBtn)).isDisplayed());
        System.out.println("Found sign up button: " + driver.findElement(By.xpath(goToSignUpBtn)).isDisplayed());
        System.out.println("Landing page loaded successfully");
    }

    @Test
    public void goToSignInPage() {
        driver.get(mainUrl);
        driver.findElement(By.xpath(goToSignInBtn)).click();
        System.out.println("Sign in page opens successfully");
    }

    @Test
    public void validateLoginInputFieldsAndButton() {
        driver.get(loginUrl);
        driver.findElement(By.xpath(emailInputField)).isDisplayed();
        driver.findElement(By.xpath(passInputField)).isDisplayed();
        driver.findElement(By.xpath(loginButton)).isDisplayed();
        System.out.println("Email field, Password field and Login button are displayed on Sign In page");
    }

    @Test
    public void enterInvalidLoginCredentials() {
        driver.get(loginUrl);
        driver.findElement(By.xpath(emailInputField)).sendKeys(validEmail);
        driver.findElement(By.xpath(passInputField)).sendKeys(incorrectPassword);
        driver.findElement(By.xpath(loginButton)).click();
    }

    @Test
    public void findsErrorMessageAfterFailedLogin() throws InterruptedException {
        driver.get(loginUrl);
        driver.findElement(By.xpath(emailInputField)).sendKeys(validEmail);
        driver.findElement(By.xpath(passInputField)).sendKeys(incorrectPassword);
        driver.findElement(By.xpath(loginButton)).click();
        Thread.sleep(4000);
        System.out.println("Unable to log in due to " + driver.findElement(By.xpath(incorrectEmailError)).getText());
    }

    @Test
    public void validateCheckboxIsSelectedByDefault() {
        driver.get(loginUrl);
        System.out.println("Remember me checkbox is checked by default: " + driver.findElement(By.xpath(rememberMeCheckbox)).isSelected());
    }

    @AfterMethod
    public void TearDown() {
        driver.quit();
    }

}
