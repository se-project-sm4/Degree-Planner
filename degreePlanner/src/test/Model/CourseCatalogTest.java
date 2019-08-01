package test.Model;

import degreePlanner.Model.CourseCatalog;
import degreePlanner.Model.Course;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class CourseCatalogTest {
	/*
		public CourseCatalog();
		public Course findCourse(int id, String subject);
		public Map<String, Integer> getMap();
		public List<List<Course>> getCatalog();
	 */
	@Test
	void testAll() {
		CourseCatalog courseCatalog = new CourseCatalog();
		assertEquals(new Course(1428, "CS", null, 0, null, null, false), courseCatalog.findCourse(1428, "CS"));
		assertEquals(null, courseCatalog.findCourse(1, "CS"));
		assertEquals(null, courseCatalog.findCourse(0, "CS"));
		assertEquals(null, courseCatalog.findCourse(1428, null));
		assertEquals(null, courseCatalog.findCourse(1, null));
		assertEquals(null, courseCatalog.findCourse(0, null));
		assertEquals(null, courseCatalog.findCourse(1428, ""));
		assertEquals(null, courseCatalog.findCourse(1, ""));
		assertEquals(null, courseCatalog.findCourse(0, ""));
	}
}
