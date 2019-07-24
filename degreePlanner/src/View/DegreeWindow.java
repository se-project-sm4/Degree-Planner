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
    JButton addMajor = new JButton("Add Major");
    JButton addMinor = new JButton("Add Minor");
    JButton rmvMajor = new JButton("Remove Major");
    JButton rmvMinor = new JButton("Remove Minor");

    DegreeWindow(){
        super("Degree Planner");
        setSize(500,500);
        setLocation(500,280);
        panel.setLayout (new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        title.setBounds(230,10,150,20);

        panel.add(title);
        panel.add(addMajor);
        panel.add(addMinor);
        panel.add(rmvMajor);
        panel.add(rmvMinor);

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
