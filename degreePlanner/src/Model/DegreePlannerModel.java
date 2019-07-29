package Model;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Model.DegreePlan;
import Model.CourseCatalog;
import Model.DisciplineCatalog;

public class DegreePlannerModel  extends AbstractModel{
	private CourseCatalog catalog = new CourseCatalog();;
	private DisciplineCatalog disciplines = new DisciplineCatalog();;
	private DegreePlan plan = new DegreePlan();
	String fileName;
	
	public DegreePlannerModel(String username) {
		for(int i = 0; i < 12; ++i) {
			if(plan.getSemesters().size() % 3 == 2) {
				plan.addSemester(new Semester(16));
			}else {
				plan.addSemester(new Semester(18));
			}
		}
		try {
			fileName = username + ".bin";
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			plan = (DegreePlan)ois.readObject();
			ois.close();
			fis.close();
		}catch(FileNotFoundException e) {
			System.out.println("file \"" + fileName + "\" not found");
			e.printStackTrace();
		}catch(IOException e) {
			System.out.println("io exception");
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			System.out.println("class \"DegreePlan\" not found");
			e.printStackTrace();
		}
	}
	
	public void createPlan(){
		//automate a degree plan
		save();
	}

	public void clearPlan(){
		plan.setSemesters(new ArrayList<Semester>());
		plan.setMajors(new ArrayList<Major>());
		plan.setMinors(new ArrayList<Minor>());
		save();
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
			if(plan.getSemesters().size() < semester) {
				
			}
			if(plan.getSemesters().get(semester).getMaxHours() < plan.getSemesters().get(semester).getHours() + course.getHours()) {
				return false;
			}
			for(int i = 0; i < plan.getSemesters().size(); ++i) {
				if(plan.getSemesters().get(i).getCourses().contains(new Course(id, subject, null, 0, null, null, false))) {
					return false;
				}
			}
			if(plan.getSemesters().get(semester).getCourses().add(course)) {
				save();
				return true;
			}
		}catch(NumberFormatException e) {
			return false;
		}
		return false;
	}

	public boolean removeCourse(String course){
		String[] split = course.split("\\s+");
		if(split.length != 2)
			return false;
		String subject = split[0];
		try {
			int id = Integer.parseInt(split[1]);
			int semester = Integer.parseInt(split[2]);
			if(plan.getSemesters().get(semester).getCourses().remove(new Course(id, subject, null, 0, null, null, false))) {
				save();
				return true;
			}
		}catch(NumberFormatException e) {
			return false;
		}
		return false;
	}

	public boolean addMajor(String major){
		Major m = new Major();
		m = disciplines.findMajor(major);
		if(m == null){
			return false;
		}
		if(!plan.getMajors().contains(m)) {
			if(plan.getMajors().add(m)) {
				save();
				return true;
			}
		}
		return false;
	}

	public boolean removeMajor(String major){
		if(plan.getMajors().remove(disciplines.findMajor(major))) {
			save();
			return true;
		}
		return false;
	}

	public boolean addMinor(String minor){
		Minor m = new Minor();
		m = disciplines.findMinor(minor);
		if(m == null){
			return false;
		}
		if(!plan.getMinors().contains(m)) {
			if(plan.getMinors().add(m)) {
				save();
				return true;
			}
		}
		return false;
	}

	public boolean removeMinor(String minor){
		if(plan.getMinors().remove(disciplines.findMinor(minor))) {
			save();
			return true;
		}
		return false;
	}
	
	public void logout() {
		save();
	}
	
	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(plan);
			oos.flush();
			oos.close();
			fos.close();
		}catch(FileNotFoundException e) {
			System.out.println("file \"" + fileName + "\"not found");
			e.printStackTrace();
		}catch(IOException e) {
			System.out.println("io exception");
			e.printStackTrace();
		}
	}
}