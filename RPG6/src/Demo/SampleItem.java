package Demo;

import java.util.ArrayList;

/**
 * @author Mr. Nockles
 * I made this for my demo. This is bare bones!
 *
 */
public class SampleItem {

	ArrayList<ItemI> items;
	public String name;
	
	//by not making getters and setters and making these variables public,
	//they are automatically read AND write! You might choose not to do this

	
	//examples of how to add variety

	
	
	
	/**
	 * 
	 */
	public SampleItem(int number, ArrayList<ItemI> items) {
		name = "enemy"+number;
		this.items=items;
		
	}
	

	
	public SampleItem(String name, ArrayList<ItemI> items) {
		this.name=name;
		this.items=items;
		
	}
	
	//the following method will most likely be
	//something required by the Battles team. It is likely they will 
	//require a method for taking a turn in a battle
	
	public void selectItem(){
		//Try to make it so it's selectable
		//int itemSelection = 0;
		int itemSelection = (int) (Math.random()*items.size());
		items.get(itemSelection).castOn(this);
	}

}