package schuljahr1;

import java.util.HashMap;
import java.util.Scanner;

public class StringsAufgaben {

	public static void main(String[] args) {
		Scanner keyboardInput = new Scanner(System.in);
		/*
		Aufgabe 1:
		Schreiben Sie ein Programm, das eine E-Mail Adresse vom Benutzer einliest. Anschließend soll die E-Mail
		Adresse in Benutzername und Hostname getrennt ausgegeben werden.
		Beispieleingabe:
		thomas.schmidt@elektronikschule.de
		Ausgabe:
		Benutzername: thomas.schmidt
		Hostname: elektronikschule.de
		*/
		
//		System.out.println("\n1: Email Adressen");
//		System.out.println("----------------------------------------");
//		
//		System.out.println("Bitte gib deine Email Adresse ein:");
//		String email = keyboardInput.nextLine();
//		
//		String[] split = email.split("@");
//		System.out.println("Benutzername: " + split[0] + "\nHostname: " + split[1]);
		
		/*
		Aufgabe 2:
		Deutsche Wörter können in eine Sprache namens „Schweinelatein“ übersetzt werden, indem der erste
		Buchstabe des Wortes an das Ende des Wortes verschoben wird und ein "oink" angehängt wird.
		Zum Beispiel, „Guten Morgen“ in Schweinelatein lautet: „Utengoink Orgenmoink“.
		Schreiben Sie ein Programm, das den Benutzer nach Vor- und Nachname fragt und dessen Namen in
		Schweinelatein ausgibt.
		*/
		
//		System.out.println("\n2: Schweinelatein");
//		System.out.println("----------------------------------------");
//		
//		System.out.println("Bitte gib deinen Vor- und Nachnamen ein:");
//		String inputStr = keyboardInput.nextLine();
//		
//		String[] words = inputStr.split("\\s");
//		String outputStr = "";
//		
//		for(int i=0; i<words.length; i++) {
//			// Ersten Buchstaben nach hinten
//			String newWord = words[i].substring(1, words[i].length()) + words[i].substring(0, 1).toLowerCase();
//			
//			// Ersten Buschstaben groß falls er bei words[i] Groß war
//			if(Character.isUpperCase(words[i].charAt(0))) {
//				newWord = newWord.substring(0, 1).toUpperCase() + newWord.substring(1, newWord.length());
//			}
//			
//			// oink anhängen
//			newWord += "oink";
//			
//			outputStr += newWord + (i == words.length-1 ? "" : " ");
//		}
//		
//		System.out.println(outputStr);
		
		/*
		Aufgabe 3:
		Schreiben Sie ein Programm mit dem Namen „AddressReader“ das Daten von der Tastatur in folgendem
		Format einliest:
		Vorname Nachname Alter
		Adresse
		
		Beispieleingabe:
		Thomas Schmidt 21
		Hauptstr. 4, 88069 Tettnang
		
		Die Ausgabe soll so aussehen:
		Vorname: Thomas
		Nachname: Schmidt
		Alter: 21
		Strasse: Hauptstr.
		Hausnummer: 4
		PLZ: 88069
		Wohnort: Tettnang
		*/
		
//		System.out.println("\n3: AddressReader");
//		System.out.println("----------------------------------------");
//		
//		System.out.println("Bitte gib deinen Vornamen Nachnamen und Alter ein:");
//		String nameAndAge = keyboardInput.nextLine();
//		System.out.println("Bitte gib deine Adresse ein: (Straße Hausnummer, PLZ Wohnort)");
//		String fullAdress = keyboardInput.nextLine();
//		
//		String[] nameSplit = nameAndAge.split("\\s");
//		String[] adressSplit = fullAdress.split(",?\\s");
//		
//		System.out.println("Vorname: " + nameSplit[0] + "\n"
//				+ "Nachname: " + nameSplit[1] + "\n"
//				+ "Alter: " + nameSplit[2] + "\n"
//				+ "Strasse: " + adressSplit[0] + "\n"
//				+ "Hausnummer: " + adressSplit[1] + "\n"
//				+ "PLZ: " + adressSplit[2] + "\n"
//				+ "Wohnort: " + adressSplit[3]);
		
		/*
		Aufgabe 4:
		Schreiben Sie ein Programm, das als Eingabe ein Geburtsdatum einer Person sowie das heutige Datum
		einliest.
		Beispieleingabe:
		Geben Sie Ihr Geburtsdatum ein: 26.09.1997
		Geben Sie das aktuelle Datum ein: 21.10.2015
		a) Geben Sie das Alter der Person in Jahren aus.
		b) Geben Sie das Alter der Person in Jahren und Monaten aus.
		 */
		
//		System.out.println("\n3: Alter");
//		System.out.println("----------------------------------------");
//		
//		System.out.println("Bitte gib dein Geburtsdatum ein: (dd.mm.yyyy)");
//		String birthdayStr = keyboardInput.nextLine();
//		
//		System.out.println("Bitte gib das heutige Datum ein: (dd.mm.yyyy)");
//		String todayStr = keyboardInput.nextLine();
//		
//		String[] birthdaySplit = birthdayStr.split("\\.");
//		String[] todaySplit = todayStr.split("\\.");
//		
//		int birthdayYear = Integer.valueOf(birthdaySplit[2]);
//		int birthdayMonth = Integer.valueOf(birthdaySplit[1]);
//		
//		int todayYear = Integer.valueOf(todaySplit[2]);
//		int todayMonth = Integer.valueOf(todaySplit[1]);
//		
//		int ageInYears = todayYear - birthdayYear;
//		if(birthdayMonth > todayMonth) ageInYears--;
//		
//		int monthsDif = birthdayMonth > todayMonth ? todayMonth + 12 - birthdayMonth : todayMonth - birthdayMonth;
//		
//		System.out.println("a) Alter in Jahre: " + ageInYears);
//		System.out.println("b) Alter in Jahre, Monate: " + ageInYears + " J, " + monthsDif + " M");
		
		/*
		Schreiben Sie ein Programm, das vom Benutzer Kontonummer und Bankleitzahl einliest und die
		berechnetete IBAN ausgibt.
		Überprüfen Sie Ihr Programm auf Korrektheit mit Hilfe der Webseite http://www.iban-rechner.de/
		
		Deutsches IBAN-Format
		Länge 22 Zeichen
		
		Bestandteil 		Kurzbezeichnung	Stelle 		Inhalt
		----------------------------------------------------------------------------------------------------
		Länderkennzeichen 	LK (L) 			1 – 2 		konstant “DE” für Deutschland
		
		Prüfziffer 			PZ (P) 			3 – 4 		2-stellig
		
														Berechnung Modulo 97 – 10 (ISO 7064)
		Bankleitzahl 		BLZ (B) 		5 – 12		konstant 8-stellig
														Bankidentifikation entsprechend der deutschen
														“Bankleitzahlendatei“
														
		Kontonummer 		KTO (K) 		13 – 22		konstant 10-stellig
														Kunden-Konto(stamm)nummer (kürzere
														Kontonummern werden linksbündig mit führenden
														Nullen auf 10 Stellen erweitert)
		
		Damit ergibt sich folgende Struktur einer deutschen IBAN:
		LLPPBBBBBBBBKKKKKKKKKK
		*/
		
		System.out.println("\n4: IBAN Rechner");
		System.out.println("----------------------------------------");
		
		System.out.println("Bitte gib deine Kontonummer ein:");
		String kontoNrStr = keyboardInput.nextLine();
		
		System.out.println("Bitte gib deine Bankleitzahl ein:");
		String blzStr = keyboardInput.nextLine();
		
		String countryCode = "DE";
		String pruefZiffer = "00";
		
		/*
		Berechnung der Prüfziffer
		Schritt 1
		Die ersten 4-Zeichen (LLPP) an das Ende der IBAN stellen. Da die Prüfziffer noch nicht bekannt ist, wird für
		PP “00” angenommen. Sollte die Kontonummer kürzer sein als 10 Zeichen, so wird die Kontonummer
		linksbündig auf 10 Stellen mir Nullen aufgefüllt.
		BBBBBBBBKKKKKKKKKKDE00
		*/
		
		/*
		Schritt 2
		Der Ländercode LL muss in nummerische Werte umgerechnet werden. Dabei repräsentiert das A den Wert
		10 (<Position des Buchstaben im lateinischen Alphabet> + 9).
		Der Übersichtshalber können Sie die Werte der folgenden Tabelle entnehmen.
		
		A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
		10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35
		
		BBBBBBBBKKKKKKKKKK131400
		*/
		
		HashMap<Character, Integer> countryCodeMap = new HashMap<Character, Integer>() {
			private static final long serialVersionUID = 1L;
		{
			put('A', 10);
			put('B', 11);
			put('C', 12);
			put('D', 13);
			put('E', 14);
			put('F', 15);
			put('G', 16);
			put('H', 17);
			put('I', 18);
			put('J', 19);
			put('K', 20);
			put('L', 21);
			put('M', 22);
			put('N', 23);
			put('O', 24);
			put('P', 25);
			put('Q', 26);
			put('R', 27);
			put('S', 28);
			put('T', 29);
			put('U', 30);
			put('V', 31);
			put('W', 32);
			put('X', 33);
			put('Y', 34);
			put('Z', 35);
		}};
		
		String countryCodeAsNumber = countryCodeMap.get(countryCode.charAt(0)) + "" + countryCodeMap.get(countryCode.charAt(1));
		String ibanStrWithNumericCountryCode = blzStr + kontoNrStr + countryCodeAsNumber + pruefZiffer; 
		
		/*
		Schritt 3
		Es muss der Wert PZ1 über Modulo 97 der umgestellte IBAN berechnet werden.
		PZ1 = BBBBBBBBKKKKKKKKKK131400 mod 97
		Hinweis:
		Es gilt:
		1: wenn a mod n= x und b mod n= y , dann (a*b) mod n= x*y
		2: wenn z =a*b+c , dann z mod n=(( a mod n)*(b mod n)+(c mod n))mod n
		*/
		
		int pz1 = (int)(Long.valueOf(ibanStrWithNumericCountryCode) % 97);
		
		/*
		Schritt 4
		Das Ergebnis PZ1 aus Schritt 3 wird von dem Wert 98 abgezogen.
		PZ2 = 98 – PZ1
		*/
		
		int pz2 = 98 - pz1;
		
		/*
		Schritt 5
		Wenn das Ergebnis PZ2 aus Schritt 4 kleiner 10 ist, so wird eine führende “0” hinzugefügt, damit die
		Prüfziffer wieder 2-stellig wird.
		wenn PZ2 < 10
		dann PZ = “0” + PZ2
		sonst PZ = PZ2
		*/
		
		String pzStr = (pz2 < 10 ? "0" : "") + pz2;
		
		/*
		Beispiel Rechnung
		Bankleitzahl: 50010517
		Kontonummer: 532013018
		IBAN: DEPP50010517532013018
		Schritt 1 500105170532013018DE00
		Schritt 2 500105170532013018131400
		Schritt 3 500105170532013018131400 mod 97 = 51
		Schritt 4 PZ1 = 98 – 51
		PZ1 = 47
		Schritt 5 PZ1 nicht keiner 10, daher ist die Prüfziffer 47.
		Die korrekte IBAN wäre somit DE47500105170532013018. LLPPBBBBBBBBKKKKKKKKKK
		 */
		
		String iban = countryCode + pzStr + blzStr + kontoNrStr;
		System.out.println("Ihre IBAN ist: " + iban);
		
		// zum Abschluss noch Scanner schließen
		keyboardInput.close();
	}
}
