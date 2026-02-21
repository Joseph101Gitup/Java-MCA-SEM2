import java.util.Scanner;

class Author {
    String aName;
    int ano;

    Author() {
        aName = "";
        ano = 0;
    }

    Author(String aName, int ano) {
        this.aName = aName;
        this.ano = ano;
    }
    
    
    public void read(Scanner s) {
        System.out.println("Enter Author Name:");
        aName = s.nextLine();

        System.out.println("Enter Author Number:");
        ano = s.nextInt();
        s.nextLine(); // consume newline
    }
}

class Book extends Author {
    String bName;
    float bPrice;
    Book() {
        super();
        bName = "";
        bPrice = 0.0f;
    }
    Book(String aName, int ano, String bName, float bPrice) {
       
        this.bName = bName;
        this.bPrice = bPrice;
        super(aName, ano);
    }
    public void read(Scanner s) {
        

        System.out.println("Enter Book Name:");
        bName = s.nextLine();

        System.out.println("Enter Book Price:");
        bPrice = s.nextFloat();
        super.read(s);
    }

    public void display() {
        System.out.println("Author Name: " + aName);
        System.out.println("Author Number: " + ano);
        System.out.println("Book Name: " + bName);
        System.out.println("Book Price: " + bPrice);
    }
}

public class TClassAuthor {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        Book b = new Book();
        //System.out.println("Displaying default book details:");
       // b.display();
        b.read(s);
        b.display();
        s.close();
    }
}
