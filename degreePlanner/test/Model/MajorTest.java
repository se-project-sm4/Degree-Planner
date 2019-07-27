package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MajorTest {

	Major major = new Major();

	@Test
	void test() {
		assertNull(major.getMajorName());
	}
	
	
	@Test
	void test2() {
		major.setMajorName("Computer Science");
		assertSame("Computer Science", major.getMajorName());
	}
}
