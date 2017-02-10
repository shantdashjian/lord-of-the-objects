package project;

public class Troll extends Enemy {
	public Troll(String name, int health, int ad, Gear gear){
 	super(name, health, ad);
 	pack.add(gear);
	}
}
