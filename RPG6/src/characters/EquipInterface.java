package characters;

import items.Stats;

public interface EquipInterface {
	
	public String getItemName();//Use this for "wearable" and "wieldable"
	public Stats getAllStats();
	public int getArmorType();
	
}