import java.util.Date;

public class Transaction {
    private String transactionType;
    private double amount;
    private Date date;

    public Transaction(String transactionType, double amount) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = new Date(); // Automatically stores the date of the transaction
    }

    public String toString() {
        return "Transaction: " + transactionType + " | Amount: " + amount + " | Date: " + date;
    }
}