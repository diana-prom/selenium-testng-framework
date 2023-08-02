package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions extends BaseTest {


    @Test
    public void signupPageLoadedPerRequirements() {
        signupPage.open();
        //assert page title is correct
        String actualSignupPageTitle = driver.getTitle();
        Assert.assertEquals(signupPage.expectedSignupPageTitle, actualSignupPageTitle);
        System.out.println("Correct page title: found \'" + actualSignupPageTitle + "\'");

        //assert header is displayed
        String actualHeader = signupPage.headerName();
        Assert.assertTrue(signupPage.isHeaderDisplayed(), "Actual header was not found. Instead it returned exception: " + signupPage.isHeaderDisplayed());
        System.out.println("Found header: " + signupPage.isHeaderDisplayed());


        //assert login link is displayed
        Assert.assertTrue(signupPage.loginLinkIsPresent(), "login link was not found: " + signupPage.loginLinkIsPresent());
        System.out.println("Login link is displayed: " + signupPage.loginLinkIsPresent());

        //assert login link is correct
        String expectedSigninLink = "https://test.my-fork.com/login";
        Assert.assertEquals(expectedSigninLink, signupPage.actualLoginLInk());
        System.out.println("Login link is correct: found " + signupPage.actualLoginLInk());

        //assert number of links
        int actualNumberOfLinkRedirectingToDiffPage = 3;
        int totalNumberOfLinks = signupPage.numberOfLinks();
        System.out.println("Number of Links found " + totalNumberOfLinks);
        signupPage.linkNames();
        Assert.assertEquals(actualNumberOfLinkRedirectingToDiffPage, totalNumberOfLinks);

    }


}
