import java.util.Scanner;

public class AuthSystem {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "1234";

    public static boolean login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Admin Login ===");
        System.out.print("Username: ");
        String user = scanner.nextLine();

        System.out.print("Password: ");
        String pass = scanner.nextLine();

        if (USERNAME.equals(user) && PASSWORD.equals(pass)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Incorrect credentials. Access denied.");
            return false;
        }
    }
}
