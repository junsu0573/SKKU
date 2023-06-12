public class BankAccount {

    private String bankNumber; // bank number user has
    private int pinCode; // the pin code user has
    private double balance; // the balance user has
    User user; // object for user class

    // four-argument constructor
    public BankAccount(String bankNumber, int pinCode, double balance, User user) {
        this.bankNumber = bankNumber;
        this.pinCode = pinCode;
        this.balance = balance;
        this.user = user;
    }

    // return the user's bank number
    public String getBankNumber() {
        return bankNumber;
    }

    // return the user's pin code
    public int getPinCode() {
        return pinCode;
    }

    // return the user's balance
    public double getBalance() {
        return balance;
    }

    // set user's bank number
    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    // set user's pin code
    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    // set user's balance
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
