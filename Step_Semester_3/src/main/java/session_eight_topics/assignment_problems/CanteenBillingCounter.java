import java.util.*;

interface Customer {
    double calculateFinalAmount(double amount);
}

class Student implements Customer {
    public double calculateFinalAmount(double amount) {
        return amount * 0.90;
    }
}

class Staff implements Customer {
    public double calculateFinalAmount(double amount) {
        return amount * 0.95;
    }
}

class Guest implements Customer {
    public double calculateFinalAmount(double amount) {
        return amount + 10;
    }
}

public class CanteenBillingCounter {

    public static Customer createCustomer(String type) {
        switch (type) {
            case "STUDENT":
                return new Student();
            case "STAFF":
                return new Staff();
            case "GUEST":
                return new Guest();
            default:
                throw new IllegalArgumentException("Invalid customer type");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer = createCustomer(type);
            double finalAmount = customer.calculateFinalAmount(amount);

            total += finalAmount;

            System.out.printf("%s: %.2f%n", type, finalAmount);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
