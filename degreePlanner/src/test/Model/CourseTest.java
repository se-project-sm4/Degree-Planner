package test.Model;

import degreePlanner.Model.Course;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class CourseTest {
	/*
		public Course(int i, String s, Course p, int h, String n, String d, boolean w);
		public void setCourseID(int c);
		public int getCourseID();
		public void setSubject(String s);
		public String getSubject();
		public void setPrerequisite(Course p);
		public Course getPrerequisite();
		public void setHours(int h);
		public int getHours();
		public void setClassName(String c);
		public String getClassName();
		public void setClassDescription(String c);
		public String getClassDescription();
		public void setWritingIntensive(boolean w);
		public boolean getWritingIntensive();
	    public String toString();
	    public boolean equals(Object obj);
	 */
	
	@Test
	void testConstructor() {
		Course course = new Course(0, null, null, 0, null, null, false);
		assertEquals(0, course.getCourseID());
		assertEquals(null, course.getSubject());
		assertEquals(null, course.getPrerequisite());
		assertEquals(0, course.getHours());
		assertEquals(null, course.getClassName());
		assertEquals(null, course.getClassDescription());
		assertEquals(false, course.getWritingIntensive());
		Course course1 = new Course(1, "s1", null, 1, "c1", "d1", false);
		Course course2 = new Course(2, "s2", course1, 2, "c2", "d2", true);
		assertEquals(2, course2.getCourseID());
		assertEquals("s2", course2.getSubject());
		assertEquals(course1, course2.getPrerequisite());
		assertEquals(2, course2.getHours());
		assertEquals("c2", course2.getClassName());
		assertEquals("d2", course2.getClassDescription());
		assertEquals(true, course2.getWritingIntensive());
	}
	
	@Test
	void testEquals() {
		Course course = new Course(0, null, null, 0, null, null, false);
		Course course1 = new Course(1, "s", course, 1, "c1", "d1", false);

		assertEquals(true, course.equals(course));
		assertEquals(false, course.equals(null));
		assertEquals(false, course.equals(new Course(1, null, null, 0, null, null, false)));
		assertEquals(false, course.equals(new Course(0, "s", null, 0, null, null, false)));
		assertEquals(false, course.equals(course1));

		assertEquals(true, course1.equals(course1));
		assertEquals(false, course1.equals(null));
		assertEquals(false, course1.equals(new Course(0, null, null, 0, null, null, false)));
		assertEquals(false, course1.equals(new Course(0, "s", null, 0, null, null, false)));
		assertEquals(false, course1.equals(new Course(1, null, null, 0, null, null, false)));
		assertEquals(true, course1.equals(new Course(1, "s", null, 0, null, null, false)));
		assertEquals(false, course1.equals(course));
	}
	
	@Test
	void testToString() {
		Course course = new Course(0, null, null, 0, null, null, false);
		assertEquals("[courseID=" + Integer.toString(course.getCourseID()) + ", subject=" + course.getSubject() + ", prerequisites=" + course.getPrerequisite() + ", hours=" + Integer.toString(course.getHours()) + ", className=" + course.getClassName() + ", classDescription=" + course.getClassDescription() + ", writingIntensive=" + course.getWritingIntensive() + "]", course.toString());
		Course course1 = new Course(1, "1", null, 1, "n1", "d1", false);
		Course course2 = new Course(2, "2", course1, 2, "n2", "d2", true);
		assertEquals("[courseID=" + Integer.toString(course2.getCourseID()) + ", subject=" + course2.getSubject() + ", prerequisites=" + course2.getPrerequisite() + ", hours=" + Integer.toString(course2.getHours()) + ", className=" + course2.getClassName() + ", classDescription=" + course2.getClassDescription() + ", writingIntensive=" + course2.getWritingIntensive() + "]", course2.toString());
	}
}
