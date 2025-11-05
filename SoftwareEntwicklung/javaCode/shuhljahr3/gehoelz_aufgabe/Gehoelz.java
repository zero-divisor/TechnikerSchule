package shuhljahr3.gehoelz_aufgabe;

public class Gehoelz {

	private String art;
	private int pflanzJahr;
	private double preis;
	
	public Gehoelz(String art, int pflanzJahr, double preis) {
		this.art = art;
		this.pflanzJahr = pflanzJahr;
		this.preis = preis;
	}
	
	public String getInfo() {
		String ret = "Art: " + art + "\n"
				+ "PflanzJahr: " + pflanzJahr + "\n"
				+ "Preis: " + preis + "\n";
		return ret;
	}
	
	public String getArt() {
		return art;
	}
	public void setArt(String art) {
		this.art = art;
	}
	public int getPflanzJahr() {
		return pflanzJahr;
	}
	public void setPflanzJahr(int pflanzJahr) {
		this.pflanzJahr = pflanzJahr;
	}
	public double getPreis() {
		return preis;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}
}
