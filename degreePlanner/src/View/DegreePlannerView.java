package View;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import Controller.DegreePlannerController;
import Model.DegreePlannerModel;
import Model.ModelEvent;

public class DegreePlannerView extends JFrameView
{
	//create operation items here
    public DegreePlannerView(DegreePlannerModel model, DegreePlannerController controller){
		super(model, controller); 
		//create non-operation items here
		//add items to view
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
