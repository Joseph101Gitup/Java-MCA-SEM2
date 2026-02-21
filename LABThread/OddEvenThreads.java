import java.util.Scanner;

class OddThread implements Runnable {
    int n;

    OddThread(int n) {
        this.n = n;
    }

    public void run() {
        for (int i = 1; i <= n; i += 2) {
            System.out.println("Odd: " + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class EvenThread implements Runnable {
    int n;

    EvenThread(int n) {
        this.n = n;
    }

    public void run() {
        for (int i = 2; i <= n; i += 2) {
            System.out.println("Even: " + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class OddEvenThreads {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of N: ");
        int N = sc.nextInt();

        Thread odd = new Thread(new OddThread(N));
        Thread even = new Thread(new EvenThread(N));

        odd.start();    // start odd thread first

        try {
            odd.join(); // wait for odd thread to complete
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        even.start();   // start even thread after odd thread finishes

        sc.close();
    }
}
