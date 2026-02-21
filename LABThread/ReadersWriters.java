class SharedData {
    int readers = 0;
    boolean writing = false;

    synchronized void startRead() {
        try {
            while (writing) {
                wait();
            }
            readers++;
            System.out.println("Reader started reading. Readers count: " + readers);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    synchronized void endRead() {
        readers--;
        System.out.println("Reader stopped reading. Readers count: " + readers);
        notifyAll();
    }

    synchronized void startWrite() {
        try {
            while (readers > 0 || writing) {
                wait();
            }
            writing = true;
            System.out.println("Writer started writing.");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    synchronized void endWrite() {
        writing = false;
        System.out.println("Writer stopped writing.");
        notifyAll();
    }
}

class Reader extends Thread {
    SharedData data;

    Reader(SharedData data) {
        this.data = data;
    }

    public void run() {
        data.startRead();
        try { Thread.sleep(500); } catch (Exception e) {}
        data.endRead();
    }
}

class Writer extends Thread {
    SharedData data;

    Writer(SharedData data) {
        this.data = data;
    }

    public void run() {
        data.startWrite();
        try { Thread.sleep(500); } catch (Exception e) {}
        data.endWrite();
    }
}

public class ReadersWriters {
    public static void main(String[] args) {
        SharedData data = new SharedData();

        new Reader(data).start();
        new Reader(data).start();
        new Writer(data).start();
    }
}
