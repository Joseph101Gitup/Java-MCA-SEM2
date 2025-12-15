class UDE extends Exception{
    String strError;
    public UDE(){
        strError="Unknown Error";
    }
    public UDE(String s){
        strError=s;
    }
    public String showError(){
        return strError;
    }
}
class MUDE{
    public static void main(String args[]){
        int a=5,b=1,c;
        try{
            if(b==0)
                throw new UDE("DR is zero");
            c=a/b;
            System.out.println("Result="+c);
        }
        catch(UDE e){
            System.out.println(e.showError());
        }
    }
}