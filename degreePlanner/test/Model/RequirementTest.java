package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RequirementTest {

	Requirement req = new Requirement();
	@Test
	void test() {
		String s = "Math";
		req.setSubject("Math");
		assertEquals(s, req.getSubject());
	}
	@Test
	void test2() {
		int n = 3;
		req.setNumHour(4);
		assertNotEquals(n, req.getNumHour());
	}

}
