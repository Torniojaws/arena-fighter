import java.util.Scanner;

public class Player {
	// Prop
	private String name;
	private int charClass; // 0 = Warrior, 1 = Mage, 2 = Rogue
	private int strength = 5;
	private int agility = 5;
	private int magic = 5;
	private int vitality = 5;
	private float health = 100;
	private float armor = 0;
	private float damage = 5;
	private float accuracy = 20;
	
	// Ctor
	public Player() {
		System.out.println("Creating new character...");
		giveName();
		giveClass();
		updateStatistics();
		System.out.println(name + " has entered the game!");
	}
	
	// Methods
	private void giveName() {
		Scanner input = new Scanner(System.in);
		System.out.println("What is your name?");
		name = input.nextLine();	
	}
	
	private void giveClass() {
		Scanner input = new Scanner(System.in);
		System.out.println("And which class do you wish to be?");
		System.out.println("0 = Warrior, 1 = Mage, 2 = Rogue");
		charClass = input.nextInt();	
	}
	
	private void updateStatistics() {
		switch(charClass) {
			case 0: // Warrior
				strength += 2;
				agility -= 1;
				magic -= 2;
				vitality += 1;
				damage += 1;
				break;
			case 1: // Mage
				strength -= 2;
				agility -= 1;
				magic += 2;
				vitality += 1;
				damage -= 2;
				break;
			case 2: // Rogue
				strength += 0;
				agility += 2;
				magic -= 1;
				vitality += 1;
				damage -= 1;
				break;
			default:
				break;
		}
	}
	
	public void displayStatistics() {
		System.out.println("*** Player stats ***");
		System.out.println("Strength  " + strength);
		System.out.println("Agility   " + agility);
		System.out.println("Magic     " + magic);
		System.out.println("Vitality  " + vitality);
		System.out.println("***");
	}
	
	public boolean isAlive() {
		return health > 0;
	}
	
	public void attack(Enemy enemy) {
		System.out.println(name + " attacks " + enemy.name + "!");
		enemy.receiveDamage(damage);
	}
	
	public void receiveDamage(float dmg) {
		health -= dmg;
	}
}