package shuhljahr3;

public class Beziehungen2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Verkaeufer vk = new Verkaeufer();
		vk.erweitereSortiment(10);
		System.out.println("sortimentGröeße: " + vk.getSortiment().length);
	}


	public static class Verkaeufer {
		private Artikel[] sortiment = new Artikel[100];
		
		public Verkaeufer() {
			for(int i=0; i<sortiment.length; i++) {
				sortiment[i] = new Artikel("", "", 0, 0.0);
			}
		}
		
		
		
		public Artikel[] getSortiment() {
			return sortiment;
		}



		public void setSortiment(Artikel[] sortiment) {
			this.sortiment = sortiment;
		}



		public double getPreis(int index) {
			return sortiment[index].getPreis();
		}
		
		public void setPreis(int index, double preis) {
			sortiment[index].setPreis(preis);
		}
		
		public void kaufen(int index, int anzahl) {
			sortiment[index].kaufen(anzahl);
		}
		
		public void rabatt(int mindBestand, int prozent) {
			for(int i=0; i<sortiment.length; i++) {
				if(sortiment[i].getBestand() >= mindBestand) {
					sortiment[i].setPreis(sortiment[i].getPreis()*(double)(100-prozent));
				}
			}
		}
		
		public void erweitereSortiment(int anzahlNeueArtikel) {
			Artikel[] neuesSortiment = new Artikel[sortiment.length + anzahlNeueArtikel];
			for(int i=0; i<sortiment.length; i++) {
				neuesSortiment[i] = sortiment[i];
			}
			for(int j=sortiment.length; j<neuesSortiment.length; j++) {
				neuesSortiment[j] = new Artikel("", "", 0, 0.0);
			}
			this.sortiment = neuesSortiment;
		}
	}
	
	public static class Artikel{
		private String name, code;
		private int bestand;
		private double preis;
		
		public Artikel(String name, String code, int bestand, double preis) {
			this.name = name;
			this.code = code;
			this.bestand = bestand;
			this.preis = preis;
		}
		
		public void kaufen(int anzahl) {
			this.bestand += anzahl;
		}
		
		public double getPreis() {
			return preis;
		}
		public void setPreis(double preis) {
			this.preis = preis;
		}
		public int getBestand() {
			return bestand;
		}
		public void setBestand(int bestand) {
			this.bestand = bestand;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
	}
}
