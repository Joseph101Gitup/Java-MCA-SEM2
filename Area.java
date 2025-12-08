/*
create an interfaces named shape having prototypes for read disp and area
there are 3 classes circle rectangle and triangle implements the interface shape provide necessary data members and functions 
write a menu driven program so that the interface reference object can print any of the objects specified by the user
*/
import java.util.*;
interface shape{
    public void read();
    public void disp();
    public double area();
}
class circle implements shape{
    double r;
    public void read(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter radius of circle:");
        r=sc.nextInt();
    }
    public void disp(){
        System.out.println("Circle with radius: " + r);
    }
    public double area(){
        return 3.14*r*r;
    }
}
class rectangle implements shape{
    int l,b;
    public void read(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter length and breadth of rectangle:");
        l=sc.nextInt();
        b=sc.nextInt();
    }
    public void disp(){
        System.out.println("Rectangle with length: " + l + " and breadth: " + b);
    }
    public double area(){
        return l*b;
    }
}
class triangle implements shape{
    int base,height;
    public void read(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter base and height of triangle:");
        base=sc.nextInt();
        height=sc.nextInt();
    }
    public void disp(){
        System.out.println("Triangle with base: " + base + " and height: " + height);
    }
    public double area(){
        return 0.5*base*height;
    }
}
public class Area {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        shape s=null;
        int choice;
        do{
            System.out.println("Menu:");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice=sc.nextInt();
            switch(choice){
                case 1:
                    s=new circle();
                    break;
                case 2:
                    s=new rectangle();
                    break;
                case 3:
                    s=new triangle();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    continue;
                default:
                    System.out.println("Invalid choice! Try again.");
                    continue;
            }
            s.read();
            s.disp();
            System.out.println("Area: " + s.area());
        }while(choice!=4);
        sc.close();
    }
}