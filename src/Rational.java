
public class Rational {

	/** The nominator of this rational */
	public final int n;
	
	/** The denominator of this rational */
	public final int d;

	public Rational(int n, int d) {

		// Ensure values are within ranges that won't cause overflows on sign change
		if (n == Integer.MIN_VALUE) {
			throw new IllegalArgumentException("Rational nominator too small");
		} else if (d == Integer.MIN_VALUE) {
			throw new IllegalArgumentException("Rational denominator too small");
		}

		// Ensure denominator is not zero
		if (d == 0) {
			throw new IllegalArgumentException("Rational denominator must not be zero");
		}
		
		// We want the denominator to always be positive; the nominator's sign
		// defines this Rational's sign.
		if (d < 0) {
			n = -n;
			d = -d;
		} 
		
		int gcd = gcd(n, d);
		this.n = n / gcd;
		this.d = d / gcd;
	}
	
	private static int gcd(int a, int b) {
		if (a < 0) return gcd(-a, b);
		if (b == 0) return a;
		return gcd(b, a % b);
	}

	@Override
	public String toString() {
		return "" + n + "/" + d;
	}

	public Rational plus(Rational other) {
		int dGcd = gcd(d, other.d);
		int newDenom = d / dGcd * other.d;
		int myN = n * (newDenom / d);
		int otherN = other.n * (newDenom / other.d);
		
		return new Rational(myN + otherN, newDenom);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + d;
		result = prime * result + n;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rational other = (Rational) obj;
		if (n != other.n)
			return false;
		if (d != other.d)
			return false;
		return true;
	}
}
