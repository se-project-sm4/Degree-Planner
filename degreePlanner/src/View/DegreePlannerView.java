package View;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import Controller.MainController;
import Model.DegreePlannerModel;
import Model.ModelEvent;

public class DegreePlannerView extends JFrameView
{
	private JTextField courseIDField = new JTextField(); 
    public DegreePlannerView(DegreePlannerModel model, MainController controller){
		super(model, controller); 
		courseIDField.setText("Course ID");
		this.getContentPane().add(courseIDField, BorderLayout.NORTH);
		JPanel buttonPanel = new JPanel();
		CreatePlanHandler createPlanHandler = new CreatePlanHandler();
		JButton createPlanButton = new JButton("Create Plan");
		createPlanButton.addActionListener(createPlanHandler);
		ClearPlanHandler clearPlanHandler = new ClearPlanHandler();
		JButton clearPlanButton = new JButton("Clear Plan");
		clearPlanButton.addActionListener(clearPlanHandler);
		AddCourseHandler addCourseHandler = new AddCourseHandler();
		JButton addCourseButton = new JButton("Add Course");
		addCourseButton.addActionListener(addCourseHandler);
		RemoveCourseHandler removeCourseHandler = new RemoveCourseHandler();
		JButton removeCourseButton = new JButton("Remove Course");
		removeCourseButton.addActionListener(removeCourseHandler);
		AddMajorHandler addMajorHandler = new AddMajorHandler();
		JButton addMajorButton = new JButton("Add Major");
		addMajorButton.addActionListener(addMajorHandler);
		RemoveMajorHandler removeMajorHandler = new RemoveMajorHandler();
		JButton removeMajorButton = new JButton("Remove Major");
		removeMajorButton.addActionListener(removeMajorHandler);
		AddMinorHandler addMinorHandler = new AddMinorHandler();
		JButton addMinorButton = new JButton("Add Minor");
		addMinorButton.addActionListener(addMinorHandler);
		RemoveMinorHandler removeMinorHandler = new RemoveMinorHandler();
		JButton removeMinorButton = new JButton("Remove Minor");
		removeMinorButton.addActionListener(removeMinorHandler);
		LogoutHandler logoutHandler = new LogoutHandler();
		JButton logoutButton = new JButton("Log Out");
		logoutButton.addActionListener(logoutHandler);
		buttonPanel.setLayout(new GridLayout(1, 2));
		this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.add(createPlanButton, null);
		buttonPanel.add(clearPlanButton, null);
		buttonPanel.add(addCourseButton, null);
		buttonPanel.add(removeCourseButton, null);
		buttonPanel.add(addMajorButton, null);
		buttonPanel.add(removeMajorButton, null);
		buttonPanel.add(addMinorButton, null);
		buttonPanel.add(removeMinorButton, null);
		buttonPanel.add(logoutButton, null);
		pack();
    }

	public void modelChanged(ModelEvent event) {
		//change this
		String msg = event.getType() + "";
	 }
	
	class CreatePlanHandler implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			((MainController)getController()).createPlan(); 
	    } 
	}
	
	class ClearPlanHandler implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			((MainController)getController()).clearPlan(); 
	    } 
	}
	
	class AddCourseHandler implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			((MainController)getController()).addCourse(Integer.parseInt(courseIDField.getText())); 
	    } 
	}
	
	class RemoveCourseHandler implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			((MainController)getController()).removeCourse(Integer.parseInt(courseIDField.getText())); 
	    } 
	}
	
	class AddMajorHandler implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			((MainController)getController()).addMajor(); 
	    } 
	}
	
	class RemoveMajorHandler implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			((MainController)getController()).removeMajor(); 
	    } 
	}
	
	class AddMinorHandler implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			((MainController)getController()).addMinor(); 
	    } 
	}
	
	class RemoveMinorHandler implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			((MainController)getController()).removeMinor(); 
	    } 
	}
	
	class LogoutHandler implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			((MainController)getController()).logout(); 
	    } 
	}
}
