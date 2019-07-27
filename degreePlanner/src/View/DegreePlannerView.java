package View;
import javax.swing.*;

public class DegreePlannerView extends JFrame implements ActionListener{

    String adminUser = "user";
    String adminPass = "pass";

    JButton login = new JButton("Login");
    JButton register = new JButton("Register");
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

        username.setBounds(50,35,200,20);
        pass.setBounds(50,75,200,20);
        userLab.setBounds(70,15,150,20);
        passLab.setBounds(70,55,150,20);
        login.setBounds(65,110,80,20);
        register.setBounds(160,110,80,20);

        panel.add(login);
        panel.add(register);
        panel.add(userLab);
        panel.add(username);
        panel.add(passLab);
        panel.add(pass);

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        login.addActionListener(this);
        register.addActionListener(this);

    }
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==login){
            String puname = username.getText();
            String ppaswd = pass.getText();
            if(puname.equals(adminUser) && ppaswd.equals(adminPass)) {
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
        else if(e.getSource()==register){
            Actionregister();
        }

    }
    public void Actionregister(){

        JButton register2 = new JButton("Register");
        JPanel panel2 = new JPanel();
        JTextField newUser = new JTextField(15);
        JPasswordField newPass = new JPasswordField(15);
        JLabel userLab2 = new JLabel("Enter new username:");
        JLabel passLab2 = new JLabel("Enter new password:");

        JFrame frame=new JFrame();
        frame.setLocationRelativeTo(null);

            frame.setSize(300, 200);
            setLocation(500, 280);
            panel.setLayout(null);

            newUser.setBounds(50, 35, 200, 20);
            newPass.setBounds(50, 75, 200, 20);
            userLab2.setBounds(70, 15, 150, 20);
            passLab2.setBounds(70, 55, 150, 20);
            register2.setBounds(65, 110, 80, 20);

            panel2.add(userLab2);
            panel2.add(newUser);
            panel2.add(passLab2);
            panel2.add(newPass);
            panel2.add(register2);

            getContentPane().add(panel2);

            frame.setContentPane(panel2);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400,200);
            frame.setVisible(true);
            register2.addActionListener(
        new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                {
                    String newPuname = newUser.getText();
                    String newPpaswd = newPass.getText();
                    if(newPuname.equals(adminUser) && newPpaswd.equals(adminPass)) {

                        JOptionPane.showMessageDialog(null,"Error: already taken");
                        username.setText("");
                        pass.setText("");
                        username.requestFocus();
                    } else {

                        JOptionPane.showMessageDialog(null,"Successfully added, logging in");

                        DegreeWindow regFace = new DegreeWindow();
                        regFace.setVisible(true);
                        dispose();

                    }
                    }
                }
        });
    }

}
