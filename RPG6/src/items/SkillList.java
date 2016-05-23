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
	
	

	
	ActiveSkill fireblast = new ActiveSkill("Fireblast","fire fixes everything",50,"causes burn status",10);
	ActiveSkill manaGuard = new ActiveSkill("Mana Guard","shields are essential",50,"NONE",10);
    ActiveSkill energyBolt = new ActiveSkill("Energy Bolt","Pure energy hurts",50,"NONE",10);
    ActiveSkill reignOfIce = new ActiveSkill("Reign of Ice","Ice ice baby",50,"causes frozen status",10);
    ActiveSkill gravityCore = new ActiveSkill("Gravity Core","control gravity",50,"NONE",10);
    ActiveSkill explosion = new ActiveSkill("Explosion","more fire",50,"causes burn status",10);
    ActiveSkill meditate = new ActiveSkill("Meditate","too much causes hallucinations",50,"NONE",10);
    ActiveSkill waterNebula = new ActiveSkill("Water Nebula","Agua Novela",50,"NONE",10);
    ActiveSkill Runesave = new ActiveSkill("Runesave","No mp to give",50,"NONE",10);
    ActiveSkill forbiddenTomb = new ActiveSkill("Forbidden Tomb","For the enemies you really hate",50,"NONE",10);
    ActiveSkill rockCrush = new ActiveSkill("Rock Crush","Avalanche was not enough",50,"NONE",10);
    ActiveSkill deathRay = new ActiveSkill("Death Ray","why not",50,"causes instant death",1000);
    ActiveSkill TripleShot = new ActiveSkill("Triple Shot","Third times the charm",50,"NONE",10);
    ActiveSkill ScatterShot = new ActiveSkill("Scatter Shot","to make sure enenmies can't escape",50,"NONE",10);
    ActiveSkill Ricochet = new ActiveSkill("Ricochet","fire",50,"NONE",10);
    ActiveSkill PoisonArrow = new ActiveSkill("Poison Arrow","Poison a convenient answer",50,"causes poison status",10);
    ActiveSkill SpeedRun = new ActiveSkill("Speed Run","go fast",50,"raises speed",10);
    ActiveSkill RainofFire = new ActiveSkill("Rain of Fire","even more fire",50,"causes burn status",10);
    ActiveSkill Paralyzingshot = new ActiveSkill("Paralyzing Shot","fire at will",50,"causes paralysis",10);
    ActiveSkill SniperInstincts = new ActiveSkill("Sniper Instincts","hunter wasn't enough",50,"",10);
    ActiveSkill SuperFreezeArrow = new ActiveSkill("Super Freeze Arrow","fire wasn't the answer",50,"",10);
    ActiveSkill StickyBombs = new ActiveSkill("Sticky Bombs","no comment",50,"",10);
    ActiveSkill TotheShadows = new ActiveSkill("To the Shadow","really tempted to add Realm",50,"",10);
    ActiveSkill TripleTalonStrike = new ActiveSkill("Triple Talon Strike","Two talons wasn't enough",50,"",10);
    ActiveSkill Vulnerability = new ActiveSkill("Vulnerability","survival of the fittests or annihalation of the weak",50,"",10);
    ActiveSkill JavalinThrow = new ActiveSkill("Javalin","not made of mistletoe",50,"",10);
    ActiveSkill DragonStrike = new ActiveSkill("Dragon Strike","Blue Eyes Ultimate not ammused",50,"",10);
    ActiveSkill Strengthen = new ActiveSkill("Strengthen","too  much steroids",50,"",10);
    ActiveSkill GroundSmash = new ActiveSkill("Ground Smash","earthquake wasn't made",50,"",10);
    ActiveSkill SevenBladeDance = new ActiveSkill("Seven Blade Dance","Because 7 is clearly better than 1",50,"",10);
    ActiveSkill BodyGuard = new ActiveSkill("Body Guard","just hire one",50,"",10);
    ActiveSkill OnePunch = new ActiveSkill("One Punch","tempted to use Man",50,"",10);
    ActiveSkill RaijintoStrike = new ActiveSkill("Raijin to Strike","don't know what it is but use it",50,"",10);
    
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
