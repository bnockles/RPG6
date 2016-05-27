package Battles;

import java.util.ArrayList;

public class MapLoader {
	static ArrayList<String> maps = new ArrayList<String>();
	public MapLoader(ArrayList<String> mapNames){
		this.maps.addAll(mapNames);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static String returnMapName(int index){
		return maps.get(index);
	}
}
