package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class GalleryPage extends BaseMain {
    public String galleryUrl = "https://test.my-fork.com/quizzes-list";
    public By expertise = By.xpath("//*[@id='app']/div[2]/div[2]/div");
    public By historyLink = By.xpath("//a[contains(text(),'History')]");
    public By basicQuizTotal = By.xpath("//span[contains(text(),'SQL 101 (Basics)')]/../../../div[2]/div[1]");
    public By getBasicQuizStartButton = By.xpath("//body/div[@id='app']/div[2]/div[3]/div[2]/div[2]/a[1]/div[1]");
    public By progressData = By.xpath("//div[@id= 'quiz-process-progress-data']");
    public By answeredQuestion = By.xpath("//div[contains(@class,'answered')]");
    public By selectedAnswerFromQuestionContainer = By.xpath("//div[contains(@class,'answers-block-item active')]");
    public By questions = By.xpath("//div[contains(text(),'SQL 101 (Basics)')]/../div/div");
    public By firstQuestion = By.xpath("//div[@data-answer-id='0']");
    public By nextButton = By.xpath("//div[contains(text(),'Next')]");
    public By homePageLink = By.xpath("//img[@id='logo']");
    public String previousProgressData = "";
    public int questionsCounter = 0;

    public GalleryPage(ChromeDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(galleryUrl);
    }

    public boolean isHistoryPresent() {
        try {
            return driver.findElement(historyLink).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void returnToHomePage() {
        driver.findElement(homePageLink).click();
    }

    public List<String> getAllExpertiseAreas() {
        List<String> expertiseList = new ArrayList<>();
        List<WebElement> expertiseAreas = driver.findElements(expertise);
        for (int i = 0; i < expertiseAreas.size(); i++) {
            expertiseList.add(expertiseAreas.get(i).getText());
        }
        return expertiseList;
    }

    public String getGrandTotalFromBasicQuiz() {
        String quizTotal = driver.findElement(basicQuizTotal).getText();

        String[] arrOfStr = quizTotal.split("/");
        return arrOfStr[1];
    }

    public void startBasicQuiz() {
        driver.findElement(getBasicQuizStartButton).click();
    }

    public void selectFirstQuestion() {
        driver.findElement(firstQuestion).click();
    }

    public String displayedProgress() {
        String data = driver.findElement(progressData).getText();

        String[] arrOfStr = data.split("%");
        return arrOfStr[0];
    }


    public String getProgressData() {

        int totalQuestions = driver.findElements(questions).size();
        int totalAnsweredQuestions = getNumberOfAnsweredQuestions();

        //(correct value = number of answered questions / total number of questions)
        float value = (float) totalAnsweredQuestions / (float) totalQuestions;
        int correctValue = (int) (value * 100);

        previousProgressData = String.valueOf(correctValue);
        countNumberOfQuestions();
        return previousProgressData;
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public int getNumberOfSelectedAnswers() {
        return driver.findElements(selectedAnswerFromQuestionContainer).size();
    }

    public int getNumberOfAnsweredQuestions() {
        return driver.findElements(answeredQuestion).size();
    }

    public Boolean isProgressDataCorrect() {
        String lastData = previousProgressData;

        if ((lastData == getProgressData()) && (getNumberOfSelectedAnswers() == 0)) {
            return true;
        }
        if ((getNumberOfSelectedAnswers() > 0) && (getNumberOfAnsweredQuestions() == questionsCounter)) {
            return true;
        }

        return false;
    }

    public int countNumberOfQuestions() {
        return questionsCounter = questionsCounter + 1;
    }

}
