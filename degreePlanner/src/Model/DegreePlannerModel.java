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