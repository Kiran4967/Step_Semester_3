import java.util.Scanner;
abstract class StaffMember {
    protected String name;
    public StaffMember(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract double calculatePay();
}
class FullTimeStaff extends StaffMember {
    private double weeklySalary;
    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }
    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}
class HourlyStaff extends StaffMember {
    private double hours;
    private double rate;
    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }
    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return (40 * rate) + ((hours - 40) * 1.5 * rate);
        }
    }
}
class InternStaff extends StaffMember {
    private double stipend;
    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }
    @Override
    public double calculatePay() {
        return stipend;
    }
}
public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double totalPayroll = 0.0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            StaffMember staff = null;
            if (type.equals("FULLTIME")) {
                double weeklySalary = sc.nextDouble();
                staff = new FullTimeStaff(name, weeklySalary);
            } else if (type.equals("HOURLY")) {
                double hours = sc.nextDouble();
                double rate = sc.nextDouble();
                staff = new HourlyStaff(name, hours, rate);
            } else if (type.equals("INTERN")) {
                double stipend = sc.nextDouble();
                staff = new InternStaff(name, stipend);
            }
            if (staff != null) {
                double pay = staff.calculatePay();
                totalPayroll += pay;
                System.out.printf("%s: %.2f\n", staff.getName(), pay);
            }
        }
        System.out.printf("Total Payroll: %.2f\n", totalPayroll);
        sc.close();
    }
}
