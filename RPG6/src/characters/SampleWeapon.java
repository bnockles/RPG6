package characters;

public class SampleWeapon implements Wieldable{
	
	public static String d;
	public SampleWeapon(String title,String description){
		 d = title ;
	}
	
	//Ex. Getter
	public String getTitle(){
		return this.d;
	}
}
