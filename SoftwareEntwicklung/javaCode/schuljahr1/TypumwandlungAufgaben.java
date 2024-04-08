package schuljahr1;

public class TypumwandlungAufgaben {

	public static void main(String[] args) {
		/*
		Aufgabe 1:
		Schreiben Sie ein Programm, das nach Eingabe eines ASCII-Codes, das zugehörige Zeichen ausgibt.
		*/
		
		System.out.println("\n1: Ascii-Code");
		System.out.println("----------------------------------------");
		
		int asciiNr = 35;
		System.out.println("Der Ascii Charakter für " + asciiNr + " ist: " + (char) asciiNr);
		
		/*
		Aufgabe 2:
		Schreiben Sie einen Taschenrechner, der nach Eingabe einer Rechnung, z.B. 2+5 die Summe ausgibt.
		Ergänzen Sie den Taschenrechner auch für Subtraktion, Multiplikation, Division und Modulo.
		*/
		
		System.out.println("\n2: Taschenrechner");
		System.out.println("----------------------------------------");
		
		String rechnung = "21%5";
		
		String rechenzeichen = rechnung.replaceAll("\\d", "");
		int rechenzeichenPos = rechnung.indexOf(rechenzeichen);
		
		int zahl1 = Integer.valueOf(rechnung.substring(0, rechenzeichenPos));
		int zahl2 = Integer.valueOf(rechnung.substring(rechenzeichenPos+1, rechnung.length()));

		System.out.print(rechnung + "=");
		
		switch (rechenzeichen) {
		case "+":
			System.out.println(zahl1 + zahl2);
			break;
		case "-":
			System.out.println(zahl1 - zahl2);
			break;
		case "*":
			System.out.println(zahl1 * zahl2);
			break;
		case "/":
			System.out.println(zahl1 / zahl2);
			break;
		case "%":
			System.out.println(zahl1 % zahl2);
			break;
		default:
			System.err.println("Ungültiges Rechenzeichen");
			break;
		}
		
		/*
		Aufgabe 3:
		Schreiben Sie ein Programm, das eine Zahl einliest. Ist die Zahl größer als 100, soll die Quersumme
		berechnet und ausgegeben werden.
		Beispiel:
		Eingabe: 234
		Ausgabe: 9
		*/
		
		System.out.println("\n3: Quersumme");
		System.out.println("----------------------------------------");
		
		int inputNr = 12345;
		System.out.println("Eingabe: " + inputNr);
		
		if(inputNr > 100) {
			String nrString = String.valueOf(inputNr);
			int quersumme = 0;
			
			for(int i=0; i<nrString.length(); i++) {
				int digit = Integer.valueOf(nrString.substring(i, i+1));
				quersumme += digit;
			}
			
			System.out.println("Quersumme: " + quersumme);
		}else {
			System.out.println(inputNr + " ist kleiner als 100");
		}
	}

}
