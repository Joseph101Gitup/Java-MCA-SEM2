//Create 2 threads to display froim 1 to n and n to 1
class NTherad extends Thread {
    int n,m;
    public NTherad(int a,int b) {
        n=a;
        m=b;
    }
    public void run(){
        while(n!=m){
            System.out.println(n+"\t");
            if(n<m)
                n++;
            else
                n--;
        }
        System.out.println(n+"\t");
    }
}
public class ThreadnTo1 {
    public static void main(String[] args) {
        NTherad t1=new NTherad(1,20);
        NTherad t2=new NTherad(20,1);
        System.out.println("Thread from 1 to 20:");
        t1.start();
        System.out.println("Thread from 20 to 1:");
        t2.start();
    }
}