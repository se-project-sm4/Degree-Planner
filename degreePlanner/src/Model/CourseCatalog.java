package Model;

import java.util.ArrayList;
import java.util.List;
import Model.Course;

public class CourseCatalog {
	private List<Course> catalog = new ArrayList<>();
	
	public CourseCatalog() {
		Course cs1428 = new Course(1428, "CS", null, 4, "Foundations of CS I", "computer science introductory course", false);
		Course cs2308 = new Course(2308, "CS", cs1428, 3, "Foundations of CS II", "second computer science introductory course", false);
		Course cs2315 = new Course(2315, "CS", cs1428, 3, "Computer Ethics", "studies of the ethical codes of the computing industry", true);
		Course cs2318 = new Course(2318, "CS", cs2308, 3, "Assembly Language", "introductory class for assembly language programming", false);
		Course cs3339 = new Course(3339, "CS", cs2318, 3, "Computer Architecture", "study of the fundamental hardware components", false);
		Course cs3354 = new Course(3354, "CS", cs2308, 3, "Object Oriented Design & Programming", "introductory course for object oriented design and programming", false);
		Course cs3358 = new Course(3358, "CS", cs2308, 3, "Data Structures and Algorithms", "introductory course to data structures and algorithms", false);
		Course cs3398 = new Course(3398, "CS", cs3354, 3, "Software Engineering", "software engineering course", true);
		Course cs4398 = new Course(4398, "CS", cs3398, 3, "Software Engineering Project", "software engineering project course", false);
		//add more
		catalog.add(cs1428);
		catalog.add(cs2308);
		catalog.add(cs2318);
		catalog.add(cs2315);
		catalog.add(cs3339);
		catalog.add(cs3354);
		catalog.add(cs3358);
		catalog.add(cs3398);
		catalog.add(cs4398);
	}
	
	public Course findCourse(int id, String subject){
		int index  = catalog.indexOf(new Course(id, subject, null, 0, null, null, false));
		if(index == -1) {
			return null;
		}
		return catalog.get(index);
	}
}
