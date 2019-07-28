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
		Handler handler = new Handler();
		JButton loginButton = new JButton(LOGIN);
		loginButton.addActionListener(handler);
		JButton registerButton = new JButton(REGISTER);
		registerButton.addActionListener(handler);
		buttonPanel.setLayout(new GridLayout(1, 2));
		this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.add(loginButton, null);
		buttonPanel.add(registerButton, null);
		pack();
	}
	
	public void modelChanged(ModelEvent event) {
		if(event.getType() == 0) {
			//login success
			this.dispose();
		}else if(event.getType() == 1) {
			//login fail
		}else if(event.getType() == 2) {
			//register success
		}else{
			//register fail
		}
	}

	class Handler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			((MainController)getController()).operation(e.getActionCommand(), usernameField.getText(), passwordField.getText(), "");
	    } 
	}
	
	public static void main(String [] args) { new MainController(); }
}
