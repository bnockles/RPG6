package items;

public class SkillStock {
	//Active Skills
	//Mage skills
	public static final int FB = 0;
	public static final int EB = 1;
	
	public static final int ROI = 2;
	public static final int GC = 3;
	public static final int E = 4;
	public static final int WN = 5;
	public static final int LS = 5;
	
	public static final int FT = 6;
	public static final int RC = 7;
	public static final int DR = 8;
	public static final int CF = 9;
	
	//Bowman skills
	public static final int TS = 10;
	public static final int SS = 11;
	public static final int PA = 12;
	public static final int C = 13;
	
	public static final int ROF = 14;
	public static final int PS = 15;
	public static final int R = 16;
	public static final int PW = 17;
	
	public static final int SFA = 18;
	public static final int SB = 19;
	public static final int TTS = 20;
	public static final int FOTS = 21;
	public static final int HR = 22;
	public static final int CB = 23;
	
	//Warrior skills
	public static final int V = 24;
	public static final int JT = 25;
	
	public static final int DS = 26;
	public static final int GS = 27;
	public static final int PB  = 28;
	public static final int LR = 29;
	public static final int BS = 30;
	
	public static final int SBD = 40;
	public static final int BG = 41;
	public static final int OP = 42;
	public static final int RS = 43;
	public static final int ER = 44;
	public static final int ROTR = 45;
	public static final int BSA = 46;
	
	//Rogue skills
	public static final int BST = 47;
	public static final int DJ = 48;
	public static final int TT = 49;
	
	public static final int SST = 50;
	public static final int IA = 51;
	public static final int FK = 52;
	public static final int EC = 53;
	public static final int RF = 54;
	
	public static final int SP = 55;
	public static final int BA = 56;
	public static final int BB = 57;
	public static final int CR = 58;
	public static final int I = 59;
	public static final int TTSK = 60;
	public static final int RON = 61;
	
	//Priest
	public static final int HB = 62;
	public static final int H = 63;
	public static final int B = 64;
	
	public static final int COH = 65;
	public static final int A = 66;
	public static final int AR = 67;
	public static final int VN = 68;
	public static final int COL = 69;
	
	public static final int LB = 70;
	public static final int AM = 71;
	public static final int ENC = 72;
	public static final int SA = 73;
	public static final int P = 74;
	public static final int GA = 75;
	public static final int HJ = 76;
	public static final int GR = 77;
	
	//Passive List
	public static final int MW = 0;
	public static final int M = 1;
	public static final int SI =2;
	public static final int IW = 3;
	public static final int S = 4;
	public static final int EV = 5;
	public static final int SNB = 6;
	public static final int SE = 7;
	
	
	public static ActiveSkill activeSkillStock(int type) {
		if(type == FB) return new ActiveSkill("Fireblast","Throws a Fireball at an enemy.",50,10);
		if(type == EB) return new ActiveSkill("Energy Bolt","Fires a bolt of energy at an enemy.",50,10);
		
		if(type == ROI) return new ActiveSkill("Reign of Ice","Creates an ice field that slows all enemies and deals damage per turn.",100,25);
		if(type == GC) return new ActiveSkill("Gravity Core","Creates a gravity ball behind the enemy that slows down enemies. After 3 turns, it explodes and deals damage.",50,10);
		if(type == E) return new ActiveSkill("Explosion","Magic that creates an explosion on an enemy.",50,10);
		if(type == WN) return new ActiveSkill("Water Nebula","Creates a water core that shoots both attacks and heals randomly. It lasts 5 turns and shoots one bolt per turn at the lowest hp target on one side. Example: If healing is chosen, it will heal the lowest target on your team. If attack is chosen, it will hit the lowest target on the enemy team.",50,10);
		if(type == LS) return new ActiveSkill("Lightning Strike","Throws a Fireball at an enemy.",50,10);
		
		if(type == FT) return new ActiveSkill("Forbidden Tomb","Encages an enemy in a tomb. Deals damage per turn for 3 turns. Enemies have a chance to break out each turn.",50,10);
		if(type == RC) return new ActiveSkill("Rock Crush","Crushes an enemy with a massive rock.",50,10);
		if(type == DR) return new ActiveSkill("Death Ray","Shoots a ray of energy at an enemy.",50,10);
		if(type == CF) return new ActiveSkill("Cyro Freeze","Deals damage and has a chance to completely freeze an enemy for one turn. Half the chance for bosses.",50,10);
		if(type == CF) return new ActiveSkill("Pyroclasm","Creates destructive fire power to burn down an enemy.",50,10);
		
		if(type == TS) return new ActiveSkill("Triple Shot","Shoots three arrows at an enemy.",50,10);
		if(type == SS) return new ActiveSkill("Scatter Shot","Shoot an arrow at an enemy that scatters to hit other enemies. Scattered shots deal half the damage.",50,10);
		if(type == PA) return new ActiveSkill("Poison Arrow","Shoots a deadly arrow at an enemy.",50,10);
		if(type == C) return new ActiveSkill("Critical","Shoots an arrow that targets critical spots. Guarentee crit damage.",50,10);
		
		if(type == ROF) return new ActiveSkill("Rain of Fire","Shoots fire arrows into the sky to rain down on all enemies.",50,10);
		if(type == PS) return new ActiveSkill("Paralyzing Shot","Shoots a shot that disables an enemy to take action for a turn. Does not work on bosses.",50,10);
		if(type == R) return new ActiveSkill("Ricochet","Shoots a bomb arrow that bounces off enemies up to 3 times.",50,10);
		if(type == PW) return new ActiveSkill("Piercing Winds","Calls on the power of the wind to attack all enemies. Has a chance to lower enemies speed.",50,10);
		
		if(type == SFA) return new ActiveSkill("Super Freeze Arrow","Deals damage and freezes an enemy for one turn.",50,10);
		if(type == SB) return new ActiveSkill("Sticky Bombs","Attaches bombs that will explode in 3 turns.",50,10);
		if(type == TTS)
		if(type == FOTS) return new ActiveSkill("Fate of the Stars","Shoots an arrow into the stars. Depending on what sign is chosen, an action will occur.",50,10);
		if(type == HR) return new ActiveSkill("Helix Rockets","Shoots three rockets to massively damage an enemy.",50,10);
		if(type == CB) return new ActiveSkill("Concussive Blow","Deals damage to an enemy. If used right before sticky bombs explode, it will instantly blow up the bombs and also double the damage of this skill.",50,10);
		
		if(type == V) return new ActiveSkill("Vulnerability","Targets the weak points of your enemies. Lowers their defense.",50,10);
		if(type == JT) return new ActiveSkill("Javalin Throw","Tosses a far ranged attack that pierces one enemy.",50,10);
		
		if(type == DS) return new ActiveSkill("Dragon Strike","Summons the power of the dragon to strike down an enemy.",50,10);
		if(type == GS) return new ActiveSkill("Ground Smash","Smashes the ground and damaged all enemies.",50,10);
		if(type == PB) return new ActiveSkill("Pulse Bomb","Throws a Fireball at an enemy.",50,10);
		if(type == LR) 
		if(type == BS) return new ActiveSkill("Body Slam","Throws a Fireball at an enemy.",50,10);
		
		if(type == SBD) return new ActiveSkill("Seven Blade Dance","Throws a Fireball at an enemy.",50,10);
		if(type == BG) 
		if(type == OP) return new ActiveSkill("One Punch","Destructive blow that can guarentee a K.O.",50,10);
		if(type == RS) return new ActiveSkill("Raijinto Strike","Charges lightning on your weapon and deals massive damage. Has a chance to stun the enemy.",50,10);
		if(type == ER) return new ActiveSkill("Eruption","Calls on the power of the earth to rupture upon all enemies.",50,10);
		if(type == ROTR) return new ActiveSkill("Roar of the Dragons","The roar of a dragon that damages the enemies slightly and make them cower in fear, decreasing both their attack and speed.",50,10);
		if(type == BSA)
		
		if(type == BST) return new ActiveSkill("Backstab","Throws a Fireball at an enemy.",50,10);
		if(type == DJ) return new ActiveSkill("Double Jab","Attacks an enemy twice in one turn.",50,10);
		if(type == TT) return new ActiveSkill("Triple Throw","Attacks 3 enemies with shurikens.",50,10);
		
		if(type == SST) return new ActiveSkill("Swift Strike","You always attack first. If this kills an enemy, gain permanent speed for that round.",50,10);
		if(type == IA) return new ActiveSkill("Instant Agility ","Increases speed for the entire battle.",50,10);//must do buffs ask wilson when he's here
		if(type == FK) return new ActiveSkill("Fan of Knives","Throws lots of knives that attack all enemies.",50,10);
		if(type == EC) return new ActiveSkill("Explosive Charge","Places an explosive on an enemy that blows up after 5 turns. If it can charge 5 turns, the explosive will do massive damage. The enemy can stop the bomb.",50,10);
		if(type == RF) return new ActiveSkill("Reflection","Uses your dagger to deflect some damage. Half the damage is deflected to the attacker.",50,10);
		
		if(type == SP) return new ActiveSkill("Shadow Play","Calls on the power of the shadows. Allows you to attack twice per turn.",50,10);
		if(type == BA) return new ActiveSkill("Bombs Away","Throws a huge bomb that attacks all enemies with massive damage.",50,10);
		if(type == BB) return new ActiveSkill("Bouncing Bombs","Throws a bomb that bounces through all enemies. The bounce stops bouncing when it hits an enemy with less than 60% damage.",50,10);
		if(type == CR) return new ActiveSkill("Charm Replacement","Places a charm down that will change place with you when attacked. The attacker will take damage from the charm.",50,10);
		if(type == I) return new ActiveSkill("Impact","Puts an explosive on an enemy that instantly blows up to do impactful damage.",50,10);
		if(type == TTSK) return new ActiveSkill("Ten Thousand Shurikens","Calls upons billions of shurikens that attack all enemies.",50,10);
		if(type == RON) return new ActiveSkill("Raid of Ninjas","Calls on various different ninjas to help you attack enemies. Attacking one enemy will multiply your damage.",50,10);
		
		if(type == HB) return new ActiveSkill("Holy Bolt","Shoots a bolt of holy light.",50,10);
		if(type == H) return new ActiveSkill("Heal","Heal an ally.",50,10);
		if(type == B) return new ActiveSkill("Barrier","Puts a barrier on an ally that absorbs damage.",50,10);
		
		if(type == COH) return new ActiveSkill("Circle of Healing","Creates a circle of healing thay heals allies every turn.",50,10);
		if(type == A) return new ActiveSkill("Armor","Throws lots of knives that attack all enemies.",50,10);
		if(type == AR) return new ActiveSkill("Angel's Ray","Calls upon the light of an angel to shine on an enemy.",50,10);
		if(type == VN) return new ActiveSkill("Vernier","Increases SPD of all allies.",50,10);
		if(type == COL) return new ActiveSkill("Chain of Lightning","Fires lightning at an enemy that chains to up to 2 enemies. All enemies take the same damage.",50,10);
		
		if(type == LB) return new ActiveSkill("Light Burst","Calls down immense light that strikes all enemies.",50,10);
		if(type == AM) return new ActiveSkill("Arms","Increases ATK of all allies.",50,10);
		if(type == ENC) return new ActiveSkill("Encouragement","When in battle, has a chance to increase allies crit chance and crit damage.",50,10);
		if(type == SA) return new ActiveSkill("Shining Array","Shoots arrays of light particles to attack up to 3 enemies.",50,10);
		if(type == P) return new ActiveSkill("Purification","Instantly restores all HP of 2 allies.",50,10);
		if(type == GA) return new ActiveSkill("Guardian Angel","Ressurects an ally.",50,10);
		if(type == HJ) return new ActiveSkill("Heaven's Judgement","Allows the Heavens to judge a target. Depending on the target, various effects can happen.",50,10);
		if(type == GR) return new ActiveSkill("Goddess's Realm","Changes the region into the sky realm. All allies can benefits and all enemies take damage every turn.",50,10);
		
		return null;
	}
	
//	public static PassiveSkill passiveSkillStock(int type){
//		if(type == MW) return new PassiveSkill("Magician's Will", "Passively increases MAX Mana and INT.", type, type, null, null);
//		if(type == M) return new PassiveSkill("Meditate", "Passively increases INT.", type, type, null, null);
//		if(type == SI) return new PassiveSkill("Magician's Will", "Passively increases MAX Mana and INT.", type, type, null, null);
//		if(type == IW) return new PassiveSkill("Magician's Will", "Passively increases MAX Mana and INT.", type, type, null, null);
//		if(type == S) return new PassiveSkill("Magician's Will", "Passively increases MAX Mana and INT.", type, type, null, null);
//		if(type == EV) return new PassiveSkill("Magician's Will", "Passively increases MAX Mana and INT.", type, type, null, null);
//		if(type == SNB) return new PassiveSkill("Magician's Will", "Passively increases MAX Mana and INT.", type, type, null, null);
//		if(type == SE) return new PassiveSkill("Magician's Will", "Passively increases MAX Mana and INT.", type, type, null, null);
//		
//		return null;
//	}
	
	

}