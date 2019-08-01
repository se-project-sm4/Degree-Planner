package test.Model;

import degreePlanner.Model.Minor;
import degreePlanner.Model.Requirement;

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
	void test() {
		Minor minor = new Minor();
		List<Requirement> requirements = new ArrayList<Requirement>();
		Minor minor1 = new Minor("minor name", requirements, 3);
		String name = minor.getMinorName();
		minor.setMinorName("minor name 1");
		minor.setRequirements((ArrayList<Requirement>)requirements);
		requirements = minor.getRequirements();
		minor.addRequirements(new Requirement("SOCI", 3));
		minor.removeRequirements(new Requirement("SOCI", 3));
		minor.setWritingIntensiveHours(3);
		int writingHours = minor.getWritingIntensiveHours();
	    String string = minor.toString();
	    boolean bool = minor.equals(minor1);
	}
}
