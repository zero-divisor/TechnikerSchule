package shuhljahr3.abstrct_classes;

public class Dog extends Animal{

	public Dog() {
		setHungerlevel(30);
	}

	public void doTrick() {
		setHungerlevel(getHungerlevel() + 20);
	}
	
	@Override
	public void eat() {
		setHungerlevel(getHungerlevel()/2);
	}
	
	@Override
	public void play() {
		setHungerlevel(getHungerlevel()*2);
	}

	@Override
	public String speak() {
		// Hunde sagen "Grrr", wenn Ihr Hungerlevel >= 50 ist, andernfalls sagen sie "woof"
		if(getHungerlevel() >= 50) return "Grrr";
		else return "woof";
	}

}
