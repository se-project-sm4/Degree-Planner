package View;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import Controller.MainController;
import Model.LoginModel;
import Model.ModelEvent;

public class LoginView extends JFrameView {
	public static final String LOGIN = "Login"; 
	public static final String REGISTER = "Register"; 
	private JTextField usernameField = new JTextField(); 
	private JTextField passwordField = new JTextField(); 
	private JLabel notifier = new JLabel(); 
	
	public LoginView(LoginModel model, MainController controller) { 
		super(model, controller);
		usernameField.setText("Username");
		passwordField.setText("Password");
		notifier.setText("Login/Register");
		JPanel mainPanel= new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(notifier);
		mainPanel.add(usernameField);
		mainPanel.add(passwordField);
		this.getContentPane().add(mainPanel, BorderLayout.NORTH);
		JPanel buttonPanel = new JPanel();
		LoginHandler loginHandler = new LoginHandler();
		JButton loginButton = new JButton(LOGIN);
		loginButton.addActionListener(loginHandler);
		RegisterHandler registerHandler = new RegisterHandler();
		JButton registerButton = new JButton(REGISTER);
		registerButton.addActionListener(registerHandler);
		buttonPanel.setLayout(new GridLayout(1, 2));
		this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.add(loginButton, null);
		buttonPanel.add(registerButton, null);
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
			System.out.println("hello");
			notifier.setText("Registration Failed");
		}
	}

	class LoginHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			((MainController)getController()).loginOperation(usernameField.getText(), passwordField.getText());
	    } 
	}

	class RegisterHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			((MainController)getController()).registerOperation(usernameField.getText(), passwordField.getText());
	    } 
	}
	
	public static void main(String [] args) { new MainController(); }
}
