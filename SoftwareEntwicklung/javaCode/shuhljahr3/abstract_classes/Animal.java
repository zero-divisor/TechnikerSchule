package shuhljahr3.abstract_classes;

public abstract class Animal {
	private int hungerlevel;
	private String name;
	
	public abstract void play();
	public abstract String speak();
	
	public void eat() {
		hungerlevel = 0;
	}
	
	public int getHungerlevel() {
		return hungerlevel;
	}
	public void setHungerlevel(int hungerlevel) {
		this.hungerlevel = hungerlevel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
