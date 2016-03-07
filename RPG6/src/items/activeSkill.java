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
	
	public static void skillList(){
        Spell fireblast = new activeSkill("Fireblast","fire",50,"",10);
        Spell manaGuard = new activeSkill("Mana Guard","shields are essential",50,"",10);
        Spell energyBolt = new activeSkill("Energy Bolt","Pure energy hurts",50,"",10);
        Spell reignOfIce = new activeSkill("Reign of Ice","Ice",50,"",10);
        Spell gravityCore = new activeSkill("Gravity Core","control gravity",50,"",10);
        Spell explosion = new activeSkill("Explosion","more fire",50,"",10);
        Spell meditate = new activeSkill("Meditate","too much cause hallucinations",50,"",10);
        Spell waterNebula = new activeSkill("Water Nebula","water",50,"",10);
        Spell Runesave = new activeSkill("Runesave","No mana to give",50,"",10);
        Spell forbiddenTomb = new activeSkill("Forbidden Tomb","For the enemies you really hate",50,"",10);
        Spell rockCrush = new activeSkill("Rock Crush","Avalanche was not enough",50,"",10);
        Spell deathRay = new activeSkill("Death Ray","why not",50,"",10);
        activeSkill TripleShot = new activeSkill("Triple Shot","Third times the charm",50,"",10);
        activeSkill ScatterShot = new activeSkill("Scatter Shot","to make sure enenmies can't escape",50,"",10);
        activeSkill Ricochet = new activeSkill("Ricochet","fire",50,"",10);
        activeSkill PoisonArrow = new activeSkill("Poison Arrow","Poison a convenient answer",50,"",10);
        activeSkill SpeedRun = new activeSkill("Speed Run","fast",50,"",10);
        activeSkill RainofFire = new activeSkill("Rain of Fire","even more fire",50,"",10);
        activeSkill Paralyzingshot = new activeSkill("Paralyzing Shot","fire at will",50,"",10);
        activeSkill SniperInstincts = new activeSkill("Sniper Instincts","hunter wasn't enough",50,"",10);
        activeSkill SuperFreezeArrow = new activeSkill("Super Freeze Arrow","fire wasn't the answer",50,"",10);
        activeSkill StickyBombs = new activeSkill("Sticky Bombs","fno comment",50,"",10);
        activeSkill TotheShadows = new activeSkill("To the Shadow","really tempted to add realm",50,"",10);
        activeSkill TripleTalonStrike = new activeSkill("Triple Talon Strike","Two talons wasn't enough",50,"",10);
        activeSkill Vulnerability = new activeSkill("Vulnerability","fire",50,"",10);
        activeSkill JavalinThrow = new activeSkill("Javalin","fire",50,"",10);
        activeSkill DragonStrike = new activeSkill("Dragon Strike","fire",50,"",10);
        activeSkill Strengthen = new activeSkill("Strengthen","fire",50,"",10);
        activeSkill GroundSmash = new activeSkill("Ground Smash","fire",50,"",10);
        activeSkill SevenBladeDance = new activeSkill("Seven Blade Dance","Because 7 is clearly better than 1",50,"",10);
        activeSkill BodyGuard = new activeSkill("Body Guard","fire",50,"",10);
        activeSkill OnePunch = new activeSkill("One Punch","tempted to use Man",50,"",10);
        activeSkill RaijintoStrike = new activeSkill("Raijin to Strike","don't know what it is but use it",50,"",10);
	}

}
