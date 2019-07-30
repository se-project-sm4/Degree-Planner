package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DegreePlanTest {

	@Test
	void test() {
		DegreePlan plan = new DegreePlan();
		Major major = new Major();
		Minor minor = new Minor();
		Semester semester = new Semester();
		major.setMajorName("Computer Science");
		minor.setMinorName("Math");

		plan.addMajor(major);
		plan.addMinor(minor);
		plan.addSemester(semester);
		
		System.out.print(major.getMajorName());
		System.out.print(minor.getMinorName());
		System.out.print(plan.toString());
		assertEquals("Computer Science", major.getMajorName());
	}
	
	@Test
	void test2() {
		DegreePlan plan = new DegreePlan();
		Major major = new Major();
		Minor minor = new Minor();
		Semester semester = new Semester();
		major.setMajorName("Computer Science");
		minor.setMinorName("Math");

		plan.addMajor(major);
		plan.addMinor(minor);
		plan.addSemester(semester);
		
		System.out.print(major.getMajorName());
		System.out.print(minor.getMinorName());
		System.out.print(plan.toString());
		assertEquals("Math", minor.getMinorName());
	}
	
	@Test
	void test3() {
		DegreePlan plan = new DegreePlan();
		Major major = new Major();
		Minor minor = new Minor();
		Semester semester = new Semester();
		major.setMajorName("Computer Science");
		minor.setMinorName("Math");

		plan.addMajor(major);
		plan.addMinor(minor);
		plan.addSemester(semester);
		
		System.out.print(major.getMajorName());
		System.out.print(minor.getMinorName());
		System.out.print(plan.toString());
		assertEquals("[Computer Science []0] [Math []0] [0 0 []]", plan.toString());
	}

}
