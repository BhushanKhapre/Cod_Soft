package Codsoft_Task2;

import java.util.ArrayList;
import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        ArrayList<Integer> marks = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        char op;

        do {
            System.out.print("Enter the total no. of subjects : \u0332");
            int size = sc.nextInt();
            System.out.println("------------------------------------------------------------------------------------------------");
            for (int i = 1; i <= size; i++) {
                System.out.print("Enter the marks of " + i + "st subject : ");
                marks.add(sc.nextInt());
            }

            // Calculate total marks
            int totalMarks = 0;
            for (int mark : marks) {
                totalMarks += mark;
            }

            // Calculate average percentage
            double averagePercentage = (double) totalMarks / marks.size();

            // Calculate grade
            String grade;
            if (averagePercentage >= 90) {
                grade = "A+";
            } else if (averagePercentage >= 80) {
                grade = "A";
            } else if (averagePercentage >= 70) {
                grade = "B";
            } else if (averagePercentage >= 60) {
                grade = "C";
            } else if (averagePercentage >= 50) {
                grade = "D";
            } else {
                grade = "You fail";
            }

            // Display Results
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("+----------------------+----------------------+----------------------+----------------------+");
            System.out.printf("| %-20s | %-20s | %-20s |%-20s |\n", "Total Subjecs", "Total Marks", "Average Percentage", "Grade");
            System.out.println("+----------------------+----------------------+----------------------+----------------------+");
            System.out.printf("| %-20s | %-20s | %-20s |%-20s |\n", size, totalMarks, averagePercentage, grade);
            System.out.println("+----------------------+----------------------+----------------------+----------------------+");
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------------------");
            System.out.print("Do you want to continue ? (yes/no): ");
            while (true) {
                op = sc.next().charAt(0);
                if (op == 'Y' || op == 'y' || op == 'N' || op == 'n')
                    break;
                else
                    System.out.println("Enter Y for (yes) or N for (no)");
            }
        } while (op == 'Y' || op == 'y');
    }
}