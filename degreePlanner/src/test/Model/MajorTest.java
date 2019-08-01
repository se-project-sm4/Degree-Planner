package test.Model;

import degreePlanner.Model.Major;
import degreePlanner.Model.Requirement;

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
	void test() {
		Major major = new Major();
		List<Requirement> requirements = new ArrayList<Requirement>();
		Major major1 = new Major("major name", requirements, 3);
		String name = major.getMajorName();
		major.setMajorName("major name 1");
		major.setRequirements((ArrayList<Requirement>)requirements);
		requirements = major.getRequirements();
		major.addRequirements(new Requirement("SOCI", 3));
		major.removeRequirements(new Requirement("SOCI", 3));
		major.setWritingIntensiveHours(3);
		int writingHours = major.getWritingIntensiveHours();
	    String string = major.toString();
	    boolean bool = major.equals(major1);
	}
}
