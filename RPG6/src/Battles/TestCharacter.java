	package Battles;

	import java.awt.Graphics2D;
	import java.awt.image.BufferedImage;
	import java.io.IOException;
	import java.net.URL;
	import java.util.ArrayList;

	import javax.imageio.ImageIO;

	public class TestCharacter {
	    String title;
	    int currentHP = 100;
	    int totalHP = 100;

	    
	    BufferedImage img = null;
	    
	    ArrayList<String> meleeMoves = new ArrayList<String>();
	    ArrayList<String> spellMoves = new ArrayList<String>();
	    ArrayList<Integer>stats = new ArrayList<Integer>();
	    
	    BufferedImage image;
	    public String getTitle() {
	   	 return title;
	    }
	    
	    
	    public TestCharacter(String name,ArrayList<String>giveMovesM){
	   	 this.title = name;
	   	 this.meleeMoves.addAll(giveMovesM);
	   	 image = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
	   	 URL url = getClass().getResource("/images/"+name+".png");
	   	 try {
	   		 BufferedImage original = ImageIO.read(url);
	   		 Graphics2D g = (Graphics2D) image.getGraphics();
	   		 int w = original.getWidth();
	   		 int h = original.getHeight();
	   		 g.drawImage(original,0,0,300,250,0,0,w,h,null);
	   	 } catch (IOException e) {
	   		 e.printStackTrace();
	   	 }
	    }
	    
	    public BufferedImage getImage() {
	   	 return image;
	    }
	    
	    public int getCurrentHP() {
	   	 return currentHP;
	    }
	    
	    public void setCurrentHP(int number) {
	   	 this.currentHP = number;
	    }

	    public int getTotalHP() {
	   	 return totalHP;
	    }
	}

