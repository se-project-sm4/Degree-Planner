package test.Model;

import degreePlanner.Model.Course;
import degreePlanner.Model.DegreePlan;
import degreePlanner.Model.Major;
import degreePlanner.Model.Requirement;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

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
		Major major = new Major();
		assertEquals(null, major.getMajorName());
		assertEquals(null, major.getRequirements());
		assertEquals(0, major.getWritingIntensiveHours());
		Major major1 = new Major(null, null, 0);
		assertEquals(null, major1.getMajorName());
		assertEquals(null, major1.getRequirements());
		assertEquals(0, major1.getWritingIntensiveHours());
		List<Requirement> requirements = new ArrayList<Requirement>();
		Requirement requirement = new Requirement(null, 0);
		Requirement requirement1 = new Requirement("n1", 1);
		requirements.add(requirement);
		requirements.add(requirement1);
		Major major2 = new Major("name", requirements, 1);
		assertEquals("name", major2.getMajorName());
		assertEquals(requirements, major2.getRequirements());
		assertEquals(1, major2.getWritingIntensiveHours());
	}
	
	@Test
	void testEquals() {
		List<Requirement> requirements = new ArrayList<Requirement>();
		Requirement requirement = new Requirement(null, 0);
		Requirement requirement1 = new Requirement("n1", 1);
		requirements.add(requirement);
		requirements.add(requirement1);
		Major major = new Major();
		Major major1 = new Major("name", requirements, 1);

		assertEquals(true, major.equals(major));
		assertEquals(true, major.equals(new Major()));
		assertEquals(true, major.equals(new Major(null, null, 0)));
		assertEquals(true, major.equals(new Major(null, requirements, 1)));
		assertEquals(false, major.equals(null));
		assertEquals(false, major.equals(new Major("1", null, 0)));
		assertEquals(false, major.equals(new Major("1", requirements, 1)));
		assertEquals(false, major.equals(major1));
		
		assertEquals(true, major1.equals(new Major("name", requirements, 1)));
		assertEquals(true, major1.equals(new Major("name", null, 0)));
		assertEquals(false, major1.equals(null));
		assertEquals(false, major1.equals(new Major(null, requirements, 1)));
		assertEquals(false, major1.equals(new Major(null, null, 0)));
		assertEquals(false, major1.equals(major));
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
