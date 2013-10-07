import static org.junit.Assert.*;
import org.junit.Test;


public class RationalTest {

	@Test
	public void testCreateRational() {
		new Rational(4, 3);
	}

	@Test
	public void testRationalToString() {
		Rational r = new Rational(4, 3);
		assertEquals("4/3", r.toString());
	}

}
