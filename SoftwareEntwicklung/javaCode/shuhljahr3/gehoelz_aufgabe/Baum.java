package shuhljahr3.gehoelz_aufgabe;

public class Baum extends Gehoelz{

	private int maxHoehe;
	
	public Baum(String art, int pflanzJahr, double preis, int maxHoehe) {
		super(art, pflanzJahr, preis);
		this.maxHoehe = maxHoehe;
	}
	
	@Override
	public String getInfo() {
		String ret = super.getInfo();
		ret += "MaxHoehe: " + maxHoehe + "\n";
		return ret;
	}

	public int getMaxHoehe() {
		return maxHoehe;
	}

	public void setMaxHoehe(int maxHoehe) {
		this.maxHoehe = maxHoehe;
	}
}
