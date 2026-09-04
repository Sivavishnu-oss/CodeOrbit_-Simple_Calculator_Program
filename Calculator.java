import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Simple Calculator Program in Java.
 * Demonstrates console I/O using Scanner, basic arithmetic operations,
 * exception handling for invalid input and division by zero, and interactive loop.
 */
public class Calculator {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the standard input stream (console)
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        System.out.println("========================================");
        System.out.println("       WELCOME TO JAVA CALCULATOR       ");
        System.out.println("========================================");

        // Main execution loop: keeps the calculator running until the user chooses to exit
        while (keepRunning) {
            try {
                // Display operational menu
                displayMenu();

                System.out.print("Select an option (1-6): ");
                int choice = scanner.nextInt();

                // Exit check
                if (choice == 6) {
                    keepRunning = false;
                    System.out.println("\nThank you for using Java Calculator. Goodbye!");
                    break;
                }

                // Validate operator choice range
                if (choice < 1 || choice > 6) {
                    System.out.println("\n[Error] Invalid choice! Please select a number between 1 and 6.");
                    continue;
                }

                // Prompt user for input numbers
                System.out.print("Enter the first number: ");
                double num1 = scanner.nextDouble();

                System.out.print("Enter the second number: ");
                double num2 = scanner.nextDouble();

                // Perform calculation based on user's menu selection
                double result = 0;
                boolean validOperation = true;

                switch (choice) {
                    case 1: // Addition
                        result = num1 + num2;
                        System.out.printf("\nResult: %.2f + %.2f = %.2f\n", num1, num2, result);
                        break;

                    case 2: // Subtraction
                        result = num1 - num2;
                        System.out.printf("\nResult: %.2f - %.2f = %.2f\n", num1, num2, result);
                        break;

                    case 3: // Multiplication
                        result = num1 * num2;
                        System.out.printf("\nResult: %.2f * %.2f = %.2f\n", num1, num2, result);
                        break;

                    case 4: // Division
                        // Handle division by zero explicitly to throw or warn clearly
                        if (num2 == 0) {
                            throw new ArithmeticException("Division by zero is not allowed.");
                        }
                        result = num1 / num2;
                        System.out.printf("\nResult: %.2f / %.2f = %.2f\n", num1, num2, result);
                        break;

                    case 5: // Modulus (Remainder)
                        if (num2 == 0) {
                            throw new ArithmeticException("Modulus by zero is not allowed.");
                        }
                        result = num1 % num2;
                        System.out.printf("\nResult: %.2f %% %.2f = %.2f\n", num1, num2, result);
                        break;

                    default:
                        validOperation = false;
                        System.out.println("\n[Error] Invalid operation selection.");
                        break;
                }

            } catch (InputMismatchException e) {
                // Catches errors when user inputs letters/symbols instead of numbers
                System.out.println("\n[Input Error] Invalid input type! Please enter numeric values only.");
                scanner.nextLine(); // Clear the scanner buffer to prevent an infinite loop
            } catch (ArithmeticException e) {
                // Catches division or modulus by zero operations
                System.out.println("\n[Math Error] " + e.getMessage());
            } catch (Exception e) {
                // Generic catch block for any unforeseen exceptions
                System.out.println("\n[Error] An unexpected error occurred: " + e.getMessage());
                scanner.nextLine(); // Clear buffer
            }

            System.out.println("----------------------------------------");
        }

        // Close scanner resource to prevent memory leaks
        scanner.close();
    }

    /**
     * Helper method to display the calculator operation menu.
     */
    private static void displayMenu() {
        System.out.println("\nSelect an operation:");
        System.out.println("  1. Addition (+)");
        System.out.println("  2. Subtraction (-)");
        System.out.println("  3. Multiplication (*)");
        System.out.println("  4. Division (/)");
        System.out.println("  5. Modulus (%)");
        System.out.println("  6. Exit");
    }
}
