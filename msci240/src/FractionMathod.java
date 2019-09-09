

public class FractionMathod {
	
	public static Fraction add (Fraction a, Fraction b) {
		Fraction c = new Fraction();
		
		if (a.denominator == b.denominator) {
			c.numerator = a.numerator + b.numerator;
			c.denominator = a.denominator;
			
		}else {
			c.denominator = (a.denominator * b.denominator);
			c.numerator = (a.numerator * b.denominator) + (a.denominator * b.numerator);
		}
		
		return c;
	}

	public static double asDouble(Fraction a) {
		return (double) a.numerator / a.denominator;
	}
}


