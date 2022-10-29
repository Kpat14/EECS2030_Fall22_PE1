package PE1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PE1Tester {

	// Add your testers here
	
	@Test
	void test_1() {
		// you may want to change the assert statement such that it fits your purpose.
		assertTrue(true, "A message to show what went wrong");
		assertFalse(false, "A message to show what went wrong");
		assertEquals(0, 0, "A message to show what went wrong");
	}
	
	@Test
	void test_2() {
		// you may want to change the assert statement such that it fits your purpose.
		String[][] s = {{"1110", "1010", "1010", "1000", "1010", "1010"},
				 {"1010", "1000", "1001", "0101","1100", "1001"},
				 {"1100", "0011", "0101", "0110", "0011" , "0101"},
				 {"0101", "1101", "0110", "1001", "1110" , "0000"},
				 {"0110", "0011", "1110", "0010", "1010", "0011"}};
		
		Maze r = new Maze(s);
		r.getMaze();
		r.toString();
		
		assertEquals(0, 0, "A message to show what went wrong");
	}

}
