package Model;
import java.util.ArrayList;
import java.util.List;
import Model.Course;

public class Semester {
	private int maxHours;
	private int minHours;
	private List<Course> courses = new ArrayList<>();
	
	public void setMaxHours(int m) {
		maxHours = m;
	}
	
	public int getMaxHours() {
		return maxHours;
	}
	
	public void setMinHours(int m) {
		minHours = m;
	}
	
	public int getMinHours() {
		return minHours;
	}
	
	public void setCourses(ArrayList<Course> c) {
		courses = c;
	}

	public List<Course> getCourses() {
		return courses;
	}
	
	public void addSemester(Course c) {
		courses.add(c);
	}
	
	public void removeSemester(Course c) {
		courses.remove(c);
	}
}
