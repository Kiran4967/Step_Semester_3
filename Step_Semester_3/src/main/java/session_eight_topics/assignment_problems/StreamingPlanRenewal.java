import java.time.LocalDate;
import java.util.*;

interface SubscriptionPlan {
    LocalDate getRenewalDate(LocalDate startDate);
}

class BasicPlan implements SubscriptionPlan {
    public LocalDate getRenewalDate(LocalDate startDate) {
        return startDate.plusDays(30);
    }
}

class StandardPlan implements SubscriptionPlan {
    public LocalDate getRenewalDate(LocalDate startDate) {
        return startDate.plusDays(90);
    }
}

class PremiumPlan implements SubscriptionPlan {
    public LocalDate getRenewalDate(LocalDate startDate) {
        return startDate.plusDays(365);
    }
}

public class StreamingPlanRenewal {

    public static SubscriptionPlan createPlan(String type) {
        switch (type) {
            case "BASIC":
                return new BasicPlan();

            case "STANDARD":
                return new StandardPlan();

            case "PREMIUM":
                return new PremiumPlan();

            default:
                throw new IllegalArgumentException("Invalid plan type");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            LocalDate startDate = LocalDate.parse(date);

            SubscriptionPlan plan = createPlan(type);

            LocalDate renewalDate =
                    plan.getRenewalDate(startDate);

            System.out.println(
                    name + ": " + renewalDate
            );
        }

        sc.close();
    }
}