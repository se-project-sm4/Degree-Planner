package Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import Model.Course;

public class Semester implements Serializable{
	private static final long serialVersionUID = 1L;
	private int maxHours;
	private int minHours;
	private List<Course> courses = new ArrayList<>();
	private String name;
	
	public void setName(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
	
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
	
    @Override
    public String toString() { 
        return Integer.toString(maxHours) + " " + Integer.toString(minHours) +  " " + courses;
    } 
}
