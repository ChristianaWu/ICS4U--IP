

public class FractionMethods {
	
	public static Fraction add (Fraction a, Fraction b) {
		Fraction c = new Fraction();
		
		if (a.getDenominator == b.getDenominator) {
			c.numerator = a.getNumerator + b.getNumerator;
			c.denominator = a.getDenominator;
			
		}else {
			c.denominator = (a.getDenominator * b.getDenominator);
			c.numerator = (a.numerator * b.denominator) + (a.denominator * b.numerator);
		}
		
		return c;
	}

	public static double asDouble(Fraction a) {
		return (double) a.numerator / a.denominator;
	}
}


