package items;

public class activeSkill extends Spell {

	public int finalDamage;
	
	public activeSkill(String name, String description, int cost, int damage) {
		super(name, description, cost, damage);
	}

	@Override
	public boolean canCast(Character caster, Character target) {
		if (target.getType().equals("enemy")){
			return true;
		}
		return false;
	}

	@Override
	public int cast(Character caster, activeSkill skill, Character target) {
		if (canCast(caster, target)){
			finalDamage = (caster.getTrueStats().getAttack() + skill.getDamage()) - target.getTrueStats().getDefense();
		}
		return finalDamage;
	}

	public int getFinalDamage() {
		return finalDamage;
	}

	public String getSkillInfo() {
		return "Name: " + this.getName() + " Description: " + this.getDescription();
	}

	public int getSkillDamage() {
		// TODO Auto-generated method stub
		return this.getDamage();
	}

	public int getSkillCost() {
		return this.getManaCost();
	}

	public boolean isUsable() {
		return true;
	}

}
