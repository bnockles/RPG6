package characters;

public class SamplePotion implements Consumable{
	
	public String c;
	public SamplePotion(String title,String description){
		 c=title ;
	}
	
	//Ex. Getter
	public String getTitle(){
		return this.c;
	}
}