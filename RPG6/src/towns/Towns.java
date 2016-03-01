package towns;

public abstract class Towns {
	public boolean townIsBig = false;
	public TownScreen screen;
	public AbstractNPC merchant;
	public AbstractNPC storage;
	public AbstractNPC minigame;
	
	public Towns(TownScreen screen, AbstractNPC merchant, 
			AbstractNPC storage, AbstractNPC minigame, boolean townIsBig){
		this.townIsBig = townIsBig;
		this.screen = screen;
		this.merchant = merchant;
		this.storage = storage;
		this.minigame = minigame;
	}
	
}
