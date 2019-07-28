package Model;

import java.util.ArrayList;
import java.util.List;
import Model.Course;

public class CourseCatalog {
	private List<Course> catalog = new ArrayList<>();
	
	public CourseCatalog() {
		Course cs1428 = new Course(1428, "CS", null, 4, "Foundations of CS I", "computer science introductory course", false);
		Course cs2308 = new Course(2308, "CS", cs1428, 3, "Foundations of CS II", "second computer science introductory course", false);
		Course cs3354 = new Course(2308, "CS", cs2308, 3, "Object Oriented Design & Programming", "introductory course for object oriented design and programming", false);
		Course cs3358 = new Course(2308, "CS", cs2308, 3, "Data Sctructures and Algorithms", "introductory course to data sctructures and algorithms", false);
		Course cs3398 = new Course(3354, "CS", cs3354, 3, "Software Engineering", "software engineering course", false);
		Course cs4398 = new Course(3354, "CS", cs3398, 3, "Software Engineering Project", "software engineering project course", false);
		//add more
		catalog.add(cs1428);
		catalog.add(cs2308);
		catalog.add(cs3354);
		catalog.add(cs3358);
		catalog.add(cs3398);
		catalog.add(cs4398);
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
