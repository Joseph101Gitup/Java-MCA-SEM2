/*
     Write a program to implement a Generic class.
     This program demonstrates a generic class that can store and retrieve any type of object.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
class Box<T> {
    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}

public class GenericClassDemo {
    public static void main(String[] args) {
        // Generic class instance for Integer
        Box<Integer> integerBox = new Box<>();
        integerBox.add(10);
        System.out.println("Integer Value: " + integerBox.get());

        // Generic class instance for String
        Box<String> stringBox = new Box<>();
        stringBox.add("Hello World");
        System.out.println("String Value: " + stringBox.get());
        
        // Generic class instance for Double
        Box<Double> doubleBox = new Box<>();
        doubleBox.add(15.5);
        System.out.println("Double Value: " + doubleBox.get());
    }
}
