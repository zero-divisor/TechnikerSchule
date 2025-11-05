package shuhljahr3.gehoelz_aufgabe;

import java.util.ArrayList;

public class Gaertnerei {

	private ArrayList<Gehoelz> inventar = new ArrayList<Gehoelz>();

	public void einkaufen(Gehoelz gh) {
		inventar.add(gh);
	}
	
	public Gehoelz verkaufen(String art, int pflanzjahr) {
		for(Gehoelz gh : inventar) {
			if(gh.getArt().equals(art) && gh.getPflanzJahr() == pflanzjahr) {
				inventar.remove(gh);
				return gh;
			}
		}
		return null;
	}
	
	public ArrayList<Gehoelz> getWoodByLimit(double maxPrice){
		ArrayList<Gehoelz> ret = new ArrayList<Gehoelz>();
		for(Gehoelz gh : inventar) {
			if(gh.getPreis() < maxPrice) {
				ret.add(gh);
			}
		}
		return ret;
	}
	
	public ArrayList<Gehoelz> getInventar() {
		return inventar;
	}

	public void setInventar(ArrayList<Gehoelz> inventar) {
		this.inventar = inventar;
	}
}
