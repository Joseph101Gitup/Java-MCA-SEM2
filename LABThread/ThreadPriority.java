class PriorityThread extends Thread {

    public PriorityThread(String name, int priority) {
        setName(name);           // set thread name
        setPriority(priority);   // set thread priority
    }

    public void run() {
        System.out.println(
            "Thread Name: " + getName() +
            " | Priority: " + getPriority()
        );

        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " running: " + i);
        }
    }
}

public class ThreadPriority {
    public static void main(String[] args) {

        PriorityThread t1 = new PriorityThread(
                "Low Priority Thread",
                Thread.MIN_PRIORITY);   // 1

        PriorityThread t2 = new PriorityThread(
                "Normal Priority Thread",
                Thread.NORM_PRIORITY); // 5

        PriorityThread t3 = new PriorityThread(
                "High Priority Thread",
                Thread.MAX_PRIORITY);  // 10

        t1.start();
        t2.start();
        t3.start();
    }
}
