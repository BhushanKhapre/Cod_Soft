package Codsoft_Task5;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        // Loading initial data from a file (if available)
        system.readFromFile("Codsoft_Task5/students.csv");

        int choice;

        do {
            System.out.println("+-----------------------------------------------+");
            System.out.println("| Student Management System Menu                |");
            System.out.println("+-----------------------------------------------+");
            System.out.println("| 1. Add a new student                          |");
            System.out.println("| 2. Edit existing student's information        |");
            System.out.println("| 3. Search for a student                       |");
            System.out.println("| 4. Display all students                       |");
            System.out.println("| 5. Remove a student                           |");
            System.out.println("| 6. Save data to file                          |");
            System.out.println("| 7. Exit                                       |");
            System.out.println("+-----------------------------------------------+");

            System.out.print("\nEnter your choice (1-7):\u0332");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    addNewStudent(system, scanner);
                    break;
                case 2:
                    editStudentInformation(system, scanner);
                    break;
                case 3:
                    searchForStudent(system, scanner);
                    break;
                case 4:
                    displayAllStudents(system);
                    break;
                case 5:
                    removeStudent(system, scanner);
                    break;
                case 6:
                    saveDataToFile(system);
                    break;
                case 7:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }

        } while (choice != 7);
    }
    private static void saveDataToFile(StudentManagementSystem system) {
        system.writeToFile("Codsoft_Task5/students.csv");
        System.out.println("Data saved to file successfully.");
    }

    private static void removeStudent(StudentManagementSystem system, Scanner scanner) {
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.print("Enter the Roll Number of the student to remove: ");
        int rollNumberToRemove = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        system.removeStudent(rollNumberToRemove);
        System.out.println("Student with Roll Number " + rollNumberToRemove + " removed successfully.");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
    }

    private static void addNewStudent(StudentManagementSystem system, Scanner scanner) {
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("Adding a new student:");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        int rollNumber = getValidPositiveIntegerInput(scanner, "Roll Number");

        System.out.print("Grade: ");
        char grade = scanner.nextLine().toUpperCase().charAt(0);

        System.out.print("Gender: ");
        String gender = scanner.nextLine();

        int age = getValidPositiveIntegerInput(scanner, "Age");

        Student newStudent = new Student(name, rollNumber, grade, gender, age);
        system.addStudent(newStudent);
        System.out.println("Student added successfully.");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
    }

    private static void editStudentInformation(StudentManagementSystem system, Scanner scanner) {
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.print("Enter the Roll Number of the student to edit: ");
        int rollNumberToEdit = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        Student studentToEdit = system.searchStudent(rollNumberToEdit);

        if (studentToEdit != null) {
            System.out.println("Editing information for student with Roll Number: " + rollNumberToEdit);

            System.out.print("New Name: ");
            String newName = scanner.nextLine();
            studentToEdit.setName(newName);

            int newRollNumber = getValidPositiveIntegerInput(scanner, "New Roll Number");
            studentToEdit.setRollNumber(newRollNumber);

            System.out.print("New Grade: ");
            char newGrade = scanner.nextLine().toUpperCase().charAt(0);
            studentToEdit.setGrade(newGrade);

            System.out.print("New Gender: ");
            String newGender = scanner.nextLine();
            studentToEdit.setGender(newGender);

            int newAge = getValidPositiveIntegerInput(scanner, "New Age");
            studentToEdit.setAge(newAge);

            System.out.println("Student information updated successfully.");
            System.out.println("--------------------------------------------------------------------------------------------------------------");

        } else {
            System.out.println("Student with Roll Number " + rollNumberToEdit + " not found.");
            System.out.println("--------------------------------------------------------------------------------------------------------------");
        }
    }

    private static void searchForStudent(StudentManagementSystem system, Scanner scanner) {
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.print("Enter the Roll Number of the student to search for: ");
        int rollNumberToSearch = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        Student searchedStudent = system.searchStudent(rollNumberToSearch);

        if (searchedStudent != null) {
            System.out.println("Student found:");
            displayStudentInfo(searchedStudent);
            System.out.println("--------------------------------------------------------------------------------------------------------------");
        } else {
            System.out.println("Student with Roll Number " + rollNumberToSearch + " not found.");
            System.out.println("--------------------------------------------------------------------------------------------------------------");
        }
    }

    private static void displayAllStudents(StudentManagementSystem system) {
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("All Students:");
        system.displayAllStudents();
        System.out.println("--------------------------------------------------------------------------------------------------------------");

    }

    private static void displayStudentInfo(Student student) {
        System.out.println("+---------------+------------+----------+----------+------+");
        System.out.printf("| %-13s | %-10s | %-8s | %-8s | %-4s |\n", "Name", "Roll no", "Grade", "Gender", "Age");
        System.out.println("+---------------+------------+----------+----------+------+");
        System.out.printf("| %-13s | %-10s | %-8s | %-8s | %-4s |\n", student.getName(), student.getRollNumber(), student.getGrade(), student.getGender(), student.getAge());
        System.out.println("+---------------+------------+----------+----------+------+");
        System.out.println("--------------------------------------------------------------------------------------------------------------");

    }

    private static int getValidPositiveIntegerInput(Scanner scanner, String fieldName) {
        int value = 0;
        while (value <= 0) {
            try {
                System.out.print(fieldName + ": ");
                value = Integer.parseInt(scanner.nextLine());
                if (value <= 0) {
                    System.out.println(fieldName + " must be a positive integer. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. " + fieldName + " must be a positive integer. Please try again.");
            }
        }
        return value;
    }
}

