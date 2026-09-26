import java.util.*;

interface Room {
    double calculateBill();
    String getType();
}

class SingleRoom implements Room {
    private double units;

    public SingleRoom(double units) {
        this.units = units;
    }

    public double calculateBill() {
        return units * 8;
    }

    public String getType() {
        return "SINGLE";
    }
}

class SharedRoom implements Room {
    private double units;
    private int occupants;

    public SharedRoom(double units, int occupants) {
        this.units = units;
        this.occupants = occupants;
    }

    public double calculateBill() {
        return (units * 6) / occupants;
    }

    public String getType() {
        return "SHARED";
    }
}

class ACRoom implements Room {
    private double units;

    public ACRoom(double units) {
        this.units = units;
    }

    public double calculateBill() {
        return (units * 10) + 200;
    }

    public String getType() {
        return "AC";
    }
}

public class HostelElectricityBill {

    public static Room createRoom(String type, String[] data) {
        double units = Double.parseDouble(data[1]);

        switch (type) {
            case "SINGLE":
                return new SingleRoom(units);

            case "SHARED":
                int occupants = Integer.parseInt(data[2]);
                return new SharedRoom(units, occupants);

            case "AC":
                return new ACRoom(units);

            default:
                throw new IllegalArgumentException("Invalid room type");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] data;

            String type = sc.next();

            if (type.equals("SHARED")) {
                data = new String[]{
                        type,
                        sc.next(),
                        sc.next()
                };
            } else {
                data = new String[]{
                        type,
                        sc.next()
                };
            }

            Room room = createRoom(type, data);
            double bill = room.calculateBill();

            total += bill;

            System.out.printf("%s: %.2f%n", type, bill);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}