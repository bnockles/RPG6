
public class RegularTreasure extends Treasure{
	int numMoney;
	public RegularTreasure(int type, int level, String description) {
		super(type, level, description);
		numMoney=0;
		getItems();
	}

	@Override
	public void getItems() {
		numMoney = (int)(Math.random()*level*30*(type+1));
	}

	public int getNumMoney() {
		return numMoney;
	}

}
