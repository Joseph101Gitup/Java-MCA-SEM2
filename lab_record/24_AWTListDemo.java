/*
     AWT List control functionality.
     Demonstration of List component in AWT including add, remove, and show operations.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.awt.*;
import java.awt.event.*;

public class AWTListDemo extends Frame implements ActionListener {
    List list;
    Button bAdd, bRemove, bClear, bShow;
    TextField tInput;
    Label lMsg;

    public AWTListDemo() {
        setLayout(new FlowLayout());

        tInput = new TextField(15);
        bAdd = new Button("Add Item");
        bRemove = new Button("Remove Selected");
        bClear = new Button("Clear List");
        bShow = new Button("Show Selected");
        
        // Multiple selection list
        list = new List(5, true); 
        list.add("Java");
        list.add("Python");
        list.add("C++");

        lMsg = new Label("Status: Ready");

        add(tInput);
        add(bAdd);
        add(list);
        add(bRemove);
        add(bClear);
        add(bShow);
        add(lMsg);

        bAdd.addActionListener(this);
        bRemove.addActionListener(this);
        bClear.addActionListener(this);
        bShow.addActionListener(this);

        setTitle("AWT List Control Demo");
        setSize(300, 400);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bAdd) {
            String item = tInput.getText();
            if (!item.isEmpty()) {
                list.add(item);
                tInput.setText("");
                lMsg.setText("Added: " + item);
            }
        } else if (e.getSource() == bRemove) {
            int index = list.getSelectedIndex();
            if (index != -1) {
                String item = list.getSelectedItem();
                list.remove(index);
                lMsg.setText("Removed: " + item);
            }
        } else if (e.getSource() == bClear) {
            list.removeAll();
            lMsg.setText("List Cleared");
        } else if (e.getSource() == bShow) {
            String[] items = list.getSelectedItems();
            String res = String.join(", ", items);
            lMsg.setText("Selected: " + (res.isEmpty() ? "None" : res));
        }
    }

    public static void main(String[] args) {
        new AWTListDemo();
    }
}
