
public class Rational {

	/** The nominator of this rational */
	public final int n;
	
	/** The denominator of this rational */
	public final int d;

	public Rational(int n, int d) {
		this.n = n;
		this.d = d;
	}
	
	@Override
	public String toString() {
		return "" + n + "/" + d;
	}

}
