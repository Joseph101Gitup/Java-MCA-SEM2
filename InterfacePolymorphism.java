import java.util.Scanner;

// Interface
interface ishape {
    void draw();
    void move();
}

// Circle class implementing ishape
class Circle implements ishape {
    public void draw() {
        System.out.println("Drawing Circle");
    }

    public void move() {
        System.out.println("Moving Circle");
    }
}

// Rectangle class implementing ishape
class Rectangle implements ishape {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }

    public void move() {
        System.out.println("Moving Rectangle");
    }
}

public class InterfacePolymorphism {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ishape s;   // interface reference

        System.out.println("Enter your choice:");
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        int choice = sc.nextInt();

        if (choice == 1) {
            s = new Circle();     // points to Circle object
        } else if (choice == 2) {
            s = new Rectangle();  // points to Rectangle object
        } else {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }

        s.draw();
        s.move();

        sc.close();
    }
}
