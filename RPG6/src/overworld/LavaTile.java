package overworld;

public class LavaTile extends Tile{

	public LavaTile(int id) {
		super(Assets.lava, id);
	}

	public boolean isWalkable(){
		return true;
	}
}
