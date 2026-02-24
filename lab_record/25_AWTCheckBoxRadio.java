/*
     AWT Checkbox and Radio button.
     Demonstration of Checkbox and CheckboxGroup (Radio button) in AWT.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.awt.*;
import java.awt.event.*;

public class AWTCheckBoxRadio extends Frame implements ItemListener {
    Checkbox cb1, cb2, rb1, rb2;
    CheckboxGroup cbg;
    Label lStatus;

    public AWTCheckBoxRadio() {
        setLayout(new FlowLayout());

        lStatus = new Label("Select options below:          ");
        
        // Checkboxes
        cb1 = new Checkbox("Java");
        cb2 = new Checkbox("Python");
        
        // Radio Buttons (using CheckboxGroup)
        cbg = new CheckboxGroup();
        rb1 = new Checkbox("Male", cbg, true);
        rb2 = new Checkbox("Female", cbg, false);

        add(lStatus);
        add(new Label("--- Checkboxes ---"));
        add(cb1); add(cb2);
        add(new Label("--- Radio Buttons ---"));
        add(rb1); add(rb2);

        cb1.addItemListener(this);
        cb2.addItemListener(this);
        rb1.addItemListener(this);
        rb2.addItemListener(this);

        setTitle("AWT Checkbox & Radio Demo");
        setSize(300, 250);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void itemStateChanged(ItemEvent e) {
        String msg = "CB1: " + cb1.getState() + ", CB2: " + cb2.getState() + 
                     ", Gender: " + cbg.getSelectedCheckbox().getLabel();
        lStatus.setText(msg);
    }

    public static void main(String[] args) {
        new AWTCheckBoxRadio();
    }
}
