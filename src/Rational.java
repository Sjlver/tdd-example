
public class Rational {

	/** The nominator of this rational */
	public final int n;
	
	/** The denominator of this rational */
	public final int d;

	public Rational(int n, int d) {
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

}
