package schuljahr1;

import java.util.Scanner;

public class BoolscheAusdrueckeAufgaben {

	public static void main(String[] args) {
		/*
		Aufgabe 1: KFZ-Versicherungsbeitrag berechnen
		Die KFZ-Versicherung wird ausgehend von einem Grundbetrag für jedes Fahrzeug in Abhängigkeit vom
		Alter des Fahrers, der jährlichen Fahrleistung in km und ob das Fahrzeug in einer Garage abgestellt wird,
		berechnet.
		
		Schreiben Sie ein Programm bei dem der zu zahlende Versicherungsbetrag nach Eingabe des
		Grundbetrags und weiterer Angaben (Alter, jährliche Fahrleistung in km, Garagenfahrzeug) berechnet
		wird.
		
		Dabei soll gelten:
		- Ist der Fahrer jünger als 25 Jahre UND die jährliche Fahrleistung mehr als 15000 km, erhöht sich
		  der Gesamtbetrag um 40% des Grundbetrags.
		- Bei einer jährlichen Fahrleistung von weniger als 15000 km im Jahr ODER einem
		  Garagenfahrzeug verringert sich der Gesamtbetrag um 10% des Grundbetrags.
		- Ist das Fahrzeug KEIN Garagenfahrzeug, erhöht sich der Gesamtbetrag um 5% des Grundbetrags.
		*/
		
		System.out.println("\n1: KFZ-Versicherungsbeitrag berechnen");
		System.out.println("----------------------------------------");
		
		double grundbetrag = 100.0;
		int alter = 66;
		int jaehrlFahrleistung = 10000;
		boolean garagenfahrzeug = true;
		double endbetrag = grundbetrag;
		
		if(alter < 25 && jaehrlFahrleistung > 15000) endbetrag += 1.4*grundbetrag;
		if(jaehrlFahrleistung < 15000 || garagenfahrzeug) endbetrag -= 0.1*grundbetrag;
		if(!garagenfahrzeug) endbetrag += 0.05*grundbetrag;
		
		System.out.println(endbetrag + "€");
		
		/*
		Aufgabe 2: Boolescher Taschenrechner
		Schreiben Sie ein Programm das zwei boolesche Werte, also entweder true oder false einliest und
		zusätzlich abfragt, wie die beiden eingelesenen Werte logisch miteinander verknüpft werden sollen.
		
		- Gibt der Benutzer die Zeichenkette "&&" ein, dann werden die beiden Eingangswerte mit UND
		  verknüpft und ausgegeben.
		- Gibt der Benutzer die Zeichenkette "||" ein, dann werden die beiden Eingangswerte mit ODER
		  verknüpft und ausgegeben.
		- Gibt der Benutzer die Zeichenkette "!" ein, dann werden beide Eingangswerte negiert und
		  ausgegeben.
		- Gibt der Benutzer die Zeichenkette "xor" ein, dann werden die beiden Eingangswerte mit einem
		  "exklusiven" ODER verknüpft und ausgegeben.
		*/
		
		System.out.println("\n2: Boolescher Taschenrechner");
		System.out.println("----------------------------------------");
		
		String operator = "xor";
		boolean bol1 = true;
		boolean bol2 = true;

		switch (operator) {
		case "&&":
			System.out.print(bol1 + " " + operator + " " + bol2 + " = ");
			System.out.println(bol1 && bol2);
			break;
		case "||":
			System.out.print(bol1 + " " + operator + " " + bol2 + " = ");
			System.out.println(bol1 || bol2);
			break;
		case "!":
			System.out.println("!" + bol1 + " = " + !bol1 + "; !" + bol2 + " = " + !bol2);
			break;
		case "xor":
			System.out.print(bol1 + " " + operator + " " + bol2 + " = ");
			System.out.println((bol1 && !bol2) || (!bol1 && bol2));
			break;
		default:
			System.err.println("Ungültiger Operator");
			break;
		}
		
		/*
		Aufgabe 3: Eingabeüberprüfung
		Schreiben Sie ein Programm das den Benutzer solange zur Eingabe eines Zeichens oder Zahl auffordert
		bis er entweder eine Zahl < 0, eine Zahl > 200 oder das Zeichen 'c' eingibt. 
		Ist die Zahl kleiner 0, muss sie zwischen -50 und -100 liegen.
		*/
		
		System.out.println("\n3: Eingabeüberprüfung");
		System.out.println("----------------------------------------");
		
		
		Scanner keyboardInput = new Scanner(System.in);
		
		while(true) {
			System.out.println("Input here:");
			String input = keyboardInput.nextLine();
			
			try {
				int inputNr = Integer.parseInt(input);
				if(inputNr > 200 || (inputNr<=-50 && inputNr>=-100)) break;
			}catch(NumberFormatException e) {
				if(input.equals("c")) break;
			}
		}
		System.out.println("Exited");
		keyboardInput.close();
	}

}
