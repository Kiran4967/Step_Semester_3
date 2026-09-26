class Book {
    String title;
    String author;
    int copiesAvailable;

    Book(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    void printEntry() {
        System.out.println(title + " by " + author + " - " + copiesAvailable + " copies available");
    }
}

public class LibraryInventory {
    public static void main(String[] args) {
        Book[] books = {
                new Book("Clean Code", "Robert C. Martin", 3),
                new Book("Effective Java", "Joshua Bloch", 5),
                new Book("Refactoring", "Martin Fowler", 0),
                new Book("Design Patterns", "GoF", 2)
        };

        for (Book book : books) {
            book.printEntry();
        }
    }
}
