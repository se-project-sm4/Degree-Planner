package test.Model;

import degreePlanner.Model.Course;
import degreePlanner.Model.DegreePlannerModel;
import degreePlanner.Model.Major;
import degreePlanner.Model.Minor;
import degreePlanner.Model.Semester;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class DegreePlannerModelTest {
	/*
		public DegreePlannerModel(String username);
		public void login();
		public void showCourseCatalog();
		public void showDisciplineCatalog();
		public void showPlan();
		public void createPlan();
		public void addCourse(String courseName);
		public void removeCourse(String course);
		public void addMajor(String major);
		public void removeMajor(String major);
		public void addMinor(String minor);
		public void removeMinor(String minor);
		public void removeSemester(String semester);
		private void addSemester();
		private void save();
		private List<List<String>> getPlanForView();
		private List<List<String>> getCourseCatalogForView();
		private List<List<String>> getDisciplineCatalogForView();
		private void removeCoursesWithRequirement(Course course, int semester);
	 */
	
	@Test
	void testCreatePlan() {
		DegreePlannerModel degreePlannerModel = new DegreePlannerModel("1");
		degreePlannerModel.getDegreePlan().setMajors(new ArrayList<Major>());
		degreePlannerModel.getDegreePlan().setMinors(new ArrayList<Minor>());
		degreePlannerModel.getDegreePlan().setSemesters(new ArrayList<Semester>());
		degreePlannerModel.createPlan();
		assertEquals(new ArrayList<Semester>(), degreePlannerModel.getDegreePlan().getSemesters());
		List<Major> majors = new ArrayList<Major>();
		List<Minor> minors = new ArrayList<Minor>();
		majors.add(degreePlannerModel.getDisciplineCatalog().getMajors().get(0));
		minors.add(degreePlannerModel.getDisciplineCatalog().getMinors().get(0));
		degreePlannerModel.getDegreePlan().setMajors(majors);
		degreePlannerModel.getDegreePlan().setMinors(minors);
		degreePlannerModel.createPlan();
		assertNotEquals(new ArrayList<Semester>(), degreePlannerModel.getDegreePlan().getSemesters());
		
	}
	
	@Test
	void testAddCourse() {
		DegreePlannerModel degreePlannerModel = new DegreePlannerModel("1");
		degreePlannerModel.getDegreePlan().setSemesters(new ArrayList<Semester>());
		degreePlannerModel.addCourse("gibberish");
		assertEquals(0, degreePlannerModel.getDegreePlan().getSemesters().size());
		degreePlannerModel.addCourse("CS 1 1");
		assertEquals(0, degreePlannerModel.getDegreePlan().getSemesters().size());
		degreePlannerModel.addCourse("CS 2308 1");
		assertEquals(0, degreePlannerModel.getDegreePlan().getSemesters().size());
		degreePlannerModel.addCourse("CS 1428 1");
		assertEquals(1, degreePlannerModel.getDegreePlan().getSemesters().size());
		assertEquals(new Course(1428, "CS", null, 0, null, null, false), degreePlannerModel.getDegreePlan().getSemesters().get(0).getCourses().get(0));
		degreePlannerModel.addCourse("CS 1428 1");
		assertEquals(1, degreePlannerModel.getDegreePlan().getSemesters().size());
		degreePlannerModel.addCourse("CS 1428 2");
		assertEquals(1, degreePlannerModel.getDegreePlan().getSemesters().size());
		degreePlannerModel.addCourse("CS 2308 1");
		assertEquals(1, degreePlannerModel.getDegreePlan().getSemesters().size());
		degreePlannerModel.addCourse("CS 2308 2");
		assertEquals(2, degreePlannerModel.getDegreePlan().getSemesters().size());
		assertEquals(new Course(2308, "CS", null, 0, null, null, false), degreePlannerModel.getDegreePlan().getSemesters().get(1).getCourses().get(0));
		degreePlannerModel.addCourse("CS 2315 2");
		assertEquals(2, degreePlannerModel.getDegreePlan().getSemesters().size());
		assertEquals(new Course(2308, "CS", null, 0, null, null, false), degreePlannerModel.getDegreePlan().getSemesters().get(1).getCourses().get(0));
		assertEquals(new Course(2315, "CS", null, 0, null, null, false), degreePlannerModel.getDegreePlan().getSemesters().get(1).getCourses().get(1));
		degreePlannerModel.addCourse("CS 2318 10");
		assertEquals(10, degreePlannerModel.getDegreePlan().getSemesters().size());
		assertEquals(new Course(2318, "CS", null, 0, null, null, false), degreePlannerModel.getDegreePlan().getSemesters().get(9).getCourses().get(0));
	}
	
	@Test
	void testRemoveCourse() {
		DegreePlannerModel degreePlannerModel = new DegreePlannerModel("1");
		degreePlannerModel.getDegreePlan().setSemesters(new ArrayList<Semester>());
		degreePlannerModel.removeCourse("gibberish");
		assertEquals(0, degreePlannerModel.getDegreePlan().getSemesters().size());
		degreePlannerModel.removeCourse("CS 1428 1");
		assertEquals(0, degreePlannerModel.getDegreePlan().getSemesters().size());
		degreePlannerModel.addCourse("CS 1428 1");
		degreePlannerModel.removeCourse("gibberish");
		assertEquals(1, degreePlannerModel.getDegreePlan().getSemesters().size());
		degreePlannerModel.addCourse("CS 2308 2");
		degreePlannerModel.addCourse("CS 2315 2");
		degreePlannerModel.addCourse("CS 2318 3");
		degreePlannerModel.removeCourse("CS 2315 2");
		assertEquals(3, degreePlannerModel.getDegreePlan().getSemesters().size());
		assertEquals(1, degreePlannerModel.getDegreePlan().getSemesters().get(1).getCourses().size());
		assertEquals(new Course(2308, "CS", null, 0, null, null, false), degreePlannerModel.getDegreePlan().getSemesters().get(1).getCourses().get(0));
		degreePlannerModel.removeCourse("CS 1428 1");
		assertEquals(0, degreePlannerModel.getDegreePlan().getSemesters().size());
	}
	
	@Test
	void testAddMajor() {
		DegreePlannerModel degreePlannerModel = new DegreePlannerModel("1");
		degreePlannerModel.getDegreePlan().setMajors(new ArrayList<Major>());
		degreePlannerModel.addMajor("doesn't exist");
		assertEquals(0, degreePlannerModel.getDegreePlan().getMajors().size());
		degreePlannerModel.addMajor("Computer Science");
		assertEquals(1, degreePlannerModel.getDegreePlan().getMajors().size());
		assertEquals(new Major("Computer Science", null, 0), degreePlannerModel.getDegreePlan().getMajors().get(0));
	}
	
	@Test
	void testRemoveMajor() {
		DegreePlannerModel degreePlannerModel = new DegreePlannerModel("1");
		degreePlannerModel.getDegreePlan().setMajors(new ArrayList<Major>());
		degreePlannerModel.addMajor("Computer Science");
		degreePlannerModel.removeMajor("doesn't exist");
		assertEquals(1, degreePlannerModel.getDegreePlan().getMajors().size());
		assertEquals(new Major("Computer Science", null, 0), degreePlannerModel.getDegreePlan().getMajors().get(0));
		degreePlannerModel.removeMajor("Computer Science");
		assertEquals(0, degreePlannerModel.getDegreePlan().getMajors().size());
	}
	
	@Test
	void testAddMinor() {
		DegreePlannerModel degreePlannerModel = new DegreePlannerModel("1");
		degreePlannerModel.getDegreePlan().setMinors(new ArrayList<Minor>());
		degreePlannerModel.addMinor("doesn't exist");
		assertEquals(0, degreePlannerModel.getDegreePlan().getMinors().size());
		degreePlannerModel.addMinor("Mathematics");
		assertEquals(1, degreePlannerModel.getDegreePlan().getMinors().size());
		assertEquals(new Minor("Mathematics", null, 0), degreePlannerModel.getDegreePlan().getMinors().get(0));
	}
	
	@Test
	void testRemoveMinor() {
		DegreePlannerModel degreePlannerModel = new DegreePlannerModel("1");
		degreePlannerModel.getDegreePlan().setMinors(new ArrayList<Minor>());
		degreePlannerModel.addMinor("Mathematics");
		degreePlannerModel.removeMinor("doesn't exist");
		assertEquals(1, degreePlannerModel.getDegreePlan().getMinors().size());
		assertEquals(new Minor("Mathematics", null, 0), degreePlannerModel.getDegreePlan().getMinors().get(0));
		degreePlannerModel.removeMinor("Mathematics");
		assertEquals(0, degreePlannerModel.getDegreePlan().getMinors().size());
	}
	
	@Test
	void testRemoveSemester() {
		DegreePlannerModel degreePlannerModel = new DegreePlannerModel("1");
		degreePlannerModel.getDegreePlan().setSemesters(new ArrayList<Semester>());
		degreePlannerModel.addCourse("CS 1428 10");
		degreePlannerModel.removeSemester("gibberish");
		assertEquals(10, degreePlannerModel.getDegreePlan().getSemesters().size());
		degreePlannerModel.removeSemester("11");
		assertEquals(10, degreePlannerModel.getDegreePlan().getSemesters().size());
		degreePlannerModel.removeSemester("10");
		assertEquals(9, degreePlannerModel.getDegreePlan().getSemesters().size());
		degreePlannerModel.removeSemester("1");
		assertEquals(0, degreePlannerModel.getDegreePlan().getSemesters().size());
		degreePlannerModel.addCourse("CS 1428 10");
		degreePlannerModel.removeSemester("0");
		assertEquals(0, degreePlannerModel.getDegreePlan().getSemesters().size());
		degreePlannerModel.addCourse("CS 1428 10");
		degreePlannerModel.removeSemester("-1");
		assertEquals(0, degreePlannerModel.getDegreePlan().getSemesters().size());
	}
}