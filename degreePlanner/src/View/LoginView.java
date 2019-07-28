package View;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import Controller.LoginController;
import Model.LoginModel;
import Model.ModelEvent;

public class LoginView extends JFrameView {
	public static final String LOGIN = "Login"; 
	public static final String REGISTER = "Register"; 
	private JTextField usernameField = new JTextField(); 
	private JTextField passwordField = new JTextField(); 
	
	public LoginView(LoginModel model, LoginController controller) { 
		super(model, controller);
		usernameField.setText("Username");
		passwordField.setText("Password");
		this.getContentPane().add(usernameField, BorderLayout.NORTH);
		this.getContentPane().add(passwordField, BorderLayout.CENTER);
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
		//change this
		String msg = event.getAmount() + "";
	}

	class Handler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			((LoginController)getController()).operation(e.getActionCommand(), usernameField.getText(), passwordField.getText());
	    } 
	}
	
	public static void main(String [] args) { new LoginController(); }
}
