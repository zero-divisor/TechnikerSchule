package schuljahr2;

import java.util.Arrays;

public class MethodenAufgaben {

	public static void main(String[] args) {
		System.out.println(min(1.4, 1.3));
		System.out.println(betrag(0));
		System.out.println(anzahlVokale("Homotopieäquivalenz"));
		System.out.println(potenz(2, 4));
		System.out.println(fakultaet(8));
		System.out.println(isSchaltjahr(100));
		System.out.println(Arrays.toString(tauschen(3, 4)));
		
		int[] randomNumbers = generateRandom();
		printArray(randomNumbers);
		int[] sortednumbers = sortArray(randomNumbers);
		printArray(sortednumbers);
	}
	/*
	Aufgabe 8: Zahlenreihe sortieren
	Schreiben Sie eine Methode, welche ein Array mit 20 Zufallszahlen aufsteigend sortiert und ausgibt.
	Verwenden Sie dabei für
	- das Generieren der Zufallszahlen (Eingabe)
	- das Sortieren (Verarbeitung)
	- das Ausgeben (Ausgabe)
	jeweils eine eigene Methode.
	*/
	
	public static int[] generateRandom() {
		int[] ret = new int[20];
		
		for(int i=0; i<ret.length; i++) {
			ret[i] = (int)(Math.random()*10);
		}
		
		return ret;
	}
	
	public static int[] sortArray(int[] unSorted) {
		boolean isSorted = true;
		for(int i=0; i<unSorted.length-1; i++) {
			if(unSorted[i] <= unSorted[i+1]) {
				continue;
			}else {
				int temp = unSorted[i];
				unSorted[i] = unSorted[i+1];
				unSorted[i+1] = temp;
				isSorted = false;
			}
		}
		if(isSorted) return unSorted;
		else return sortArray(unSorted);
	}
	
	public static void printArray(int[] numbers) {
		System.out.println(Arrays.toString(numbers));
	}
	
	/*
	a) Schreiben Sie eine Methode double min(double zahl1, double zahl2) , die die kleinere der
	beiden übergebenen Zahlen zurückgibt.
	*/
	public static double min(double a, double b) {
		if(a < b) return a;
		else return b;
	}
	/*
	b) Schreiben Sie eine Methode double betrag(double zahl) , die den Betrag der Zahl zurückgibt.
	*/
	public static double betrag(double a) {
		if(a < 0) return -a;
		else return a;
	}
	/*
	c) Schreiben Sie eine Methode, die eine Zeichenkette bekommt und die Anzahl der Vokale in dieser
	Zeichenkette zurückgibt.
	*/
	public static int anzahlVokale(String word) {
		word = word.toLowerCase();
		int ret = 0;
		
		for(int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				ret++;
			}
		}
		return ret;
	}
	/*
	d) Schreiben Sie eine Methode int potenz(int basis, int exponent) , die den Potenzwert zu
	Basis und Exponent zurückgibt.
	*/
	public static int potenz(int basis, int exponent) {
		int ret = 1;
		for(int i=0; i<exponent; i++) {
			ret = ret*basis;
		}
		return ret;
	}
	/*
	e) Schreiben Sie eine Methode int fakultaet(int zahl) , die die Fakultät einer Zahl berechnet.
	*/
	public static int fakultaet(int a) {
		if(a==0) return 1;
		else return a*fakultaet(a-1);
	}
	/*
	f) Schreiben Sie eine Methode die einen booleschen Wert zurückgibt, je nach dem ob das übergebene
	Jahr ein Schaltjahr ist oder nicht.
	*/
	public static boolean isSchaltjahr(int jahr) {
		if(jahr%400 == 0) return true;
		else if(jahr%100 == 0) return false;
		else if(jahr%4 == 0) return true;
		else return false;
	}
	/*
	g) Schreiben Sie eine Methode die zwei Zahlen übergeben bekommt und diese vertauscht an die
	aufrufende Methode zurückgibt. Überlegen Sie sich dazu eine Möglichkeit mehrere Werte auf einmal
	zurückzugeben.
	*/
	public static int[] tauschen(int a, int b) {
		int[] ret = {b, a};
		return ret;
	}
}
