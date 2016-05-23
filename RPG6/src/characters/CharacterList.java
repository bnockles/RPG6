package characters;

import java.util.ArrayList;

public class CharacterList {
	ArrayList<Character> characters;
	
	public CharacterList(){
		characters = new ArrayList<Character>();
	}
	
	public void addCharacter(Character character){
		characters.add(character);
	}
	
	public void removeCharacter(Character character){
		characters.remove(character);
	}
}
