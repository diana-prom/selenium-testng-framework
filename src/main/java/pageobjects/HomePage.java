package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.logging.Logger;

public class HomePage extends BaseMain {
    public HomePage(ChromeDriver driver, Logger log) {
        super(driver, log);
    }

    public String mainUrl = "https://test.my-fork.com/";
    public By logo = By.xpath("//img[@id='home-my-fork-logo']/.. ");
    public By galleryLink = By.xpath("//div[@class='menu']/a[1]");
    public By goToSignInBtn = By.xpath("//div[@id='log-in-button']/..");
    public By goToSignUpBtn = By.xpath("//div[contains (text(),'Sign Up')]/..");

    public void open() {
        driver.get(mainUrl);
    }

    public List<Integer> urlVerification() {
        return verifyLinkActive();
    }

    public void clickSignInBtn() {
        driver.findElement(goToSignInBtn).click();
    }


    public boolean logoLoaded() {
        boolean logoExists = driver.findElement(logo).isDisplayed();
        return logoExists;
    }

    public boolean galleryLinkLoaded() {
        boolean galleryLnkExists = driver.findElement(galleryLink).isDisplayed();
        return galleryLnkExists;
    }

    public void goToGallery() {
        driver.findElement(galleryLink).click();
    }

    public boolean buttonsLoaded() {
        boolean signInBtnExists = driver.findElement(goToSignInBtn).isDisplayed();
        return signInBtnExists;
    }

}