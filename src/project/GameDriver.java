package project;

import java.util.ArrayList;
import java.util.Scanner;

public class GameDriver {
	public static String playerName;
	public static String islandName;
	public static String path;
	public static Scanner kb = new Scanner(System.in);
	public static Player player;
	public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	public static boolean randomness = false;
	public static final int PLAYER_HEALTH = 12;
	public static final int PLAYER_AD = 3;
	public static final int TROLL_HEALTH = 5;
	public static final int TROLL_AD = 3;
	public static final int OBJECT_LIZARD_HEALTH = 4;
	public static final int OBJECT_LIZARD_AD = 2;
	public static final int PYGMY_ISLANDER_HEALTH = 2;
	public static final int PYGMY_ISLANDER_AD = 1;
	public static final Gear healthBooster = new HealthBooster("Sailor's Grog");
	public static final Gear damageBooster = new DamageBooster("Corsair's Cutlass");
	public static final Gear shield = new Shield("Captain's Hat");

	public static void main(String[] args) {
		start();
		setUp();
		play();
	}

	public static void setUp() {
		player = new Player(playerName, PLAYER_HEALTH, PLAYER_AD);

		if (path.equals("left")) {
			for (int i = 0; i < 6; i++) {
				enemies.add(new ObjectLizard("Object Lizard", OBJECT_LIZARD_HEALTH, OBJECT_LIZARD_AD, healthBooster));
			}

			System.out.println(player.getName()
					+ " sets off down the left path. He encounters a dark swamp that smells \nof death and decay. Suddenly, 6 Object Lizards"
					+ " jump \nout of the swampy water and attack!");

		} else if (path.equals("center")) {
			for (int i = 0; i < 5; i++) {
				enemies.add(
						new PygmyIslander("Pygmy Islander", PYGMY_ISLANDER_HEALTH, PYGMY_ISLANDER_AD, damageBooster));
			}

			System.out.println(player.getName()
					+ " sets off down the center path. He encounters a \n shadowy jungle that smells of death and decay. Suddenly, 5 Pygmy Islanders"
					+ " \njump out of the jungle and attack!");

		} else if (path.equals("right")) {
			for (int i = 0; i < 4; i++) {
				enemies.add(new Troll("Troll", TROLL_HEALTH, TROLL_AD, shield));
			}
			System.out.println(player.getName()
					+ " sets off down the right path. He encounters a dark \ncave that smells of death and decay. Suddenly, 4 Trolls"
					+ " jump out \nof the cavernous depths and attack!");

		}

	}

	public static void play() {
		do {

			Enemy enemy = enemies.remove(0);
			System.out.print("Hit ENTER to continue: ");
			String enter = kb.nextLine();
			while (player.getHealth() > 0 && enemy.getHealth() > 0) {

				int healthRemaining = player.strike(enemy);
				if (healthRemaining == -1) {
					System.out.println(player.getName() + " defeated " + enemy.getName());
					player.setNumEnemiesDefeated(1 + player.getNumEnemiesDefeated());
					break;

				} else {
					System.out.println(
							player.getName() + " damaged " + enemy.getName() + " for " + player.getAttackDamage() + ". "
									+ enemy.getName() + " has " + healthRemaining + " health.");

				}
				int playerHealthRemaining = enemy.strike(player);
				if (playerHealthRemaining == -1) {
					System.out.println(enemy.getName() + " defeated " + player.getName());
					break;
				} else {
					System.out.println(
							enemy.getName() + " damaged " + player.getName() + " for " + enemy.getAttackDamage() + ". "
									+ player.getName() + " has " + playerHealthRemaining + " health.");
					// if (enemies != null) {
					// System.out.println("You picked-up a " +
					// enemies.get(0).getPack().get(0).getName());
					// player.retrieveGear(enemies.get(0).getPack().get(0));
					// }

				}

			}

		} while (!gameOver());
	}

	public static void start() {
		System.out.println("Welcome to The Lord of The Objects!");
		System.out.print("Enter your name: ");
		playerName = kb.next();
		System.out.print("Enter Dangerous Island name: ");
		islandName = kb.next();
		System.out.print("Enter difficulty level (1, 2): ");
		int difficulty = kb.nextInt();
		if (difficulty == 2) {
			randomness = true;
		}
		System.out.println("The dashing rogue pirate, " + playerName + ", hears from a group of traveling \nmonks of a"
				+ " mysterious treasure located on " + islandName + " Island.");
		System.out.println("When " + playerName
				+ " reaches the island, he discovers three paths leading in different directions.");

		System.out.print("Choose your path (left, center, or right): ");
		path = kb.next();

	}

	public static boolean gameOver() {
		if (player.getNumEnemiesDefeated() == 3) {
			// solve the riddle
			System.out.println(player.getName()
					+ " defeated the hoardes of enemies and followed the path to the center of the island.");
			System.out.println(
					"At the center of the island in a small clearing, was a pedestal with the golden treasure box resting upon it.");
			System.out.println(player.getName()
					+ " approaches the pedestal slowly. Upon the side, was a glowing message that read: ");
			System.out.println(
					"He who seeks the treasure chest, must solve the answer to this test. Think before you answer out loud, for if you're \nwrong your body will never be found!");
			System.out.println(
					"Riddle: Many have heard me, but no one has seen me, and I will not speak back until spoken to. What am I?");
			String answer = kb.nextLine();
			if (answer.equals("echo")) {
				System.out.println(player.getName()
						+ " spoke the magic word and was able to retrieve the treasure chest. Upon looking inside the chest, "
						+ player.getName()
						+ "\n was horrified to see the chest empty save a piecce of parchment. The parchment read: ");
				System.out.println("What is slow, too late and can be found in the center of but?");
				System.out.println("\n\n GAME OVER MATEY!!!!!");
				return true;
			}
			System.out.println("\n\n It's 'echo'. GAME OVER MATEY!!!!!");
			return true;
		} else if (player.getHealth() == 0) {
			System.out.println("Game Over!");
			return true;
		}

		return false;
	}

}
