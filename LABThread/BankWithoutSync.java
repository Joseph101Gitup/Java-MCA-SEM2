class BankAccount {
    int balance = 1000;   // initial balance

    public void deposit(int amount) {
        int temp = balance;
        temp = temp + amount;
        balance = temp;
        System.out.println("Deposited: " + amount +
                " | Balance: " + balance);
    }

    public void withdraw(int amount) {
        int temp = balance;
        temp = temp - amount;
        balance = temp;
        System.out.println("Withdrawn: " + amount +
                " | Balance: " + balance);
    }
}

class DepositThread extends Thread {
    BankAccount acc;

    DepositThread(BankAccount acc) {
        this.acc = acc;
    }

    public void run() {
        acc.deposit(500);
    }
}

class WithdrawThread extends Thread {
    BankAccount acc;

    WithdrawThread(BankAccount acc) {
        this.acc = acc;
    }

    public void run() {
        acc.withdraw(300);
    }
}

public class BankWithoutSync {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        DepositThread d = new DepositThread(account);
        WithdrawThread w = new WithdrawThread(account);

        d.start();
        w.start();
    }
}
