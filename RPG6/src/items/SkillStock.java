package items;

public class SkillStock {
	
	public static final int FB = 1;
	public static final int MG = 2;
	public static final int EB = 3;
	public static final int ROI = 4;
	public static final int GCR = 5;
	public static final int EX = 6;
	public static final int M = 7;
	public static final int WN = 8;
	public static final int RS = 9;
	public static final int FT = 10;
	public static final int RC = 11;
	public static final int DR = 12;
	public static final int TS = 13;
	public static final int SS = 14;
	public static final int R = 15;
	public static final int PA = 16;
	public static final int SR = 17;
	public static final int ROF = 18;
	public static final int PS = 19;
	public static final int SI = 20;
	public static final int SFA = 21;
	public static final int SB = 22;
	public static final int TTS = 23;
	public static final int TrTS = 24;
	public static final int V = 25;
	public static final int JT = 26;
	public static final int DS = 27;
	public static final int S = 28;
	public static final int GS = 29;
	public static final int SBD = 30;
	public static final int BG = 31;
	public static final int OP = 32;
	public static final int RTS = 33;
	
	public static ActiveSkill skillStock(int type) {
		if (type == FB){
			return new ActiveSkill("Fireblast","fire fixes everything",50,"causes burn status",10);
		}
		if (type == MG){
			return new ActiveSkill("Mana Guard","shields are essential",50,"NONE",10);
		}
		if (type == EB){
			return new ActiveSkill("Energy Bolt","Pure energy hurts",50,"NONE",10);
		}
		if (type == ROI){
			return new ActiveSkill("Reign of Ice","Ice ice baby",50,"causes frozen status",10);
		}
		if (type == GCR){
			return new ActiveSkill("Gravity Core","control gravity",50,"NONE",10);
		}
		if (type == EX){
			return new ActiveSkill("Explosion","more fire",50,"causes burn status",10);
		}
		if (type == M){
			return new ActiveSkill("Meditate","too much causes hallucinations",50,"NONE",10);
		}
		if (type == WN){
			return new ActiveSkill("Water Nebula","Agua Novela",50,"NONE",10);
		}
		if (type == RS){
			return new ActiveSkill("Runesave","No mp to give",50,"NONE",10);
		}
		if (type == FT){
			return new ActiveSkill("Forbidden Tomb","For the enemies you really hate",50,"NONE",10);
		}
		if (type == RC){
			return new ActiveSkill("Rock Crush","Avalanche was not enough",50,"NONE",10);
		}
		if (type == DR){
			return new ActiveSkill("Death Ray","why not",50,"causes instant death",1000);
		}
		if (type == TS){
			return new ActiveSkill("Triple Shot","Third times the charm",50,"NONE",10);
		}
		if (type == SS){
			return new ActiveSkill("Scatter Shot","to make sure enenmies can't escape",50,"NONE",10);
		}
		if (type == R){
			return new ActiveSkill("Ricochet","fire",50,"NONE",10);
		}
		if (type == PA){
			return new ActiveSkill("Poison Arrow","Poison a convenient answer",50,"causes poison status",10);
		}
		if (type == SR){
			return new ActiveSkill("Speed Run","go fast",50,"raises speed",10);
		}
		if (type == ROF){
			return new ActiveSkill("Rain of Fire","even more fire",50,"causes burn status",10);
		}
		if (type == PS){
			return new ActiveSkill("Paralyzing Shot","fire at will",50,"causes paralysis",10);
		}
		if (type == SI){
			return new ActiveSkill("Sniper Instincts","hunter wasn't enough",50,"",10);
		}
		if (type == SFA){
			return new ActiveSkill("Super Freeze Arrow","fire wasn't the answer",50,"",10);
		}
		if (type == SB){
			return new ActiveSkill("Sticky Bombs","no comment",50,"",10);
		}
		if (type == TTS){
			return new ActiveSkill("To the Shadow","really tempted to add Realm",50,"",10);
		}
		if (type == TrTS){
			return new ActiveSkill("Triple Talon Strike","Two talons wasn't enough",50,"",10);
		}
		if (type == V){
			return new ActiveSkill("Vulnerability","survival of the fittests or annihalation of the weak",50,"",10);
		}
		if (type == JT){
			return new ActiveSkill("Javalin","not made of mistletoe",50,"",10);
		}
		if (type == DS){
			return new ActiveSkill("Dragon Strike","Blue Eyes Ultimate not amused",50,"",10);
		}
		if (type == S){
			return new ActiveSkill("Strengthen","too  much steroids",50,"",10);
		}
		if (type == GS){
			return new ActiveSkill("Ground Smash","earthquake wasn't made",50,"",10);
		}
		if (type == SBD){
			return new ActiveSkill("Seven Blade Dance","Because 7 is clearly better than 1",50,"",10);
		}
		if (type == BG){
			return new ActiveSkill("Body Guard","just hire one",50,"",10);
		}
		if (type == OP){
			return new ActiveSkill("One Punch","tempted to use Man",50,"",10);
		}
		if (type == RTS){
			return new ActiveSkill("Raijin to Strike","don't know what it is but use it",50,"",10);
		}
		return null;
	}

}
