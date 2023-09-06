package testcases;

import org.testng.annotations.Test;

import java.util.List;

public class StudyTest extends BaseTest {


    @Test
    public void listOfTopicsWithoutSearch() {
        homePage.open();
        courseGalleryPage.open();
        studyPage.openStudyPage();
        studyPage.verifyDefaultListOfTopics();
    }

    @Test
    public void validateSearchResultsByTopic() {
        String parameter = "es";
        int expectedNumberOfTopics = 7;
        homePage.open();
        courseGalleryPage.open();
        studyPage.openStudyPage();
        studyPage.searchBy(parameter);
        List<String> list = studyPage.getTopicsList();

        int actualNumberOfTopics = studyPage.countSearchResults(list);
        studyPage.validateIntWithAssertEqual(actualNumberOfTopics, expectedNumberOfTopics);
        System.out.println("Number of topics found: " + actualNumberOfTopics);

        int actualNumberOfTopicsBySubstringInString = studyPage.numberOfTopicsBySubstringInList(parameter, list);
        studyPage.validateIntWithAssertEqual(actualNumberOfTopicsBySubstringInString, expectedNumberOfTopics);
        System.out.println("'" + parameter + "'" + " was found in all topics. Search results found " + actualNumberOfTopicsBySubstringInString + " topic(s).");
    }

    @Test
    public void validateSearchResultsByNumberOfMaterials() {
        String parameter = "66";
        int expectedTotalSearchResults = 1;
        homePage.open();
        courseGalleryPage.open();
        studyPage.openStudyPage();
        studyPage.searchBy(parameter);
        List<String> list = studyPage.getNumberOfMaterialsList();

        int actualTotalSearchResults = studyPage.countSearchResults(list);
        studyPage.validateIntWithAssertEqual(actualTotalSearchResults, expectedTotalSearchResults);
        System.out.println("Number of topics found by searching number of materials : " + actualTotalSearchResults);


        int actualNumberOfTopicsHavingSubstringInString = studyPage.numberOfTopicsBySubstringInList(parameter, list);
        studyPage.validateIntWithAssertEqual(actualNumberOfTopicsHavingSubstringInString, expectedTotalSearchResults);
        System.out.println("'" + parameter + "'" + " was found in all topics. Search results found " + actualNumberOfTopicsHavingSubstringInString + " topic(s).");

    }
}


