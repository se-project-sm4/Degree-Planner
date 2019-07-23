package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DegreePlannerView extends JFrame {

    public static void main(String[] args) {
        
        DegreePlannerView frame = new DegreePlannerView();
    }

    JButton login = new JButton("Login");
    JPanel panel = new JPanel();
    JTextField username = new JTextField(15);
    JPasswordField pass = new JPasswordField(15);
    JLabel userLab = new JLabel("Username:");
    JLabel passLab = new JLabel("Password:");

    DegreePlannerView(){
        super("Login Authentication");
        setSize(300,200);
        setLocation(500,280);
        panel.setLayout (null);

        username.setBounds(70,35,150,20);
        pass.setBounds(70,75,150,20);
        userLab.setBounds(70,15,150,20);
        passLab.setBounds(70,55,150,20);
        login.setBounds(105,110,80,20);

        panel.add(login);
        panel.add(userLab);
        panel.add(username);
        panel.add(passLab);
        panel.add(pass);

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        actionlogin();
    }

    public void actionlogin(){
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String puname = username.getText();
                String ppaswd = pass.getText();
                if(puname.equals("user") && ppaswd.equals("pass")) {
                    DegreeWindow regFace =new DegreeWindow();
                    regFace.setVisible(true);
                    dispose();
                } else {

                    JOptionPane.showMessageDialog(null,"Wrong Password / Username");
                    username.setText("");
                    pass.setText("");
                    username.requestFocus();
                }

            }
        });
    }
}