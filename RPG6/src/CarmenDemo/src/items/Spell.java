package items;

public abstract class Spell implements battleSkillInterface{
	private String name;
	private String description;
	private int cost;
	private int damage;
	public int classTag;//0 is All classes, 1 is Warrior, 2 is Bowman, 3 is Mage, 4 is Rogue
	
	public Spell(String name, String description, int cost, int damage){
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.damage = damage;
	}
	
	public String getName(){ return this.name; }
	public String getDescription(){ return this.description; }
	public int getManaCost(){ return this.cost; }
	public int getDamage() { return this.damage; }
	
	public abstract boolean canCast(Character caster, Character target);
	public abstract int cast(Character caster, ActiveSkill skill, Character target);
}
