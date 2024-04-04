package accountmanagement;

public class Customer {
	private String name;
    private String address;
    private String phoneNumber;
    private int accountNumber;
    private static int nextAccountNumber = 1;

    public Customer(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.accountNumber = nextAccountNumber++;
    }

    public String getName() {
        return name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void displayInfo() {
        System.out.println("Customer Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Account Number: " + accountNumber);
    }

}
