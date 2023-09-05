package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SignupPage extends BaseMain {
    public SignupPage(ChromeDriver driver, Logger log) {
        super(driver, log);
    }

    public String signupUrl = "https://test.my-fork.com/register";
    public String expectedSignupPageTitle = "Sign Up";
    public By header = By.xpath("//div[contains (text(),'Sign Up')]");
    public By loginLink = By.xpath("//a[contains(text(),'Log In')]");
    public By jobTitleDropdown = By.id("job-title");

    public void open() {
        driver.get(signupUrl);
    }


    public List<String> getDropdown() {
        //declared variable of WebElement type
        WebElement jobTitleDropdownElement;
        //declared and initialized a list of String type to store the job titles
        //in human-readable format
        List<String> jobsList = new ArrayList<>();
        //dropdown box locator
        jobTitleDropdownElement = driver.findElement(jobTitleDropdown);
        //Initialized locator to be of an object of 'select' type
        Select jobDropdown = new Select(jobTitleDropdownElement);
        //Initialized a list of type WebElement
        List<WebElement> options = new ArrayList<>();
        //Captures every item in the 'options' list
        options = jobDropdown.getOptions();
        for (int i = 0; i < options.size(); i++) {
            jobsList.add(options.get(i).getText());
        }
        return jobsList;
    }

    public String headerName() {
        return header.toString();
    }

    public boolean isHeaderDisplayed() {
        return driver.findElement(header).isDisplayed();
    }

    public boolean loginLinkIsPresent() {

        return driver.findElement(loginLink).isDisplayed();
    }

    public String actualLoginLInk() {
        return driver.findElement(loginLink).getAttribute("href");

    }

    public List<WebElement> getAllLinks() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        return links;
    }

    public int numberOfLinks() {
        return getAllLinks().size();
    }

    public void linkNames() {

        for (int i = 0; i < getAllLinks().size(); i = i + 1) {
            System.out.println("Link name  #" + i + ": " + getAllLinks().get(i).getText() + " - " + getAllLinks().get(i).getAttribute("href"));
        }

    }

    public List<Integer> urlVerification() {
        return verifyLinkActive();
    }
}