import java.util.*;

interface PaymentMethod {
    double calculateAmount(double amount);
    String getType();
}

class CardPayment implements PaymentMethod {
    public double calculateAmount(double amount) {
        return amount * 1.02;
    }

    public String getType() {
        return "CARD";
    }
}

class WalletPayment implements PaymentMethod {
    public double calculateAmount(double amount) {
        return amount * 1.01;
    }

    public String getType() {
        return "WALLET";
    }
}

class BankTransferPayment implements PaymentMethod {
    public double calculateAmount(double amount) {
        return amount;
    }

    public String getType() {
        return "BANKTRANSFER";
    }
}

class Transaction {
    private PaymentMethod paymentMethod;
    private double amount;

    public Transaction(PaymentMethod paymentMethod, double amount) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    public double process() {
        return paymentMethod.calculateAmount(amount);
    }

    public String getType() {
        return paymentMethod.getType();
    }
}

public class PaymentSystem {

    public static PaymentMethod createPaymentMethod(String type) {
        switch (type) {
            case "CARD":
                return new CardPayment();
            case "WALLET":
                return new WalletPayment();
            case "BANKTRANSFER":
                return new BankTransferPayment();
            default:
                throw new IllegalArgumentException("Invalid payment type");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");

            String type = input[0];
            double amount = Double.parseDouble(input[1]);

            PaymentMethod method = createPaymentMethod(type);
            Transaction transaction = new Transaction(method, amount);

            double adjustedAmount = transaction.process();
            total += adjustedAmount;

            System.out.printf("%s: %.2f%n", type, adjustedAmount);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}