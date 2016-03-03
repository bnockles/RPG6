package towns;

import java.awt.event.KeyListener;

public abstract class AbstractNPC {

	public String name;
	public String description;
	public String gender;
	public boolean isTalkable;
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getGender() {
		return gender;
	}

	public boolean isTalkable() {
		return isTalkable; 
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setTalkable(boolean isTalkable) {
		this.isTalkable = isTalkable;
	}
	
	public AbstractNPC(String nm, String gen, String des, boolean talkable) {
		this.name=nm;
		this.gender=gen;
		this.description=des;
		this.isTalkable = talkable;
	}
	
	public abstract void npcMovement();
}
