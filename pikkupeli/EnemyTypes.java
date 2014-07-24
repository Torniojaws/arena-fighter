import java.util.Random;

public class EnemyTypes {
	private static String[] prefixes = {"Weary", "Young", "Wild", "Fierce", "Unfathomable"};
	private static String[] suffixes = {"Wolf", "Rat", "Bear", "Viper", "Spider"};
	private static int generatedPrefixLevel;
	private static int generatedSuffixLevel;
	public String name;
	public int level;
	
	public EnemyTypes() {
		level = generateLevel();
		name = generateName();
		
		System.out.println("Level is = " + level);
	}
	
	private static int generateLevel() {
		generatedPrefixLevel = randInt(0, prefixes.length);
		generatedSuffixLevel = randInt(0, suffixes.length);
		return generatedPrefixLevel + generatedSuffixLevel;
	}
	
	public static String generateName() {
		return(prefixes[generatedPrefixLevel] + " " + suffixes[generatedSuffixLevel]);
	}
	
	public int getLevel() {
		return level;
	}
	
	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) - 1) + min;
		return randomNum;
	}
}