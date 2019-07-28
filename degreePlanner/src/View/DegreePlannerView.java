package View;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import Controller.DegreePlannerController;
import Model.DegreePlannerModel;
import Model.ModelEvent;
import View.LoginView.Handler;

public class DegreePlannerView extends JFrameView
{
	public static final String CREATE_PLAN = "Create Plan";
	public static final String CLEAR_PLAN = "Clear Plan";
	public static final String ADD_COURSE = "Add Course";
	public static final String REMOVE_COURSE = "Remove Course";
	public static final String ADD_MAJOR = "Add Major";
	public static final String REMOVE_MAJOR = "Remove Major";
	public static final String ADD_MINOR = "Add Minor";
	public static final String REMOVE_MINOR = "Remove Minor";
	public static final String LOGOUT = "Log Out";
    public DegreePlannerView(DegreePlannerModel model, DegreePlannerController controller){
		super(model, controller); 
		JPanel buttonPanel = new JPanel();
		Handler handler = new Handler();
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(handler);
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(handler);
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(handler);
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(handler);
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(handler);
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(handler);
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(handler);
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(handler);
		JButton loginButton = new JButton("Log Out");
		loginButton.addActionListener(handler);
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
			//add more commands (and probably change this one too)
			((DegreePlannerController)getController()).operation(e.getActionCommand()); 
	    } 
	}
}
