import java.util.*;

interface Delivery {
    double calculateFee();
    String getType();
}

class StandardDelivery implements Delivery {
    private double weight;
    private double distance;

    public StandardDelivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public double calculateFee() {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }

    public String getType() {
        return "STANDARD";
    }
}

class ExpressDelivery implements Delivery {
    private double weight;
    private double distance;

    public ExpressDelivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public double calculateFee() {
        return 15 + (1.00 * weight) + (0.20 * distance);
    }

    public String getType() {
        return "EXPRESS";
    }
}

class InternationalDelivery implements Delivery {
    private double weight;
    private double distance;
    private double customsFee;

    public InternationalDelivery(
            double weight, double distance, double customsFee) {
        this.weight = weight;
        this.distance = distance;
        this.customsFee = customsFee;
    }

    public double calculateFee() {
        return 25
                + (2.00 * weight)
                + (0.50 * distance)
                + customsFee;
    }

    public String getType() {
        return "INTERNATIONAL";
    }
}

public class DeliveryFeeCalculator {

    public static Delivery createDelivery(String type, String[] data) {

        double weight = Double.parseDouble(data[1]);
        double distance = Double.parseDouble(data[2]);

        switch (type) {
            case "STANDARD":
                return new StandardDelivery(weight, distance);

            case "EXPRESS":
                return new ExpressDelivery(weight, distance);

            case "INTERNATIONAL":
                double customsFee = Double.parseDouble(data[3]);
                return new InternationalDelivery(
                        weight, distance, customsFee
                );

            default:
                throw new IllegalArgumentException("Invalid delivery type");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {

            String[] input = sc.nextLine().split("\\s+");

            String type = input[0];

            Delivery delivery = createDelivery(type, input);

            double fee = delivery.calculateFee();

            total += fee;

            System.out.printf("%s: %.2f%n", type, fee);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
