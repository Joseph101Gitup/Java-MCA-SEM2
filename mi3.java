interface i1{
    public void disp() ;
}
interface i2{
    public void print();
}
class c1 implements i1,i2{
    public void disp(){
        System.out.println("in disp interface method");
        print();
    }
    public void print(){
        System.out.println("in print interface method");
        show();
    }
    public void show(){
        System.out.println("show not interface");
    }
}
class mi3{
    public static void main(String args[]){
        i1 obj1;
        i2 obj2;
        obj1=new c1();
        obj1.disp();
        obj2=new c1();
        obj2.print();
        //obj.show();
    }
}


