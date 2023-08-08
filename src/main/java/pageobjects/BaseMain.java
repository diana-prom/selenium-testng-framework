package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class BaseMain {

    public ChromeDriver driver;
    public Logger log;

    public int tab;
    public int pixels;

    public BaseMain(ChromeDriver driver, Logger logger) {

        this.driver = driver;
        this.log = logger;
    }

    public void clickUsingXpath(String xpath, String elementName) {
        driver.findElement(By.xpath(xpath)).click();
        log.info("Element: " + elementName + " was successfully clicked");
    }

    public void typeUsingXpath(String xpath, String elementName, String value) {
        driver.findElement(By.xpath(xpath)).sendKeys(value);
        log.info("Value: " + value + " was successfully entered into" + elementName);
    }

    public int getListSize(String xpath, String elementName) {
        List<WebElement> listSize = driver.findElements(By.xpath(xpath));
        log.info("Element: " + elementName + " is " + listSize.size());
        return listSize.size();
    }

    public String getHeaderTextUsingXpath(String xpath, String elementName) {
        String text = driver.findElement(By.xpath(xpath)).getText();
        log.info("Element: " + elementName + " is " + text);

        return text;
    }

    public boolean isDisplayedUsingXpath(String xpath, String elementName) {
        Boolean isDisplayed = driver.findElement(By.xpath(xpath)).isDisplayed();
        log.info("Element " + elementName + " loaded successfully");
        return isDisplayed;
    }

    public void windowHandling(int tab) {
        List<String> tabHandler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabHandler.get(tab));
    }

    public void scrollWindow(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + "+)", "");
    }

}
