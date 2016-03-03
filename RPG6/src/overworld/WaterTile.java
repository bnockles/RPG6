package overworld;

public class WaterTile extends Tile{

	public WaterTile(int id) {
		super(Assets.water, id);
	}

	public boolean isWalkable(){
		return true;
	}
}
