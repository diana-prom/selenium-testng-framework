package testcases;

import org.testng.annotations.Test;

import java.util.List;

public class SignupTest extends BaseTest {

    @Test
    public void validateAllSupportedRolesInDropdownList() {
        super.signupPage.open();
        List<String> jobTitles = signupPage.getDropdown();
        System.out.println("Dropdown list has the following job titles: " + jobTitles);
    }

}
