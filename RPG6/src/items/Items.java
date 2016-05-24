package items;

import java.util.HashMap;
import items.itemslist.*;

public final class Items {
	private static HashMap<String,Item> registry;
	
	static {
		registry = new HashMap<String,Item>();
	}
	

	public static void registerItem(Item it){
		if(itemRegistered(it.getId())){
			System.out.println("Warning: Failed to register item with id {" + it.getId() + "} because id already registered!");
			return;
		}
		
		Items.registry.put(it.getId(), it);
	}
	
	public static boolean itemRegistered(String id){
		return Items.registry.containsKey(id);
	}
	
	public static Item getItemById(String id){
		return Items.registry.get(id);
	}
	

	//special utility method to bulk register on start
	//put your item here after you define it to automatically register it
	//TODO: make sure registerBufferedItems is called on init.
	public static void registerBufferedItems(){
		//Quest Items
		new AngelFeather().register();
		
		//Equipment
		new BronzeSword().register();
		
		//Consumables
		new HP100().register();
		new HP500().register();
		new HP1000().register();
		
		new MP100().register();
		new MP500().register();
		new MP1000().register();
		
		new SpeedI().register();
		new SpeedII().register();
	}
}