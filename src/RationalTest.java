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

	@Test
	public void testExceptionOnOverflow() {
		// That's really interesting... When I first wrote this test, what I got
		// was a StackOverflowError in the gcd method. That was unexpected.
		try {
			new Rational(1, Integer.MIN_VALUE);
			fail("Could create rational causing overflow?");
		} catch (IllegalArgumentException e) {
			assertEquals("Rational denominator too small", e.getMessage());
		}

		try {
			new Rational(Integer.MIN_VALUE, -3);
			fail("Could create rational causing overflow?");
		} catch (IllegalArgumentException e) {
			assertEquals("Rational nominator too small", e.getMessage());
		}

		try {
			new Rational(Integer.MIN_VALUE, 3);
			fail("Could create rational causing overflow?");
		} catch (IllegalArgumentException e) {
			assertEquals("Rational nominator too small", e.getMessage());
		}
	}

	@Test
	public void testAddition() {
		Rational r = new Rational(4, 7);
		Rational s = new Rational(2, 7);
		Rational res = r.plus(s);
		assertEquals("6/7", res.toString());
	}
	
	@Test
	public void testAdditionOfDifferentDenominators() {
		Rational r = new Rational(4, 7);
		Rational s = new Rational(2, 3);
		Rational res = r.plus(s);
		assertEquals("26/21", res.toString());
	}

	@Test
	public void testAdditionOfLargeDenominators() {
		Rational r = new Rational(4, 1000001);
		Rational s = new Rational(2, 1000001);
		Rational res = r.plus(s);
		assertEquals("6/1000001", res.toString());
	}
	
	@Test
	public void testRationalEquals() {
		Rational r = new Rational(4, 7);
		Rational s = new Rational(2, 7);
		assertEquals(new Rational(6, 7), r.plus(s));
	}

}
