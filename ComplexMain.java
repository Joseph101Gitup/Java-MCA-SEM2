import java.util.Scanner;

class Complex {
    private double real;
    private double imag;

    // Read complex number
    public void read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter real part: ");
        real = sc.nextDouble();
        System.out.print("Enter imaginary part: ");
        imag = sc.nextDouble();
    }

    // Display complex number
    public void display() {
        if (imag >= 0)
            System.out.println(real + " + " + imag + "i");
        else
            System.out.println(real + " - " + Math.abs(imag) + "i");
    }

    // Add two complex numbers
    public Complex add(Complex c) {
        Complex temp = new Complex();
        temp.real = this.real + c.real;
        temp.imag = this.imag + c.imag;
        return temp;
    }

    // Multiply two complex numbers
    public Complex multiply(Complex c) {
        Complex temp = new Complex();
        temp.real = (this.real * c.real) - (this.imag * c.imag);
        temp.imag = (this.real * c.imag) + (this.imag * c.real);
        return temp;
    }
}

public class ComplexMain {
    public static void main(String[] args) {
        Complex c1 = new Complex();
        Complex c2 = new Complex();

        System.out.println("Enter first complex number:");
        c1.read();

        System.out.println("\nEnter second complex number:");
        c2.read();

        System.out.print("\nFirst number: ");
        c1.display();

        System.out.print("Second number: ");
        c2.display();

        Complex sum = c1.add(c2);
        Complex product = c1.multiply(c2);

        System.out.print("\nAddition result: ");
        sum.display();

        System.out.print("Multiplication result: ");
        product.display();
    }
}
