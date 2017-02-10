package project;

public class PygmyIslander extends Enemy {
	public PygmyIslander(String name, int health, int ad, Gear gear){
	 	super(name, health, ad);
	 	pack.add(gear);
	}

}
