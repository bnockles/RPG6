package items;

public class buffSkills extends Spell {
	private Stats statEffect;
	
	public buffSkills(String name, String description, int cost, int damage, Stats statEffect) {
		super(name, description, cost, damage);
		this.statEffect = statEffect;
	}
	
	public Stats getStatEffect(){
		return statEffect;
	}

	@Override
	public boolean canCast(Character caster, Character target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int cast(Character caster, ActiveSkill skill, Character target) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getSkillInfo() {
		return "Name: " + this.getName() + " Description: " + this.getDescription();
	}

	public int getSkillDamage() {
		return 0;
	}

	public int getSkillCost() {
		return this.getManaCost();
	}

	public boolean isUsable() {
		return true;
	}

}
