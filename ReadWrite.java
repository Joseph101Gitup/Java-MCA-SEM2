//readers writers problem
class MBook{
    int content;
    boolean readflag=false;
    synchronized void readBook()  {
        try {
            if(readflag==true){
                wait();
            }
            System.out.println("Reader reading content: "+content);
            readflag=true;
            notify();
        } catch (Exception e) {
        }
    }
    synchronized void writeBook(int wno) {
        try {
            if(readflag==false){
                wait();
            }
            content=wno;
            System.out.println("Writer writing content: "+content);
            readflag=false;
            notify();
        } catch (Exception e) {
        }
    }
}
class Reader extends Thread{
    MBook b;
    public Reader(MBook b) {
        this.b=b;
    }
    public void run(){
        while (true) { 
           b.readBook();
        }
    }
   
}
class Writer extends Thread{
    MBook b;
    public Writer(MBook b) {
        this.b=b;
    }
    public void run(){
        int i=1;
        while (true) { 
            b.writeBook(i);
            i++;
        }
    }
}
public class ReadWrite {
    public static void main(String[] args) {
        MBook b=new MBook();
        Reader r=new Reader(b);
        Writer w=new Writer(b);
        r.start();
        w.start();
    }
}