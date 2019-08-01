package test.Model;

import degreePlanner.Model.Requirement;

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
	void test() {
		Requirement requirement = new Requirement();
		Requirement requirement1 = new Requirement("subject1", 10);
		requirement.setSubject("subject");
		String subject = requirement.getSubject();
		requirement.setNumHour(5);
		int hours = requirement.getNumHour();
	    String string = requirement.toString();
	}
}
