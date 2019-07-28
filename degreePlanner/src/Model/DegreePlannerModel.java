package Model;
import java.util.ArrayList;

import Model.DegreePlan;
import Model.CourseCatalog;

public class DegreePlannerModel  extends AbstractModel{
	private CourseCatalog catalog = new CourseCatalog();;
	private DegreePlan plan = new DegreePlan();
	
	public DegreePlannerModel(String username) {
		//open file for student
		catalog = new CourseCatalog();
	}
	
	public void createPlan(){
		//automate a degree plan
	}

	public void clearPlan(){
		plan.setSemesters(new ArrayList<Semester>());
	}

	public void addCourse(int id){
		catalog.findCourse(id);
	}

	public void removeCourse(int id){
		
	}

	public void addMajor(){
		
	}

	public void removeMajor(){
		
	}

	public void addMinor(){
		
	}

	public void removeMinor(){
		
	}
}