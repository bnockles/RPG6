package items;

public abstract class Spell {
	private String name;
	private String description;
	private int manaCost;
	public int damage;
	
	public Spell(String name, String description, int cost, int damage){
		this.name = name;
		this.description = description;
		this.manaCost = cost;
		this.damage = damage;
	}
	
	public String getName(){ return this.name; }
	public String getDescription(){ return this.description; }
	public int getManaCost(){ return this.manaCost; }
	public int getDamage() { return this.damage; }
	
	public abstract boolean canCast(Character caster, Character target);
	public abstract int cast(Character caster, ActiveSkill skill, Character target);
}
