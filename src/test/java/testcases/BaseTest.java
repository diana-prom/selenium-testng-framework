package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.SignupPage;

import java.time.Duration;

public class BaseTest {

    private String chromeDriverKey = "webdriver.chrome.driver";
    private String chromeDriverPath = "/Users/dianatinajero/IdeaProjects/SeleniumProject/src/test/resources/executables/chromedriver";
    public ChromeDriver driver;
    public ChromeOptions options;
    HomePage homePage;
    LoginPage loginPage;
    SignupPage signupPage;

    @BeforeMethod(groups = {"Smoke", "Acceptance", "Functional", "Regression"}, alwaysRun = true)
    public void setUp() {
        System.setProperty(chromeDriverKey, chromeDriverPath);
        options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        signupPage = new SignupPage(driver);
    }


    @AfterMethod(groups = {"Smoke", "Acceptance", "Functional", "Regression"}, alwaysRun = true)
    public void TearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
