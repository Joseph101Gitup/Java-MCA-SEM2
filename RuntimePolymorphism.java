// Interface
interface Shape {
    void draw();   // abstract method
}

// Implementing class 1
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

// Implementing class 2
class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

public class RuntimePolymorphism {
    public static void main(String[] args) {

        Shape s;   // interface reference

        s = new Circle();     // Circle object
        s.draw();             // calls Circle's draw()

        s = new Rectangle();  // Rectangle object
        s.draw();             // calls Rectangle's draw()
    }
}
