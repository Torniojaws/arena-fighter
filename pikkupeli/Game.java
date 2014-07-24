import java.util.Scanner;

public class Game {
	// Props
	
	// Ctor
	public Game() {
		System.out.println("The Game is starting... - press 'q' to quit");
		Player pc = new Player();
		Enemy enemy = new Enemy();
		pc.displayStatistics();
		
		// Battle begins
		while(enemy.isAlive()) {
			switch(userInput()) {
				case 'a':
					pc.attack(enemy);
					if(enemy.isAlive()) {
						enemy.attack(pc);
					} else {
						System.out.println("The enemy is dead! Long live the enemy!");
					}
					break;
				case 'd':
					System.out.println("Player defends!");
					break;
				case 'q':
					System.out.println("User has quit!");
					break;
				default:
					break;
			}
		}
		
		// Battle ends
		if(pc.isAlive()) {
			System.out.println("Player survived! Until the sequel...!");
		} else {
			System.out.println("Player is Dead! Game over!");
		}
	}
	
	// Methods
	private static char userInput() {
		System.out.println("Press 'a' to attack. Press 'd' to defend. Press 'q' to quit");
		Scanner input = new Scanner(System.in);
		return input.next().charAt(0);
	}
}