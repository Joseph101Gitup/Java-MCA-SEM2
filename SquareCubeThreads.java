import java.util.Scanner;

class SquareThread implements Runnable {
    int num;

    SquareThread(int num) {
        this.num = num;
    }

    public void run() {
        int square = num * num;
        System.out.println("Square of " + num + " = " + square);
    }
}

class CubeThread implements Runnable {
    int num;

    CubeThread(int num) {
        this.num = num;
    }

    public void run() {
        int cube = num * num * num;
        System.out.println("Cube of " + num + " = " + cube);
    }
}

public class SquareCubeThreads {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        Thread t1 = new Thread(new SquareThread(n));
        Thread t2 = new Thread(new CubeThread(n));

        t1.start();   // start square thread
        t2.start();   // start cube thread

        sc.close();
    }
}
