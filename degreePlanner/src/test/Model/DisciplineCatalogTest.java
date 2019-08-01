package test.Model;

import degreePlanner.Model.DisciplineCatalog;
import degreePlanner.Model.Major;
import degreePlanner.Model.Minor;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class DisciplineCatalogTest {
	/*	
	public DisciplineCatalog();
	public Major findMajor(String major);
	public Minor findMinor(String minor);
	public List<Requirement> getDefaultRequirements();
	public List<Major> getMajors();
	public List<Minor> getMinors();
	 */
	@Test
	void testAll() {
		DisciplineCatalog disciplineCatalog = new DisciplineCatalog();
		assertEquals(new Major("Computer Science", null, 0), disciplineCatalog.findMajor("Computer Science"));
		assertEquals(null, disciplineCatalog.findMajor(null));
		assertEquals(null, disciplineCatalog.findMajor(""));
		assertEquals(null, disciplineCatalog.findMajor("a"));
		assertEquals(new Minor("Mathematics", null, 0), disciplineCatalog.findMinor("Mathematics"));
		assertEquals(null, disciplineCatalog.findMinor(null));
		assertEquals(null, disciplineCatalog.findMinor(""));
		assertEquals(null, disciplineCatalog.findMajor("a"));
	}
}
