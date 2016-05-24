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
			if(party.get(0).isFront()){
				hero.setX(party.get(party.size() - 2).getX());
				hero.setY(party.get(party.size() - 2).getY()-hero.getCharHeight());
				hero.setFront(true);
				hero.setBack(false);
				hero.setRight(false);
				hero.setLeft(false);		
			}
			if(party.get(0).isBack()){
				hero.setX(party.get(party.size() - 2).getX());
				hero.setY(party.get(party.size() - 2).getY()+hero.getCharHeight());
				hero.setFront(false);
				hero.setBack(true);
				hero.setRight(false);
				hero.setLeft(false);		
			}
			if(party.get(0).isRight()){
				hero.setX(party.get(party.size() - 2).getX() - 60);
				hero.setY(party.get(party.size() - 2).getY());
				hero.setFront(false);
				hero.setBack(false);
				hero.setRight(true);
				hero.setLeft(false);		
			}
			if(party.get(0).isLeft()){
				hero.setX(party.get(party.size() - 2).getX() + 60);
				hero.setY(party.get(party.size() - 2).getY());
				hero.setFront(false);
				hero.setBack(false);
				hero.setRight(false);
				hero.setLeft(true);		
			}
			
//			hero.setFront(party.get(0).isFront());
//			hero.setBack(party.get(0).isBack());
//			hero.setRight(party.get(0).isRight());
//			hero.setLeft(party.get(0).isLeft());
		}
	}
	
	public void removeMember(Hero hero){
		party.remove(hero);
	}
	
	
}
