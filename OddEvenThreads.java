class OddThread implements Runnable {
    int n;

    OddThread(int n) {
        this.n = n;
    }

    public void run() {
        for (int i = 1; i <= n; i += 2) {
            System.out.println("Odd Thread: " + i);
            try {
                Thread.sleep(500);
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
            System.out.println("Even Thread: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class OddEvenThreads {
    public static void main(String[] args) {

        int N = 10;  // Change value as needed

        Thread odd = new Thread(new OddThread(N));
        Thread even = new Thread(new EvenThread(N));

        odd.start();
        even.start();
    }
}
