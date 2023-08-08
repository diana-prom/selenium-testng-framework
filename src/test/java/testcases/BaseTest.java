package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.GalleryPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.SignupPage;

import java.io.IOException;
import java.time.Duration;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BaseTest {

    private String chromeDriverKey = "webdriver.chrome.driver";
    private String chromeDriverPath = "/Users/dianatinajero/IdeaProjects/SeleniumProject/src/test/resources/executables/chromedriver";
    public ChromeDriver driver;
    public Logger log;
    public ChromeOptions options;
    HomePage homePage;
    LoginPage loginPage;
    SignupPage signupPage;
    GalleryPage courseGalleryPage;

    @BeforeMethod(groups = {"Smoke", "Acceptance", "Functional", "Regression"}, alwaysRun = true)
    public void setUp() throws IOException {
        System.setProperty(chromeDriverKey, chromeDriverPath);
        options = new ChromeOptions();
        driver = new ChromeDriver(options);
        log = Logger.getLogger(getClass().getName());
        saveLogs(log);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        homePage = new HomePage(driver, log);
        loginPage = new LoginPage(driver, log);
        signupPage = new SignupPage(driver, log);
        courseGalleryPage = new GalleryPage(driver, log);
    }


    @AfterMethod(groups = {"Smoke", "Acceptance", "Functional", "Regression"}, alwaysRun = true)
    public void TearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void saveLogs(Logger log) throws IOException {
        FileHandler fileHandler;
        fileHandler = new FileHandler("/Users/dianatinajero/IdeaProjects/SeleniumProject/MyLogs.log");
        log.addHandler(fileHandler);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        log.info("Starting test suite now");
    }
}
