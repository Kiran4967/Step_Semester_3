import java.util.Scanner;
abstract class LibraryItem {
    protected String title;
    protected int daysLate;
    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }
    public abstract double calculateFine();
    public String getTitle() {
        return title;
    }
}
class Book extends LibraryItem {
    public Book(String title,int daysLate) {
        super(title, daysLate);
    }
    @Override
    public double calculateFine() {
        return daysLate * 2.0;
    }
}
class DVD extends LibraryItem {
    public DVD(String title, int daysLate) {
        super(title, daysLate);
    }
    @Override
    public double calculateFine() {
        return Math.min(daysLate * 5.0, 50.0);
    }
}
class Magazine extends LibraryItem {
    public Magazine(String title, int daysLate) {
        super(title, daysLate);
    }
    @Override
    public double calculateFine() {
        return daysLate * 1.0;
    }
}
public class LibraryFine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double totalFines = 0.0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();
            LibraryItem item = null;
            if (type.equals("BOOK")) {
                item = new Book(title, daysLate);
            } else if (type.equals("DVD")) {
                item = new DVD(title, daysLate);
            } else if (type.equals("MAGAZINE")) {
                item = new Magazine(title, daysLate);
            }
            if (item != null) {
                double fine = item.calculateFine();
                totalFines += fine;
                System.out.printf("%s: %.2f\n", item.getTitle(), fine);
            }
        }
        System.out.printf("Total Fines: %.2f\n", totalFines);
        sc.close();
    }
}