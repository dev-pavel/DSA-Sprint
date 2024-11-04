package com.keyin;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- To-Do List Manager ---");
            System.out.println("1. Create User");
            System.out.println("2. Add Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    createUser(scanner);
                    break;
                case 2:
                    addTask(scanner);
                    break;
                case 3:
                    markTaskAsCompleted(scanner);
                    break;
                case 4:
                    viewTasks(scanner);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static void createUser(Scanner scanner) {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();

        if (findUser(name) != null) {
            System.out.println("User already exists.");
        } else {
            users.add(new User(name));
            System.out.println("User " + name + " created.");
        }
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        User user = findUser(name);

        if (user == null) {
            System.out.println("User not found.");
        } else {
            System.out.print("Enter task description: ");
            String description = scanner.nextLine();
            user.addTask(description);
            System.out.println("Task added to " + name + "'s to-do list.");
        }
    }

    private static void markTaskAsCompleted(Scanner scanner) {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        User user = findUser(name);

        if (user == null) {
            System.out.println("User not found.");
        } else {
            System.out.print("Enter task description to mark as completed: ");
            String description = scanner.nextLine();
            if (user.markTaskAsCompleted(description)) {
                System.out.println("Task marked as completed.");
            } else {
                System.out.println("Task not found.");
            }
        }
    }

    private static void viewTasks(Scanner scanner) {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        User user = findUser(name);

        if (user == null) {
            System.out.println("User not found.");
        } else {
            user.printTasks();
        }
    }

    private static User findUser(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }
}
