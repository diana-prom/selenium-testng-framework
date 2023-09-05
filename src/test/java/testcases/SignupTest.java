package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SignupTest extends BaseTest {


    @Test(groups = {"Functional", "Regression"})
    public void validateAllSupportedRolesInDropdownList() {
        signupPage.open();
        List<String> jobTitles = signupPage.getDropdown();
        System.out.println("Dropdown list has the following job titles: " + jobTitles);
    }

    @Test(groups = {"Regression"})
    public void urlVerification() {
        SoftAssert softAssert = new SoftAssert();
        Integer expected = 200;
        signupPage.open();
        List<Integer> codes = signupPage.urlVerification();
        System.out.println(codes);
        for (Integer code : codes) {
            softAssert.assertEquals(code, expected);
        }
        softAssert.assertAll();
    }

}
