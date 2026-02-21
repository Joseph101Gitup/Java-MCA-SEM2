class Parent {
    void display() {
        System.out.println("Display method of Parent class");
    }
}

class Child extends Parent {
    void display() {
        System.out.println("Display method of Child class");
    }

    void show() {
        super.display();  // Calls Parent class method
    }
}

public class SuperMethodDemoA {
    public static void main(String[] args) {
        Child obj = new Child();
        obj.display();   // Child class method
        obj.show();      // Parent class method using super
    }
}
