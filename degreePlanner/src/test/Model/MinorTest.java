package test.Model;

import degreePlanner.Model.Minor;
import degreePlanner.Model.Requirement;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MinorTest {
	/*
		public Minor();
		public Minor(String m, List<Requirement> r, int w );
		public String getMinorName();
		public void setMinorName(String n);
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
		Minor minor = new Minor();
		assertEquals("", minor.getMinorName());
		assertEquals(null, minor.getRequirements());
		assertEquals(0, minor.getWritingIntensiveHours());
		Minor minor1 = new Minor("", null, 0);
		assertEquals("", minor1.getMinorName());
		assertEquals(null, minor1.getRequirements());
		assertEquals(0, minor1.getWritingIntensiveHours());
		List<Requirement> requirements = new ArrayList<Requirement>();
		Requirement requirement = new Requirement(null, 0);
		Requirement requirement1 = new Requirement("n1", 1);
		requirements.add(requirement);
		requirements.add(requirement1);
		Minor minor2 = new Minor("name", requirements, 1);
		assertEquals("name", minor2.getMinorName());
		assertEquals(requirements, minor2.getRequirements());
		assertEquals(1, minor2.getWritingIntensiveHours());
	}
	
	@Test
	void testToString() {
		Minor minor = new Minor();
		assertEquals("[minorName=, requirements=null, writingIntensiveHours=0]", minor.toString());
		List<Requirement> requirements = new ArrayList<Requirement>();
		Requirement requirement = new Requirement(null, 0);
		Requirement requirement1 = new Requirement("n1", 1);
		requirements.add(requirement);
		requirements.add(requirement1);
		Minor minor1 = new Minor("name", requirements, 1);
		assertEquals("[minorName=name, requirements=" + requirements.toString() + ", writingIntensiveHours=1]", minor1.toString());
	}
	
	@Test
	void testEquals() {
		List<Requirement> requirements = new ArrayList<Requirement>();
		Requirement requirement = new Requirement(null, 0);
		Requirement requirement1 = new Requirement("n1", 1);
		requirements.add(requirement);
		requirements.add(requirement1);
		Minor minor = new Minor();
		Minor minor1 = new Minor("name", requirements, 1);

		assertEquals(true, minor.equals(minor));
		assertEquals(true, minor.equals(new Minor()));
		assertEquals(true, minor.equals(new Minor("", null, 0)));
		assertEquals(true, minor.equals(new Minor("", requirements, 1)));
		assertEquals(false, minor.equals(null));
		assertEquals(false, minor.equals(new Minor("1", null, 0)));
		assertEquals(false, minor.equals(new Minor("1", requirements, 1)));
		assertEquals(false, minor.equals(minor1));
		
		assertEquals(true, minor1.equals(new Minor("name", requirements, 1)));
		assertEquals(true, minor1.equals(new Minor("name", null, 0)));
		assertEquals(false, minor1.equals(null));
		assertEquals(false, minor1.equals(new Minor("", requirements, 1)));
		assertEquals(false, minor1.equals(new Minor("", null, 0)));
		assertEquals(false, minor1.equals(minor));
	}
}
