class MyThread extends Thread {

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Child Thread: " + i);
            try {
                Thread.sleep(500); // pause for 500 ms
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Thread1 {
    public static void main(String[] args) {

        MyThread t = new MyThread(); // create thread object
        t.start();                  // start child thread

        for (int i = 1; i <= 5; i++) {
            System.out.println("Main Thread: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
