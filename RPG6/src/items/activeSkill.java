package items;

public class activeSkill extends Spell {

	public int finalDamage;
	public activeSkill(String name, String description, int cost, String effect, int damage) {
		super(name, description, cost, effect, damage);
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
	

}
