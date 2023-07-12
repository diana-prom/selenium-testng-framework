package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class BaseMain {

    public ChromeDriver driver;
    public int tab;
    public int pixels;
    public BaseMain(ChromeDriver driver) {
        this.driver = driver;
    }

    public void windowHandling(int tab) {
        List<String> tabHandler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabHandler.get(tab));
    }
    public void scrollWindow(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+pixels+"+)", "");
    }

}
