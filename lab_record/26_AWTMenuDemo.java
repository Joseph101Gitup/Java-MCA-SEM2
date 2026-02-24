/*
     AWT Menu demonstration.
     Demonstration of MenuBar, Menu, and MenuItem components in AWT.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.awt.*;
import java.awt.event.*;

public class AWTMenuDemo extends Frame implements ActionListener {
    MenuBar mb;
    Menu fileMenu, editMenu, helpMenu;
    MenuItem newItem, openItem, saveItem, exitItem, cutItem, copyItem, pasteItem, aboutItem;
    Label lStatus;

    public AWTMenuDemo() {
        mb = new MenuBar();
        
        // File Menu
        fileMenu = new Menu("File");
        newItem = new MenuItem("New");
        openItem = new MenuItem("Open");
        saveItem = new MenuItem("Save");
        exitItem = new MenuItem("Exit");
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // Edit Menu
        editMenu = new Menu("Edit");
        cutItem = new MenuItem("Cut");
        copyItem = new MenuItem("Copy");
        pasteItem = new MenuItem("Paste");
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        // Help Menu
        helpMenu = new Menu("Help");
        aboutItem = new MenuItem("About");
        helpMenu.add(aboutItem);

        mb.add(fileMenu);
        mb.add(editMenu);
        mb.setHelpMenu(helpMenu);

        setMenuBar(mb);

        lStatus = new Label("Select a menu item...");
        add(lStatus, BorderLayout.SOUTH);

        // Add action listeners
        newItem.addActionListener(this);
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);
        cutItem.addActionListener(this);
        copyItem.addActionListener(this);
        pasteItem.addActionListener(this);
        aboutItem.addActionListener(this);

        setTitle("AWT Menu Demo");
        setSize(400, 300);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Exit")) {
            System.exit(0);
        } else {
            lStatus.setText("Menu Item Selected: " + cmd);
        }
    }

    public static void main(String[] args) {
        new AWTMenuDemo();
    }
}
