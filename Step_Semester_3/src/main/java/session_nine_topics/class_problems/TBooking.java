import java.util.Scanner;
abstract class TravelBooking {
    protected static final double BOOKING_FEE = 50.0;
    protected int distanceKm;
    public TravelBooking(int distanceKm) {
        this.distanceKm = distanceKm;
    }
    public abstract double calculateBaseFare();
    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}
class BusBooking extends TravelBooking {
    public BusBooking(int distanceKm) {
        super(distanceKm);
    }
    @Override
    public double calculateBaseFare() {
        return distanceKm * 2.0;
    }
}
class TrainBooking extends TravelBooking {
    public TrainBooking(int distanceKm) {
        super(distanceKm);
    }
    @Override
    public double calculateBaseFare() {
        return distanceKm * 1.5;
    }
}
class FlightBooking extends TravelBooking {
    public FlightBooking(int distanceKm) {
        super(distanceKm);
    }
    @Override
    public double calculateBaseFare() {
        return 2500.0 + (distanceKm * 4.0);
    }
}
public class TBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            int distanceKm = sc.nextInt();
            TravelBooking booking = null;
            if (mode.equals("BUS")) {
                booking = new BusBooking(distanceKm);
            } else if (mode.equals("TRAIN")) {
                booking = new TrainBooking(distanceKm);
            } else if (mode.equals("FLIGHT")) {
                booking = new FlightBooking(distanceKm);
            }
            if (booking != null) {
                System.out.printf("%s: %.2f\n", mode, booking.calculateTotalFare());
            }
        }
        sc.close();
    }
}
