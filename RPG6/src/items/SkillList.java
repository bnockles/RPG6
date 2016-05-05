package items;

import java.util.ArrayList;

public class SkillList
{
	private ArrayList<activeSkill> skillList;
	
	public SkillList(ArrayList<activeSkill> alist){
		this.skillList = alist;
	}
	
	public ArrayList<activeSkill> getSkills(){
		return skillList;
	}
	
	
ArrayList<activeSkill> skillList = new ArrayList<activeSkill>();
	
	activeSkill fireblast = new activeSkill("Fireblast","fire fixes everything",50,"causes burn status",10);
	activeSkill manaGuard = new activeSkill("Mana Guard","shields are essential",50,"NONE",10);
    activeSkill energyBolt = new activeSkill("Energy Bolt","Pure energy hurts",50,"NONE",10);
    activeSkill reignOfIce = new activeSkill("Reign of Ice","Ice ice baby",50,"causes frozen status",10);
    activeSkill gravityCore = new activeSkill("Gravity Core","control gravity",50,"NONE",10);
    activeSkill explosion = new activeSkill("Explosion","more fire",50,"causes burn status",10);
    activeSkill meditate = new activeSkill("Meditate","too much causes hallucinations",50,"NONE",10);
    activeSkill waterNebula = new activeSkill("Water Nebula","Agua Novela",50,"NONE",10);
    activeSkill Runesave = new activeSkill("Runesave","No mp to give",50,"NONE",10);
    activeSkill forbiddenTomb = new activeSkill("Forbidden Tomb","For the enemies you really hate",50,"NONE",10);
    activeSkill rockCrush = new activeSkill("Rock Crush","Avalanche was not enough",50,"NONE",10);
    activeSkill deathRay = new activeSkill("Death Ray","why not",50,"causes instant death",1000);
    activeSkill TripleShot = new activeSkill("Triple Shot","Third times the charm",50,"NONE",10);
    activeSkill ScatterShot = new activeSkill("Scatter Shot","to make sure enenmies can't escape",50,"NONE",10);
    activeSkill Ricochet = new activeSkill("Ricochet","fire",50,"NONE",10);
    activeSkill PoisonArrow = new activeSkill("Poison Arrow","Poison a convenient answer",50,"causes poison status",10);
    activeSkill SpeedRun = new activeSkill("Speed Run","go fast",50,"raises speed",10);
    activeSkill RainofFire = new activeSkill("Rain of Fire","even more fire",50,"causes burn status",10);
    activeSkill Paralyzingshot = new activeSkill("Paralyzing Shot","fire at will",50,"causes paralysis",10);
    activeSkill SniperInstincts = new activeSkill("Sniper Instincts","hunter wasn't enough",50,"",10);
    activeSkill SuperFreezeArrow = new activeSkill("Super Freeze Arrow","fire wasn't the answer",50,"",10);
    activeSkill StickyBombs = new activeSkill("Sticky Bombs","no comment",50,"",10);
    activeSkill TotheShadows = new activeSkill("To the Shadow","really tempted to add Realm",50,"",10);
    activeSkill TripleTalonStrike = new activeSkill("Triple Talon Strike","Two talons wasn't enough",50,"",10);
    activeSkill Vulnerability = new activeSkill("Vulnerability","survival of the fittests or annihalation of the weak",50,"",10);
    activeSkill JavalinThrow = new activeSkill("Javalin","not made of mistletoe",50,"",10);
    activeSkill DragonStrike = new activeSkill("Dragon Strike","Blue Eyes Ultimate not ammused",50,"",10);
    activeSkill Strengthen = new activeSkill("Strengthen","too  much steroids",50,"",10);
    activeSkill GroundSmash = new activeSkill("Ground Smash","earthquake wasn't made",50,"",10);
    activeSkill SevenBladeDance = new activeSkill("Seven Blade Dance","Because 7 is clearly better than 1",50,"",10);
    activeSkill BodyGuard = new activeSkill("Body Guard","just hire one",50,"",10);
    activeSkill OnePunch = new activeSkill("One Punch","tempted to use Man",50,"",10);
    activeSkill RaijintoStrike = new activeSkill("Raijin to Strike","don't know what it is but use it",50,"",10);
    
    skillList.add(fireblast);
    skillList.add(manaGuard);
    skillList.add(energyBolt);
    skillList.add(reignOfIce);
    skillList.add(gravityCore);
    skillList.add(explosion);
    skillList.add(meditate);
    skillList.add(waterNebula);
    skillList.add(Runesave);
    skillList.add(forbiddenTomb);
    skillList.add(rockCrush);
    skillList.add(deathRay);
    skillList.add(TripleShot);
    skillList.add(ScatterShot);
    skillList.add(Ricochet);
    skillList.add(PoisonArrow);
    skillList.add(SpeedRun);
    skillList.add(RainofFire);
    skillList.add(Paralyzingshot);
    skillList.add(SniperInstincts);
    skillList.add(SuperFreezeArrow);
    skillList.add(StickyBombs);
    skillList.add(TotheShadows);
    skillList.add(TripleTalonStrike);
    skillList.add(Vulnerability);
    skillList.add(JavalinThrow);
    skillList.add(DragonStrike);
    skillList.add(Strengthen);
    skillList.add(GroundSmash);
    skillList.add(SevenBladeDance);
    skillList.add(BodyGuard);
    skillList.add(OnePunch);
    skillList.add(RaijintoStrike);

	
	
	
	
	
}
