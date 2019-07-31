package View;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

import java.awt.*; 
import java.awt.event.*;
import java.util.List;

import Controller.MainController;
import Model.DegreePlannerModel;
import Model.ModelEvent;

public class DegreePlannerView extends JFrameView{
	private static final long serialVersionUID = 1L;
	private JTextField courseIDField = new JTextField();
	private JScrollPane scroll = new JScrollPane();
	
    public DegreePlannerView(DegreePlannerModel model, MainController controller){
		super(model, controller);
		
		setTitle("Degree Planner Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		setPreferredSize(new Dimension(684 , 362));
		setLocation(width/2 - 342, height/2 - 181);

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
			scroll.setViewportView(getScroll(event.getSemesters()));
	        revalidate();
		}else if(event.getType() == 3) {
			// create plan fail
			getScroll(event.getSemesters());
	        repaint();
		}else if(event.getType() == 4) {
			// add course success
			getScroll(event.getSemesters());
	        repaint();
		}else if(event.getType() == 5) {
			// add course fail
	        repaint();
		}else if(event.getType() == 6) {
			// remove course success
			getScroll(event.getSemesters());
	        repaint();
		}else if(event.getType() == 7) {
			// remove course fail
	        repaint();
		}else if(event.getType() == 8) {
			// add major success
			getScroll(event.getSemesters());
	        repaint();
		}else if(event.getType() == 9) {
			// add major fail
	        repaint();
		}else if(event.getType() == 10) {
			// remove major success
			getScroll(event.getSemesters());
	        repaint();
		}else if(event.getType() == 11) {
			// remove major fail
	        repaint();
		}else if(event.getType() == 12) {
			// add minor success
			getScroll(event.getSemesters());
	        repaint();
		}else if(event.getType() == 13) {
			// add minor fail
	        repaint();
		}else if(event.getType() == 14) {
			// remove minor success
			getScroll(event.getSemesters());
	        repaint();
		}else if(event.getType() == 15) {
			// remove minor fail
	        repaint();
		}else if(event.getType() == 16) {
			// remove semester success
			getScroll(event.getSemesters());
	        repaint();
		}else if(event.getType() == 17) {
			// remove semester fail
	        repaint();
		}
	 }

	private JPanel getScroll(List<List<String>> semesters) {
		JPanel semestersPanel = new JPanel();
		semestersPanel.setLayout(new GridLayout(1, semesters.size()));
		for(int i = 0; i < semesters.size(); ++i) {
			JPanel semester = new JPanel();
			semester.setLayout(new GridLayout(9, 1));
			JLabel label = new JLabel("Semester " + (i + 1));
			label.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
			label.setHorizontalAlignment(JLabel.CENTER);
			semester.add(label);
			int j;
			for(j = 0; j < semesters.get(i).size(); ++j) {
				label = new JLabel(semesters.get(i).get(j));
				label.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
				label.setHorizontalAlignment(JLabel.CENTER);
				label.setToolTipText(semesters.get(i).get(++j));
				semester.add(label);
			}
			while(j < 16) {
				label = new JLabel();
				label.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
				label.setHorizontalAlignment(JLabel.CENTER);
				semester.add(label);
				j+=2;
			}
			semestersPanel.add(semester);
		}
		return semestersPanel;
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
