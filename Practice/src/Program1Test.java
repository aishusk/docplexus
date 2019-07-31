import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class Program1Test {
	@Test
	public void testForPrimeNo() {
		Program1 test= new Program1();
		assertTrue(test.prime(5));
	}
	
	@Test
	public void testForReverse()
	{
		Program1 test= new Program1();
		assertEquals("gnirtS", test.reverseString("String"));
	}

}
