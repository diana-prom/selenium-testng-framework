package testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class LessonFourBHomeWorkTest {

    @Test
    public void startPage() {
        System.setProperty("webdriver.chrome.driver", "/Users/dianatinajero/IdeaProjects/SeleniumProject/src/test/resources/executables/chromedriver");
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.close();
    }

    @Test
    public void openMainWebsite() {
        System.setProperty("webdriver.chrome.driver", "/Users/dianatinajero/IdeaProjects/SeleniumProject/src/test/resources/executables/chromedriver");
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://test.my-fork.com/");
        System.out.println("Found logo: " + driver.findElement(By.xpath("//img[@id='home-my-fork-logo']/.. ")).isDisplayed());
        System.out.println("Found gallery link: " + driver.findElement((By.xpath("//div[@class='menu']/a[1]"))).isDisplayed());
        System.out.println("Found sign in button: " + driver.findElement(By.xpath("//div[@id='log-in-button']/..")).isDisplayed());
        System.out.println("Found sign up button: " + driver.findElement(By.xpath("//div[contains (text(),'Sign Up')]/..")).isDisplayed());
        System.out.println("Landing page loaded successfully");
        driver.quit();
    }

    @Test
    public void goToSignInPage() {
        System.setProperty("webdriver.chrome.driver", "/Users/dianatinajero/IdeaProjects/SeleniumProject/src/test/resources/executables/chromedriver");
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://test.my-fork.com/");
        driver.findElement(By.xpath("//div[@id='log-in-button']/..")).click();
        System.out.println("Sign in page opens successfully");
        driver.quit();
    }

    @Test
    public void validateLoginInputFieldsAndButton() {
        System.setProperty("webdriver.chrome.driver", "/Users/dianatinajero/IdeaProjects/SeleniumProject/src/test/resources/executables/chromedriver");
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://test.my-fork.com/login");
        driver.findElement(By.xpath("//input[@id='email']")).isDisplayed();
        driver.findElement(By.xpath("//input[@id='password']")).isDisplayed();
        driver.findElement(By.xpath("//button[contains(text(),'Log In')]")).isDisplayed();
        System.out.println("Email field, Password field and Login button are displayed on Sign In page");
        driver.quit();
    }

    @Test
    public void enterInvalidLoginCredentials() {
        System.setProperty("webdriver.chrome.driver", "/Users/dianatinajero/IdeaProjects/SeleniumProject/src/test/resources/executables/chromedriver");
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://test.my-fork.com/login");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("random@email.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("!@df");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("!@df");
        driver.findElement(By.xpath("//button[contains(text(),'Log In')]")).click();
        driver.quit();
    }

    @Test
    public void findsErrorMessageAfterFailedLogin() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/dianatinajero/IdeaProjects/SeleniumProject/src/test/resources/executables/chromedriver");
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://test.my-fork.com/login");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("random@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("!@df");
        driver.findElement(By.xpath("//button[contains(text(),'Log In')]")).click();
        Thread.sleep(4000);
        System.out.println("Found error message: " + driver.findElement(By.xpath("//p[contains(text(),'Error: email is incorrect')]")).isDisplayed());
        driver.quit();
    }

    @Test
    public void validateCheckboxIsSelectedByDefault() {
        System.setProperty("webdriver.chrome.driver", "/Users/dianatinajero/IdeaProjects/SeleniumProject/src/test/resources/executables/chromedriver");
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://test.my-fork.com/login");
        System.out.println("Remember me checkbox is checked by default: " + driver.findElement(By.xpath("//input[@id='auth-page-remember-me']")).isSelected());
        driver.quit();
    }

}
