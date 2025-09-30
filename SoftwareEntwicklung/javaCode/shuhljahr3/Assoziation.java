package shuhljahr3;

import java.util.ArrayList;

public class Assoziation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class Kunde{
		private String kdNr, kdBez;
		private ArrayList<Bestellung> bestellungen;
		
		public Kunde(String kdNr, String kdBez) {
			this.kdBez = kdBez;
			this.kdNr = kdNr;
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
		private double anzahl, rabSatz = 15;
		private boolean bestellungOnline;
		private Kunde kunde;
		
		public Bestellung(double anzahl, boolean bestellungOnline, Kunde kunde) {
			this.anzahl = anzahl;
			this.bestellungOnline = bestellungOnline;
			this.kunde = kunde;
			setRabSatz();
			kunde.getBestellungen().add(this);
		}
		
		public double getAnzahl() {
			return anzahl;
		}
		public void setAnzahl(double anzahl) {
			this.anzahl = anzahl;
			setRabSatz();
		}
		public boolean isBestellungOnline() {
			return bestellungOnline;
		}
		public void setBestellungOnline(boolean bestellungOnline) {
			this.bestellungOnline = bestellungOnline;
			setRabSatz();
		}
		public double getRabSatz() {
			return rabSatz;
		}
		public void setRabSatz() {
			this.rabSatz = 15;
			if(bestellungOnline) rabSatz += 1.5;
			if(anzahl >= 5000) rabSatz += 2;
			else if (anzahl >= 2500) rabSatz += 1.5;
		}
		public Kunde getKunde() {
			return kunde;
		}
		public void setKunde(Kunde kunde) {
			this.kunde = kunde;
		}
	}
}
