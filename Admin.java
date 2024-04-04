package accountmanagement;
import java.util.Scanner;

public class Admin {

	public static void main(String[] args) 
	{
		AccountManager accountManager = new AccountManager(); // Create an instance of AccountManager
        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("Welcome to the Account Management System!");

        do {
            // Display the menu
            System.out.println("\nMain Menu");
            System.out.println("1. Open a New Account");
            System.out.println("2. Close an Account");
            System.out.println("3. Login to an Account");
            System.out.println("4. Specify Interest Rate for Savings Accounts");
            System.out.println("5. Display All Account Details");
            System.out.println("6. Display All Account Deductions");
            System.out.println("7. Exit");
            System.out.print("Please select an option: ");

            // Read user input
            option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    // Open a new account
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter customer address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter customer phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter account type (1 for Checking, 2 for Savings): ");
                    int accountType = scanner.nextInt();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();

                    if (accountType == 2) {
                        System.out.print("Enter interest rate for Savings Account: ");
                        double interestRate = scanner.nextDouble();
                        accountManager.openAccount(name, address, phoneNumber, accountType, initialBalance, interestRate);
                    } else {
                        accountManager.openAccount(name, address, phoneNumber, accountType, initialBalance, 0.0);
                    }
                    break;

                case 2:
                    // Close an account
                    System.out.print("Enter account number to close: ");
                    int accountNumberToClose = scanner.nextInt();
                    accountManager.closeAccount(accountNumberToClose);
                    break;

                case 3:
                    // Login to an account
                    System.out.print("Enter account number to login: ");
                    int accountNumberToLogin = scanner.nextInt();
                    accountManager.loginToAccount(accountNumberToLogin);
                    break;

                case 4:
                    // Specify interest rate for Savings Accounts
                    System.out.print("Enter new interest rate for Savings Accounts: ");
                    double newInterestRate = scanner.nextDouble();
                    accountManager.setInterestRate(newInterestRate);
                    break;

                case 5:
                    // Display All Account Details
                    accountManager.displayAllAccountDetails();
                    break;

                case 6:
                    // Display All Account Deductions
                    accountManager.displayAllDeductions();
                    break;

                case 7:
                    // Exit the program
                    System.out.println("Exiting Account Management System.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (option != 7);

        // Close resources
        scanner.close();
    }
    
}
