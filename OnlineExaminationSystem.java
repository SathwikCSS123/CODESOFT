import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineExaminationSystem {
    private static Map<String, String> users = new HashMap<>();
    private static Map<String, String> questions = new HashMap<>();

    public static void main(String[] args) {
        initializeUsers();
        initializeQuestions();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Online Examination System!");

        // User Authentication
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authenticateUser(username, password)) {
            System.out.println("Login successful!");
            // Test-taking Interface
            System.out.println("Test starts now:");

            int score = 0;
            for (Map.Entry<String, String> entry : questions.entrySet()) {
                System.out.println(entry.getKey());
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase(entry.getValue())) {
                    score++;
                }
            }

            // Result Processing
            System.out.println("Test completed. Your score: " + score);
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }

        scanner.close();
    }

    private static void initializeUsers() {
        users.put("user1", "password1");
        users.put("user2", "password2");
        // Add more users as needed
    }

    private static void initializeQuestions() {
        questions.put("What is the capital of France?", "Paris");
        questions.put("What is the largest planet in the solar system?", "Jupiter");
        // Add more questions and answers as needed
    }

    private static boolean authenticateUser(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}
