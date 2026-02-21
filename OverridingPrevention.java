// Parent class
class Parent {
    final  void show() {             //to vercome problem using final keyword should comment the child clas function
        System.out.println("This is Parent class method");
    }
}

// Child class
class Child extends Parent {

    // The below method will cause error if uncommented
    /* 
    void show() {
        // to overcome function overridding using super keyword
        //super.show();
        System.out.println("This is Child class method");
    }
    */
}

public class OverridingPrevention {
    public static void main(String[] args) {
        Child obj = new Child();
        obj.show();
    }
}
// if not using final keyword in parent class method then the child class can override the parent class method
// if no keyword is used then the output will be "This is Child class method"