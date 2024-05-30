import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


// This is just my initial, non-completed test class that I created during 
// class. Your goal is to complete this with more test cases (either using
// parameterized testing or just the regular @Test methods. Look at the 
// specification.

// Here is the specification, for convenience:

/* Specification: This method takes three integers as input and outputs an
 * integer. The three input variables each describe the lengths of each 
 * side of a triangle. The lengths of the sides of the triangle should be 
 * less than or equal to 1000. The output of this method will be one of 
 * 5 possible values: 
 * 		1 for a scalene triangle, 
 * 		2 for an isosceles triangle, 
 * 		3 for an equilateral triangle, 
 * 		4 for values that do not describe a triangle, and 
 * 		5 for values that are out of bounds.
 */
class TriangleTyperTest {
	
	// Normal JUnit (non-parameterized) version
	@Test
	void testEquilateral() {
		int type = TriangleTyper.typer(5, 5, 5);
		Assertions.assertEquals(3, type);
	}
	
	// Parameterized version (you just need to add more values to the @CsvSource)
	@ParameterizedTest(name="{0}: sides {1}, {2}, {3} Expected= {4}")
	@CsvSource({"'Equilateral', 5, 5, 5, 3",
		"'Scalene a<b<c', 3, 4, 5, 1"
		})
	void testTyper(String name, int a, int b, int c, int expected) {
		int type = TriangleTyper.typer(a, b, c);
		Assertions.assertEquals(expected, type);
	}
	
}
