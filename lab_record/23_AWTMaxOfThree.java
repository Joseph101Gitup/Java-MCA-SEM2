/*
     Max of three numbers using AWT.
     GUI application to take three numbers and find the maximum among them.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.awt.*;
import java.awt.event.*;

public class AWTMaxOfThree extends Frame implements ActionListener {
    TextField t1, t2, t3, tResult;
    Button bFind;
    Label l1, l2, l3, lResult;

    public AWTMaxOfThree() {
        setLayout(new FlowLayout());
        
        l1 = new Label("Number 1:");
        t1 = new TextField(10);
        l2 = new Label("Number 2:");
        t2 = new TextField(10);
        l3 = new Label("Number 3:");
        t3 = new TextField(10);
        
        bFind = new Button("Find Maximum");
        lResult = new Label("Result:");
        tResult = new TextField(10);
        tResult.setEditable(false);

        add(l1); add(t1);
        add(l2); add(t2);
        add(l3); add(t3);
        add(bFind);
        add(lResult); add(tResult);

        bFind.addActionListener(this);

        setTitle("Max of Three Numbers");
        setSize(250, 300);
        setVisible(true);

        // Window closer
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int n1 = Integer.parseInt(t1.getText());
            int n2 = Integer.parseInt(t2.getText());
            int n3 = Integer.parseInt(t3.getText());
            
            int max = n1;
            if (n2 > max) max = n2;
            if (n3 > max) max = n3;
            
            tResult.setText(String.valueOf(max));
        } catch (NumberFormatException ex) {
            tResult.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new AWTMaxOfThree();
    }
}
