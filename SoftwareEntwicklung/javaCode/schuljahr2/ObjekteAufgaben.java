package schuljahr2;

public class ObjekteAufgaben {

	public static void main(String[] args) {
		RationalNumber q1 = new RationalNumber(3, 8);
		RationalNumber q2 = new RationalNumber(6, 16);
		System.out.println(q1.equals(q2));
	}

}

class RationalNumber {
	
	private int numerator, denominator;
	
	public RationalNumber(int numerator, int denominator) throws ArithmeticException{
		if(denominator == 0) {
			throw new ArithmeticException("Durch 0 teilen ist nicht erlaubt.");
		}
		this.setNumerator(numerator);
		this.setDenominator(denominator);
		kuerzen();
	}
	
	public boolean equals(RationalNumber q) {
		return denominator*q.getNumerator() == numerator*q.getDenominator();
	}
	
	public void divideBy(RationalNumber toMultiply) {
		numerator *= toMultiply.getDenominator();
		denominator *= toMultiply.getNumerator();
		kuerzen();
	}
	
	public void multiplyBy(RationalNumber toMultiply) {
		numerator *= toMultiply.getNumerator();
		denominator *= toMultiply.getDenominator();
		kuerzen();
	}
	
	public void add(RationalNumber toAdd) {
		int lcm = leastCommonMultiple(denominator, toAdd.getDenominator());
		int factor1 = lcm/denominator;
		int factor2 = lcm/toAdd.getDenominator();
		
		numerator = numerator*factor1 + toAdd.getNumerator()*factor2;
		denominator = lcm;
		kuerzen();
	}
	
	public void subtract(RationalNumber toSubtract) {
		int lcm = leastCommonMultiple(denominator, toSubtract.getDenominator());
		int factor1 = lcm/denominator;
		int factor2 = lcm/toSubtract.getDenominator();
		
		numerator = numerator*factor1 - toSubtract.getNumerator()*factor2;
		denominator = lcm;
		kuerzen();
	}
	
	public void kuerzen() {
		int gcd = greatestCommonDivisor(numerator, denominator);
		numerator = numerator/gcd;
		denominator = denominator/gcd;
	}
	
	private int leastCommonMultiple(int val1, int val2) {
		// lcm(a,b) = |a|*|b|/gcd(a,b)
		int gcd = greatestCommonDivisor(val1, val2);
		int temp = val2/gcd;
		return Math.abs(val1*temp);
	}
	
	private int greatestCommonDivisor(int val1, int val2) {
		if(val1 == 0) return val2;
		if(val2 == 0) return val1;
		
		// damit der größer/kleiner vergleich funktioniert 
		val1 = Math.abs(val1);
		val2 = Math.abs(val2);
		
		int largerVal = Math.max(val1, val2);
		int smallerVal = Math.min(val1, val2);
		
		int remainder = largerVal%smallerVal;
		
		return greatestCommonDivisor(smallerVal, remainder);
	}
	
	
	public String toString() {
		return numerator + "/" + denominator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}
}
