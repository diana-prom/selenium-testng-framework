package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertions extends BaseTest {

    @Test
    public void signupPageLoaded() {
        SoftAssert softAssert = new SoftAssert();
        signupPage.open();
        //assert page title is correct
        String actualSignupPageTitle = driver.getTitle();
        softAssert.assertEquals(signupPage.expectedSignupPageTitle, actualSignupPageTitle);
        System.out.println("Correct page title: found \'" + actualSignupPageTitle + "\'");

        //assert header is NOT displayed
        String actualHeader = signupPage.headerName();
        softAssert.assertFalse(signupPage.isHeaderDisplayed(), "Actual header was found. Instead it returned exception: " + signupPage.isHeaderDisplayed());
        System.out.println("Should have not found header. Instead, it exists on page: " + signupPage.isHeaderDisplayed());

        //assert login link is NOT displayed
        softAssert.assertFalse(signupPage.loginLinkIsPresent(), "login link was found: " + signupPage.loginLinkIsPresent());
        System.out.println("Should have not found Login link. Instead, it exists on page: " + signupPage.loginLinkIsPresent());

        //assert login link is different
        String expectedSigninLink = "https://test.my-fork.com/login";
        softAssert.assertNotEquals(expectedSigninLink, signupPage.actualLoginLInk());
        System.out.println("Login link should be different as expected url: Instead, it found " + signupPage.actualLoginLInk());

        //assert number of links
        int actualNumberOfLinkRedirectingToDiffPage = 3;
        int totalNumberOfLinks = signupPage.numberOfLinks();
        System.out.println("Number of Links found " + totalNumberOfLinks);
        signupPage.linkNames();
        softAssert.assertEquals(actualNumberOfLinkRedirectingToDiffPage, totalNumberOfLinks);
        softAssert.assertAll();
    }

}
