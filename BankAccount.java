package accountmanagement;
import java.util.Date;

public abstract class BankAccount {
	protected int accountNumber;
    protected double balance;
    protected String dateCreated;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        Date currentTime = new Date();
        dateCreated = currentTime.toString();
    }

    public void checkBalance() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance + " PKR");
    }

    public void printStatement() {
        System.out.println("Transaction Date: " + dateCreated);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Transaction Amount: " + balance + " PKR");
    }

    public void makeDeposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " PKR");
    }

    public void makeWithdrawal(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " PKR");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void calculateZakat() {
        // Zakat calculation for Savings account (2.5% of total balance)
        System.out.println("Zakat: " + (balance * 2.5) / 100 + " PKR");
    }

	public int getAccountNumber() {
		// TODO Auto-generated method stub
		return accountNumber;
	}

	public void close() {
	}
	

}
