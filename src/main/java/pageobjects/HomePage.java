package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage extends BaseMain {
    public HomePage(ChromeDriver driver) {
        super(driver);
    }

    public String mainUrl = "https://test.my-fork.com/";
    public By logo = By.xpath("//img[@id='home-my-fork-logo']/.. ");
    public By galleryLink = By.xpath("//div[@class='menu']/a[1]");
    public By goToSignInBtn = By.xpath("//div[@id='log-in-button']/..");
    public By goToSignUpBtn = By.xpath("//div[contains (text(),'Sign Up')]/..");

    public void open() {
        driver.get(mainUrl);
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

    public boolean buttonsLoaded() {
        boolean signInBtnExists = driver.findElement(goToSignInBtn).isDisplayed();
        return signInBtnExists;
    }

}