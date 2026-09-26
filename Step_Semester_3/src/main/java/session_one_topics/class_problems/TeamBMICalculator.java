package session_one_topics.class_problems;

import java.util.Scanner;

public class TeamBMICalculator {

    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    public static String getCategory(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of team members: ");
        int n = sc.nextInt();

        double totalBMI = 0;

        for (int i = 1; i <= n; i++) {
            System.out.println("\nMember " + i);

            System.out.print("Enter weight (kg): ");
            double weight = sc.nextDouble();

            System.out.print("Enter height (m): ");
            double height = sc.nextDouble();

            double bmi = calculateBMI(weight, height);
            String category = getCategory(bmi);

            System.out.printf("BMI: %.2f%n", bmi);
            System.out.println("Category: " + category);

            totalBMI += bmi;
        }

        double averageBMI = totalBMI / n;

        System.out.printf("%nAverage Team BMI: %.2f%n", averageBMI);
        System.out.println("Average BMI Category: " + getCategory(averageBMI));

        sc.close();
    }
}