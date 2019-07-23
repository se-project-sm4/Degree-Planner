package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class DegreeWindow extends JFrame {

    public static void main(String[] args) {
        DegreeWindow frameTabel = new DegreeWindow();
    }

    JLabel title = new JLabel("Homepage");
    JPanel panel = new JPanel();

    DegreeWindow(){
        super("Degree Planner");
        setSize(500,500);
        setLocation(500,280);
        panel.setLayout (null);

        title.setBounds(230,10,150,20);

        panel.add(title);

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}