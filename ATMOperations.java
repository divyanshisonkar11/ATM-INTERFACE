public class ATMOperations {

    public void withdraw(Account account, double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
            return;
        }
        if (account.withdraw(amount)) {
            System.out.println("Withdraw successful. New balance: " + account.getBalance());
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void deposit(Account account, double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
            return;
        }
        account.deposit(amount);
        System.out.println("Deposit successful. New balance: " + account.getBalance());
    }

    public void transfer(Account account, String recipientID, double amount) {
        if (account.getBalance() >= amount) {
            account.transfer(amount, recipientID);
            System.out.println("Transfer successful. New balance: " + account.getBalance());
        } else {
            System.out.println("Insufficient balance for transfer.");
        }
    }

    public void viewTransactionHistory(Account account) {
        System.out.println("Transaction History:");
        for (Transaction transaction : account.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }

    // New method to display the available balance
    public void viewBalance(Account account) {
        System.out.println("Available Balance: " + account.getBalance());
    }
}