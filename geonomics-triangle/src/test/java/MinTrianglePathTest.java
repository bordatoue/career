import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.Reader;
import java.io.StringReader;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MinTrianglePathTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void test_getLineStartIndex() {
		assertEquals(0, MinTrianglePath.getRowStartIndex(0));
		assertEquals(1, MinTrianglePath.getRowStartIndex(1));
		assertEquals(3, MinTrianglePath.getRowStartIndex(2));
		assertEquals(6, MinTrianglePath.getRowStartIndex(3));
	}

	private void epectedException(String input, String message) throws MinTrianglePath.TriangleException {
		Reader reader = new StringReader(input);

		thrown.expect(MinTrianglePath.TriangleException.class);
		thrown.expectMessage(message);

		MinTrianglePath.calculateMinimumTrianglePath(reader);

		fail("Should exit.");
	}

	@Test
	public void test_empty_input() throws MinTrianglePath.TriangleException {

		String input = "";
		String message = "No data provided.";

		epectedException(input, message);
	}
	
	@Test
	public void test_too_many_elements_in_line() throws MinTrianglePath.TriangleException {

		String input = "1 2";
		String message = "Too many elements in line 1.";

		epectedException(input, message);
	}

	@Test
	public void test_too_little_elements_in_line() throws MinTrianglePath.TriangleException {

		String input = "1\n1";
		String message = "Too little elements in line 2.";

		epectedException(input, message);
	}

	@Test
	public void test_invalid_element() throws MinTrianglePath.TriangleException {

		String input = "1\n1 2\n3 A 5";
		String message = "Invalid element at position 2 in line 3.";

		epectedException(input, message);
	}

	@Test
	public void test_example() throws MinTrianglePath.TriangleException {

		String input = "7\n6 3\n3 8 5\n11 2 10 9";
		Reader reader = new StringReader(input);

		assertEquals("Minimal path is: 7 + 6 + 3 + 2 = 18", MinTrianglePath.calculateMinimumTrianglePath(reader));
	}

	@Test
	public void test_overflow() throws MinTrianglePath.TriangleException {

		// 2147483647
		// 2147483647 0
		String input = "2147483647\n2147483647 0";
		Reader reader = new StringReader(input);

		assertEquals("Minimal path is: 2147483647 + 0 = 2147483647", MinTrianglePath.calculateMinimumTrianglePath(reader));
	}

}