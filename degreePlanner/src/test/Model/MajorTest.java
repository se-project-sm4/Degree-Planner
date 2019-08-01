package test.Model;

import degreePlanner.Model.Major;
import degreePlanner.Model.Requirement;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MajorTest {
	/*
		public Major();
		public Major(String m, List<Requirement> r, int w );
		public String getMajorName();
		public void setMajorName(String n);
		public void setRequirements(ArrayList<Requirement> r);
		public List<Requirement> getRequirements();
		public void addRequirements(Requirement r);
		public void removeRequirements(Requirement r);
		public void setWritingIntensiveHours(int w);
		public int getWritingIntensiveHours();
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
	void testToString() {
		Major major = new Major();
		assertEquals("[majorName=null, requirements=null, writingIntensiveHours=0]", major.toString());
		List<Requirement> requirements = new ArrayList<Requirement>();
		Requirement requirement = new Requirement(null, 0);
		Requirement requirement1 = new Requirement("n1", 1);
		requirements.add(requirement);
		requirements.add(requirement1);
		Major major1 = new Major("name", requirements, 1);
		assertEquals("[majorName=name, requirements=" + requirements.toString() + ", writingIntensiveHours=1]", major1.toString());
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
}
