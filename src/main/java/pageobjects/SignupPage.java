package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SignupPage extends BaseMain {
    public SignupPage(ChromeDriver driver) {
        super(driver);
    }

    public String signupUrl = "https://test.my-fork.com/register";

    public void open() {
        driver.get(signupUrl);
    }

    public By jobTitleDropdown = By.id("job-title");

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
            if(options.get(i).getText() != ""){
                jobsList.add(options.get(i).getText());
            }
        }
        return jobsList;
    }

}
