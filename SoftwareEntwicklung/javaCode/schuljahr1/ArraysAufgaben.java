package schuljahr1;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysAufgaben {

	public static void main(String[] args) {
		/*
		Aufgabe 1: Messwerte eingeben und ausgeben
		Schreiben Sie ein Programm, das die Temperaturwerte für eine Woche (also 7 Stück) vom Benutzer mit Hilfe
		einer Schleife einliest. Speichern Sie die Temperaturwerte in einem Array. Geben Sie die Temperaturwerte
		anschließend (um die Eingabe zu kontrollieren) mit Hilfe einer Schleife wieder aus.
		*/
		
		System.out.println("\n1: Messwerte eingeben und ausgeben");
		System.out.println("----------------------------------------");
		
		Scanner sc = new Scanner(System.in);
		int[] values = new int[7];
		
		System.out.println("Gib 7 integers ein:");
		
		for(int i=0; i<values.length; i++) {
			values[i] = sc.nextInt();
		}
		
		for(int out : values) System.out.println(out);
		
		/*
		Aufgabe 2: Beliebige Anzahl an Messwerten
		Ein Nachteil des Programms aus Aufgabe 1 ist, dass es nur 7 Messwerte speichern kann. Erweitern Sie nun
		Ihr Programm aus Aufgabe 1: Es soll zusätzlich beim Start des Programms vom Benutzer die Anzahl der zu
		erfassenden Messwerte eingegeben werden können.
		*/
		
		System.out.println("\n2: Beliebige Anzahl an Messwerten");
		System.out.println("----------------------------------------");
		
		System.out.println("Gib die anzahl der Werte ein:");
		int length = sc.nextInt();
		int[] values2 = new int[length];
		
		System.out.println("Gib " + values2.length + " integers ein:");
		for(int i=0; i<values2.length; i++) {
			values2[i] = sc.nextInt();
		}
		
		for(int out : values2) System.out.println(out);
		
		/*
		Aufgabe 3: Durchschnittswert, Höchstwert, Tiefstwert
		Erweitern Sie Ihr Programm aus Aufgabe 2 um folgende drei Features:
		Nach Eingabe aller Messwerte soll
		a) der Durchschnitt aller Messwerte
		b) der größte Messwert
		c) der kleinste Messwert
		ermittelt und am Ende ausgegeben werden.
		*/
		
		System.out.println("\n3: Durchschnittswert, Höchstwert, Tiefstwert");
		System.out.println("----------------------------------------");
		
		int max=0, min=0, avg=0;
		
		for(int val : values2) {
			max = Math.max(max, val);
			min = Math.min(min, val);
			avg += val;
		}
		
		System.out.println("Max = " + max);
		System.out.println("Min = " + min);
		System.out.println("Avg = " + avg/values2.length);
		
		/*
		Aufgabe 4: Messwertprogramm für die Profis
		
		Teil a)
		Verändern Sie Ihr Programm aus Aufgabe 3, in dem nicht der Benutzer die Temperaturwerte eingibt, sondern
		für ein Jahr lang jeden Tag diese zu Testzwecken von einem Zufallsgenerator generiert werden. Dabei sind
		Temperaturwerte zwischen -30 Grad und +30 Grad zulässig.
		Zur Erinnerung: Eine Zufallszahl zwischen 0,0 und 1,0 kann in Java folgendermaßen erzeugt werden:
		double zahl = Math.random();
		
		Teil b)
		Erweitern Sie Ihr Programm aus Aufgabenteil a), in dem Sie zu jeweils 7 Temperaturwerten (eine Woche)
		den Durchschnittswert berechnen und die Durchschnittswerte der Reihe nach in ein zusätzliches Array
		schreiben. Geben Sie die Wochendurchschnittswerte am Ende des Programms am Bildschirm aus.
		*/
		
		System.out.println("\n4 a), b)");
		System.out.println("----------------------------------------");
		
		double maxRand=0, minRand=0, avgRand=0;
		
		double weeklyMax=0, weeklyMin=0, weeklyAvg=0;
		double[] weeklyMaxArr = new double[365/7];
		double[] weeklyMinArr = new double[365/7];
		double[] weeklyAvgArr = new double[365/7];
		int weekCounter = 0;
		
		for(int i=0; i<365; i++) {
			double rand = Math.random()*60-30;
			
			System.out.println(rand);
			maxRand = Math.max(maxRand, rand);
			minRand = Math.min(minRand, rand);
			avgRand += rand;
			
			weeklyMax = Math.max(weeklyMax, rand);
			weeklyMin = Math.min(weeklyMin, rand);
			weeklyAvg += rand;
			
			if(i%7 == 6) {
				weeklyMaxArr[weekCounter] = weeklyMax;
				weeklyMinArr[weekCounter] = weeklyMin;
				weeklyAvgArr[weekCounter] = weeklyAvg/7;
				
				weeklyMax=0;
				weeklyMin=0;
				weeklyAvg=0;
				weekCounter++;
			}
		}
		
		System.out.println("Max = " + maxRand);
		System.out.println("Min = " + minRand);
		System.out.println("Avg = " + avgRand/365);
		
		System.out.println("weeklyMax = " + Arrays.toString(weeklyMaxArr));
		System.out.println("weeklyMin = " + Arrays.toString(weeklyMinArr));
		System.out.println("weeklyAvg = " + Arrays.toString(weeklyAvgArr));
		
		/*
		Teil c)
		-30 Grad im Juli und +30 Grad im Januar sind unrealistisch. Generieren Sie für jeden Monat oder Jahreszeit
		realistische Zufallswerte.
		*/
		
		System.out.println("\n4 c)");
		System.out.println("----------------------------------------");
		
//		double rand1 = Math.random()*(maxtemp - minTemp) + minTemp;
		
		sc.close();
	}

}
