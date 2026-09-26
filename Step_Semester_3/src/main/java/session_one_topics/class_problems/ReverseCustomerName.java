package session_one_topics.class_problems;

import java.util.Scanner;

public class ReverseCustomerName {

    public static String reverseName(String name) {
        return new StringBuilder(name).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        String reversedName = reverseName(name);

        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reversedName);

        sc.close();
    }
}
