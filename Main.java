import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Account current = new CurrentAccount("C001", "Emon", 5000);
        Account savings = new SavingsAccount("S001", "Rafi", 3000);
        PremiumAccount deposit = new PremiumAccount("D001", "Nayeem", 0);

        int choice;
        do {
            System.out.println("\n===== Account Management Menu =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer Money");
            System.out.println("4. Show Account Info");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Select Account: 1. Current  2. Savings  3. Deposit Premium");
                    int depositType = sc.nextInt();
                    System.out.print("Enter amount to deposit: ");
                    double damt = sc.nextDouble();
                    if (depositType == 1) current.deposit(damt);
                    else if (depositType == 2) savings.deposit(damt);
                    else if (depositType == 3) deposit.deposit(damt);
                    else System.out.println("Invalid Account Type");
                    break;

                case 2:
                    System.out.println("Select Account: 1. Current  2. Savings  3. Deposit Premium");
                    int withdrawType = sc.nextInt();
                    System.out.print("Enter amount to withdraw: ");
                    double wamt = sc.nextDouble();
                    boolean success = false;
                    if (withdrawType == 1) success = current.withdraw(wamt);
                    else if (withdrawType == 2) success = savings.withdraw(wamt);
                    else if (withdrawType == 3) success = deposit.withdraw(wamt);
                    else System.out.println("Invalid Account Type");

                    System.out.println(success ? "Withdrawal Successful" : "Withdrawal Failed");
                    break;

                case 3:
                    System.out.println("From Account: 1. Current  2. Savings");
                    int from = sc.nextInt();
                    System.out.println("To Account: 1. Current  2. Savings  3. Deposit Premium");
                    int to = sc.nextInt();
                    System.out.print("Enter amount to transfer: ");
                    double tamt = sc.nextDouble();

                    Account fromAcc = (from == 1) ? current : (from == 2) ? savings : null;
                    Account toAcc = (to == 1) ? current : (to == 2) ? savings : (to == 3) ? deposit : null;

                    if (fromAcc == null || toAcc == null || fromAcc instanceof PremiumAccount) {
                        System.out.println("Invalid transfer attempt.");
                    } else {
                        if (fromAcc.withdraw(tamt)) {
                            toAcc.deposit(tamt);
                            System.out.println("Transfer successful.");
                        } else {
                            System.out.println("Transfer failed. Insufficient funds.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Account Information:");
                    current.showInfo();
                    savings.showInfo();
                    deposit.showInfo();
                    System.out.println("Installments Paid (Deposit Premium): " + deposit.getInstallmentsPaid());
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}