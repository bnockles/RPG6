package items;

public abstract class Spell {
	private String name;
	private String description;
	private int manaCost;
	public String effect;
	public int damage;
	
	public Spell(String name, String description, int cost, String effect, int damage){
		this.name = name;
		this.description = description;
		this.manaCost = cost;
		this.effect = effect;
		this.damage = damage;
	}
	
	public String getName(){ return this.name; }
	public String getDescription(){ return this.description; }
	public int getManaCost(){ return this.manaCost; }
	public String getEffect() { return this.effect; }
	public int getDamage() { return this.damage; }
	
	public abstract boolean canCast(Character caster, Character target);
	public abstract int cast(Character caster, activeSkill skill, Character target);
}
