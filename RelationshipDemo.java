
// Parent class
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

// Child class (ISA relationship)
class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}
// Engine class
class Engine {
    void start() {
        System.out.println("Engine starts");
    }
}

// Car class (HAS-A relationship)
class Car {
    Engine engine = new Engine();  // Car HAS-A Engine

    void drive() {
        engine.start();
        System.out.println("Car is moving");
    }
}
public class RelationshipDemo {
    public static void main(String[] args) {

        // ISA relationship demo
        Dog d = new Dog();
        d.eat();   // inherited method
        d.bark();  // own method

        System.out.println();

        // HAS-A relationship demo
        Car c = new Car();
        c.drive();
    }
}
