
class calculate {
    public static void main(String args[]) {
        if(args.length < 3) {
            System.out.println("Usage: java Calculate <n1> <n2> <operation>");
            System.out.println("Operation: 0=Add, 1=Subtract, 2=Multiply, 3=Divide");
            return;
        }

        int n1, n2, result, ch;
        n1 = Integer.parseInt(args[0]);
        n2 = Integer.parseInt(args[1]);
        ch = Integer.parseInt(args[2]);

        switch(ch) {
            case 0:
                result = n1 + n2;
                System.out.println("Addition = " + result);
                break;

            case 1:
                result = n1 - n2;
                System.out.println("Subtraction = " + result);
                break;

            case 2:
                result = n1 * n2;
                System.out.println("Multiplication = " + result);
                break;

            case 3:
                if(n2 != 0) {
                    result = n1 / n2;
                    System.out.println("Division = " + result);
                } else {
                    System.out.println("Cannot divide by zero!");
                }
                break;

            default:
                System.out.println("Invalid operation!");
                break;
        }
    }
}
