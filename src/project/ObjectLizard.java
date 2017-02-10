package project;

public class ObjectLizard extends Enemy {
	public ObjectLizard(String name, int health, int ad, Gear gear){
	 	super(name, health, ad);
	 	pack.add(gear);
	}
}
