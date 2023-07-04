package testcases;

import org.testng.annotations.Test;

public class ConditionsTest {

    @Test
    public void testIfElseConditionalStatements() {
        int income = 10296;

        if (income >= 0 && income <= 10275) {
            System.out.println("your tax will be 10%$");
        } else if (income >= 10276 && income <= 41775) {
            System.out.println("your tax will be 12%");
        } else if (income >= 41776 && income <= 89075) {
            System.out.println("your tax will be 22%");
        } else {
            System.out.println("please call your CPA");
        }
    }

    @Test
    public void testSwitchStatement() {
        String department = "HR";
        switch (department) {
            case "Sales":
                System.out.println("Sales department works from 8am to 12pm.");
                break;
            case "Operations":
                System.out.println("Operations department works from 8am to 5pm.");
                break;
            case "HR":
                System.out.println("Human Resources department works from 8am to 5pm.");
                break;
            case "CS":
                System.out.println("CS department works from 8am to 6pm.");
                break;
            case "Security":
                System.out.println("Implementation department works from 12am to 8:30pm.");
                break;
            case "Engineering":
                System.out.println("Engineering department works from 8am to 5pm.");
                break;
        }


    }

    @Test
    public void testForLoop() {

        for (int i = 0; i < 24; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
