import java.util.Scanner;

public class atm{
    public static void main(String[] args) {
        UserAuthentication auth = new UserAuthentication();
        ATMOperations operations = new ATMOperations();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM System");
        System.out.print("Enter User ID: ");
        String userID = scanner.nextLine();
        System.out.print("Enter User PIN: ");
        String userPIN = scanner.nextLine();

        if (auth.login(userID, userPIN)) {
            int choice;
            do {
                System.out.println("\nATM Menu:");
                System.out.println("1. View Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. View Available Balance");  // New option for balance inquiry
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        operations.viewTransactionHistory(auth.getAccount());
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        operations.withdraw(auth.getAccount(), withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        operations.deposit(auth.getAccount(), depositAmount);
                        break;
                    case 4:
                        System.out.print("Enter recipient account ID: ");
                        String recipientID = scanner.next();
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        operations.transfer(auth.getAccount(), recipientID, transferAmount);
                        break;
                    case 5:  // Case for checking balance
                        operations.viewBalance(auth.getAccount());
                        break;
                    case 6:
                        System.out.println("Thank you for using the ATM.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 6);
        } else {
            System.out.println("Invalid User ID or PIN.");
        }

        scanner.close();
    }
}