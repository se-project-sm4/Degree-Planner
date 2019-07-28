package View;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import Controller.MainController;
import Model.DegreePlannerModel;
import Model.ModelEvent;

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
	private JTextField courseIDField = new JTextField(); 
    public DegreePlannerView(DegreePlannerModel model, MainController controller){
		super(model, controller); 
		courseIDField.setText("Course ID");
		this.getContentPane().add(courseIDField, BorderLayout.NORTH);
		JPanel buttonPanel = new JPanel();
		Handler handler = new Handler();
		JButton createPlanButton = new JButton(CREATE_PLAN);
		createPlanButton.addActionListener(handler);
		JButton clearPlanButton = new JButton(CLEAR_PLAN);
		clearPlanButton.addActionListener(handler);
		JButton addCourseButton = new JButton(ADD_COURSE);
		addCourseButton.addActionListener(handler);
		JButton removeCourseButton = new JButton(REMOVE_COURSE);
		removeCourseButton.addActionListener(handler);
		JButton addMajorButton = new JButton(ADD_MAJOR);
		addMajorButton.addActionListener(handler);
		JButton removeMajorButton = new JButton(REMOVE_MAJOR);
		removeMajorButton.addActionListener(handler);
		JButton addMinorButton = new JButton(ADD_MINOR);
		addMinorButton.addActionListener(handler);
		JButton removeMinorButton = new JButton(REMOVE_MINOR);
		removeMinorButton.addActionListener(handler);
		JButton logoutButton = new JButton(LOGOUT);
		logoutButton.addActionListener(handler);
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
	
	class Handler implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			//add more commands (and probably change this one too)
			((MainController)getController()).operation(e.getActionCommand(), courseIDField.getText()); 
	    } 
	}
}
