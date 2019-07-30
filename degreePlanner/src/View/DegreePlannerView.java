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

		setTitle("Degree Planner Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		setPreferredSize(new Dimension(width/2 , height/2));
		setLocation(width/4, height/4);

		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel titlePanel = new JPanel();
		titlePanel.add(new JLabel("Welcome to the Degree Planner Menu!"));
		JButton courseCatalogButton = new JButton("Show Course Catalog");
		courseCatalogButton.setToolTipText("N/A");
		JButton disciplineCatalogButton = new JButton("Show Discipline Catalog");
		disciplineCatalogButton.setToolTipText("N/A");
		CreatePlanHandler createPlanHandler = new CreatePlanHandler();
		JButton createPlanButton = new JButton("Create Plan");
		createPlanButton.setToolTipText("N/A");
		createPlanButton.addActionListener(createPlanHandler);
		mainPanel.add(titlePanel, null);
		mainPanel.add(courseCatalogButton, null);
		mainPanel.add(disciplineCatalogButton, null);
		mainPanel.add(createPlanButton, null);
		
		JPanel semesterPanel = new JPanel();
		semesterPanel.setPreferredSize(new Dimension(1000 , 0));
        JScrollPane scroll = new JScrollPane(semesterPanel);
		
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(3, 1));
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(1, 2));
		inputPanel.add(new JLabel("Hover over buttons for input instructions, then input them to the right.", SwingConstants.CENTER));
		inputPanel.add(courseIDField);
		JPanel buttonPanel1 = new JPanel();
		buttonPanel1.setLayout(new GridLayout(1, 4));
		AddCourseHandler addCourseHandler = new AddCourseHandler();
		JButton addCourseButton = new JButton("Add Course");
		addCourseButton.setToolTipText("Subject ID Semester (ex: CS 1428 1)");
		addCourseButton.addActionListener(addCourseHandler);
		RemoveCourseHandler removeCourseHandler = new RemoveCourseHandler();
		JButton removeCourseButton = new JButton("Remove Course");
		removeCourseButton.setToolTipText("Subject ID Semester (ex: CS 1428 1)");
		removeCourseButton.addActionListener(removeCourseHandler);
		AddMajorHandler addMajorHandler = new AddMajorHandler();
		JButton addMajorButton = new JButton("Add Major");
		addMajorButton.setToolTipText("Name (ex: Computer Science)");
		addMajorButton.addActionListener(addMajorHandler);
		RemoveMajorHandler removeMajorHandler = new RemoveMajorHandler();
		JButton removeMajorButton = new JButton("Remove Major");
		removeMajorButton.setToolTipText("Name (ex: Computer Science)");
		removeMajorButton.addActionListener(removeMajorHandler);
		JPanel buttonPanel2 = new JPanel();
		buttonPanel2.setLayout(new GridLayout(1, 4));
		AddMinorHandler addMinorHandler = new AddMinorHandler();
		JButton addMinorButton = new JButton("Add Minor");
		addMinorButton.setToolTipText("Name (ex: Mathematics)");
		addMinorButton.addActionListener(addMinorHandler);
		RemoveMinorHandler removeMinorHandler = new RemoveMinorHandler();
		JButton removeMinorButton = new JButton("Remove Minor");
		removeMinorButton.setToolTipText("Name (ex: Mathematics)");
		removeMinorButton.addActionListener(removeMinorHandler);
		ClearPlanHandler clearPlanHandler = new ClearPlanHandler();
		JButton clearPlanButton = new JButton("Clear Plan");
		clearPlanButton.setToolTipText("N/A");
		clearPlanButton.addActionListener(clearPlanHandler);
		LogoutHandler logoutHandler = new LogoutHandler();
		JButton logoutButton = new JButton("Log Out");
		logoutButton.setToolTipText("N/A");
		logoutButton.addActionListener(logoutHandler);
		buttonPanel1.add(addCourseButton, null);
		buttonPanel1.add(addMajorButton, null);
		buttonPanel1.add(addMinorButton, null);
		buttonPanel1.add(clearPlanButton, null);
		buttonPanel2.add(removeCourseButton, null);
		buttonPanel2.add(removeMajorButton, null);
		buttonPanel2.add(removeMinorButton, null);
		buttonPanel2.add(logoutButton, null);
		controlPanel.add(inputPanel, null);
		controlPanel.add(buttonPanel1, null);
		controlPanel.add(buttonPanel2, null);
		
		this.getContentPane().add(mainPanel, BorderLayout.NORTH);
		this.getContentPane().add(scroll, BorderLayout.CENTER);
		this.getContentPane().add(controlPanel, BorderLayout.SOUTH);
		
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
