public class Enemy {
	public String name;
	private int level;
	private float health;
	private float damage;
	private float reward;
	
	public Enemy() {
		EnemyTypes npc = new EnemyTypes();
		name = npc.generateName();
		level = npc.getLevel();
		updateStatistics();
		System.out.println("You encounter " + name + "! A level " + level + " creature! Bounty: " + reward + " XP");
	}
	
	private void updateStatistics() {
		health = level * level;
		damage = level / 2;
		reward = health * level;
	}
	
	public boolean isAlive() {
		return health > 0;
	}
	
	public void attack(Player player) {
		player.receiveDamage(damage);
	}
	
	public void receiveDamage(float dmg) {
		health -= dmg;
	}
}