package items;

public interface battleSkillInterface {
	
	public String getSkillInfo();//Gets name + description of the skill.
	public int getSkillDamage();//How much damage does it do before any stat boosts?
	public int getSkillCost();//How much mana does this skill cost?
	public boolean isUsable();//Is it usable in battles (if it's active or passive skill)
//	public boolean statBoost();//If isUsable is false, that means it's a passive skill. So how will you write out the implementation of it (I have this already technically)

}
