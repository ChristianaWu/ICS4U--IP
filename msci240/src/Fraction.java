

public class Fraction {
	private int numerator;
    private int denominator;
   
    public Fraction () {
    	this.numerator = 0;
    	this.denominator = 1;
    }
    
    public Fraction (int numerator, int denominator) {
    	this.denominator = denominator;
    	this.numerator = numerator;
    }
    
    public double asDouble() throws IllegalArgumentException{
    	return (double) this.numerator/this.denominator;
    }
    
    public int getNumerator () {
    	return this.numerator;
    }
    
    public int getDenominator () {
    	return this.denominator;
    }
    
    public void simplify() {
    	int gcd = MathUtilities.gcd(this.numerator, this.denominator);
    	this.numerator = this.numerator / gcd;
    	this.denominator = this.denominator / gcd;
    }
}

