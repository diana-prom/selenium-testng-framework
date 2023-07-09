package pageobjects;

import org.openqa.selenium.chrome.ChromeDriver;

public class BaseMain {

    public ChromeDriver driver;
    HomePage homePage;
    LoginPage loginPage;

    public BaseMain(ChromeDriver driver) {
        this.driver = driver;
    }


}
