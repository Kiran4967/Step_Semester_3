public class IdCard {
    String name;
    int booksIssued;

    IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {
        IdCard card1 = new IdCard("Ravi", 3);

        IdCard duplicate = card1;

        duplicate.booksIssued = 5;

        System.out.println("Ravi's booksIssued (via first variable): " + card1.booksIssued);
        System.out.println("card1 == duplicate: " + (card1 == duplicate));

        IdCard card3 = new IdCard("Ravi", 5);

        System.out.println("card1 == card3: " + (card1 == card3));
    }
}
