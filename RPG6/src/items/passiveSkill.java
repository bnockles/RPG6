package items;

public class passiveSkill extends Spell {
	public int finalDamage;
	public Stats stats;
	public int boostAtk;
	public int boostDef;
	public int boostHP;
	public int boostMP;
	public int boostStr;
	public int boostDex;
	public int boostInt;
	public int boostWis;
	public int boostLuk;

	public int getFinalDamage() {
		return finalDamage;
	}

	public int getBoostAtk() {
		return boostAtk;
	}

	public int getBoostDef() {
		return boostDef;
	}

	public int getBoostHP() {
		return boostHP;
	}

	public int getBoostMP() {
		return boostMP;
	}

	public int getBoostStr() {
		return boostStr;
	}

	public int getBoostDex() {
		return boostDex;
	}

	public int getBoostInt() {
		return boostInt;
	}

	public int getBoostWis() {
		return boostWis;
	}

	public int getBoostLuk() {
		return boostLuk;
	}

	public passiveSkill(String name, String description, int cost, String effect, int damage, Stats statBoost) {
		super(name, description, cost, effect, damage);
		this.stats = statBoost;
	}
	
	public Stats getStats() {
		return stats;
	}

	@Override
	public boolean canCast(Character caster, Character target) {

		return false;
	}

	@Override
	public int cast(Character caster, activeSkill skill, Character target) {
		if (canCast(caster, target)){
			finalDamage = (caster.getTrueStats().getAttack() + skill.getDamage()) - target.getTrueStats().getDefense();
		}
		return finalDamage;
	}
	
	public void statsBoost(Character user, passiveSkill skill){
		boostAtk = user.getTrueStats().getAttack() + skill.getStats().getAttack();
		boostDef = user.getTrueStats().getDefense() + skill.getStats().getDefense();
		boostHP = user.getTrueStats().getHealth() + skill.getStats().getHealth();
		boostMP = user.getTrueStats().getHealth() + skill.getStats().getHealth();
		boostStr = user.getTrueStats().getStrength() + skill.getStats().getStrength();
		boostDex = user.getTrueStats().getDexterity() + skill.getStats().getDexterity();
		boostInt = user.getTrueStats().getIntelligence() + skill.getStats().getIntelligence();
		boostWis = user.getTrueStats().getWisdom() + skill.getStats().getWisdom();
		boostLuk = user.getTrueStats().getLuck() + skill.getStats().getLuck();
	}
	
	public static void main(){
		
	}
}
