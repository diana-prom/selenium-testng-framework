package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HomepageTest extends BaseTest {


    @Test(priority = 0, groups = {"Smoke"})
    public void gotoMainPage() {
        homePage.open();
     /*   boolean logo = homePage.logoLoaded();
        boolean galleryLink = homePage.galleryLinkLoaded();
        boolean buttons = homePage.buttonsLoaded();

        if (logo) {
            System.out.println("Found logo: " + logo);
        }
        if (galleryLink) {
            System.out.println("Found gallery link: " + galleryLink);
        }
        if (buttons) {
            System.out.println("Found sign in and sign up buttons: " + buttons);

        }
        if (logo && galleryLink && buttons) {
            System.out.println("Landing page loaded successfully");
        }
        */
        SoftAssert softAssert = new SoftAssert();
        Integer expected = 200;
        List<Integer> codes = homePage.urlVerification();
        System.out.println(codes);
        for (Integer code : codes) {
            softAssert.assertEquals(code, expected);
        }
        softAssert.assertAll();
    }


    @Test(priority = 1, groups = "Smoke")
    public void goToSignInPage() {
        homePage.open();
        homePage.clickSignInBtn();
        boolean isLoginFields = loginPage.loginInputFieldsExist();
        if (isLoginFields == true) {
            System.out.println("Sign in page opens successfully");
        } else {
            System.out.println("Failed to open Sign In Page");
        }
    }


}
