import java.util.*;

interface Employee {
    double calculateBonus();
    String getName();
}

class FullTimeEmployee implements Employee {
    private String name;
    private double salary;

    public FullTimeEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.10;
    }

    public String getName() {
        return name;
    }
}

class PartTimeEmployee implements Employee {
    private String name;
    private double salary;

    public PartTimeEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.05;
    }

    public String getName() {
        return name;
    }
}

class InternEmployee implements Employee {
    private String name;
    private double salary;

    public InternEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double calculateBonus() {
        return 2000;
    }

    public String getName() {
        return name;
    }
}

public class FestivalBonusCalculator {

    public static Employee createEmployee(
            String type, String name, double salary) {

        switch (type) {
            case "FULLTIME":
                return new FullTimeEmployee(name, salary);

            case "PARTTIME":
                return new PartTimeEmployee(name, salary);

            case "INTERN":
                return new InternEmployee(name, salary);

            default:
                throw new IllegalArgumentException("Invalid employee type");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalBonus = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee employee = createEmployee(type, name, salary);

            double bonus = employee.calculateBonus();
            totalBonus += bonus;

            System.out.printf(
                    "%s: %.2f%n",
                    employee.getName(),
                    bonus
            );
        }

        System.out.printf(
                "Total Bonus: %.2f%n",
                totalBonus
        );

        sc.close();
    }
}