package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import Model.Course;

public class CourseCatalog {
	private List<Course> catalog = new ArrayList<>();
	
	public CourseCatalog() {
		List<Course> cs3398pr = new ArrayList<Course>(Arrays.asList(Course());
	}
	
	public Course findCourse(int id) {
		for(int i = 0; i < catalog.size(); ++i) {
			if(catalog.get(i).getCourseID() == id) {
				return catalog.get(i);
			}
		}
		return null;
	}
}
