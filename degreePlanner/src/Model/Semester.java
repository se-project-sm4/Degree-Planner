package Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import Model.Course;

public class Semester implements Serializable{
	private static final long serialVersionUID = 1L;
	private int maxHours;
	private List<Course> courses = new ArrayList<>();
	
	public Semester(int m) {
		maxHours = m;
	}
	
	public void setMaxHours(int m) {
		maxHours = m;
	}
	
	public int getMaxHours() {
		return maxHours;
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
	
	public int getHours() {
		int hours = 0;
		for(int i = 0; i < courses.size(); ++i) {
			hours += courses.get(i).getHours();
		}
		return hours;
	}
	
    @Override
    public String toString() { 
        return Integer.toString(maxHours) + " " + courses;
    } 
}
