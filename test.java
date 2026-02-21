class C1{
    public void display(){
        System.out.println("In disapay");
    }
    public void show(){
        System.out.println("In show");
    }
}
class M2 {
    public static void main(String args[]) {
        C1 obj = new C1();
        System.out.println("In main");
        obj.display();
        System.out.println("Back to main");
        obj.show();
    }
}
class M1 {
    public static void main(String args[]) {
        C1 obj = new C1();
        System.out.println("In main");
        obj.display();
        System.out.println("Back to main");
        obj.show();
        System.out.println("Finishaed");
    }
}