package towns;

import java.util.ArrayList;

/**
 * 
 * @author Khandaker Shayel 
 *
 */

public class BlackSmith extends AbstractNPC implements ItemCraftable {

	static ArrayList<String> itemList = new ArrayList<String>();
	
	static Equipment[][] Recipe = 
	{			
			{equipStock.equipStocks(equipStock.B_SD), equipStock.equipStocks(equipStock.W_BW)}, //Iron Bow
			{equipStock.equipStocks(equipStock.M_WD), equipStock.equipStocks(equipStock.P_HR)}, //Mithril Hammer
			{equipStock.equipStocks(equipStock.B_SD), equipStock.equipStocks(equipStock.M_WD)}, //Spear of Destruction
			{equipStock.equipStocks(equipStock.W_BW), equipStock.equipStocks(equipStock.P_HR)}, //Diamond Bow
			{equipStock.equipStocks(equipStock.B_SD), equipStock.equipStocks(equipStock.P_HR)}  //Plat Sword
	};

	
	public BlackSmith(String nm, String gen, String des, boolean talkable) 
	{
		super(nm, gen, des, talkable);
		// TODO Auto-generated constructor stub
	}
	
	//checks through entire player inventory to see if the player needs repairs on any of the items or not
	public static boolean needRepairs(ArrayList<Equipment> inventory) 
	{
		int counter = 0;
		int size = inventory.size();
		for(int i=0; i<inventory.size();i++)
		{
			if(inventory.get(i).getDurability() == 100){
				counter++;
			}
		}
		if(counter == size)
		{
			return false;
		}
		return true;
	}
	
	// returns an arrayList of equipment for every item that needs repairing
	public static ArrayList<Equipment> addRepairList(ArrayList<Equipment> list){
		ArrayList<Equipment> repairItems = new ArrayList<Equipment>();
		for(int i=0; i<TownScreen.inventory.size();i++){
			if(TownScreen.inventory.get(i).getDurability()<100){
				repairItems.add(TownScreen.inventory.get(i));
			}	
		}
		
		return repairItems;
	}
	
	//sorts the equipment
	private static ArrayList<Equipment> sortRepairList(ArrayList<Equipment> repairItems) {
		ArrayList<Equipment> sortedItems = new ArrayList<Equipment>();
		int low = repairItems.get(0).getDurability();
		Equipment curr = repairItems.get(0);
			for(int j=0;j<repairItems.size();j++)
			{
				if(repairItems.get(j).getDurability()<low)
				{
					curr = repairItems.get(j);
					low = repairItems.get(j).getDurability();
				}
			}
		sortedItems.add(curr);
		return sortedItems;
	}

	//returns a string for the status of the item depending on what durability it has
	public static String durabilityMeter(Equipment item){
		if(item.getDurability() == 100){
			return "Repaired!";
		}
		if(item.getDurability() < 100 && item.getDurability() >= 75){
			return "Good!";
		}
		if(item.getDurability() < 75 && item.getDurability() >= 50){
			return "Decent.";
		}
		if(item.getDurability() < 50 && item.getDurability() >= 25){
			return "Okay.";
		}
		return "Critical!";
	}

	//calculates a cost to repair the item to full durability
	public static int getCostRepair(Equipment item)
	{
		int rarity = item.getRarity(item);
		int needFixing = 100 - (item.getDurability());
		
		return rarity*needFixing*15;
	}
	
	//repairs item
	public static void repair(Equipment item)
	{
		item.setDurability(100);
	}
	
	//IMPLEMENTED METHOD FROM ItemCraftable
	public boolean isDurable(Equipment item) 
	{
		if(item.getDurability() == 100)
		{
			return true;
		}
		return false;
	}
	
	//helper method for matchesRecipe, turns the array list of the player's inventory into an array
	private Equipment[] convertToArray(ArrayList<Equipment> playerInventory)
	{		
		Equipment[] equipArray = new Equipment[playerInventory.size()];
		equipArray = playerInventory.toArray(equipArray);
		return equipArray;
	}
	
	//IMPLEMENTED METHOD FROM ItemCraftable
	//looks through the players inventory to see if anything is craftable by going through the recipe 2d array and comparing the two
	public ArrayList<String> matchesRecipe(ArrayList<Equipment> playerInventory, Equipment[][] Recipe) 
	{
		ArrayList<String> craftableStuff = new ArrayList<String>();
		Equipment[] playerInventoryArr = convertToArray(playerInventory);
		int counter = 0;
		int rowIndex = 0;
		for(int k=0; k<Recipe.length;k++){
			for(int i=0; i<Recipe[rowIndex].length;i++){
				for(int j=0; j<playerInventoryArr.length;j++){
					if(playerInventoryArr[j].getName().equals(Recipe[rowIndex][i].getName()) && playerInventoryArr[j].getDurability()==100){
						System.out.println(Recipe[rowIndex][i].getName());
						counter++;
						System.out.println(counter);
					}
				}
				if(counter == Recipe[rowIndex].length){
					craftableStuff.add(craftedName(Recipe, rowIndex));
					System.out.println("true");
					System.out.println(craftedName(Recipe, rowIndex));
				}
			}
			counter = 0;
			rowIndex++;
		}
		System.out.println("RETURN STUFF");
		return craftableStuff;
	}
	
	////IMPLEMENTED METHOD FROM ItemCraftable
	//returns the name of the item whom the recipe belongs too for each row
	public String craftedName(Equipment[][] list, int itemRecipe) {
		if(itemRecipe == 0){
			return "Iron Bow";
		}
		if(itemRecipe == 1){
			return "Mithril Hammer";
		}
		if(itemRecipe == 2){
			return "Spear of Destruction";
		}
		if(itemRecipe == 3){
			return "Diamond Bow";
		}
		if(itemRecipe == 4){
			return "Plat Sword";
		}
		return null;
	}
	
	//returns an integer for the row of the crafting recipe
	public static int returnInt(String name) {
		if(name.equals("Iron Bow"))
		{
			return 0;
		}
		if(name.equals("Mithril Hammer"))
		{
			return 1;
		}
		if(name.equals("Spear of Destruction")){
			return 2;
		}
		if(name.equals("Diamond Bow")){
			return 3;
		}
		if(name.equals("Plat Sword")){
			return 4;
		}
		return 5;
	}


	@Override
	public void npcMovement() 
	{
		// TODO Auto-generated method stub
	}

	

	

	


}
