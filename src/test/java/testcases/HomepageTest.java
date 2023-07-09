package testcases;

import org.testng.annotations.Test;

public class HomepageTest extends BaseTest {

    @Test
    public void gotoMainPage() {
        super.homePage.open();
        boolean logo = homePage.logoLoaded();
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
    }

    @Test
    public void goToSignInPage() {
        super.homePage.open();
        homePage.clickSignInBtn();
        boolean isLoginFields = loginPage.loginInputFieldsExist();
        if (isLoginFields == true) {
            System.out.println("Sign in page opens successfully");
        } else {
            System.out.println("Failed to open Sign In Page");
        }
    }

}
