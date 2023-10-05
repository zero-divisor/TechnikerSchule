package schuljahr1;

import java.util.Scanner;

public class ErsteEingabe {

	public static void main(String[] args) {
		int zahl;
		Scanner keyboardInput = new Scanner(System.in);
		
		System.out.println("Bitte gib eine Zahl  ein:");
		zahl = keyboardInput.nextInt();
		
		System.out.println("Deine eingegebene Zahl lautet: " + zahl);
		
		keyboardInput.close();
	}

}
