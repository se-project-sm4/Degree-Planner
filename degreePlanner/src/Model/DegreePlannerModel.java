package Model;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import Model.DegreePlan;
import Model.CourseCatalog;
import Model.DisciplineCatalog;

public class DegreePlannerModel  extends AbstractModel{
	private CourseCatalog catalog = new CourseCatalog();;
	private DisciplineCatalog disciplines = new DisciplineCatalog();;
	private DegreePlan plan = new DegreePlan();
	
	public DegreePlannerModel(String username) {
		try {
			String fileName = username + ".bin";
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			plan = (DegreePlan)ois.readObject();
			ois.close();
			fis.close();
		}catch(FileNotFoundException e) {
			System.out.println("file \"" + username + ".bin\" not found");
			e.printStackTrace();
		}catch(IOException e) {
			System.out.println("io exception");
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			System.out.println("class \"DegreePlan\" not found");
			e.printStackTrace();
		}
		//System.out.println(plan.toString());
	}
	
	public void createPlan(){
		//automate a degree plan
	}

	public void clearPlan(){
		plan.setSemesters(new ArrayList<Semester>());
	}

	public boolean addCourse(String courseName){
		String[] split = courseName.split("\\s+");
		if(split.length != 3)
			return false;
		String subject = split[0];
		try {
			int id = Integer.parseInt(split[1]);
			int semester = Integer.parseInt(split[2]);
			Course course = catalog.findCourse(id, subject);
			if(course == null)
				return false;
			for(int i = 0; i < plan.getSemesters().size(); ++i) {
				if(plan.getSemesters().get(i).getCourses().contains(new Course(id, subject, null, 0, null, null, false))) {
					return false;
				}
			}
			return plan.getSemesters().get(semester).getCourses().add(course);
		}catch(NumberFormatException e) {
			return false;
		}
	}

	public boolean removeCourse(String course){
		String[] split = course.split("\\s+");
		if(split.length != 2)
			return false;
		String subject = split[0];
		try {
			int id = Integer.parseInt(split[1]);
			int semester = Integer.parseInt(split[2]);
			return plan.getSemesters().get(semester).getCourses().remove(new Course(id, subject, null, 0, null, null, false));
		}catch(NumberFormatException e) {
			return false;
		}
	}

	public boolean addMajor(String major){
		Major m = new Major();
		m = disciplines.findMajor(major);
		if(m == null){
			return false;
		}
		if(!plan.getMajors().contains(m)) {
			return plan.getMajors().add(m);
		}
		return false;
	}

	public boolean removeMajor(String major){
		return plan.getMajors().remove(disciplines.findMajor(major));
	}

	public boolean addMinor(String minor){
		Minor m = new Minor();
		m = disciplines.findMinor(minor);
		if(m == null){
			return false;
		}
		if(!plan.getMinors().contains(m)) {
			return plan.getMinors().add(m);
		}
		return false;
	}

	public boolean removeMinor(String minor){
		return plan.getMinors().remove(disciplines.findMinor(minor));
	}
}