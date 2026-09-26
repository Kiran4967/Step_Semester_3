import java.time.LocalDate;
import java.util.*;

interface LibraryItem {
    LocalDate getDueDate();
    String getTitle();
}

class Book implements LibraryItem {
    private String title;
    private LocalDate currentDate;

    public Book(String title, LocalDate currentDate) {
        this.title = title;
        this.currentDate = currentDate;
    }

    public LocalDate getDueDate() {
        return currentDate.plusDays(14);
    }

    public String getTitle() {
        return title;
    }
}

class DVD implements LibraryItem {
    private String title;
    private LocalDate currentDate;

    public DVD(String title, LocalDate currentDate) {
        this.title = title;
        this.currentDate = currentDate;
    }

    public LocalDate getDueDate() {
        return currentDate.plusDays(7);
    }

    public String getTitle() {
        return title;
    }
}

class Magazine implements LibraryItem {
    private String title;
    private LocalDate currentDate;

    public Magazine(String title, LocalDate currentDate) {
        this.title = title;
        this.currentDate = currentDate;
    }

    public LocalDate getDueDate() {
        return currentDate.plusDays(3);
    }

    public String getTitle() {
        return title;
    }
}

public class LibraryDueDateCalculator {

    public static LibraryItem createItem(
            String type, String title, LocalDate currentDate) {

        switch (type) {
            case "BOOK":
                return new Book(title, currentDate);
            case "DVD":
                return new DVD(title, currentDate);
            case "MAGAZINE":
                return new Magazine(title, currentDate);
            default:
                throw new IllegalArgumentException("Invalid item type");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            String[] parts = line.split("\\s+", 2);
            String type = parts[0];

            String title = parts[1];

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item = createItem(type, title, currentDate);

            System.out.println(
                    item.getTitle() + ": " + item.getDueDate()
            );
        }

        sc.close();
    }
}