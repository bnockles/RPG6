package items;


public interface GetItem {
	
	public String getItemName();
	
	public String getItemDesc();
	
	public int getItemBuyPrice();
	
	public int getItemSellPrice();
	
	public boolean getBuyable();
}