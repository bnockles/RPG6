package towns;

import java.util.ArrayList;

public class BlackSmith extends AbstractNPC {

	static ArrayList<String> itemList = new ArrayList<String>();
	
	public BlackSmith(String nm, String gen, String des, boolean talkable) 
	{
		super(nm, gen, des, talkable);
		// TODO Auto-generated constructor stub
	}

	//calculates a cost to repair the item to full durability
	public static int getCostRepair(String item)
	{
		return 0;
	}
	
	public static void sortEquipment(ArrayList<String> items)
	{
		itemList = items;
	}
	
	//repairs item
	public static void repair(String item)
	{
		  
	}

	@Override
	public void npcMovement() 
	{
		// TODO Auto-generated method stub
	}

}
