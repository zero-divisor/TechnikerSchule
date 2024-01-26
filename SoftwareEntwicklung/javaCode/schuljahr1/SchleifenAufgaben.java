package schuljahr1;

public class SchleifenAufgaben {
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
		
		System.out.println("\n4: Geldanlage");
		System.out.println("----------------------------------------");
		
		double initialMoney = 1000;
		int years = 5;
		
		for(int i=0; i<years; i++) {
			initialMoney = initialMoney*1.25;
		}
		System.out.println("Anlage = " + initialMoney + "€");
		
		/*
		Zusatzaufgabe:
		Berechnen Sie wie hoch Ihr Guthaben jetzt wäre, wenn sie das Geld im Jahr 0 angelegt hätten.
		*/
		
		System.out.println("\n4: Zusatzaufgabe Geldanlage");
		System.out.println("----------------------------------------");
		
		initialMoney = 1000;
		years = 2024;
		
		for(int i=0; i<years; i++) {
			initialMoney = initialMoney*1.25;
		}
		System.out.println("Anlage ab Jahr 0 = " + initialMoney + "€");
		
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
			if(c == '\b') {
				System.out.printf("%3d %2x %2s%n", i, i, "\\b");
				continue;
			}
			if(c == '\t') {
				System.out.printf("%3d %2x %2s%n", i, i, "\\t");
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
		
		int line_nr = 22;
		for(int i=0; i<line_nr; i++) {
			
			for(int j=0; j<=256/line_nr; j++) {
				if(i+j*line_nr >= 256) break;
				char c = (char) (i+j*line_nr);
				
				if(c == '\n') {
					System.out.printf("%3d %2x %2s \t", i+j*line_nr, i+j*line_nr, "\\n");
				}else if(c == '\r') {
					System.out.printf("%3d %2x %2s \t", i+j*line_nr, i+j*line_nr, "\\r");
				}else if(c == '\b') {
					System.out.printf("%3d %2x %2s \t", i+j*line_nr, i+j*line_nr, "\\b");
				}else if(c == '\t') {
					System.out.printf("%3d %2x %2s \t", i+j*line_nr, i+j*line_nr, "\\t");
				}else {
					System.out.printf("%3d %2x %2c \t", i+j*line_nr, i+j*line_nr, c);
				}
			}
			System.out.println();
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
		
		System.out.println("\n8: Noch ein Muster");
		System.out.println("----------------------------------------");
		
		int maxWidht = 8;
		
		for(int i=1; i<=maxWidht; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("x");
			}
			System.out.println();
		}
		
		/*
		Aufgabe 9: Quadratwurzel
		Schreiben Sie ein Programm, das die Quadratwurzel einer beliebigen Fließkommazahl bis auf zwei Stellen
		hinter dem Komma genau berechnet. Der Benutzer soll die Fließkommazahl eingeben und das Ergebnis
		am Bildschirm ausgegeben werden.
		Zusatzaufgabe: Erweitern Sie Ihr Programm, indem Sie nun anstatt der Quadratwurzel die dritte Wurzel
		aus der Eingabe berechnen.
		 */
		
		System.out.println("\n9: Quadratwurzel");
		System.out.println("----------------------------------------");
		
		double inputNumber = 5.12;
		double root = 0.0;
		
		while(root*root < inputNumber) {
			root += 0.01;
		}
		                                          // -0.01 für abgerundetes ergebnis
		System.out.printf("sqrt(%.2f) = %.2f", inputNumber, root-0.01);
		System.out.println();
		
		/*
		Aufgabe 10: Noch ein Muster
		Schreiben Sie ein Programm mit for-Schleifen, welches folgende Bildschirmausgabe erzeugt:
		       x
		      xx
		     xxx
		    xxxx
		   xxxxx
		  xxxxxx
		 xxxxxxx
		xxxxxxxx
		*/
		
		System.out.println("\n10: Noch ein Muster");
		System.out.println("----------------------------------------");
		
		for(int i=7; i>=0; i--) {
			String line = "";
			for(int j=0; j<8; j++) {
				line += j<i ? " " : "x";
			}
			System.out.println(line);
		}
		
		/*
		Aufgabe 11: Tannenbaum
		Schreiben Sie ein Programm mit for-Schleifen, welches folgende Bildschirmausgabe erzeugt:
		       x
		      xxx
		     xxxxx
		    xxxxxxx
		   xxxxxxxxx
		  xxxxxxxxxxx
		 xxxxxxxxxxxxx
		xxxxxxxxxxxxxxx
		 */
		
		System.out.println("\n11: Tannenbaum");
		System.out.println("----------------------------------------");
		
		int numberOfLines = 10;
		int maxWidth = 2*numberOfLines-1;
		
		for(int i=0; i<numberOfLines; i++) {
			for(int j=0; j<maxWidth; j++) {
				int inset = (maxWidth-2*i)/2;
				System.out.print(j>=inset && j<maxWidth-inset ? "x" : " ");
			}
			System.out.println();
		}
	}
}
