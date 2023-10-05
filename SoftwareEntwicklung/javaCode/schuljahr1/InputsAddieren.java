package schuljahr1;

import java.util.Scanner;

public class InputsAddieren {

	public static void main(String[] args) {
		int zahl1, zahl2;
		Scanner keyboardInput = new Scanner(System.in);
		
		System.out.println("Bitte gib eine Zahl ein:");
		zahl1 = keyboardInput.nextInt();
		
		System.out.println("Bitte gib eine weitere Zahl ein:");
		zahl2 = keyboardInput.nextInt();
		
		int summe = zahl1 + zahl2;
		System.out.println("Die Summe der eingegebenenen Zahlen ist: " + summe);
		
		keyboardInput.close();
	}

}
