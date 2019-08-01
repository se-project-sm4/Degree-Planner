package test.Model;

import degreePlanner.Model.Semester;
import degreePlanner.Model.Course;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class SemesterTest {
	/*
	 	public Semester(int m);
		public void setMaxHours(int m);
		public int getMaxHours();
		public void setCourses(ArrayList<Course> c);
		public List<Course> getCourses();
		public void addCourse(Course c);
		public void removeCourse(Course c);
		public int getHours();
		public String toString();
	 */

	@Test
	void test() {
		//need to add asserts
	 	Semester semester = new Semester(18);
	 	semester.setMaxHours(16);
		int maxHours = semester.getMaxHours();
		List<Course> courses = new ArrayList<>();
		semester.setCourses((ArrayList<Course>)courses);
		courses = semester.getCourses();
		semester.addCourse(new Course(1428, "CS", null, 4, "Foundations of CS I", "computer science introductory course", false));
		semester.removeCourse(new Course(1428, "CS", null, 4, "Foundations of CS I", "computer science introductory course", false));
		int hours = semester.getHours();
		String string = semester.toString();
	}
}
