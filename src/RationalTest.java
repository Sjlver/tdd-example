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
		Rational s = new Rational(4, 7);
		assertEquals("4/7", s.toString());
	}

	@Test
	public void testRationalIsReduced() {
		Rational r = new Rational(8, 6);
		assertEquals("4/3", r.toString());
	}
	
	@Test
	public void testNegativeRational() {
		Rational r = new Rational(-8, 6);
		assertEquals("-4/3", r.toString());
	}

	@Test
	public void testNegativeDenominatorRational() {
		Rational r = new Rational(8, -6);
		assertEquals("-4/3", r.toString());
	}

	@Test
	public void testExceptionOnZeroDenominator() {
		try {
			new Rational(1, 0);
			fail("Could create rational with denominator zero");
		} catch (IllegalArgumentException e) {
			assertEquals("Rational denominator must not be zero", e.getMessage());
		}
	}
}
