package schuljahr1;

import java.nio.charset.StandardCharsets;

public class Schleifen {
	public static void main(String[] args) {
		/*
		Aufgabe 1: Zahlen aufzählen
		Schreiben Sie ein Programm, das die ganzen Zahlen von 1 bis 100 am Bildschirm ausgibt.
		*/
		System.out.println("\n1: Zahlen aufzählen");
		System.out.println("----------------------------------------");
		
		for(int i=1; i<=100; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		/*
		Aufgabe 2: Muster erstellen
		Schreiben Sie ein Programm mit einer Schleife, welches folgende Bildschirmausgabe erzeugt:
		xxxxxxxxxx
		xxxxxxxxxx
		xxxxxxxxxx
		xxxxxxxxxx
		xxxxxxxxxx
		xxxxxxxxxx
		*/
		
		System.out.println("\n1: Muster erstellen");
		System.out.println("----------------------------------------");
		
		for(int i=1; i<=60; i++) {
			System.out.print("x");
			if(i%10 == 0) {
				System.out.println();
			}
		}
		
		/*
		Aufgabe 3: Handy PIN
		a) Bei einem Handy lautet der gespeicherte PIN-Code 2884. Erstellen Sie ein Programm, das den
		Benutzer des Handys auffordert beim Einschalten die PIN einzugeben und diese anschließend auf
		Richtigkeit überprüft. Wird die PIN falsch eingegeben, so soll die Eingabe wiederholt werden. Wird
		die PIN 3x falsch eingegeben, endet das Programm ohne Fehlermeldung.
		
		b) Fügen Sie Ihrem Programm aus Aufgabe a) die Ausgabe einer Fehlermeldung hinzu, falls die PIN
		3x falsch eingegeben wurde.
		
		c) Die PUK (Personal Unblocking Key) des Handys lautet 341256. Fügen Sie Ihrem Programm aus
		Aufgabe b) nun die Abfrage der PUK hinzu, falls die PIN 3x fehlerhaft eingegeben wurde. Die PUK
		darf 10x falsch eingegeben werden, bevor das Programm mit der Fehlermeldung „PUK 10x falsch
		eingegeben. Bitte kontaktieren Sie den Service.“ endet.
		 */
		
		/*
		Aufgabe 4: Geldanlage
		Schreiben Sie ein Programm, das den Benutzer fragt, wie viel Euro er auf einem neu eröffneten Konto
		anlegen möchte. Außerdem soll der Benutzer gefragt werden, wie viele Jahre er es anlegen möchte.
		Berechnen Sie nun aus Betrag und Dauer der Anlage mit einem Zinssatz von 0,25% pro Jahr, das
		Guthaben am Ende der Anlage.
		*/
		
		/*
		Zusatzaufgabe:
		Berechnen Sie wie hoch Ihr Guthaben jetzt wäre, wenn sie das Geld im Jahr 0 angelegt hätten.
		*/
		
		/*
		Aufgabe 5: Eingabeüberprüfung
		Schreiben Sie ein Programm, das den Benutzer solange zur Eingabe einer Zahl auffordert, bis dieser eine
		Zahl größer 20 eingibt. Informieren Sie sich im Internet über die „do-while“ Schleife und verwenden Sie
		diese in Ihrem Programm. Welchen Vorteil bringt die „do-while“ Schleife?
		*/
		
		/*
		Aufgabe 6: Gerade oder ungerade?
		Erweitern Sie Ihr Programm aus Aufgabe 1, indem Sie nur die Ausgabe aller geraden Zahlen von 1 bis 100
		am Bildschirm ausgeben. Hinweis: Um festzustellen ob eine Zahl eine gerade Zahl ist, benötigen Sie den
		Modulo-Operator „%“.
		*/
		
		System.out.println("\n6: Gerade oder ungerade?");
		System.out.println("----------------------------------------");
		
		for(int i=1; i<=100; i++) {
			System.out.print(i%2 == 0 ? (i + " ") : "");
		}
		System.out.println();
		
		/*
		Aufgabe 7: ASCII-Tabelle ausgeben
		a) Schreiben Sie ein Programm, das alle Zeichen der ASCII-Tabelle mit den zugehörigen Dezimal-
		und Hexadezimalwerten am Bildschirm ausgibt.
		*/
		
		System.out.println("\n7: ASCII-Tabelle ausgeben a)");
		System.out.println("----------------------------------------");
		
		for(int i=0; i<256; i++) {
			char c = (char) i;
			if(c == '\n') {
				System.out.printf("%3d %2x %s%n", i, i, "\\n");
				continue;
			}
			if(c == '\r') {
				System.out.printf("%3d %2x %s%n", i, i, "\\r");
				continue;
			}
			System.out.printf("%3d %2x %c%n", i, i, c);
			
		}
		
		/*
		b) Erweitern Sie Ihr Programm aus Aufgabe a) indem in einer Zeile mehrere Zeichen mit ihren
		zugehörigen Werten ausgegeben werden. Dadurch entsteht eine Tabelle am Bildschirm mit
		mehreren Spalten. Wählen Sie die Anzahl der Spalten so, dass die Bildschirmausgabe so weit
		benutzerfreundlich wie möglich aussieht.
		*/
		
		System.out.println("\n7: ASCII-Tabelle ausgeben b)");
		System.out.println("----------------------------------------");
		
		for(int i=0; i<256; i++) {
			char c = (char) i;
			
			if(c == '\n') {
				System.out.printf("%3d %2x %s%n", i, i, "\\n");
			}else if(c == '\r') {
				System.out.printf("%3d %2x %s%n", i, i, "\\r");
			}else {
				System.out.printf("%3d %2x %c%n", i, i, c);
			}	
		}
		
		/*
		Aufgabe 8: Noch ein Muster
		Schreiben Sie ein Programm mit Schleifen, welches folgende Bildschirmausgabe erzeugt:
		x
		xx
		xxx
		xxxx
		xxxxx
		xxxxxx
		xxxxxxx
		xxxxxxxx
		*/
		
		/*
		Aufgabe 9: Quadratwurzel
		Schreiben Sie ein Programm, das die Quadratwurzel einer beliebigen Fließkommazahl bis auf zwei Stellen
		hinter dem Komma genau berechnet. Der Benutzer soll die Fließkommazahl eingeben und das Ergebnis
		am Bildschirm ausgegeben werden.
		Zusatzaufgabe: Erweitern Sie Ihr Programm, indem Sie nun anstatt der Quadratwurzel die dritte Wurzel
		aus der Eingabe berechnen.
		 */
	}
}
