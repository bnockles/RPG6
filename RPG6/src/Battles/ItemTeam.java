package Battles;

public interface ItemTeam {

	public String getItemInfo();//Description of the item
	public String getItemType();//What does this do increase HP?/attackPower?/etc.
	public boolean getIsUsableForBattle();//Can battles use this?
	public int getChangeValue();//Returns the the amount you want this item to change
}
