package schuljahr2;

public class RekursionAufgaben {

	public static void main(String[] args) {
		//numbers(200, 100);
		//System.out.println(powers(8));
		//System.out.println(fac(4));
		System.out.println(wasGebeIchAus(5));
	}
	/*
	Aufgabe 2:
		Programmieren Sie eine Methode, die die Zahlen von 200 bis 100 absteigend sortiert ausgibt. Verwenden
		Sie keine Schleife sondern rekursive Methodenaufrufe.
	*/
	public static void numbers(int upper, int lower) {
		System.out.println(upper);
		if(upper > lower) numbers(upper-1, lower);
	}
	/*
	Aufgabe 3:
		Programmieren Sie eine Methode, die Zweierpotenzen berechnet. Die Methode bekommt als Parameter
		den Exponenten und gibt die Potenz zur Basis zwei zurück. Verwenden Sie zur Berechnung keine Schleife,
		sondern rekursive Methodenaufrufe.
	*/
	public static int powers(int exponent) {
		if(exponent > 0) {
			return 2*powers(exponent-1);
		}else {
			return 1;
		}
	}
	/*
	Aufgabe 4:
		Programmieren Sie eine Methode, die die Fakultät rekursiv berechnet.
	*/
	public static int fac(int n) {
		if(n > 1) {
			return n*fac(n-1);
		}else {
			return 1;
		}
	}
	
	public static int wasGebeIchAus(int n)
	{
		if(n == 0)
		{
			return 3;
		}
		else if(n == 1)
		{
			return 2;
		}
		else
		{
			return wasGebeIchAus(n - 1) + wasGebeIchAus(n - 2);
		}
	}
}
