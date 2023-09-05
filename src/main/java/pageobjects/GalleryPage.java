package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class GalleryPage extends BaseMain {
    public String galleryUrl = "https://test.my-fork.com/quizzes-list";
    public By expertise = By.xpath("//*[@id='app']/div[2]/div[2]/div");
    public String historyLink = "//a[contains(text(),'History')]";
    public String basicQuizTotal = "//span[contains(text(),'SQL 101 (Basics)')]/../../../div[2]/div[1]";
    public String getBasicQuizStartButton = "//body/div[@id='app']/div[2]/div[3]/div[2]/div[2]/a[1]/div[1]";
    public String progressData = "//div[@id= 'quiz-process-progress-data']";
    public String answeredQuestion = "//div[contains(@class,'answered')]";
    public String selectedAnswerFromQuestionContainer = "//div[contains(@class,'answers-block-item active')]";
    public String questions = "//div[contains(text(),'SQL 101 (Basics)')]/../div/div";
    public String firstAnswer = "//div[@data-answer-id='0']";
    public String nextButton = "//div[contains(text(),'Next')]";
    public By homePageLink = By.xpath("//img[@id='logo']");
    public String previousProgressData = "";
    public int questionsCounter = 0;

    public GalleryPage(ChromeDriver driver, Logger log) {
        super(driver, log);
    }

    public void open() {
        driver.get(galleryUrl);
    }

    public boolean isHistoryPresent() {
        try {
            return isDisplayedUsingXpath(historyLink, "history link");
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
        String quizTotal = getHeaderTextUsingXpath(basicQuizTotal, "Total number of answers over Total number of questions");

        String[] arrOfStr = quizTotal.split("/");
        return arrOfStr[1];
    }

    public void startBasicQuiz() {
        clickUsingXpath(getBasicQuizStartButton, "Start button for the Basic Quiz");
    }

    public void selectFirstQuestion() {
        clickUsingXpath(firstAnswer, "First answer");
    }

    public String displayedProgress() {
        String data = getHeaderTextUsingXpath(progressData, "Progress data");

        String[] arrOfStr = data.split("%");
        return arrOfStr[0];
    }


    public String getProgressData() {

        int totalQuestions = getListSize(questions, "total number of questions");

        int totalAnsweredQuestions = getNumberOfAnsweredQuestions();

        //(correct value = number of answered questions / total number of questions)
        float value = (float) totalAnsweredQuestions / (float) totalQuestions;
        int correctValue = (int) (value * 100);

        previousProgressData = String.valueOf(correctValue);
        countNumberOfQuestions();
        return previousProgressData;
    }

    public void clickNextButton() {
        clickUsingXpath(nextButton, "Next button");
    }

    public int getNumberOfSelectedAnswers() {
        return getListSize(selectedAnswerFromQuestionContainer, "total number of selected answers");
    }

    public int getNumberOfAnsweredQuestions() {
        return getListSize(answeredQuestion, "total number of answered questions");
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
