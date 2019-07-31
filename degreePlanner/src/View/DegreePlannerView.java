package View;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.util.List;

import Controller.MainController;
import Model.DegreePlannerModel;
import Model.ModelEvent;

public class DegreePlannerView extends JFrameView{
	private static final long serialVersionUID = 1L;
	private JTextField courseIDField = new JTextField();
    JScrollPane scroll = new JScrollPane();
	
    public DegreePlannerView(DegreePlannerModel model, MainController controller){
		super(model, controller);
    }
    
    public void paint(Graphics g) {
		setTitle("Degree Planner Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		setPreferredSize(new Dimension(width/2 , height/2));
		setLocation(width/4, height/4);

		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton courseCatalogButton = new JButton("Show Course Catalog");
		courseCatalogButton.setToolTipText("N/A");
		JButton disciplineCatalogButton = new JButton("Show Discipline Catalog");
		disciplineCatalogButton.setToolTipText("N/A");
		CreatePlanHandler createPlanHandler = new CreatePlanHandler();
		JButton createPlanButton = new JButton("Create Plan");
		createPlanButton.setToolTipText("N/A");
		createPlanButton.addActionListener(createPlanHandler);
		mainPanel.add(new JLabel("Welcome to the Degree Planner Menu!"), null);
		mainPanel.add(courseCatalogButton, null);
		mainPanel.add(disciplineCatalogButton, null);
		mainPanel.add(createPlanButton, null);
		
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(3, 1));
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(1, 2));
		inputPanel.add(new JLabel("Hover over buttons for input instructions, then input them to the right.", SwingConstants.CENTER));
		courseIDField = new JTextField(courseIDField.getText());
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
		RemoveSemesterHandler removeSemesterHandler = new RemoveSemesterHandler();
		JButton removeSemesterButton = new JButton("Remove Semester");
		removeSemesterButton.setToolTipText("Number (ex: 1) (WARNING: THIS FUNCTION WILL ALSO REMOVE ALL SEMESTERS AFTER THE REQUESTED SEMESTER)");
		removeSemesterButton.addActionListener(removeSemesterHandler);
		LogoutHandler logoutHandler = new LogoutHandler();
		JButton logoutButton = new JButton("Log Out");
		logoutButton.setToolTipText("N/A");
		logoutButton.addActionListener(logoutHandler);
		buttonPanel1.add(addCourseButton);
		buttonPanel1.add(addMajorButton);
		buttonPanel1.add(addMinorButton);
		buttonPanel1.add(removeSemesterButton);
		buttonPanel2.add(removeCourseButton);
		buttonPanel2.add(removeMajorButton);
		buttonPanel2.add(removeMinorButton);
		buttonPanel2.add(logoutButton);
		controlPanel.add(inputPanel);
		controlPanel.add(buttonPanel1);
		controlPanel.add(buttonPanel2);
		
		getContentPane().add(mainPanel, BorderLayout.NORTH);
		getContentPane().add(scroll, BorderLayout.CENTER);
		getContentPane().add(controlPanel, BorderLayout.SOUTH);
		
		pack();
    }
    
	public void modelChanged(ModelEvent event) {
		if(event.getType() == 0) {
			//show course catalog
		}else if(event.getType() == 1) {
			//show discipline catalog
		}else if(event.getType() == 2) {
			// create plan success
	        repaint();
		}else if(event.getType() == 3) {
			// create plan fail
	        repaint();
		}else if(event.getType() == 4) {
			// add course success
	        updateScroll(event.getSemesters());
	        repaint();
		}else if(event.getType() == 5) {
			// add course fail
	        repaint();
		}else if(event.getType() == 6) {
			// remove course success
	        updateScroll(event.getSemesters());
	        repaint();
		}else if(event.getType() == 7) {
			// remove course fail
	        repaint();
		}else if(event.getType() == 8) {
			// add major success
	        updateScroll(event.getSemesters());
	        repaint();
		}else if(event.getType() == 9) {
			// add major fail
	        repaint();
		}else if(event.getType() == 10) {
			// remove major success
	        updateScroll(event.getSemesters());
	        repaint();
		}else if(event.getType() == 11) {
			// remove major fail
	        repaint();
		}else if(event.getType() == 12) {
			// add minor success
	        updateScroll(event.getSemesters());
	        repaint();
		}else if(event.getType() == 13) {
			// add minor fail
	        repaint();
		}else if(event.getType() == 14) {
			// remove minor success
	        updateScroll(event.getSemesters());
	        repaint();
		}else if(event.getType() == 15) {
			// remove minor fail
	        repaint();
		}else if(event.getType() == 16) {
			// remove semester success
	        updateScroll(event.getSemesters());
	        repaint();
		}else if(event.getType() == 17) {
			// remove semester fail
	        repaint();
		}
	 }

	private void updateScroll(List<List<String>> semesters) {
		int numSemesters = semesters.size();
		scroll.setLayout(new GridLayout(numSemesters, 1));
		for(int i = 0; i < numSemesters; ++i) {
			int loops = semesters.get(i).size();
			JPanel semester = new JPanel();
			scroll.setLayout(new GridLayout(1, loops));
			for(int j = 0; j < loops; ++j) {
				semester.add(new JLabel(semesters.get(i).get(j)));
			}
			scroll.add(semester);
		}
	}
	
	class CreatePlanHandler implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			((MainController)getController()).createPlan(); 
	    } 
	}
	
	class RemoveSemesterHandler implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			((MainController)getController()).removeSemester(courseIDField.getText()); 
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
