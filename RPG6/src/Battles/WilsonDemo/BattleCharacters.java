package Battles.WilsonDemo;

import java.util.ArrayList;

public interface BattleCharacters {
	
	public String getName();
	
	public int getHp();
	
	public int getCurrHp();
	
	public int getMp();
	
	public int getCurrMp();
	
	public int getAttack();
	
	public int getDefense();
	
	public int getStrength();
	
	public int getSpeed();
	
	public int getDexterity();
	
	public int getIntelligence();
	
	public int getWisdom();
	
	public int getLuck();
	
	public int getCurrExp();
	
	public int getExpNeededToLevel();
	
	public ArrayList<Item> getInventory();
	
	public ArrayList<Skill> getSkills();
	
	public void flee();
	
	public String getImageFilepath();
	
	public void updateCharacterInfo(int currHp, int currMp, int exp);
	
}