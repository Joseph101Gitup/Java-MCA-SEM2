/* create a user defined exception class for handling different
types of errors. create another class for reading and validating a password based on seartion conditions.
1. Password should be in alphanumeric
2. At least 1 lowercase 
3. At least 1 UPPEDCASE 
4. Special characters allowed are '@','*','!','{','}','(','(','[',']',and'='
At least 1 needed  
5. There Should not be any consecutive repetition of characters
6. Minimum length 8.
7. At least 1 Special character needed */
import java.io.*;
class  Errorhandeling extends Exception{
    String strError;
    public Errorhandeling(){
        strError="Unknown Error";
    }
    public Errorhandeling(String s){
        strError=s;
    }
    public String showError(){
        return strError;
    }
}
class PasswordValidator{
    public static void main(String args[]){
        DataInputStream din=new DataInputStream(System.in);
        String password;
        System.out.println("Enter the password to validate:");
        try{
            password=din.readLine();
            int len=password.length();
            boolean hasLower=false,hasUpper=false,hasSpecial=false,hasConsecutive=false,isAlphanumeric=true,hasDigit = false;
            String specialChars="@*!{}()[]=";
            for(int i=0;i<len;i++){
                char ch=password.charAt(i);
                if(Character.isLowerCase(ch)){
                    hasLower=true;
                }else if(Character.isUpperCase(ch)){
                    hasUpper=true;
                }else if (Character.isDigit(ch)) {
                    hasDigit = true;   
                }else if(specialChars.indexOf(ch)!=-1){
                    hasSpecial=true;
                }else if(!Character.isDigit(ch)){
                    isAlphanumeric=false;
                }if(i>0 && ch==password.charAt(i-1)){
                    hasConsecutive=true;
                }
            }
            if(len<8){
                throw new Errorhandeling("Password must be at least 8 characters long.");
            }
            if(!isAlphanumeric){
                throw new Errorhandeling("Password must be alphanumeric.");
            }
            if(!hasLower){
                throw new Errorhandeling("Password must contain at least one lowercase letter.");
            }
            if(!hasUpper){
                throw new Errorhandeling("Password must contain at least one uppercase letter.");
            }
            if(!hasSpecial){
                throw new Errorhandeling("Password must contain at least one special character.");
            }
            if(hasConsecutive){
                throw new Errorhandeling("Password must not have consecutive repeating characters.");
            }
            if (!hasDigit) {
                throw new Errorhandeling("Password must contain at least one numeric digit.");
            }
            System.out.println("Password is valid.");
        }catch(IOException e){
            System.out.println("IO Error: "+e.getMessage());
        }catch(Errorhandeling e){
            System.out.println("Password Validation Error: "+e.showError());
        }
    }
}

