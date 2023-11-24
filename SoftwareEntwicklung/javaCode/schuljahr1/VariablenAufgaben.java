package schuljahr1;

import java.util.Locale;
import java.util.Scanner;

public class VariablenAufgaben {
	
	public static void main(String[] args) {
		/*
		Aufgabe 1:
		Schreiben Sie ein Java-Programm, in dem folgende Literale den passenden Variablen zugewiesen werden
		und diese Variablen anschließend ausgibt:
		'A'
		100
		1.344
		"Sonne"
		100200300
		-12
		*/
		char zeichen = 'A';
		int ganzeZahl = 100;
		double kommazahl = 1.344;
		String text = "Sonne";
		int grosseZahl = 100200300;
		int negativeZahl = -12;
		
		System.out.println(zeichen);
		System.out.println(ganzeZahl);
		System.out.println(kommazahl);
		System.out.println(text);
		System.out.println(grosseZahl);
		System.out.println(negativeZahl);
		
		/*
		Aufgabe 2: Summe, Differenz, Produkt und Quotient
		Schreiben Sie in Java ein Programm, das zwei Kommazahlen einliest und deren Summe, Differenz,
		Produkt und Quotient ausgibt.
		*/
		
		System.out.println("\n2: Rechnen mit Kommazahlen");
		System.out.println("----------------------------------------");
		
		double double1, double2;
		Scanner keyboardInput = new Scanner(System.in);
		
		System.out.println("Bitte gib eine Kommazahl ein: (Mit komma nicht mit punkt)");
		double1 = keyboardInput.nextDouble();
		
		System.out.println("Bitte gib eine weitere Kommazahl ein: (Mit komma nicht mit punkt)");
		double2 = keyboardInput.nextDouble();
		
		double summe = double1 + double2;
		double differenz = double1 - double2;
		double produkt = double1 * double2;
		double quotient = double1 / double2;
		System.out.println("summe:     " + summe);
		System.out.println("differenz: " + differenz);
		System.out.println("produkt:   " + produkt);
		System.out.println("quotient:  " + quotient);
		
		
		/*
		Aufgabe 3: Währungsumrechner
		Schreiben Sie in Java einen Währungsumrechner für DM in Euro. DM-Beträge werden über die Tastatur
		eingegeben und Euro-Beträge über die Konsole ausgegeben. Der Umrechnungskurs: 1 Euro = 1,96 DM
		*/
		System.out.println("\n3: Währungsumrechner");
		System.out.println("----------------------------------------");
		
		System.out.println("Bitte gib einen Betrag in DM ein: (Mit komma nicht mit punkt)");
		double wertDM = keyboardInput.nextDouble();
		
		System.out.println("Wert in Euro (1 Euro = 1,96 DM): " + (wertDM / 1.96));
		
		/*
		Aufgabe 4: Kraftstoffverbrauch
		Entwickeln Sie ein Java-Programm, welches nach Eingabe der zurückgelegten Strecke (km) und der
		verbrauchten Kraftstoffmenge den durchschnittlichen Kraftstoffverbrauch auf 100 km berechnet und
		ausgibt.
		*/
		System.out.println("\n4: Kraftstoffverbrauch");
		System.out.println("----------------------------------------");
		
		System.out.println("Bitte gib die zurückgelegte Strecke ein: (Mit komma nicht mit punkt)");
		double strecke = keyboardInput.nextDouble();
		
		System.out.println("Bitte gib die verbrauchte Kraftstoffmenge ein: (Mit komma nicht mit punkt)");
		double kraftstoffmenge = keyboardInput.nextDouble();
		
		System.out.println("Durchnittlicher Verbrauch: " + (kraftstoffmenge*100 / strecke) + " Liter pro 100Km");
		
		/*
		Aufgabe 5: Uhrzeit berechnen
		Schreiben Sie ein Programm, welches eine vom Benutzer einzugebende Zeit in Sekunden als Tage,
		Stunden, Minuten und Sekunden ausgibt. 1089386 entspräche beispielsweise 12 Tage 14 Stunden 36
		Minuten und 26 Sekunden.
		*/
		
		System.out.println("\n5: Zeit berechnen");
		System.out.println("----------------------------------------");
		
		System.out.println("Bitte gib eine Zeit in Sekunden ein: (ganze Zahl)");
		int sekundenEingegeben = keyboardInput.nextInt();
		
		int tage = sekundenEingegeben / (24*60*60);
		int stunden = (sekundenEingegeben - tage*24*60*60) / (60*60);
		int minuten = (sekundenEingegeben - tage*24*60*60 - stunden*60*60) / 60;
		int sekunden = sekundenEingegeben - tage*24*60*60 - stunden*60*60 - minuten*60;
		
		System.out.println(tage + " Tage " + stunden + " Stunden " + minuten + " Minuten " + sekunden + " Sekunden");
		
		/*
		Aufgabe 6: Stromrechnung erstellen
		Ein Energieversorgungsunternehmen erstellt monatlich die Rechnungen für den Stromverbrauch mithilfe
		einer Datenverarbeitungsanlage. Dabei müssen zur Erfassung des Stromverbrauchs der alte und der neue
		Zählerstand eingegeben werden.
		Aufgabe: Erstellen Sie ein Programm, dass die Zählerstände mithilfe von Ganzzahlen erfasst und
		anschließend eine Rechung wie unten dargestellt ausgibt:
		R E C H N U N G
		Preis fuer eine kWh: 0.13 EUR
		Anschlussgrundgebuehr: 27.30 EUR
		Verbrauch: 100 kWh * 0.13 EUR = + 13.00
		----------
		40.30 EUR
		MwSt (19%): + 7.66
		----------
		Endbetrag: 47.96 EUR
		*/
		
		System.out.println("\n6: Stromrechnung erstellen");
		System.out.println("----------------------------------------");
		
		System.out.println("Bitte gib den alten Zählerstand ein: (ganze Zahl)");
		int zaehlerstandAlt = keyboardInput.nextInt();
		System.out.println("Bitte gib den neuen Zählerstand ein: (ganze Zahl)");
		int zaehlerstandNeu = keyboardInput.nextInt();
		
		int zaehlerDifferenz = zaehlerstandNeu - zaehlerstandAlt;
		double anschlussgrundgebuehr = 27.30;
		// Locale.US, dass . statt , benutzt wird
		String anschlussgrundgebuehrFormatted = String.format(Locale.US, "%.2f", anschlussgrundgebuehr);
		
		double preisProKw = 0.13;
		String preisProKwFormatted = String.format(Locale.US, "%.2f", preisProKw);
		
		double strompreisGes = preisProKw * (double) zaehlerDifferenz;
		String strompreisGesFormatted = String.format(Locale.US, "%.2f", strompreisGes);
		
		double mitGebuehr = strompreisGes + anschlussgrundgebuehr;
		String mitGebuehrFormatted = String.format(Locale.US, "%.2f", mitGebuehr);
		
		double mwst = mitGebuehr * 0.19;
		String mwstFormatted = String.format(Locale.US, "%.2f", mwst);
		
		double gesamtBetrag = mitGebuehr + mwst;
		String gesamtBetragFormatted = String.format(Locale.US, "%.2f", gesamtBetrag);
		
		System.out.println("\nR E C H N U N G\r\n"
				+ "Preis fuer eine kWh: " + preisProKwFormatted + " EUR\n"
				+ "Anschlussgrundgebuehr: " + anschlussgrundgebuehrFormatted + " EUR\n"
				+ "Verbrauch: " + zaehlerDifferenz + " kWh * " + preisProKwFormatted + " EUR = + " + strompreisGesFormatted + "\n"
				+ "----------\r\n"
				+ mitGebuehrFormatted + " EUR\r\n"
				+ "MwSt (19%): + " + mwstFormatted + "\n"
				+ "----------\n"
				+ "Endbetrag: " + gesamtBetragFormatted + " EUR");
		
		
		
		/*
		Aufgabe 7: Quersumme
		Schreiben Sie ein Java-Programm, welches die Quersumme einer maximal 5-stelligen Integer-Zahl
		berechnet und ausgibt. Die Zahl wird entweder im Programm definiert oder kann vom Benutzer eingegeben
		werden.
		Beispiel: int z = 123 => Quersumme = 1 + 2 + 3 = 6
		Hinweis: Lösen Sie das Problem ohne eine Schleife.
		*/
		
		System.out.println("\n7: Quersumme berechnen");
		System.out.println("----------------------------------------");
		
		int quersummenTestZahl = 23456;
		
		int digit1 = quersummenTestZahl % 10;
		int digit2 = quersummenTestZahl/10 % 10;
		int digit3 = quersummenTestZahl/100 % 10;
		int digit4 = quersummenTestZahl/1000 % 10;
		int digit5 = quersummenTestZahl/10000 % 10;
		
		int quersumme = digit1 + digit2 + digit3 + digit4 + digit5;
		
		System.out.println("Die quersumme von " + quersummenTestZahl + " ist:");
		System.out.println(digit5 + " + " + digit4 + " + " + digit3 + " + " + digit2 + " + " + digit1 + " = " + quersumme);
		
		// zum Abschluss noch Scanner schließen
		keyboardInput.close();
	}
	
}
