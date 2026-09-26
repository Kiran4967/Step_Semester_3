package session_one_topics.class_problems;

import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    public static char findFirstNonRepeating(String text) {
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            int count = 0;

            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) == current) {
                    count++;
                }
            }

            if (count == 1) {
                return current;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        char result = findFirstNonRepeating(text);

        if (result == '\0') {
            System.out.println("No non-repeating character found.");
        } else {
            System.out.println("First non-repeating character: " + result);
        }

        sc.close();
    }
}
