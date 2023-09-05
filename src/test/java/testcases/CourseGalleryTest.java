package testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;


public class CourseGalleryTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();
    List<String> expectedCourseOptions = Arrays.asList("Development", "Testing", "Business Analysis", "Agile", "Project Management");
    private String correctEmail = "testing@my-fork.com";
    private String correctPassword = "Password";

    @Test
    public void historyAvailableForLoggedInUsersOnly() {
        homePage.open();
        homePage.goToGallery();


        softAssert.assertFalse(courseGalleryPage.isHistoryPresent(), "History is actually available for users who have not logged in");
        System.out.println("History is NOT available for users who have not logged in: true");

        courseGalleryPage.returnToHomePage();

        homePage.clickSignInBtn();
        loginPage.userLogsIn(correctEmail, correctPassword);
        homePage.goToGallery();
        softAssert.assertTrue(courseGalleryPage.isHistoryPresent(), "History is NOT available for logged in users.");
        System.out.println("History is available for logged in users: " + courseGalleryPage.isHistoryPresent());

        softAssert.assertAll();

    }

    @Test
    public void validateAllCourseOptions() {
        homePage.open();
        courseGalleryPage.open();
        List<String> actualCourseOptions = courseGalleryPage.getAllExpertiseAreas();
        Assert.assertEquals(expectedCourseOptions, actualCourseOptions, "One of the options is different.");
    }

    @Test
    public void validateQuizProgressBarFunctionality() {
        homePage.open();
        courseGalleryPage.open();
        courseGalleryPage.getGrandTotalFromBasicQuiz();


        //Check we don't have other windows open already
        assert driver.getWindowHandles().size() == 1;

        courseGalleryPage.startBasicQuiz();


        WebDriverWait waitForNewWindow = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForNewWindow.until(ExpectedConditions.numberOfWindowsToBe(2));

        //switched to second window
        courseGalleryPage.windowHandling(1);

        courseGalleryPage.selectFirstQuestion();

        String expectedProgress = courseGalleryPage.displayedProgress();
        String firstActualProgress = courseGalleryPage.getProgressData();


        Assert.assertEquals(expectedProgress, firstActualProgress);
        System.out.println("Progress data is correct after selecting answer on first question. Expected data: " + expectedProgress + " Actual data: " + firstActualProgress);


        courseGalleryPage.clickNextButton();
        String actualSecondProgressData = courseGalleryPage.displayedProgress();

        /*Assert that progress bar has changed after clicking next button
         * Value will be the same since user has not selected an answer yet
         */
        softAssert.assertNotEquals(actualSecondProgressData, firstActualProgress, "Progress bar did not change.");


        //Assert that progress bar value is correct
        softAssert.assertFalse(courseGalleryPage.isProgressDataCorrect(), "Progress bar value is incorrect!");

        System.out.println("Value is correct. User selected " + courseGalleryPage.getNumberOfSelectedAnswers() + " answers while on question number " + courseGalleryPage.questionsCounter);

        softAssert.assertAll();

    }
}
