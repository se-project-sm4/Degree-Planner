package test.Model;

import degreePlanner.Model.Requirement;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class RequirementTest {
	/*
		public Requirement();
		public Requirement(String s, int n);
		public void setSubject(String s);
		public String getSubject();
		public void setNumHour(int n);
		public int getNumHour();
	    public String toString();
    */
	
	@Test
	void testConstructor() {
		Requirement requirement = new Requirement();
		assertEquals(null, requirement.getSubject());
		assertEquals(0, requirement.getNumHour());
		Requirement requirement1 = new Requirement("s1", 1);
		assertEquals("s1", requirement1.getSubject());
		assertEquals(1, requirement1.getNumHour());
		Requirement requirement2 = new Requirement("s2", 2);
		assertEquals("s2", requirement2.getSubject());
		assertEquals(2, requirement2.getNumHour());
	}
	
	@Test
	void testToString() {
		Requirement requirement = new Requirement();
		assertEquals("[subject=null, numHours=0]", requirement.toString());
		Requirement requirement1 = new Requirement("s1", 1);
		assertEquals("[subject=s1, numHours=1]", requirement1.toString());
	}
}
