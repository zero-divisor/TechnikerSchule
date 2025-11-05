package shuhljahr3.gehoelz_aufgabe;

public class Strauch extends Gehoelz{

	private boolean istGiftig;
	
	public Strauch(String art, int pflanzJahr, double preis, boolean istGiftig) {
		super(art, pflanzJahr, preis);
		this.istGiftig = istGiftig;
	}
	
	@Override
	public String getInfo() {
		String ret = super.getInfo();
		ret += "IstGiftig: " + istGiftig + "\n";
		return ret;
	}

	public boolean isIstGiftig() {
		return istGiftig;
	}

	public void setIstGiftig(boolean istGiftig) {
		this.istGiftig = istGiftig;
	}
}
