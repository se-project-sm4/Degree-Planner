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
			System.out.println("file not found");
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("io exception");
		}catch(ClassNotFoundException e) {
			System.out.println("class not found");
		}
		System.out.println(plan.toString());
	}
	
	public void createPlan(){
		//automate a degree plan
	}

	public void clearPlan(){
		plan.setSemesters(new ArrayList<Semester>());
	}

	public boolean addCourse(String courseName){
		String[] split = courseName.split("\\s+");
		String subject = split[0];
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
	}

	public boolean removeCourse(String course){
		String[] split = course.split("\\s+");
		String subject = split[0];
		int id = Integer.parseInt(split[1]);
		int semester = Integer.parseInt(split[2]);
		return plan.getSemesters().get(semester).getCourses().remove(new Course(id, subject, null, 0, null, null, false));
	}

	public boolean addMajor(String major){
		
		//if(!plan.getMajors().contains(major)) {
		//	return plan.getMajors().add(major);
		//}
		return false;
		
	}

	public boolean removeMajor(String major){
		return plan.getMajors().remove(major);
	}

	public boolean addMinor(String minor){
		//if(!plan.getMinors().contains(minor)) {
		//	return plan.getMinors().add(minor);
		//}
		return false;
	}

	public boolean removeMinor(String minor){
		return plan.getMinors().remove(minor);
	}
}