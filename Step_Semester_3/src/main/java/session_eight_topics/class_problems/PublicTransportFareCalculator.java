import java.util.*;

interface Transport {
    double calculateFare();
    String getType();
}

class Bus implements Transport {
    private double distance;

    public Bus(double distance) {
        this.distance = distance;
    }

    public double calculateFare() {
        double fare = 2 + (0.10 * distance);

        if (fare > 10) {
            fare = 10;
        }

        return fare;
    }

    public String getType() {
        return "BUS";
    }
}

class Train implements Transport {
    private double distance;

    public Train(double distance) {
        this.distance = distance;
    }

    public double calculateFare() {
        return 3 + (0.15 * distance);
    }

    public String getType() {
        return "TRAIN";
    }
}

class Metro implements Transport {
    private double distance;
    private double peakHourFactor;

    public Metro(double distance, double peakHourFactor) {
        this.distance = distance;
        this.peakHourFactor = peakHourFactor;
    }

    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }

    public String getType() {
        return "METRO";
    }
}

public class PublicTransportFareCalculator {

    public static Transport createTransport(
            String type, String[] data) {

        double distance = Double.parseDouble(data[1]);

        switch (type) {

            case "BUS":
                return new Bus(distance);

            case "TRAIN":
                return new Train(distance);

            case "METRO":
                double peakHourFactor =
                        Double.parseDouble(data[2]);

                return new Metro(
                        distance,
                        peakHourFactor
                );

            default:
                throw new IllegalArgumentException(
                        "Invalid transport type"
                );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        double total = 0;

        for (int i = 0; i < n; i++) {

            String[] input = sc.nextLine().split("\\s+");

            String type = input[0];

            Transport transport =
                    createTransport(type, input);

            double fare = transport.calculateFare();

            total += fare;

            System.out.printf(
                    "%s: %.2f%n",
                    type,
                    fare
            );
        }

        System.out.printf(
                "Total: %.2f%n",
                total
        );

        sc.close();
    }
}
