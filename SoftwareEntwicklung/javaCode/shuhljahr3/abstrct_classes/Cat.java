package shuhljahr3.abstrct_classes;

public class Cat extends Animal{

	public Cat() {
		setHungerlevel(10);
	}
	
	public void mausFangen() {
		setHungerlevel(getHungerlevel()/2);
	}

	@Override
	public void play() {
		setHungerlevel(getHungerlevel() + 20);
	}

	@Override
	public String speak() {
		// Katzen sagen "REOW", falls hungerlevel >= 85
		// Katzen sagen "meow", falls hungerlevel < 85 und hungerlevel >= 30
		// Katzen sagen ansonsten "purrrr"
		if(getHungerlevel() >= 85) return "REOW";
		else if(getHungerlevel() >= 30) return "meow";
		else return "purrrr";
	}

}
