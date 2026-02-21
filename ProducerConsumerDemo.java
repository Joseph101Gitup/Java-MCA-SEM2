class Q {
    int n;
    boolean f = false;

    synchronized int get() {
        while (!f) {  // wait until a value is produced
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        int value = n;
        f = false;
        notify();     // notify producer
        return value;
    }

    synchronized void put(int a) {
        while (f) {   // wait if buffer is full
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        n = a;
        f = true;
        notify();     // notify consumer
    }
}

class Producer implements Runnable {
    Q q;
    Thread t;

    Producer(Q q) {
        this.q = q;
        t = new Thread(this, "Producer");
        t.start();
    }

    public void run() {
        int i = 0;
        while (true) {
            q.put(i);
            System.out.printf("%-10s", "PUT: " + i);  // left-align
            i++;
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }
}

class Consumer implements Runnable {
    Q q;
    Thread t;

    Consumer(Q q) {
        this.q = q;
        t = new Thread(this, "Consumer");
        t.start();
    }

    public void run() {
        while (true) {
            int value = q.get();
            System.out.printf("%-10s\n", "GOT: " + value); // new line after consumer
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}
