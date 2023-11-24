package schuljahr1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class IfElseAufgaben {

	public static void main(String[] args) {
		Scanner keyboardInput = new Scanner(System.in);
		/*
		Aufgabe 1: Handy PIN-Code
		Bei einem Handy lautet der PIN-Code 2884.
		Schreiben Sie ein Programm, das den Benutzer eines Handys auffordert beim Einschalten die PIN
		einzugeben. Überprüfen Sie die PIN in Ihrem Programm und geben Sie eine Rückmeldung an den
		Benutzer aus, ob die PIN richtig eingegeben wurde.
		 */

		System.out.println("\n1: Handy PIN-Code");
		System.out.println("----------------------------------------");

		System.out.println("Bitte gib deinen Pin ein:");
		int pin = keyboardInput.nextInt();
		
		System.out.println(pin == 2884 ? "Pin korrekt" : "Pin falsch");
		
		/*
		Aufgabe 2: Passworteingabe
		Bei einem Computer lautet das Passwort: zmQ15!3Z
		Schreiben Sie ein Programm, das den Benutzer auffordert das Passwort einzugeben. Überprüfen Sie das
		Passwort in Ihrem Programm und geben Sie eine Rückmeldung an den Benutzer aus, ob das Passwort
		richtig eingegeben wurde.
		 */

		System.out.println("\n2: Passworteingabe");
		System.out.println("----------------------------------------");

		System.out.println("Bitte gib deinen Passwort ein:");
		String pw = keyboardInput.nextLine();

		System.out.println(pw.equals("zmQ15!3Z") ? "Passwort korrekt" : "Passwort falsch");

		/*
		Aufgabe 3: Längenbegrenzung der Eingabe
		Schreiben Sie ein Programm das einen Text einliest und anschließend am Bildschirm ausgibt wenn der
		Text zwischen 8 und 20 Zeichen lang ist. Ist der Text weniger als 8 oder mehr als 20 Zeichen lang soll eine
		Fehlermeldung ausgegeben werden.
		 */

		System.out.println("\n3: Längenbegrenzung der Eingabe");
		System.out.println("----------------------------------------");

		System.out.println("Bitte gib einen String ein:");
		String str = keyboardInput.nextLine();
		
		if(str.length() < 8 || str.length() > 20) {
			System.out.println("Out of bounds");
		}else {
			System.out.println(str);
		}

		/*
		Aufgabe 4: Kfz-Versicherungsbeitrag berechnen
		Die KFZ-Versicherung wird ausgehend von einem Grundbetrag für jedes Fahrzeug in Abhängigkeit vom
		Alter des Fahrers, der jährlichen Fahrleistung in km und ob das Fahrzeug in einer Garage abgestellt wird,
		berechnet.
		Schreiben Sie ein Programm bei dem der zu zahlende Versicherungsbetrag nach Eingabe des
		Grundbetrags und weiterer Angaben (Alter, jährliche Fahrleistung in km, Garagenfahrzeug) berechnet
		wird.
		Dabei soll gelten:

		 * Bei Fahrern bis 25 Jahren erhöht sich der Gesamtbetrag um 40% des Grundbetrags, bei Fahrern
		  über 25 Jahren verringert sich der Gesamtbetrag um 10% des Grundbetrags.
		 * Bei einer Kilometerleistung von mehr als 15000 km im Jahr (Vielfahrer) erhöht sich der
		  Gesamtbetrag um 20% des Grundbetrags, ansonsten verringert er sich um 10% des
		  Grundbetrags.
		 * Wird das Fahrzeug in einer Garage abgestellt verringert sich der Gesamtbetrag um 5% des
		  Grundbetrags, ansonsten erhöht er sich um 5% des Grundbetrags.
		 */
		
		System.out.println("\n4: Kfz-Versicherungsbeitrag berechnen");
		System.out.println("----------------------------------------");
		
		System.out.println("Bitte gib deien Grundbetrag ein:");
		double grundBetrag = keyboardInput.nextDouble();
		System.out.println("Bitte gib dein Alter ein:");
		int age = keyboardInput.nextInt();
		System.out.println("Bitte gib deine jährliche Fahrleistung in km ein:");
		int km = keyboardInput.nextInt();
		System.out.println("Ist dein Fahrzeug ein Garagenfahrzeug?");
		boolean garage = keyboardInput.nextBoolean();
		
		double ageMod = 0;
		double kmMod = 0;
		double garageMod = 0;
		
		if(age <= 25) {
			ageMod = grundBetrag * 0.1;
		}
		
		if(km > 15000) {
			kmMod = grundBetrag * 0.2;
		}else {
			kmMod = -grundBetrag * 0.1;
		}
		
		if(garage) {
			garageMod = -grundBetrag * 0.05;
		}else {
			garageMod = grundBetrag * 0.05;
		}

		System.out.println("Grundbetrag: " + grundBetrag);
		System.out.println("Alter Mod.:  " + ageMod);
		System.out.println("Km Mod.:     " + kmMod);
		System.out.println("Garage Mod.: " + garageMod);
		System.out.println("----------------------------------------");
		System.out.println("Gesamt: " + (grundBetrag + ageMod + kmMod + garageMod));
		
		/*
		Aufgabe 5: Taschenrechner
		Erstellen Sie ein Programm, das

		 * zuerst eine Zahl einliest,
		 * als nächstes ein Zeichen für die Art der Rechenoperation (+, -, *, /, %) einliest,
		 * als letztes die zweite Zahl einliest.

		Geben Sie das Ergebnis der Rechnung am Bildschirm aus.
		 */

		System.out.println("\n5: Taschenrechner");
		System.out.println("----------------------------------------");
		
		System.out.println("Bitte gib eine Zahl ein:");
		double operand1 = keyboardInput.nextDouble();
		
		System.out.println("Bitte gib eine Rechenoperation ein (+, -, *, / oder %):");
		String operator = keyboardInput.next();
		
		System.out.println("Bitte gib eine Zahl ein:");
		double operand2 = keyboardInput.nextDouble();
		
		if(operator.equals("+")) {
			System.out.println(operand1 + " + " + operand2 + " = " + (operand1 + operand2));
		}else if(operator.equals("-")) {
			System.out.println(operand1 + " - " + operand2 + " = " + (operand1 - operand2));
		}else if(operator.equals("*")) {
			System.out.println(operand1 + " * " + operand2 + " = " + (operand1 * operand2));
		}else if(operator.equals("/")) {
			/*
			Zusatzaufgabe zur Aufgabe 5:
			b)Überprüfen Sie, dass der Benutzer nicht durch die Zahl 0 teilt.
			 */
			if(operand2 == 0) {
				System.out.println("Kann nicht durch 0 teilen!");
			}else {
				System.out.println(operand1 + " / " + operand2 + " = " + (operand1 / operand2));
			}
		}else if(operator.equals("%")) {
			System.out.println(operand1 + " % " + operand2 + " = " + (operand1 % operand2));
		}else {
			/*
			Zusatzaufgabe zur Aufgabe 5:
			a)Überprüfen Sie, ob der Benutzer eine gültige Rechenoperation eingegeben hat.
			 */
			System.out.println("Ungültige Rechenoperation!");
		}

		/*
		Aufgabe 6: Schaltjahre
		In unserem Kalender sind zum Ausgleich der Jahreslänge in regelmäßigen Abständen Schaltjahre
		eingebaut. Ein astronomisches Jahr hat dabei 365,24219 Kalendertage. Zur exakten Festlegung der
		Schaltjahre dienen folgende Regeln:

		 * Ist die Jahreszahl durch 4 teilbar, so ist das Jahr ein Schaltjahr. Diese Regel hat allerdings eine
		Ausnahme:
		 * Ist die Jahreszahl durch 100 teilbar, so ist das Jahr kein Schaltjahr. Diese Regel hat allerdings
		wiederum eine Ausnahme:
		 * Ist die Jahreszahl durch 400 teilbar, so ist das Jahr doch ein Schaltjahr.

		Erstellen Sie ein Programm, das berechnet, ob eine vom Benutzer eingegebene Jahreszahl ein Schaltjahr
		ist oder nicht.
		 */
		
		System.out.println("\n6: Schaltjahre");
		System.out.println("----------------------------------------");
		
		System.out.println("Bitte gib ein Jahr ein:");
		int jahr = keyboardInput.nextInt();
		
		if(jahr % 400 == 0) {
			System.out.println(jahr + " ist ein Schaltjahr");
		}else if(jahr % 100 == 0) {
			System.out.println(jahr + " ist kein Schaltjahr");
		}else if(jahr % 4 == 0) {
			System.out.println(jahr + " ist ein Schaltjahr");
		}else {
			System.out.println(jahr + " ist kein Schaltjahr");
		}
		
		/*
		Aufgabe 7: Quadratische Gleichungen
		Entwickeln Sie ein Programm zur Lösung einer quadratischen Gleichung der Form
		a*x^2 + b*x + c = 0 mit Hilfe der Mitternachtsformel.
		
		Überlegen Sie zuerst wie viele Lösungen es abhängig von der Diskriminante gibt.
		Der Benutzer soll dabei a , b und c eingeben und x1 und x2 soll berechnet und ausgegeben
		werden.
		
		Anmerkung: Die Klasse Math stellt eine Methode zum Berechnen der Quadratwurzel einer Zahl zur
		Verfügung. Lesen Sie zu Math die Dokumentation.
		 */
		
		System.out.println("\n7: Quadratische Gleichungen");
		System.out.println("----------------------------------------");
		
		System.out.println("Bitte gib die Koeffizienten einer quadratischen Gleichung (a*x^2 + b*x + c) ein:");
		double a = keyboardInput.nextDouble();
		double b = keyboardInput.nextDouble();
		double c = keyboardInput.nextDouble();
		
		String polynomStrRep = a + "*x^2 + " + b + "*x + " + c;
		
		double diskriminante = Math.pow(b, 2) - 4*a*c;
		
		if(diskriminante == 0) {
			System.out.println(polynomStrRep + " hat eine Nullstelle");
			System.out.println("Lösung: " + (-b/(2*a)));
		}else if(diskriminante < 0) {
			System.out.println(polynomStrRep + " hat keine Nullstellen");
		}else {
			System.out.println(polynomStrRep + " hat 2 Nullstellen");
			System.out.println("Lösung1: " + (-b + Math.sqrt(diskriminante))/(2*a));
			System.out.println("Lösung1: " + (-b - Math.sqrt(diskriminante))/(2*a));
		}

		/*
		Aufgabe 8: Drei Zahlen sortieren
		Entwickeln Sie ein Programm, welches drei Zahlen einliest und mithilfe geschickter Verzweigungen
		aufsteigend sortiert auf dem Bildschirm ausgibt.
		Anmerkung: Die kürzeste Lösung benötigt nur 3 if-Verzweigungen.
		 */
		System.out.println("\n8: Drei Zahlen sortieren");
		System.out.println("----------------------------------------");

		System.out.println("Bitte gib drei zahlen ein:");
		int zahl1 = keyboardInput.nextInt();
		int zahl2 = keyboardInput.nextInt();
		int zahl3 = keyboardInput.nextInt();

		int first, second, third;

		if(zahl1 < zahl2) {
			first = zahl1;
			second = zahl2;
		}else {
			first = zahl2;
			second = zahl1;
		}

		if(zahl3 < first) {
			third = second;
			second = first;
			first = zahl3;
		}else if(zahl3 > second) {
			third = zahl3;
		}else {
			third = second;
			second = zahl3;
		}

		System.out.println(zahl1 + ", " + zahl2 + ", " + zahl3 + " -> " + first + ", " + second + ", " + third);

		/*
		Aufgabe 9: Bluttransfusion
		Bei einer Bluttransfusion müssen folgende Bedingungen beachtet werden (vgl. Tabelle)
		
		Empfänger | Spender
		          +----+----+----+----+----+----+-----+-----
		          | O- | O+ | B- | B+ | A- | A+ | AB- | AB+
		----------+----+----+----+----+----+----+-----+-----
		AB+       | x  | x  | x  | x  | x  | x  | x   | x   
		AB-       | x  |    | x  |    | x  |    | x   |
		A+        | x  | x  |    |    | x  | x  |     |
		A-        | x  |    |    |    | x  |    |     |
		B+        | x  | x  | x  | x  |    |    |     |
		B-        | x  |    | x  |    |    |    |     |
		O+        | x  | x  |    |    |    |    |     |
		O-        | x  |    |    |    |    |    |     |
		
		Erstellen Sie ein Java-Programm, das nach Eingabe der Spender-und Empfänger-Blutgruppe auf dem
		Bildschirm die Information "verträglich" oder "nicht verträglich" ausgibt.
		*/
		
		System.out.println("\n9: Bluttransfusion");
		System.out.println("----------------------------------------");
		
		String[] rows = {"AB+", "AB-", "A+", "A-", "B+", "B-", "O+", "O-"};
		String[] cols = {"O-", "O+", "B-", "B+", "A-", "A+", "AB-", "AB+"};
		ArrayList<String> spenderList = new ArrayList<String>(Arrays.asList(cols));
		ArrayList<String> empfaengerList = new ArrayList<String>(Arrays.asList(rows));
		
		
		boolean[][] truthTable =
		{//       O-     O+     B-     B+     A-     A+     AB-    AB+
		/*AB+*/	{true,  true,  true,  true,  true,  true,  true,  true },
		/*AB-*/	{true,  false, true,  false, true,  false, true,  false},
		/*A+*/	{true,  true,  false, false, true,  true,  false, false},
		/*A-*/	{true,  false, false, false, true,  false, false, false},
		/*B+*/	{true,  true,  true,  true,  false, false, false, false},
		/*B-*/	{true,  false, true,  false, false, false, false, false},
		/*O+*/	{true,  true,  false, false, false, false, false, false},
		/*O-*/	{true,  false, false, false, false, false, false, false}
		};
		
		System.out.println("Bitte gib die Blutgruppe des Spenders ein:");
		String spenderBG = keyboardInput.nextLine();
		
		System.out.println("Bitte gib die Blutgruppe des Empfängers ein:");
		String empfaengerBG = keyboardInput.nextLine();
		
		boolean vertraeglich = truthTable[empfaengerList.indexOf(empfaengerBG)][spenderList.indexOf(spenderBG)];
		
		System.out.println(vertraeglich ? "verträglich" : "nicht verträglich" );
		
		
		// zum Abschluss noch Scanner schließen
		keyboardInput.close();
	}
}
