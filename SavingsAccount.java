package accountmanagement;

public class SavingsAccount extends BankAccount{

	
	
	private double interestRate;

    public SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }

    public void calculateInterest() {
        // Calculate interest annually
        double interest = (balance * interestRate) / 100;
        balance += interest;
        System.out.println("Interest Earned: " + interest + " PKR");
    }

    @Override
    public void calculateZakat() {
        // Zakat calculation for Savings account (2.5% of total balance)
        System.out.println("Zakat: " + (balance * 2.5) / 100 + " PKR");
    }

}
