package accountmanagement;

public class CheckingAccount extends BankAccount {
    private int freeTransactionsPerMonth;
    private int transactionCount;
    private double transactionFee;

    public CheckingAccount(int accountNumber, double balance, int freeTransactionsPerMonth) {
        super(accountNumber, balance);
        this.freeTransactionsPerMonth = freeTransactionsPerMonth;
        this.transactionCount = 0;
        this.transactionFee = 10.0;
    }

    public CheckingAccount(int accountNumber, double balance) {
        this(accountNumber, balance, 2); // Default to 2 free transactions per month
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void makeWithdrawal(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " PKR");
            transactionCount++;
            if (transactionCount > freeTransactionsPerMonth) {
                double fee = (transactionCount - freeTransactionsPerMonth) * transactionFee;
                balance -= fee;
                System.out.println("Transaction Fee: " + fee + " PKR");
            }
        } else {
            System.out.println("Insufficient balance.");
        }
    }

}