import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DigitalLibraryManagementSystem {
    private static Map<String, String> users = new HashMap<>();
    private static Map<String, Integer> resources = new HashMap<>();
    private static Map<String, Integer> borrowedBooks = new HashMap<>();
    private static int borrowLimit = 3;

    public static void main(String[] args) {
        initializeUsers();
        initializeResources();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Digital Library Management System!");

        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    register(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeUsers() {
        // Initialize users (username, password)
        users.put("user1", "password1");
        users.put("user2", "password2");
        // Add more users as needed
    }

    private static void initializeResources() {
        // Initialize resources (resource name, available copies)
        resources.put("Book1", 5);
        resources.put("Book2", 3);
        // Add more resources as needed
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Login successful! Welcome, " + username + "!");
            // After successful login, show available resources and options for borrowing, returning, etc.
            showMenu(scanner);
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private static void register(Scanner scanner) {
        System.out.print("Enter new username: ");
        String newUsername = scanner.nextLine();
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();

        if (users.containsKey(newUsername)) {
            System.out.println("Username already exists. Please choose a different username.");
        } else {
            users.put(newUsername, newPassword);
            System.out.println("Registration successful! You can now login with your new account.");
        }
    }

    private static void showMenu(Scanner scanner) {
        while (true) {
            System.out.println("1. Browse resources");
            System.out.println("2. Borrow a resource");
            System.out.println("3. Return a resource");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    browseResources();
                    break;
                case 2:
                    borrowResource(scanner);
                    break;
                case 3:
                    returnResource(scanner);
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void browseResources() {
        System.out.println("Available resources:");
        for (String resourceName : resources.keySet()) {
            System.out.println("- " + resourceName + ": " + resources.get(resourceName) + " available");
        }
    }

    private static void borrowResource(Scanner scanner) {
        System.out.print("Enter the name of the resource you want to borrow: ");
        String resourceName = scanner.nextLine();

        if (resources.containsKey(resourceName) && resources.get(resourceName) > 0) {
            if (borrowedBooks.containsKey(resourceName) && borrowedBooks.get(resourceName) >= borrowLimit) {
                System.out.println("You have reached the borrowing limit for this resource.");
            } else {
                resources.put(resourceName, resources.get(resourceName) - 1);
                borrowedBooks.put(resourceName, borrowedBooks.getOrDefault(resourceName, 0) + 1);
                System.out.println("Resource borrowed successfully.");
            }
        } else {
            System.out.println("The resource is not available for borrowing.");
        }
    }

    private static void returnResource(Scanner scanner) {
        System.out.print("Enter the name of the resource you want to return: ");
        String resourceName = scanner.nextLine();

        if (borrowedBooks.containsKey(resourceName) && borrowedBooks.get(resourceName) > 0) {
            resources.put(resourceName, resources.getOrDefault(resourceName, 0) + 1);
            borrowedBooks.put(resourceName, borrowedBooks.get(resourceName) - 1);
            System.out.println("Resource returned successfully.");
        } else {
            System.out.println("You have not borrowed this resource.");
        }
    }
}
