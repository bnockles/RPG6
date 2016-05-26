import items.Equipment;
import items.equipStock;

public class RareTreasure extends Treasure{
	int numMoney;
	equipStock x;
	Equipment equip;
	public RareTreasure(int type,int level,String description) {
		super(type,level,description);
		equipStock x = new equipStock();
		getItems();
	}

	@Override
	public void getItems(){
		numMoney = (int)(Math.random()*level*30*type)+300;
		equip = x.equipStocks((int)(Math.random()*level));
	}

	public Equipment getEquip(){
		return equip;
	}

	public int getNumMoney() {
		return numMoney;
	}
}
