package test.Model;

import degreePlanner.Model.Semester;
import degreePlanner.Model.Course;

import static org.junit.Assert.assertEquals;

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
	void testConstructor() {
	 	Semester semester = new Semester(18);
		assertEquals(0, semester.getCourses().size());
		assertEquals(18, semester.getMaxHours());
	}

	@Test
	void testGetHours() {
		//need to add asserts
	 	Semester semester = new Semester(18);
		assertEquals(0, semester.getHours());
		semester.addCourse(new Course(1, "id1", null, 4, "cn1", "cd1", false));
		assertEquals(4, semester.getHours());
		semester.addCourse(new Course(2, "id2", null, 3, "cn2", "cd2", false));
		assertEquals(7, semester.getHours());
		semester.removeCourse(new Course(1, "id1", null, 4, "cn1", "cd1", false));
		assertEquals(3, semester.getHours());
		semester.removeCourse(new Course(2, "id2", null, 3, "cn2", "cd2", false));
		assertEquals(0, semester.getHours());
	}
	
	@Test
	void testToString() {
	 	Semester semester = new Semester(18);
		assertEquals("[maxHours=18, courses=[]]", semester.toString());
		semester.addCourse(new Course(1, "id1", null, 4, "cn1", "cd1", false));
		assertEquals("[maxHours=18, courses=" + semester.getCourses().toString() + "]", semester.toString());
		semester.addCourse(new Course(2, "id2", null, 3, "cn2", "cd2", false));
		assertEquals("[maxHours=18, courses=" + semester.getCourses().toString() + "]", semester.toString());
		semester.removeCourse(new Course(1, "id1", null, 4, "cn1", "cd1", false));
		assertEquals("[maxHours=18, courses=" + semester.getCourses().toString() + "]", semester.toString());
		semester.removeCourse(new Course(2, "id2", null, 3, "cn2", "cd2", false));
		assertEquals("[maxHours=18, courses=" + semester.getCourses().toString() + "]", semester.toString());
	}
}
