class Base {
    int x;

    Base(int x) {
        this.x = x;
        System.out.println("Base class constructor called");
        System.out.println("Value of x: " + x);
    }
}

class Derived extends Base {
    int y;

    Derived(int x, int y) {
        super(x);  // Pass argument to base class constructor
        this.y = y;
        System.out.println("Derived class constructor called");
        System.out.println("Value of y: " + y);
    }
}

public class SuperConstructorDemoB {
    public static void main(String[] args) {
        Derived obj = new Derived(10, 20);
    }
}
