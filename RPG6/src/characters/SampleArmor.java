package characters;

public class SampleArmor implements Equipable{
	
	public static String b;
	
	
	public SampleArmor(String title,String description){
		 b=title ;
	}
	
	//Ex. Getter
	public String getTitle(){
		return this.b;
	}
	
}


