package towns;

/**
 * 
 * @author Khandaker Shayel  
 *
 */

public class townStock {
	public static final int PelletTown = 0;
	public static final int BigRootTown = 1;
	public static final int OldYelpTown = 2;
	
	public static towns getTown(int town){
		if (town == BigRootTown){
			return new towns(TownScreen.town1Npc, "Big Root Town");	
		}
		else if (town == OldYelpTown){
			return new towns(TownScreen.town2Npc, "Old Yelp Town");
		}
		else{
			return new towns(TownScreen.town3Npc, "Pellet Town");
		}
	}

}
