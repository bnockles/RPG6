package characters;

public class SampleAccesory implements Equipable{

	public String a;
	public SampleAccesory(String title,String description){
		 a =title ;
	}
	
	//Ex. Getter
	public String getTitle(){
		return this.a;
	}
	
	//Ex. Setter
	public void setTitle(String title){
		this.a=title;
	}
}
