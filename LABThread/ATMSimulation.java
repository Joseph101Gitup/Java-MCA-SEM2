import Thread.ATMUser;
import Thread.BankAccount;

class BankAccount {
    private int balance = 1000; // Initial balance

    // Synchronized deposit
    public synchronized void deposit(int amount, String user) {
        int temp = balance;
        System.out.println(user + " is depositing " + amount + " | Current Balance: " + balance);
        temp += amount;
        try { Thread.sleep(500); } catch (InterruptedException e) {}
        balance = temp;
        System.out.println(user + " completed deposit. Updated Balance: " + balance);
    }

    // Synchronized withdraw
    public synchronized void withdraw(int amount, String user) {
        System.out.println(user + " is trying to withdraw " + amount + " | Current Balance: " + balance);
        if (amount <= balance) {
            int temp = balance;
            temp -= amount;
            try { Thread.sleep(500); } catch (InterruptedException e) {}
            balance = temp;
            System.out.println(user + " completed withdrawal. Updated Balance: " + balance);
        } else {
            System.out.println(user + " withdrawal failed! Insufficient balance.");
        }
    }

    public int getBalance() {
        return balance;
    }
}

class ATMUser extends Thread {
    BankAccount account;
    String userName;

    ATMUser(BankAccount account, String userName) {
        this.account = account;
        this.userName = userName;
    }

    public void run() {
        // Simulate some ATM operations
        account.deposit(500, userName);
        account.withdraw(300, userName);
    }
}

public class ATMSimulation {
    public static void main(String[] args) {
        BankAccount sharedAccount = new BankAccount();

        ATMUser user1 = new ATMUser(sharedAccount, "User1");
        ATMUser user2 = new ATMUser(sharedAccount, "User2");

        user1.start();
        user2.start();

        try {
            user1.join();
            user2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Final Balance: " + sharedAccount.getBalance());
    }
}
