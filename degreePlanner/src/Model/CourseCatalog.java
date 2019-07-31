package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.Course;

public class CourseCatalog {
	//make sure courseIDs are sorted from decreasing to increasing (for prerequisite purposes)
	private List<List<Course>> catalog = new ArrayList<List<Course>>();
	//map is used to get index of array of courses corresponding to subject
	Map<String, Integer> map = new HashMap<String, Integer>();
	
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
		Course cs4328 = new Course(4328, "CS", cs3339, 3, "Operating Systems", "principles of operating systems course", false);
		Course cs3320 = new Course(3320, "CS", cs3339, 3, "Internet Software Development", "software development for the internet", false);
		Course cs4350 = new Course(4350, "CS", cs3358, 3, "Unix Systems Programming", "unix programming introductory course", false);
		Course cs4381 = new Course(4381, "CS", cs3398, 3, "Practical Game Development", "practical aspects of computer game design and implementation course", false);
		Course cs4380 = new Course(4380, "CS", cs3358, 3, "Parallel Programming", "practical aspects of parallel programming course", false);

		Course eng1310 = new Course(1310, "ENG", null, 3, "College Writing I", "critical reading course", false);
		Course eng1320 = new Course(1320, "ENG", eng1310, 3, "College Writing II", "expository writing course", false);
		Course eng2330 = new Course(2330, "ENG", null, 3, "World Literature before 1600", "literature from the ancient world to the early modern world", false);
		Course eng2340 = new Course(2330, "ENG", null, 3, "World Literature since 1600", "literature from the modern world", false);

		Course phil1305 = new Course(1305, "PHIL", null, 3, "Philosophy and Critical Thinking", "philosophy with an emphasis on critical thinking skills", true);
		Course phil1320 = new Course(1320, "PHIL", null, 3, "Ethics and Society", "philosophy with an emphasis on moral reasoning", true);

		Course art2313 = new Course(2313, "ART", null, 3, "Introduction to Fine Arts", "introductory course of expression through the visual and performing arts", false);
		Course art2314 = new Course(2314, "ART", null, 3, "Introduction to Music", "introductory course of expression through music", false);
		Course art2315 = new Course(2315, "ART", null, 3, "Introduction to Dance", "introductory course of expression through dance", false);
		Course art2316 = new Course(2316, "ART", null, 3, "Introduction to Theatre", "introductory course of expression through theatre", false);

		Course math2471 = new Course(2471, "MATH", null, 3, "Calculus I", "introductory course to calculus", false);
		Course math2358 = new Course(2358, "MATH", math2471, 3, "Discrete Mathematics I", "math encountered in computing hardware and software", false);
		Course math3398 = new Course(3398, "MATH", math2358, 3, "Discrete Mathematics II", "continuation of discrete math I", false);
		Course math2472 = new Course(2472, "MATH", math2471, 3, "Calculus II", "continuation of calculus I", false);
		Course math3305 = new Course(3305, "MATH", math2472, 3, "Introduction to Probability and Statistics", "introductory course to statistics", false);
		Course math3373 = new Course(3373, "MATH", math2472, 3, "Calculus III", "continuation of calculus II", false);
		Course math3377 = new Course(3377, "MATH", math2472, 3, "Linear Algebra", "introductory course for linear algebra", false);
		
		//add more
		
		List<Course> cs = new ArrayList<Course>();
		cs.add(cs1428);
		cs.add(cs2308);
		cs.add(cs2318);
		cs.add(cs2315);
		cs.add(cs3320);
		cs.add(cs3339);
		cs.add(cs3354);
		cs.add(cs3358);
		cs.add(cs3398);
		cs.add(cs4328);
		cs.add(cs4350);
		cs.add(cs4380);
		cs.add(cs4381);
		cs.add(cs4398);

		List<Course> eng = new ArrayList<Course>();
		eng.add(eng1310);
		eng.add(eng1320);
		eng.add(eng2330);
		eng.add(eng2340);

		List<Course> phil = new ArrayList<Course>();
		phil.add(phil1305);
		phil.add(phil1320);

		List<Course> art = new ArrayList<Course>();
		art.add(art2313);
		art.add(art2314);
		art.add(art2315);
		art.add(art2316);

		List<Course> math = new ArrayList<Course>();
		math.add(math2358);
		math.add(math2471);
		math.add(math2472);
		math.add(math3305);
		math.add(math3373);
		math.add(math3377);
		math.add(math3398);
		
		map.put("CS", 0);
		catalog.add(cs);
		
		map.put("ENG", 1);
		catalog.add(eng);
		
		map.put("PHIL", 2);
		catalog.add(phil);
		
		map.put("ART", 3);
		catalog.add(art);
		
		map.put("MATH", 4);
		catalog.add(math);
	}
	
	public Course findCourse(int id, String subject){
		int subjectIndex = map.get(subject);
		int index  = catalog.get(subjectIndex).indexOf(new Course(id, subject, null, 0, null, null, false));
		if(index == -1) {
			return null;
		}
		return catalog.get(subjectIndex).get(index);
	}
	
	public Map<String, Integer> getMap() {
		return map;
	}
	
	public List<List<Course>> getCatalog() {
		return catalog;
	}
}
