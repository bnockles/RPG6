package items;

public abstract class Spell {
	private String name;
	private String description;
	private int manaCost;
	
	public String getName(){ return this.name; }
	public String getDescription(){ return this.description; }
	public int getManaCost(){ return this.manaCost; }
	
	public abstract boolean canCast(Character caster, Character target);
	public abstract void cast(Character caster, Character target);
}
