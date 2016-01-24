package sampleoverworld;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import directors.Animated;
import directors.Game;
import directors.Screen;
import directors.UtilityMethods;

public class OverworldScreen extends Screen implements KeyListener, Animated{

	BufferedImage[][] backgroundGrid;
	BufferedImage[][] obstacleGrid;
	BufferedImage[][] foregroundGrid;
	int gridColumns;
	int gridRows;
	
	
	int currentRow;//index of the cell currently showing
	int currentColumn;//index of the cell currently showing
	
	int entranceRow;//the index of the cell where a character always enters from
	int entraceColumn;
	int entranceX;//exact location on the cell where the entrance is
	int entranceY;
	
	public static final int MOVE_UNIT = 6;
	ArrayList<Integer> pressedKeys;
	OverworldWanderer sprite;
	int spriteX;
	int spriteY;
	
	int mapTileWidth = 1024;
	int mapTileHeight = 720;
	
	/**
	 * 
	 * @param game
	 * @param sprite 
	 * @param folder name of folder where image files are found within "overwolrd" directory
	 * @param area name of area (file name) all files followconvention areabackr-c.png, areaforer-c.png, areaobsr-c.bmp,
	 * @param gridWidth
	 * @param gridHeight
	 */
	public OverworldScreen(Game game, OverworldWanderer sprite, String folder, String area, int gridWidth, int gridHeight, int enterR, int enterC, int enterX, int enterY) {
		super(game);
		this.gridColumns=gridWidth;
		this.gridRows=gridHeight;
		backgroundGrid = new BufferedImage[gridHeight][gridWidth];
		obstacleGrid = new BufferedImage[gridHeight][gridWidth];
		foregroundGrid = new BufferedImage[gridHeight][gridWidth];
		for(int r=0; r<gridHeight; r++){
			for(int c=0; c< gridWidth; c++){
				try {
					obstacleGrid[r][c]=UtilityMethods.getImageFromFile(this, "/overworld/"+folder+"/"+area+"obs"+r+"-"+c+".bmp");
					backgroundGrid[r][c]=UtilityMethods.getImageFromFile(this, "/overworld/"+folder+"/"+area+"back"+r+"-"+c+".png");
					foregroundGrid[r][c]=UtilityMethods.getImageFromFile(this, "/overworld/"+folder+"/"+area+"fore"+r+"-"+c+".png");
				} catch (IOException e) {
					obstacleGrid[r][c]=new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
					backgroundGrid[r][c]=new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
					foregroundGrid[r][c]=new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
					e.printStackTrace();
				}
			}
		}
		currentRow=enterR;
		currentColumn=enterC;
		spriteX=enterX;
		spriteY=enterY;
		this.sprite=sprite;
		pressedKeys= new ArrayList<Integer>();
	}

	

	@Override
	public void paintScreen(Graphics2D g2) {
		int x = determineOffset(width, currentColumn, spriteX, gridColumns);
		int y = determineOffset(height, currentRow, spriteY, gridRows);
		
		//draw background
		g2.drawImage(backgroundGrid[currentRow][currentColumn], x, y, null);
		if(x<0){
			g2.drawImage(backgroundGrid[currentRow][currentColumn+1], x+mapTileWidth, y, null);
		}
		if(x>0){
			g2.drawImage(backgroundGrid[currentRow][currentColumn-1], x-mapTileWidth, y, null);
		}
		if(y<0){
			g2.drawImage(backgroundGrid[currentRow+1][currentColumn], x, y+mapTileHeight, null);
		}
		if(y>0){
			g2.drawImage(backgroundGrid[currentRow][currentColumn-1], x, y - mapTileHeight, null);
		}
		//diagonal corners
		if(x<0 && y<0 && currentRow < gridRows-1 && currentColumn < gridRows - 1){
			g2.drawImage(backgroundGrid[currentRow+1][currentColumn+1], x+mapTileWidth, y+mapTileHeight, null);
		}
		if(x>0 && y<0 && currentRow < gridRows-1 && currentColumn > 0){
			g2.drawImage(backgroundGrid[currentRow+1][currentColumn-1], x-mapTileWidth, y+mapTileHeight, null);
		}
		if(x<0 && y>0 && currentRow > 0 && currentColumn < gridRows - 1){
			g2.drawImage(backgroundGrid[currentRow-1][currentColumn+1], x+mapTileWidth, y+-mapTileHeight, null);
		}
		if(x>0 && y>0 && currentRow > 0 && currentColumn > 0){
			g2.drawImage(backgroundGrid[currentRow-1][currentColumn-1], x-mapTileWidth, y+-mapTileHeight, null);
		}
		
		//draws sprite
		int spriteDrawX=spriteX;
		if(x!=0)spriteDrawX=width/2;
		int spriteDrawY=spriteY;
		if(y!=0)spriteDrawY=height/2;
		g2.drawImage(sprite.getImage(),spriteDrawX,spriteDrawY,null);
		
		//draw foreground
		g2.drawImage(foregroundGrid[currentRow][currentColumn], x, y, null);
	}

	private int determineOffset(int widthOrHeight, int currentColumnOrRow, int xOrY, int gridColumnsorRows) {
		int offset = 0;
		//if sprite is left of center, offset compensates right, assuming adjacent cell
		if(xOrY < widthOrHeight/2 && currentColumnOrRow > 0){
			offset = widthOrHeight/2 - xOrY;
		}
		//if sprite is right of center, offset compensates left, assuming adjacent cell
		if(xOrY > widthOrHeight/2 && currentColumnOrRow < gridColumnsorRows-1){
			offset = xOrY - widthOrHeight/2;
		}
		return offset;
	}



	public void update(){
		Graphics2D g2 = (Graphics2D) screenImage.getGraphics();
		g2.setColor(Color.black);
		g2.fillRect(0, 0, width, height);
		checkMotion();
		sprite.increaseCount();
		paintScreen(g2);
	}
	
	public KeyListener getKeyListener() {
		return this;
	}

	private void checkMotion() {
		int proposedNewY=spriteY;
		int proposedNewX=spriteX;
		
		if(pressedKeys.contains(KeyEvent.VK_UP) && !pressedKeys.contains(KeyEvent.VK_DOWN)) proposedNewY-=MOVE_UNIT;
		if(!pressedKeys.contains(KeyEvent.VK_UP) && pressedKeys.contains(KeyEvent.VK_DOWN)) proposedNewY+=MOVE_UNIT;
		if(pressedKeys.contains(KeyEvent.VK_RIGHT) && !pressedKeys.contains(KeyEvent.VK_LEFT)) proposedNewX+=MOVE_UNIT;
		
		if(!pressedKeys.contains(KeyEvent.VK_RIGHT) && pressedKeys.contains(KeyEvent.VK_LEFT)) proposedNewX-=MOVE_UNIT;
		
		checkCollisionOrOutOfBounds(proposedNewX, proposedNewY);
		
	}



	private void  checkCollisionOrOutOfBounds(int proposedNewX, int proposedNewY) {
		boolean moves = true;
		
		//check if movement is beyond x boundary
		if(proposedNewX > mapTileWidth){
			if(currentColumn == gridColumns-1) moves = false;
			else{
				currentColumn++;
				proposedNewX-=mapTileWidth;
			}
		}
		if(proposedNewX < 0){
			if(currentColumn == 0) moves = false;
			else{
				currentColumn--;
				proposedNewX+=mapTileWidth;
			}
		}
		if(proposedNewY > mapTileHeight){
			if(currentRow == gridRows-1) moves = false;
			else{
				currentRow++;
				proposedNewY-=mapTileHeight;
			}
		}
		if(proposedNewY < 0){
			if(currentRow == 0) moves = false;
			else{
				currentColumn--;
				proposedNewX+=mapTileWidth;
			}
		}
		int clr=  obstacleGrid[currentRow][currentColumn].getRGB(100,40); 
		int  red   = (clr & 0x00ff0000) >> 16;
		int  green = (clr & 0x0000ff00) >> 8;
		int  blue  =  clr & 0x000000ff;
		if(red>200 && green > 200 && blue>200)moves = false;
		
		if(moves){
			spriteY=(proposedNewY);
			spriteX=(proposedNewX);
		}
	}



	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
			if(!pressedKeys.contains(keyCode))pressedKeys.add(keyCode);
		}
		if(!pressedKeys.isEmpty()){
			sprite.setWalking(true);
		}
	}

	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
			pressedKeys.remove(pressedKeys.indexOf(keyCode));
		}
		if(pressedKeys.isEmpty())sprite.setWalking(false);
	}

}
