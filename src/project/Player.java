package project;

public class Player extends Character {
	private int numEnemiesDefeated;


	public int getNumEnemiesDefeated() {
		return numEnemiesDefeated;
	}

	public void setNumEnemiesDefeated(int numEnemiesDefeated) {
		this.numEnemiesDefeated = numEnemiesDefeated;
	}

	public Player(String name, int health, int attackDamage){

		numEnemiesDefeated = 0;
		setName(name);
		setHealth(health);
		setAttackDamage(attackDamage);
	}

	public void retrieveGear(Gear gear) {
		pack.add(gear);

	}

}
