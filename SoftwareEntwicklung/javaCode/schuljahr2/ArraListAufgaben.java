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
		a) Fügen Sie die Zahlen 1, 2, 3, 4 und 5 hinzu.
		*/
		for(int i=1; i<=5; i++) {
			myInts.add(i);
		}
		/*
		b) Löschen Sie die vorletzte Zahl heraus.
		*/
		myInts.remove(myInts.size()-2);
		/*
		c) Fügen Sie am Index 2, die Zahl 10 ein.
		*/
		myInts.add(2, 10);
		/*
		d) Ersetzen Sie die erste Zahl durch die Zahl 7.
		*/
		myInts.set(0, 7);
		/*
		e) Geben Sie die Länge der ArrayList aus.
		*/
		System.out.println("Länge: " + myInts.size());
		/*
		f) Geben Sie die Elemente der ArrayList mit einer for-each-Schleife aus.
		 */
		for(int i : myInts) {
			System.out.println(i);
		}
		
		/*
		Aufgabe 2: Benutzerverwaltung
		Erstellen Sie ein Programm zur Benutzerverwaltung. Verwaltet wird über eine immer wiederkehrend
		angezeigtes Menü mit folgenden Auswahlmöglichkeiten:
		1. Nutzer hinzufügen (Eingabe des Nutzernamens)
		2. Nutzername anzeigen (Eingabe der Nutzernummer)
		3. Liste mit Nutzernummern und Nutzername anzeigen sowie die Anzahl der Nutzer
		4. Prüfen ob ein Nutzer vorhanden ist (Eingabe Nutzername)
		5. Nutzer löschen (Eingabe der Nutzernummer)
		6. Programm beenden (System.exit(0);)
		 */
		
		System.out.println("\n2: Benutzerverwaltung");
		System.out.println("----------------------------------------");
		
		Scanner keyBoardInput = new Scanner(System.in);
		ArrayList<String> users = new ArrayList<>();
		
		boolean running = true;
		while(running) {
			System.out.println("\nWählen sie eine Option:\n"
					+ "	1. Nutzer hinzufügen (Eingabe des Nutzernamens)\n"
					+ "	2. Nutzername anzeigen (Eingabe der Nutzernummer)\n"
					+ "	3. Liste mit Nutzernummern und Nutzername anzeigen sowie die Anzahl der Nutzer\n"
					+ "	4. Prüfen ob ein Nutzer vorhanden ist (Eingabe Nutzername)\n"
					+ "	5. Nutzer löschen (Eingabe der Nutzernummer)\n"
					+ "	6. Programm beenden (System.exit(0);)");
			
			int option = keyBoardInput.nextInt();
			switch(option) {
				case 1:
					System.out.println("Nutzer hinzufügen (Eingabe des Nutzernamens)");
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
					System.out.println("Prüfen ob ein Nutzer vorhanden ist (Eingabe Nutzername)");
					System.out.println(users.contains(keyBoardInput.next()));
					break;
				case 5:
					System.out.println("Nutzer löschen (Eingabe der Nutzernummer)");
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
		Pixel einer monochromen Grafik (erlaubte Grauwerte 0-255) eingeben lässt. Nach jeder Eingabe wird die
		eingegebene Zahl einer ArrayList farben hinzugefügt, falls die Farbe in der ArrayList noch nicht existiert.
		Außerdem wird nach jeder Eingabe die Anzahl der Farben in der ArrayList ausgegeben. Das Programm
		meldet einen Fehler wenn eine ungültige Farbeingabe erfolgt und beendet sich daraufhin.
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
		Simulieren Sie die Eingabe mit einem Zufallsgenerator für die einzelnen Pixel nach vom Benutzer erfolgter
		Eingabe der Pixelbreite und Pixelhöhe der Grafik.
		 */
		
		System.out.println("\nZusatzaufgabe:");
		System.out.println("----------------------------------------");
		
		colors.clear();
		Random ran = new Random();
		System.out.println("Breite:");
		int width = keyBoardInput.nextInt();
		System.out.println("Höhe:");
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
