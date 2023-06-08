package testcases;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class FirstTest {
@Test
    public void startPage() {
    System.setProperty("webdriver.chrome.driver", "/Users/dianatinajero/IdeaProjects/SeleniumProject/src/test/resources/executables/chromedriver");
    ChromeOptions options = new ChromeOptions();
    ChromeDriver driver = new ChromeDriver(options);
    driver.get("https://www.yahoo.com/");
  }
}
