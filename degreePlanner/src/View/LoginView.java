package View;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import Controller.MainController;
import Model.LoginModel;
import Model.ModelEvent;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
public class LoginView extends JFrameView {
	private static final long serialVersionUID = 1L;
	private JTextField usernameField = new JTextField(); 
	private JTextField passwordField = new JTextField(); 
	private JLabel notifier = new JLabel(); 
	
	public LoginView(LoginModel model, MainController controller) { 
		super(model, controller);

		setTitle("Login/Registration Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		setPreferredSize(new Dimension(300 , 140));
		setLocation(width/2 - 150, height/2 - 70);

		JPanel titlePanel = new JPanel();
		notifier.setText("Login or Register");
		notifier.setHorizontalAlignment(JLabel.CENTER);
		notifier.setVerticalAlignment(JLabel.CENTER);
		titlePanel.add(notifier);

		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(2, 2));
		JLabel usernameLabel = new JLabel("Username:", SwingConstants.CENTER);
		JLabel passwordLabel = new JLabel("Password:", SwingConstants.CENTER);
		infoPanel.add(usernameLabel);
		infoPanel.add(usernameField);
		infoPanel.add(passwordLabel);
		infoPanel.add(passwordField);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2));
		LoginHandler loginHandler = new LoginHandler();
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(loginHandler);
		RegisterHandler registerHandler = new RegisterHandler();
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(registerHandler);
		buttonPanel.add(loginButton, null);
		buttonPanel.add(registerButton, null);

		this.getContentPane().add(titlePanel, BorderLayout.NORTH);
		this.getContentPane().add(infoPanel, BorderLayout.CENTER);
		this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		pack();
	}
	
	public void modelChanged(ModelEvent event) {
		if(event.getType() == 0) {
			notifier.setText("Login Successful!");
		}else if(event.getType() == 1) {
			notifier.setText("Login Failed");
		}else if(event.getType() == 2) {
			notifier.setText("Registration Successful!");
		}else{
			notifier.setText("Registration Failed");
		}
	}

	class LoginHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			((MainController)getController()).login(usernameField.getText(), passwordField.getText());
	    } 
	}

	class RegisterHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			((MainController)getController()).register(usernameField.getText(), passwordField.getText());
	    } 
	}
	
	public static void main(String [] args) { new MainController(); }
}
