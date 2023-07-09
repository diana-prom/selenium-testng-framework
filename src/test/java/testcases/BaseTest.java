package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.SignupPage;

public class BaseTest {

    public ChromeDriver driver;
    public ChromeOptions options;
    HomePage homePage;
    LoginPage loginPage;
    SignupPage signupPage;
    private String chromeDriverKey = "webdriver.chrome.driver";
    private String chromeDriverPath = "/Users/dianatinajero/IdeaProjects/SeleniumProject/src/test/resources/executables/chromedriver";

    @BeforeMethod
    public void setUp() {
        System.setProperty(chromeDriverKey, chromeDriverPath);
        options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        signupPage = new SignupPage(driver);
    }


    @AfterMethod
    public void TearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
