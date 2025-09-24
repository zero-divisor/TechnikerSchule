package shuhljahr3;

import java.util.ArrayList;

public class Assoziation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class Kunde{
		private String kdNr, kdBez;
		private ArrayList<Bestellung> bestellungen;
		
		public Kunde(String kdNr, String kdBez, Bestellung best) {
			this.kdBez = kdBez;
			this.kdNr = kdNr;
			this.bestellungen.add(best);
			best.setKunde(this);
		}

		public ArrayList<Bestellung> getBestellungen(){
			return this.bestellungen;
		}
		public String getKdNr() {
			return kdNr;
		}

		public void setKdNr(String kdNr) {
			this.kdNr = kdNr;
		}

		public String getKdBez() {
			return kdBez;
		}

		public void setKdBez(String kdBez) {
			this.kdBez = kdBez;
		}
	}

	public class Bestellung{
		private double anzahl, rabSatz;
		private boolean bestellungOnline;
		private Kunde kunde;
		
		public Bestellung() {
			x
		}
		
		public double getAnzahl() {
			return anzahl;
		}
		public void setAnzahl(double anzahl) {
			this.anzahl = anzahl;
		}
		public boolean isBestellungOnline() {
			return bestellungOnline;
		}
		public void setBestellungOnline(boolean bestellungOnline) {
			this.bestellungOnline = bestellungOnline;
		}
		public double getRabSatz() {
			return rabSatz;
		}
		public void setRabSatz(double rabSatz) {
			this.rabSatz = rabSatz;
		}
		public Kunde getKunde() {
			return kunde;
		}
		public void setKunde(Kunde kunde) {
			this.kunde = kunde;
		}
	}
}
