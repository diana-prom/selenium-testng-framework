package testcases;

public class OperatorsTest {
    public static void main(String[] args) {
        String productName = "F11";
        String username = "James";
        String location = "Colorado";
        double price = 80.99;
        int age = 18;

        System.out.println("Good evening, " + username + ". Pack your bags to head out to your next getaway: " + location + ". Your designated seat is " + productName + " . You may upgrade to first class for only $" + price + ". Remember that drinks are on us. Note: You must be " + age + " or older for this offer.");
        Calculations();
    }

    public static void Calculations() {
        int total = 1220;
        double price = 80.99;

        System.out.println("Average: " + total / 5);
        System.out.println("Grand total: " + (total + total));
        System.out.println("Discount: " + (total - 3));
        System.out.println("Multiples: " + ((price * total)));
    }
}
