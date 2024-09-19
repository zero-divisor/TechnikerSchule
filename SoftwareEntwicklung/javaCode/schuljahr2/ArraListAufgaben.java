package schuljahr2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ArraListAufgaben {

	public static void main(String[] args) {
		/*
		Aufgabe 1:
		Erstellen Sie ein Programm mit einer ArrayList vom Typ Integer
		*/
		System.out.println("\n1: Erstellen Sie ein Programm mit einer ArrayList vom Typ Integer");
		System.out.println("----------------------------------------");
		
		ArrayList<Integer> myInts = new ArrayList<>();
		/*
		a) F�gen Sie die Zahlen 1, 2, 3, 4 und 5 hinzu.
		*/
		for(int i=1; i<=5; i++) {
			myInts.add(i);
		}
		/*
		b) L�schen Sie die vorletzte Zahl heraus.
		*/
		myInts.remove(myInts.size()-2);
		/*
		c) F�gen Sie am Index 2, die Zahl 10 ein.
		*/
		myInts.add(2, 10);
		/*
		d) Ersetzen Sie die erste Zahl durch die Zahl 7.
		*/
		myInts.set(0, 7);
		/*
		e) Geben Sie die L�nge der ArrayList aus.
		*/
		System.out.println("L�nge: " + myInts.size());
		/*
		f) Geben Sie die Elemente der ArrayList mit einer for-each-Schleife aus.
		 */
		for(int i : myInts) {
			System.out.println(i);
		}
		
		/*
		Aufgabe 2: Benutzerverwaltung
		Erstellen Sie ein Programm zur Benutzerverwaltung. Verwaltet wird �ber eine immer wiederkehrend
		angezeigtes Men� mit folgenden Auswahlm�glichkeiten:
		1. Nutzer hinzuf�gen (Eingabe des Nutzernamens)
		2. Nutzername anzeigen (Eingabe der Nutzernummer)
		3. Liste mit Nutzernummern und Nutzername anzeigen sowie die Anzahl der Nutzer
		4. Pr�fen ob ein Nutzer vorhanden ist (Eingabe Nutzername)
		5. Nutzer l�schen (Eingabe der Nutzernummer)
		6. Programm beenden (System.exit(0);)
		 */
		
		System.out.println("\n2: Benutzerverwaltung");
		System.out.println("----------------------------------------");
		
		Scanner keyBoardInput = new Scanner(System.in);
		ArrayList<String> users = new ArrayList<>();
		
		boolean running = true;
		while(running) {
			System.out.println("\nW�hlen sie eine Option:\n"
					+ "	1. Nutzer hinzuf�gen (Eingabe des Nutzernamens)\n"
					+ "	2. Nutzername anzeigen (Eingabe der Nutzernummer)\n"
					+ "	3. Liste mit Nutzernummern und Nutzername anzeigen sowie die Anzahl der Nutzer\n"
					+ "	4. Pr�fen ob ein Nutzer vorhanden ist (Eingabe Nutzername)\n"
					+ "	5. Nutzer l�schen (Eingabe der Nutzernummer)\n"
					+ "	6. Programm beenden (System.exit(0);)");
			
			int option = keyBoardInput.nextInt();
			switch(option) {
				case 1:
					System.out.println("Nutzer hinzuf�gen (Eingabe des Nutzernamens)");
					users.add(keyBoardInput.next());
					break;
				case 2:
					System.out.println("Nutzername anzeigen (Eingabe der Nutzernummer)");
					System.out.println(users.get(keyBoardInput.nextInt()));
					break;
				case 3:
					System.out.println("Liste mit Nutzernummern und Nutzername anzeigen sowie die Anzahl der Nutzer");
					for(String name : users) System.out.println(name);
					System.out.println("Anzahl Nutzer: " + users.size());
					break;
				case 4:
					System.out.println("Pr�fen ob ein Nutzer vorhanden ist (Eingabe Nutzername)");
					System.out.println(users.contains(keyBoardInput.next()));
					break;
				case 5:
					System.out.println("Nutzer l�schen (Eingabe der Nutzernummer)");
					users.remove(keyBoardInput.nextInt());
					break;
				default:
					System.out.println("Exit");
					running = false;
					break;
			}
		}
		
		/*
		Aufgabe 3: Anzahl Graustufen in einer Grafik ermitteln
		Erstellen Sie ein Programm, das den Benutzer mit Hilfe einer Endlosschleife die Farbwerte der einzelnen
		Pixel einer monochromen Grafik (erlaubte Grauwerte 0-255) eingeben l�sst. Nach jeder Eingabe wird die
		eingegebene Zahl einer ArrayList farben hinzugef�gt, falls die Farbe in der ArrayList noch nicht existiert.
		Au�erdem wird nach jeder Eingabe die Anzahl der Farben in der ArrayList ausgegeben. Das Programm
		meldet einen Fehler wenn eine ung�ltige Farbeingabe erfolgt und beendet sich daraufhin.
		Beispiel:
		Eingabe: 4
		Verschiedene Farben: 1
		Eingabe: 18
		Verschiedene Farben: 2
		Eingabe: 4
		Verschiedene Farben: 2
		Eingabe: 225
		Verschiedene Farben: 3
		Eingabe: 4
		Verschiedene Farben: 3
		 */
		
		System.out.println("\n3: Anzahl Graustufen in einer Grafik ermitteln");
		System.out.println("----------------------------------------");
		
		ArrayList<Integer> colors = new ArrayList<>();
		running = true;
		while(running) {
			try {
				System.out.println("Eingabe:");
				int colorVal = keyBoardInput.nextInt();
				if(!colors.contains(colorVal)) {
					colors.add(colorVal);
				}
				System.out.println("Verschiedene Farben: " + colors.size());
			}catch(InputMismatchException e) {
				keyBoardInput.nextLine();
				running = false;
			}
		}

		/*
		Zusatzaufgabe:
		Simulieren Sie die Eingabe mit einem Zufallsgenerator f�r die einzelnen Pixel nach vom Benutzer erfolgter
		Eingabe der Pixelbreite und Pixelh�he der Grafik.
		 */
		
		System.out.println("\nZusatzaufgabe:");
		System.out.println("----------------------------------------");
		
		colors.clear();
		Random ran = new Random();
		System.out.println("Breite:");
		int width = keyBoardInput.nextInt();
		System.out.println("H�he:");
		int height = keyBoardInput.nextInt();
		
		for(int i=0; i<width*height; i++) {
			int colorVal = ran.nextInt(255);
			if(!colors.contains(colorVal)) {
				colors.add(colorVal);
			}
			System.out.println("Farbwert:            " + colorVal);
			System.out.println("Verschiedene Farben: " + colors.size());
		}
		
		keyBoardInput.close();
	}

}
