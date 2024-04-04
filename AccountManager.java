package accountmanagement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AccountManager {
	 private List<Customer> customers = new ArrayList<>();
	    private List<BankAccount> accounts = new ArrayList<>();

	    public void openAccount(String name, String address, String phoneNumber, int accountType, double initialBalance, double interestRate) {
	        Customer customer = new Customer(name, address, phoneNumber);
	        customers.add(customer);

	        BankAccount account = null;
	        if (accountType == 1) {
	            account = new CheckingAccount(customer.getAccountNumber(), initialBalance);
	        } else if (accountType == 2) {
	            account = new SavingsAccount(customer.getAccountNumber(), initialBalance, interestRate);
	        } else {
	            System.out.println("Invalid account type.");
	            return;
	        }

	        accounts.add(account);
	        System.out.println("Account opened successfully.");
	    }

	    public void closeAccount(int accountNumber) {
	        Iterator<BankAccount> iterator = accounts.iterator();
	        while (iterator.hasNext()) {
	            BankAccount account = iterator.next();
	            if (account.getAccountNumber() == accountNumber) {
	                iterator.remove();
	                System.out.println("Account closed successfully.");
	                return;
	            }
	        }
	        System.out.println("Account not found.");
	    }

	    public void loginToAccount(int accountNumber) {
	        for (BankAccount account : accounts) {
	            if (account.getAccountNumber() == accountNumber) {
	                displayAccountMenu(account);
	                return;
	            }
	        }
	        System.out.println("Account not found.");
	    }

	    public void displayAccountMenu(BankAccount account) {
	        Scanner scanner = new Scanner(System.in);
	        int choice;
	        do {
	            System.out.println("\nAccount Menu");
	            System.out.println("1. Check Balance");
	            System.out.println("2. Make Deposit");
	            System.out.println("3. Make Withdrawal");
	            System.out.println("4. Calculate Zakat");
	            System.out.println("5. Print Statement");
	            System.out.println("6. Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    account.checkBalance();
	                    break;
	                case 2:
	                    double depositAmount;
	                    System.out.print("Enter the deposit amount: ");
	                    depositAmount = scanner.nextDouble();
	                    account.makeDeposit(depositAmount);
	                    break;
	                case 3:
	                    double withdrawalAmount;
	                    System.out.print("Enter the withdrawal amount: ");
	                    withdrawalAmount = scanner.nextDouble();
	                    account.makeWithdrawal(withdrawalAmount);
	                    break;
	                case 4:
	                    account.calculateZakat();
	                    break;
	                case 5:
	                    account.printStatement();
	                    break;
	                case 6:
	                    System.out.println("Exiting account menu.");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        } while (choice != 6);
	    }

	    public void setInterestRate(double interestRate) {
	        for (BankAccount account : accounts) {
	            if (account instanceof SavingsAccount) {
	                ((SavingsAccount) account).calculateInterest();
	            }
	        }
	    }

	    public void displayAllAccountDetails() {
	        System.out.println("\nAll Account Details");
	        for (Customer customer : customers) {
	            customer.displayInfo();
	            for (BankAccount account : accounts) {
	                if (account.getAccountNumber() == customer.getAccountNumber()) {
	                    account.checkBalance();
	                }
	            }
	            System.out.println("-----------------------------------");
	        }
	    }

	    public void displayAllDeductions() {
	        System.out.println("\nAll Deductions");
	        for (BankAccount account : accounts) {
	            account.printStatement();
	        }
	    }

	    public void close() {
	        for (BankAccount account : accounts) {
	            account.close();
	        }
	    }
	
}

