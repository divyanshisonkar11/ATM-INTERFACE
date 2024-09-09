import java.util.ArrayList;
import java.util.List;

public class Account {
    private String userID;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(String userID) {
        this.userID = userID;
        this.balance = 0;
        this.transactionHistory = new ArrayList<>();
    }

    public double getBalance() {
        System.out.println("Loading your account balance...........");
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdraw", amount));
            return true;
        }
        return false;
    }

    public void transfer(double amount, String recipientID) {
        balance -= amount;
        transactionHistory.add(new Transaction("Transfer to " + recipientID, amount));
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public String getUserID() {
        return userID;
    }
}