class Printer {

    synchronized public void printDocument(String docName) {
        System.out.println("Printing started: " + docName);

        try {
            // Simulate time taken to print
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Printing completed: " + docName);
    }
}

class User extends Thread {
    Printer printer;
    String document;

    User(Printer printer, String document) {
        this.printer = printer;
        this.document = document;
    }

    public void run() {
        printer.printDocument(document);
    }
}

public class PrinterQueueSynchronized {
    public static void main(String[] args) {

        Printer printer = new Printer();

        User u1 = new User(printer, "Document_A");
        User u2 = new User(printer, "Document_B");
        User u3 = new User(printer, "Document_C");

        u1.start();
        u2.start();
        u3.start();
    }
}
