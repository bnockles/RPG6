package sampleoverworld;

public interface Navigatable {
	
	//checks if the location at x, y is accessible (returns false if location is water, edge of cliff, etc)
	public boolean isCollision(int x, int y);
}
