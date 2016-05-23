package characters;

import java.util.ArrayList;

import items.Item;

public interface PlayerInfo {
	public int playerInventoryLength();
	public ArrayList<Item> getPlayerInventory();
}
