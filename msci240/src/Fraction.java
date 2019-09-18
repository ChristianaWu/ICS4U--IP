import java.util.Arrays;
import java.util.StringTokenizer;

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
    
    public Fraction multiply (Fraction f) {
    	Fraction f2 = new Fraction ();
    	f2.denominator = this.denominator * f.getDenominator();
    	f2.numerator = this.numerator * f.getNumerator();
    	
    	return f2;
    }
    
    public static Fraction parseFraction (String str) {
    	Fraction f = new Fraction ();
    	
    	String split[] = str.split("\\s*/ \\s*");
    	System.out.println(Arrays.toString(split));
    	int length = split.length;
    	//split[1] = split[1].replace("\\s*", "");
    	
    	//try {
    		if(length == 1) {
    			throw new NumberFormatException();
    		}else if (split[1].contains("0")) {
    			throw new IllegalArgumentException();
    		}else {
    			f.numerator = Integer.parseInt(split[0]);
    			f.denominator = Integer.parseInt(split[1]);

    		//}catch (Exception e) {
    		
    	}
    	
    	//System.out.println(f.numerator + " " +  f.denominator);
    	
    	return f;
    }


}

