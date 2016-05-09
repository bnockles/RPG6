package items;

import java.util.ArrayList;

public class SkillList
{
	private ArrayList<ActiveSkill> skillList;
	
	public SkillList(ArrayList<ActiveSkill> alist){
		this.skillList = alist;
	}
	
	public ArrayList<ActiveSkill> getSkills(){
		return skillList;
	}
    
	
}
