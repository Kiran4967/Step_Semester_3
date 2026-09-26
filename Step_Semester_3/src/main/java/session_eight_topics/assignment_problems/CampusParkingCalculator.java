import java.util.*;

interface Vehicle {
    double calculateCharge(int hours);
}

class Bike implements Vehicle {
    public double calculateCharge(int hours) {
        return hours * 10;
    }
}

class Car implements Vehicle {
    public double calculateCharge(int hours) {
        return 30 + (hours - 1) * 20;
    }
}

class Truck implements Vehicle {
    public double calculateCharge(int hours) {
        double charge = hours * 50;
        return Math.max(charge, 100);
    }
}

public class CampusParkingCalculator {

    public static Vehicle createVehicle(String type) {
        switch (type) {
            case "BIKE":
                return new Bike();
            case "CAR":
                return new Car();
            case "TRUCK":
                return new Truck();
            default:
                throw new IllegalArgumentException("Invalid vehicle type");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            Vehicle vehicle = createVehicle(type);
            double charge = vehicle.calculateCharge(hours);

            total += charge;

            System.out.printf("%s: %.2f%n", type, charge);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}