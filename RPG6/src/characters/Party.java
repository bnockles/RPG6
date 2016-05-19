package characters;

import java.util.ArrayList;

public class Party {
	ArrayList<Hero> party;
	int[] xCoords;
	int[] yCoords;
	int partySize = 6;
	/**
	 * @param args
	 */
	public Party(Player player){
		party = new ArrayList<Hero>();
		xCoords = new int[partySize];
		yCoords = new int[partySize];
		party.add(player);	
	}	
		
	
	public void addMember(Hero hero){
		if(party.size() <= partySize){
			party.add(hero);
			
		}
	}
	
	public void removeMember(Hero hero){
		party.remove(hero);
	}
	
	
}
