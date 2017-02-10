package project;

import java.util.ArrayList;

public abstract class Character {
	private String name;
	private int health;
	private int attackDamage;
	protected ArrayList<Gear> pack = new ArrayList<Gear>();

	public int strike(Character enemy) {
		int healthRemaining;
		if(enemy.getHealth() - getAttackDamage() > 0) {
			healthRemaining = enemy.getHealth() - getAttackDamage();
			enemy.setHealth(healthRemaining);
			return healthRemaining;
		}
		enemy.setHealth(0);
		return -1;
	}

	public boolean defeated() {
		if (health == 0) {
			return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public ArrayList<Gear> getGears() {
		return pack;
	}

	public void setGears(ArrayList<Gear> pack) {
		this.pack = pack;
	}

	public ArrayList<Gear> getPack() {
		return pack;
	}

	public void setPack(ArrayList<Gear> pack) {
		this.pack = pack;
	}



}
