package Model;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import Model.DegreePlan;
import Model.CourseCatalog;

public class DegreePlannerModel  extends AbstractModel{
	private CourseCatalog catalog = new CourseCatalog();;
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
			System.out.println("file not found");
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("io exception");
		}catch(ClassNotFoundException e) {
			System.out.println("class not found");
		}
	}
	
	public void createPlan(){
		//automate a degree plan
	}

	public void clearPlan(){
		plan.setSemesters(new ArrayList<Semester>());
	}

	public boolean addCourse(Course course, int semester){
		for(int i = 0; i < plan.getSemesters().size(); ++i) {
			if(plan.getSemesters().get(i).getCourses().contains(course)) {
				return false;
			}
		}
		return plan.getSemesters().get(semester).getCourses().add(course);
	}

	public boolean removeCourse(Course course, int semester){
		return plan.getSemesters().get(semester).getCourses().remove(course);
	}

	public boolean addMajor(Major major){
		if(!plan.getMajors().contains(major)) {
			return plan.getMajors().add(major);
		}
		return false;
	}

	public boolean removeMajor(Major major){
		return plan.getMajors().remove(major);
	}

	public boolean addMinor(Minor minor){
		if(!plan.getMinors().contains(minor)) {
			return plan.getMinors().add(minor);
		}
		return false;
	}

	public boolean removeMinor(Minor minor){
		return plan.getMinors().remove(minor);
	}
}