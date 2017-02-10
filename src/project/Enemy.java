package project;

public class Enemy extends Character {

	public Gear dropGear() {

		return pack.remove(0);
	}

	public Enemy(String name, int health, int ad) {
		setName(name);
		if (GameDriver.randomness == true) {
			health = (int) (1 + Math.random() * 10);
		}
		setHealth(health);
		setAttackDamage(ad);
	}

}
