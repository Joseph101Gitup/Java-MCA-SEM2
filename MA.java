import java.io.*;
class Array {
    int a[],n;
    public void readSize() throws IOException,NumberFormatException{
        DataInputStream din=new DataInputStream(System.in);
        System.out.println("Enter n:");
        String s = din.readLine();
        n=Integer.parseInt(s);
    }
    public void ReadArrayElements() throws IOException,NumberFormatException,ArrayIndexOutOfBoundsException{
        DataInputStream din=new DataInputStream(System.in);
        readSize();
        a=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter a["+i+"]:");
            String s=din.readLine();
            a[i]=Integer.parseInt(s);
        }
    }
    public void displayArray() throws ArrayIndexOutOfBoundsException{
        System.out.println("Array elements are:");
        int i;

        for(i=0;i<n;i++){
            System.out.println("a["+i+"]="+a[i]);
        }
    }
}
class MA{
    public static void main(String args[]) {
        try{
            Array obj=new Array();
            obj.ReadArrayElements();
            obj.displayArray();
        }
        catch(IOException e1){
            System.out.println("Erri IO"+e1);
        }
        catch(NumberFormatException e2){
            System.out.println("Number Format Exception occurred"+e2);
        }
        catch(ArrayIndexOutOfBoundsException e3){
            System.out.println("Array Index Out Of Bounds Exception occurred"+e3);
        }
        catch(Exception e4){
            System.out.println("Some other exception occurred"+e4);
        }
        
    }
}