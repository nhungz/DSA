/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentmanagementapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Student Management Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Sort Students by Name (Merge Sort)");
            System.out.println("4. Sort Students by Marks (Bubble Sort)");
            System.out.println("5. Edit Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Search Student by ID");
            System.out.println("8. Exit");
            System.out.print("Choose an option (1-8): ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }

            if (choice < 1 || choice > 8) {
                System.out.println("Invalid choice. Please select a number between 1 and 8.");
                continue;
            }

            try {
                switch (choice) {
                    case 1: // Add Student
                        System.out.print("Enter Student ID: ");
                        String id = reader.readLine();

                        System.out.print("Enter Student Name: ");
                        String name = reader.readLine();

                        double marks = 0.0;
                        while (true) {
                            System.out.print("Enter Student Marks: ");
                            try {
                                marks = Double.parseDouble(reader.readLine());
                                if (marks < 1.0 || marks > 10.0) {
                                    System.out.println("Invalid marks. Marks must be between 1.0 and 10.0.");
                                } else {
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a valid numeric value.");
                            }
                        }

                        studentManager.addStudent(id, name, marks);
                        System.out.println("Student added successfully.");
                        break;

                    case 2: // Display All Students
                        System.out.println("\nAll Students:");
                        studentManager.printStudents();
                        break;

                    case 3: // Sort Students by Name
                        studentManager.mergeSortByName();
                        System.out.println("\nStudents sorted by name:");
                        studentManager.printStudents();
                        break;

                    case 4: // Sort Students by Marks
                        studentManager.bubbleSortByMarks();
                        System.out.println("\nStudents sorted by marks:");
                        studentManager.printStudents();
                        break;

                    case 5: // Edit Student
                        System.out.print("Enter ID of student to edit: ");
                        String editId = reader.readLine();

                        System.out.print("Enter new Name: ");
                        String newName = reader.readLine();

                        double newMarks = 0.0;
                        while (true) {
                            System.out.print("Enter new Marks: ");
                            try {
                                newMarks = Double.parseDouble(reader.readLine());
                                if (newMarks < 1.0 || newMarks > 10.0) {
                                    System.out.println("Invalid marks. Marks must be between 1.0 and 10.0.");
                                } else {
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a valid numeric value.");
                            }
                        }

                        studentManager.editStudent(editId, newName, newMarks);
                        System.out.println("Student details updated.");
                        break;

                    case 6: // Delete Student
                        System.out.print("Enter ID of student to delete: ");
                        String deleteId = reader.readLine();
                        studentManager.deleteStudent(deleteId);
                        System.out.println("Student deleted successfully.");
                        break;

                    case 7: // Search Student
                        System.out.println("Choose search criteria:");
                        System.out.println("1. Search by ID");
                        System.out.println("2. Search by Name");
                        System.out.print("Enter your choice: ");
                        int searchChoice = Integer.parseInt(reader.readLine());

                        switch (searchChoice) {
                            case 1: // Search by ID
                                System.out.print("Enter ID of student to search: ");
                                String searchId = reader.readLine();
                                Student foundStudent = studentManager.searchStudentById(searchId);
                                if (foundStudent != null) {
                                    System.out.println("Found: " + foundStudent);
                                } else {
                                    System.out.println("Student not found.");
                                }
                                break;

                            case 2: // Search by Name
                                System.out.print("Enter name of student to search: ");
                                String searchName = reader.readLine();
                                List<Student> foundStudents = studentManager.searchStudentsByName(searchName);
                                if (!foundStudents.isEmpty()) {
                                    System.out.println("Found students:");
                                    for (Student student : foundStudents) {
                                        System.out.println(student);
                                    }
                                } else {
                                    System.out.println("No students found with the name: " + searchName);
                                }
                                break;

                            default: // Invalid choice
                                System.out.println("Invalid choice. Please select 1 or 2.");
                        }
                        break;

                    case 8: // Exit
                        exit = true;
                        System.out.println("Exiting the program.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please select a number between 1 and 8.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred while reading input: " + e.getMessage());
            }
        }
        scanner.close();
    }
}