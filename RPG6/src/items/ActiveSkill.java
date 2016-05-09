package items;

public class ActiveSkill extends Spell {

	public int finalDamage;
	public ActiveSkill(String name, String description, int cost, int damage) {
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
	public int cast(Character caster, ActiveSkill skill, Character target) {
		if (canCast(caster, target)){
			finalDamage = (caster.getTrueStats().getAttack() + skill.getDamage()) - target.getTrueStats().getDefense();
		}
		return finalDamage;
	}

	public int getFinalDamage() {
		return finalDamage;
	}
	

}
