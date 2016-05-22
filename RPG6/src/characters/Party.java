package characters;

import java.util.ArrayList;

public class Party {
	ArrayList<Hero> party;
	int partySize = 6;
	/**
	 * @param args
	 */
	public Party(Player player){
		party = new ArrayList<Hero>();
		party.add(player);	
	}	
		
	
	public void addMember(Hero hero){
		if(party.size() <= partySize){
			party.add(hero);
			hero.setX(party.get(party.size() - 2).getX());
			hero.setY(party.get(party.size() - 2).getY()-hero.getCharHeight());
		}
	}
	
	public void removeMember(Hero hero){
		party.remove(hero);
	}
	
	
}
