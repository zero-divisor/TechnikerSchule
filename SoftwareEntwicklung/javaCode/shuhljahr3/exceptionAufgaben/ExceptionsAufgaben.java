package shuhljahr3.exceptionAufgaben;

import java.util.Scanner;

public class ExceptionsAufgaben {

	/*
	Erstellen Sie ein Programm zu einer PIN-Abfrage. Der Benutzer hat drei Versuche, die 
	hinterlegte PIN „2884“ korrekt einzugeben. Benutzen Sie für folgende zwei Fehlerfälle zusätzliche eigene 
	unterschiedliche Exceptions.

	1) Die PIN wurde in einem Versuch falsch eingegeben.

	2) Die PIN wurde nach insgesamt drei Versuchen falsch eingegeben und die Eingabe der PUK ist nun
		erforderlich.
	 */
	
	public static final int correctPin = 2884;
	
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in); 
		int incorrectPinCounter = 0;
		
		while(incorrectPinCounter <= 3) {
			try {
				System.out.println("Pin: ");
				int pin = myScanner.nextInt();
				if(pin != correctPin) {
					throw new PinException();
				}else {
					System.out.println(pin + " ist der korrekte Pin");
					break;
				}
			}catch(PinException e) {
				incorrectPinCounter++;
				System.out.println(e.getMessage());
			}
		}
		
		if(incorrectPinCounter > 3) {
			System.out.println("PUK: ");
			int puk = myScanner.nextInt();
			System.out.println("Eingegebener PUK: " + puk);
		}
		
		myScanner.close();
	}

}
