package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class StudyPage extends BaseMain {
    public StudyPage(ChromeDriver driver, Logger log) {
        super(driver, log);
    }

    // public String studyUrl = "https://test.my-fork.com/study";
    //GUI elements xpaths
    public String searchInputField = "//input[@id='search']";
    public String topicList = "//div[@class='study-topic-item']/div[3]";
    public String materialsCount = "//div[@class='study-topic-item']/div[4]";
    public String btnStudyLocator = ("//a[contains(@id, 'study-link')]");
    public List<String> expectedTopics = Arrays.asList("Java", "ISTQB", "SQL", "Test Automation", "Data Analytics", "Testing", "Agile", "Common Interview Questions", "Version Control", "Cucumber", "Waterfall", "Bug Reporting", "Business Analysis", "Waterfall vs Agile", "Test cases", "Software Development Architectures", "Ad Hoc Testing");





    public void openStudyPage() {
        clickUsingXpath(btnStudyLocator, "Study button");
    }

    public void searchBy(String parameter) {
        driver.findElement(By.xpath(searchInputField)).sendKeys(parameter);
    }

    public List<String> getTopicsList() {
        List<String> topics = new ArrayList<>();
        List<WebElement> studyItems = driver.findElements(By.xpath(topicList));
        for (int i = 0; i < studyItems.size(); i++) {
            topics.add(studyItems.get(i).getText());
        }
        return topics;
    }

    public List<String> getNumberOfMaterialsList() {
        List<String> list = new ArrayList<>();
        List<WebElement> countMaterialsPerTopic = driver.findElements(By.xpath(materialsCount));
        for (int i = 0; i < countMaterialsPerTopic.size(); i++) {
            list.add(countMaterialsPerTopic.get(i).getText());
        }
        return list;
    }

    public int countSearchResults(List<String> list) {
        return list.size();
    }

    public void verifyDefaultListOfTopics() {
        List<String> actualTopics = getTopicsList();
        validateListOfStringWithAssertEqual(actualTopics, expectedTopics, "The list of topics is incorrect");
    }

    public int numberOfTopicsBySubstringInList(String parameter, List<String> list) {
        int counter = 0;
        for (String element : list) {
            //converted string to lowercase since contains() is case-sensitive
            if (element.toLowerCase().contains(parameter)) {
                counter += 1;
            }
        }
        return counter;
    }
}
