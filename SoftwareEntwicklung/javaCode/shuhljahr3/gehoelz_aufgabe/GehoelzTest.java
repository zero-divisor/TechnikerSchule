package shuhljahr3.gehoelz_aufgabe;

public class GehoelzTest {

	public static void main(String[] args) {

		Strauch str = new Strauch("Himbere", 2012, 12.50, false);
		Gaertnerei gr = new Gaertnerei();
		gr.einkaufen(str);
		System.out.println(str.getInfo());
	}

}
