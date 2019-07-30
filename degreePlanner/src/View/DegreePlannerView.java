package View;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import Controller.MainController;
import Model.DegreePlannerModel;
import Model.ModelEvent;

public class DegreePlannerView extends JFrameView{
	private static final long serialVersionUID = 1L;
	private JTextField courseIDField = new JTextField();
	
    public DegreePlannerView(DegreePlannerModel model, MainController controller){
		super(model, controller); 
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		setPreferredSize(new Dimension(width/2 , height/2));
		setLocation(width/4, height/4);

		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(1, 2));
		inputPanel.add(new JLabel("Input:", SwingConstants.CENTER));
		inputPanel.add(courseIDField);
		
		JPanel semesterPanel = new JPanel();
		semesterPanel.setPreferredSize(new Dimension(1000 , 0));
        JScrollPane scroll = new JScrollPane(semesterPanel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2, 5));
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
		
		buttonPanel.add(createPlanButton, null);
		buttonPanel.add(clearPlanButton, null);
		buttonPanel.add(addCourseButton, null);
		buttonPanel.add(removeCourseButton, null);
		buttonPanel.add(addMajorButton, null);
		buttonPanel.add(removeMajorButton, null);
		buttonPanel.add(addMinorButton, null);
		buttonPanel.add(removeMinorButton, null);
		buttonPanel.add(logoutButton, null);
		
		this.getContentPane().add(inputPanel, BorderLayout.NORTH);
		this.getContentPane().add(scroll, BorderLayout.CENTER);
		this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		pack();
    }

	public void modelChanged(ModelEvent event) {
		///add degreePlanner change reactions
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
			((MainController)getController()).addCourse(courseIDField.getText()); 
	    } 
	}
	
	class RemoveCourseHandler implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			((MainController)getController()).removeCourse(courseIDField.getText()); 
	    } 
	}
	
	class AddMajorHandler implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			((MainController)getController()).addMajor(courseIDField.getText()); 
	    } 
	}
	
	class RemoveMajorHandler implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			((MainController)getController()).removeMajor(courseIDField.getText()); 
	    } 
	}
	
	class AddMinorHandler implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			((MainController)getController()).addMinor(courseIDField.getText()); 
	    } 
	}
	
	class RemoveMinorHandler implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			((MainController)getController()).removeMinor(courseIDField.getText()); 
	    } 
	}
	
	class LogoutHandler implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			((MainController)getController()).logout(); 
	    } 
	}
}
