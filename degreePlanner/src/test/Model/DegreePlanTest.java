package test.Model;

import degreePlanner.Model.DegreePlan;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class DegreePlanTest {
	/*
		public void setMajors(List<Major> m);
		public List<Major> getMajors();
		public void addMajor(Major m);
		public void removeMajor(Major m);
		public void setMinors(List<Minor> m);
		public List<Minor> getMinors();
		public void addMinor(Minor m);
		public void removeMinor(Minor m);
		public void setSemesters(List<Semester> s);
		public List<Semester> getSemesters();
		public void addSemester(Semester s);
		public void removeSemester(Semester s);
		public void removeSemesterAtIndex(Semester s);
	    public String toString();
	 */
	@Test
	void testToString() {
		DegreePlan degreePlan = new DegreePlan();
		assertEquals("[majors=" + degreePlan.getMajors().toString() + ", minors=" + degreePlan.getMinors().toString() + ", semesters=" + degreePlan.getSemesters().toString() + "]", degreePlan.toString());
	}
}
