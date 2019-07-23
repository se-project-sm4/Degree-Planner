package View;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import Controller.DegreePlannerController;
import Model.DegreePlannerModel;
import Model.ModelEvent;

public class LoginView extends JFrameView {
	private JTextField textField = new JTextField(); 
	public LoginView(DegreePlannerModel model, DegreePlannerController controller) { 
		super(model, controller);
	}
	
	// Now implement the necessary event handling code 
	public void modelChanged(ModelEvent event) {
	String msg = event.getAmount() + "";
	textField.setText(msg);
	}
	/*

	// Inner classes for Event Handling 
	class Handler implements ActionListener { 
		// Event handling is handled locally
		public void actionPerformed(ActionEvent e) {
			((DegreePlannerController)getController()).operation(e.getActionCommand()); 
	   } }
	
	public static void main(String [] args) { new DegreePlannerController(); }
	*/
}
