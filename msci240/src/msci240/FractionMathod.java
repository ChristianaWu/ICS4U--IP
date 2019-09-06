/*
 * Christiana Wu
 * 2019-09-06
 * Msci 240
 */
package msci240;

public class FractionMathod {
	
	public static Fraction add (Fraction a, Fraction b) {
		Fraction c = new Fraction();
		
		if (a.denominator == b.denominator) {
			c.numerator = a.numerator + b.numerator;
		}else {
			c.denominator = (a.denominator * b.denominator);
			c.numerator = (a.numerator * b.denominator) + (a.denominator * b.numerator);
		}
		
		return c;
	}

	public static double asDouble(Fraction a) {
		double x = a.numerator / a.denominator;
		
		return x;
	}
}


