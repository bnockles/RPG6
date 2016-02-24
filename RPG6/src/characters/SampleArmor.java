package characters;

public class SampleArmor implements Equipable{
	
	public String b;
	
	
	public SampleArmor(String title,String description){
		 b=title ;
	}
	
	//Ex. Getter
	public String getTitle(){
		return this.b;
	}
	
}


