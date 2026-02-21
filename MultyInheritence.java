/*create a class A having an integer data member.
create a class B inherited from class A having a string data member 
create class C inherited from B having a flout data member
provide constructors , read and display member function.
create a menu driven program so that the user can select the object to be created {

    
} */
import java.util.Scanner;
class A{
    int data;
    A(){
        System.out.println("In A's Constructor");
    }
    //System.out.println("A's data: "+data);
    public void read(Scanner s){
        System.out.println("Enter A's data:");
        data=s.nextInt();
    }
    public void display(){
        System.out.println("A's data is: "+data);
    }
}
class B extends A{
    String str;
    B(){
        System.out.println("In B's Constructor");
    }
    //str="Hello";
    //System.out.println("B's String: "+str);
    public void read(Scanner s){
        super.read(s);
        System.out.println("Enter B's String:");
        str=s.nextLine();
    }
    public void display(){
        super.display();
        System.out.println("B's String is: "+str);
    }
}
class C extends B{
    float fdata;
    C(){
        System.out.println("In C's Constructor");
    }
    //fdata=10.5f;
    //System.out.println("C's Float data: "+fdata);
    public void read(Scanner s){
        super.read(s);
        System.out.println("Enter C's Float data:");
        fdata=s.nextFloat();
    }
    public void display(){
        super.display();
        System.out.println("C's Float data is: "+fdata);
    }
}

public class MultyInheritence {
    
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        System.out.println("Menu:");
        System.out.println("1. Create object of A");
        System.out.println("2. Create object of B");
        System.out.println("3. Create object of C");
        System.out.println("Enter your choice:");
        int choice=s.nextInt();
        switch(choice){
            case 1:
                A aobj=new A();
                aobj.read(s);
                aobj.display();
                break;
            case 2:
                B bobj=new B();
                bobj.read(s);
                bobj.display();
                break;
            case 3:
                C cobj=new C();
                cobj.read(s);
                cobj.display();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
