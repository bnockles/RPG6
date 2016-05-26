
	package Battles;

	import java.awt.Color;
	import java.awt.Font;
	import java.awt.Graphics2D;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;
	import java.awt.image.BufferedImage;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.io.InputStream;
	import java.net.URL;
	import java.util.ArrayList;
	import javax.imageio.ImageIO;

	import directors.Game;
	import directors.Screen;
	import menus.MainMenu;
	import sun.audio.AudioData;
	import sun.audio.AudioPlayer;
	import sun.audio.AudioStream;
	import sun.audio.ContinuousAudioDataStream;

	public class TestBattleScreen extends Screen implements KeyListener {
	    
	    ArrayList<TestCharacter>entities = new ArrayList<TestCharacter>();
	    
	    ArrayList<String>entityNames = new ArrayList<String>();
	    
	    ArrayList<String>entityAMoves = new ArrayList<String>();
	    
	    ArrayList<String> directory = new ArrayList<String>();
	    
	    static ArrayList<String> musicTrack = new ArrayList<String>();
	    
	    static ArrayList<String>optionNames = new ArrayList<String>();
	    
	    static ArrayList<TestCharacter>battleParticipants = new ArrayList<TestCharacter>();
	    
       	    static Reader words = null;
	    static int textint = 0;
	    
	    static int mapSelect;
	    
	    TestCharacter entityA;  
	    TestCharacter entityB;
	    TestCharacter entityC;

	    private int entityAPosX;
	    private int entityBPosX;
	    private int entityCPosX;
	    private final int entityPosY = height/2-180;
	    
	    private boolean infoToggle = true;
	    private boolean textBoxToggle = true;
	    private int space = 0;
	    private int textspace = 0;
	    private int actionCounts = 1;
	    private int frame = 0;
	    
	    static final int attacks = 0;
	    static final int spells = 1;
	    static final int items = 2;
	    static final int runs = 3;
	    static int option = attacks;
	    
		InputStream in;
		AudioStream as = null;
	    static AudioPlayer MGP = AudioPlayer.player;
	    static AudioStream BGM;
	    static AudioData MD;
	    static ContinuousAudioDataStream loop = null;
	    static FileInputStream town1Music;  
	    
	    long previous_beat = System.currentTimeMillis();
	    
	    public TestBattleScreen(Game game) {
	   	 super(game);
//	  	music();
	    	mapSelect = 2;
	    	directory.add("/images/sewerFloor.png");
	    	directory.add("/images/modernsewer.png");
	    	directory.add("/images/DemonCastleFloor.png");
	    	directory.add("/images/DemonCastleBackground.png");
	    	directory.add("/images/LavaCaveFloor.png");
	    	directory.add("/images/LavaCave.png");
	    	musicTrack.add("/resources/music/UT.wav");
	    	entityAMoves.add("High Jump Kick");
	    	entityAMoves.add("Blaze Burner");
	    	entityAMoves.add("Hydro Pump");
	    	entityAMoves.add("Energy Wave");
	    	entityAMoves.add("Lightning Strike");
	    	entityAMoves.add("Blackout");
	   	 
	    	entities.add(new TestCharacter("ArchAngel"));
	    	entities.add(new TestCharacter("Lich"));
	    	entities.add(new TestCharacter("Queen"));
	    	entities.add(new TestCharacter("MohawkA"));
	    	entities.add(new TestCharacter("Gargoyle"));
	    	entities.add(new TestCharacter("BioSoldier"));
	    	entities.add(new TestCharacter("BioBird"));
	    	entities.add(new TestCharacter("BlackDragon"));
	    	entities.add(new TestCharacter("Goliath"));
	    	entities.add(new TestCharacter("GreatDevil"));
	    	entities.add(new TestCharacter("Infantry"));
	    	entities.add(new TestCharacter("Succubus"));
	    	entities.add(new TestCharacter("LavaCaveFloor"));
	   	 
	    	battleParticipants.add(entities.get(7));
	    	battleParticipants.add(entities.get(7));
	    	battleParticipants.add(entities.get(7));
	   	 
	    	this.entityA = battleParticipants.get(0);
	    	this.entityB = battleParticipants.get(1);
	    	this.entityC = battleParticipants.get(2);
	   	 
	    	for(TestCharacter dm: battleParticipants){
	   		 entityNames.add(dm.getTitle());
	    	}
	   	 
	    	buttonHome();
	   	 dialogue();
	    	update();
	    }
	    
	    public void menuAnimation(Graphics2D g2){
	   	 int[] positionY = new int[5];
	   	 positionY[0] = 100;
	   	 positionY[1] = 125;
	   	 positionY[2] = 150;
	   	 positionY[3] = 175;
	   	 positionY[4] = 200;
	   	 int[] positionX = new int[5];
	   	 positionX[0] = 300;
	   	 positionX[1] = 320;
	   	 positionX[2] = 340;
	   	 positionX[3] = 320;
	   	 positionX[4] = 300;
	   	 if(previous_beat+500<System.currentTimeMillis())
	   	 {    
	   		 frame++;
	   		 if(frame>positionX.length)
	   			 frame=1;
	   		 previous_beat = System.currentTimeMillis();
	   	 }
	   	 g2.fillRect(positionX[frame-1],positionY[frame-1]-20,100,40);
	    }

	    @Override
	    public void paintScreen(Graphics2D g2) {
	   	 try{
//	   		 drawBackground(g2);
	   		 drawEntities(g2);
//	   		 drawInfo(g2);
	   		 drawText(g2);
	   		 drawMenu(g2);
//	   		 menuAnimation(g2);
	   	 }
	   	 catch(Exception e){
	   		 //there will only ever be one error when the Screen first prints (since enemies have not been initialized)
	   	 }
	    }
	    
	    public void drawInfo(Graphics2D g2){
	   	 if(infoToggle){
	   		 space = 100;
	   	 }
	   	 else{
	   		 space = 0;
	   	 }
	   	 
	   	 g2.setFont(new Font("Courier", Font.BOLD + Font.ITALIC, 18));
	   	 //Turns
	   	 g2.setColor(Color.orange);
	   	 g2.fillPolygon(new int[] {0-space, 110-space, 110-space, 0-space}, new int[] {60, 60, 330, 370}, 4);
	   	 g2.fillPolygon(new int[] {0, 10, 10, 0}, new int[] {0, 0, 60, 60}, 4);
	   	 g2.setColor(Color.black);
	   	 g2.fillPolygon(new int[] {0-space, 100-space, 100-space, 0-space}, new int[] {65, 65, 325, 360}, 4);
	   	 g2.setColor(Color.white);
	   	 g2.drawString("Order", 5-space, 80);
	   	 //TODO
	   	 for(int i = 0; i < 240; i+=40){
	   		 g2.drawImage(cropImage(entities.get(i/40).getImage(),140,30,100,40),0-space,85+i,null);
	   	 }
	   	 //Entity Divisor
//	   	 g2.setFont(new Font("Courier", Font.BOLD, 18));
//	   	 g2.setColor(Color.black);
//	   	 g2.fillPolygon(new int[] {width+space,width-160+space,width-180+space,width-160+space,width+space}, new int[] {(height/2)+(height/45)+3,(height/2)+(height/45)+3,(height/2)+(height/40)+8,(height/2)+(height/35)+13,(height/2)+(height/35)+13}, 5);
//	   	 g2.setColor(Color.red);
//	   	 g2.drawString("Enemy", width-170+space, (height/2)+(height/50));
//	   	 g2.setColor(Color.blue);
//	   	 g2.drawString("Player", width-170+space, (height/2)+(height/50)+30);
	   	 //Portrait GUI
	   	 for(int i = 0; i< 270; i+=90){
	   		 g2.setColor(Color.black);
	   		 g2.fillPolygon(new int[] {width-140+space, width-100+space, width, width}, new int[] {30+i, 80+i, 80+i, 30+i}, 4);
	   		 g2.fillPolygon(new int[] {width-140+space, width-100+space, width, width}, new int[] {height-4-i, height-54-i, height-54-i, height-4-i}, 4);
//	   		 if(entityB!=null)
//	   		 g2.drawString(entityB.getTitle(), width-120, height-9-i);
	   	 }
	   	 //Status Portraits
	   	 g2.setFont(new Font("Courier", Font.ITALIC, 12));
	   	 g2.setColor(Color.white);
	   	 if(entityC!=null){
	   		 g2.drawString(entityC.getCurrentHP()+"/"+entityC.getTotalHP(), width-100+space, 42);
	   		 g2.drawString(entityC.getTitle(), width-100+space, 75);
	   		 g2.drawImage(cropImage(battleParticipants.get(2).getImage(),100,60,100,40),width-100+space,80,null);
	   	 }
	   	 if(entityB!=null){
	   		 g2.drawString(entityB.getCurrentHP()+"/"+entityB.getTotalHP(), width-100+space, 132);
	   		 g2.drawString(entityB.getTitle(), width-100+space, 165);
	   		 g2.drawImage(cropImage(battleParticipants.get(1).getImage(),140,30,100,40),width-100+space,170,null);
	   	 }
	   	 if(entityA!=null){
	   		 g2.drawString(entityA.getCurrentHP()+"/"+entityA.getTotalHP(), width-100+space, 222);
	   		 g2.drawString(entityA.getTitle(), width-100+space, 255);
	   		 g2.drawImage(cropImage(battleParticipants.get(0).getImage(),100,60,100,40),width-100+space,260,null);
	   	 }
	    }
	    
	    public void drawText(Graphics2D g2){
	   	 g2.setFont(new Font("Courier", Font.ITALIC, 18));
	   	 //Text Box
	   	 g2.setColor(Color.black);
	   	 g2.fillPolygon(new int[] {10, 750, 700, 10}, new int[] {0, 0, 60+textspace, 60+textspace}, 4);
	   	 g2.setColor(Color.white);
	   	 if(textint>=0){
	   		 for(int number = textint; number>=0; number--){
	   			 g2.drawImage(cropImage(entities.get(0).getImage(),140,135,100,20),10,40+textspace-(number*30),null);
	   			 g2.drawString(words.getBattleDialouge(textint-number)+option, 120, 55+textspace-(number*30));
	   		 }
	   	 }
	    }
	    
	    public void drawMenu(Graphics2D g2){
	   	 g2.setFont(new Font("Courier", Font.PLAIN, 18));
	   	 //Option Boxes
	   	 int spacing = 0;
	   	 for(int layer = 0; layer < (actionCounts*150); layer+=150){
	   		 g2.setColor(Color.black);
	   		 g2.fillRect(105+layer, height-145, 100, 40);
	   		 g2.fillRect(125+layer, height-95, 100, 40);
	   		 g2.fillRect(105+layer, height-45, 100, 40);
	   		 if(layer>1)
	   			 g2.fillRect(65+layer, height-85, 100, 20);
	   		 spacing = layer;
	   	 }
	   	 g2.setColor(Color.orange);
	   	 //Option Names
	   	 g2.drawString(optionNames.get(1), 125+spacing, height-125);
	   	 g2.drawString(optionNames.get(0), 145+spacing, height-75);
	   	 g2.drawString(optionNames.get(optionNames.size()-1), 125+spacing, height-25);
	    }

	    public void drawBackground(Graphics2D g2){
	   	 g2.drawImage(background(directory.get(mapSelect),width,height), 0,0, null);
	   	 g2.drawImage(background(directory.get(mapSelect+1),width,height),0,0,null);
	    }
	    
	    public void drawEntities(Graphics2D g2){
	   	 g2.setFont(new Font("Courier", Font.ITALIC, 18));
	   	 if(entityC!=null){
	   		 entityCPosX = width/2+width/3-entityC.getImage().getWidth()/2;
	   		 g2.drawImage(entityC.getImage(),entityCPosX,entityPosY,null);
	   		 g2.setColor(Color.black);
	   		 g2.fillRect(entityCPosX+entityC.getImage().getWidth()/2-95, entityPosY-25, 190, 15);
	   		 g2.setColor(Color.red);
	   		 g2.fillRect(entityCPosX+entityC.getImage().getWidth()/2-90, entityPosY-20, 180, 5);
	   		 g2.setColor(Color.green);
	   		 g2.fillRect(entityCPosX+entityC.getImage().getWidth()/2-90, entityPosY-20, 180*entityC.getCurrentHP()/entityC.getTotalHP(), 5);
	   	 }
	   	 if(entityB!=null){
	   		 entityBPosX = width/2-width/3-entityB.getImage().getWidth()/2;
	   		 g2.drawImage(entityB.getImage(),entityBPosX,entityPosY,null);
	   		 g2.setColor(Color.black);
	   		 g2.fillRect(entityBPosX+entityB.getImage().getWidth()/2-95, entityPosY-25, 190, 15);
	   		 g2.setColor(Color.red);
	   		 g2.fillRect(entityBPosX+entityB.getImage().getWidth()/2-90, entityPosY-20, 180, 5);
	   		 g2.setColor(Color.green);
	   		 g2.fillRect(entityBPosX+entityB.getImage().getWidth()/2-90, entityPosY-20, 180*entityB.getCurrentHP()/entityB.getTotalHP(), 5);
	   	 }
	   	 if(entityA!=null){
	   		 entityAPosX = width/2-entityA.getImage().getWidth()/2;
	   		 g2.drawImage(entityA.getImage(),entityAPosX,entityPosY,null);
	   		 g2.setColor(Color.black);
	   		 g2.fillRect(entityAPosX+entityA.getImage().getWidth()/2-95, entityPosY-25, 190, 15);
	   		 g2.setColor(Color.red);
	   		 g2.fillRect(entityAPosX+entityA.getImage().getWidth()/2-90, entityPosY-20, 180, 5);
	   		 g2.setColor(Color.green);
	   		 g2.fillRect(entityAPosX+entityA.getImage().getWidth()/2-90, entityPosY-20, 180*entityA.getCurrentHP()/entityA.getTotalHP(), 5);
	   	 }
	    }

	    public BufferedImage background(String imagePath,int x1,int y1){
//	   	 BufferedImage bImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	   	 BufferedImage bImg = new BufferedImage(x1, y1, BufferedImage.TYPE_INT_ARGB);
	   	 URL url = getClass().getResource(imagePath);
	   	 try {
	   		 BufferedImage original = ImageIO.read(url);
	   		 Graphics2D g = (Graphics2D) bImg.getGraphics();
	   		 int w = original.getWidth();
	   		 int h = original.getHeight();
//	   		 g.drawImage(original,0,0,width,height,0,0,w,h,null);
	   		 g.drawImage(original,0,0,x1,y1,0,0,w,h,null);
	   	 } catch (IOException e) {
	   		 e.printStackTrace();
	   	 }
	   	 return bImg;
	    }
	    
	    private static BufferedImage cropImage(BufferedImage src, int x, int y, int width, int height) {
	   	 BufferedImage dest = src.getSubimage(x, y, width, height);
	   	 return dest;
	    }
	    
	    @Override
	    public KeyListener getKeyListener() {
	   	 return this;
	    }

	    public void keyPressed(KeyEvent e) {
	   	 if(e.getKeyCode()==KeyEvent.VK_1){
	   		 resetGameValues();
	   	 }
	   	 else if(e.getKeyCode()==KeyEvent.VK_ENTER){
	   		 if(textint<words.checkBattleDialogueLength()-1){
	   			 textint++;
	   		 }
	   	 }
	   	 //forwards right
	   	 else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
	   		 optionNames.add(optionNames.remove(0));
	   		 if(option<optionNames.size()-1)
	   			 option ++;
	   		 else
	   			 option = 0;
	   	 }
	   	 //backwards left
	   	 else if(e.getKeyCode()==KeyEvent.VK_LEFT){
	   		 optionNames.add(0,optionNames.remove(optionNames.size()-1));
	   		 if(option>0){
	   			 option --;
	   		 }
	   		 else
	   			 option = optionNames.size()-1;
	   	 }
	   	 //confirm up
	   	 else if(e.getKeyCode()==KeyEvent.VK_UP){
	   		 actions(option);
	   		 option = 0;
	   		 actionCounts++;
	   	 }
	   	 //cancel down
	   	 else if(e.getKeyCode()==KeyEvent.VK_DOWN){
	   		 actions(-1);
	   		 option = 0;
	   		 actionCounts--;
	   	 }
	   	 else if(e.getKeyCode()==KeyEvent.VK_B){
	   		 if(infoToggle){
	   			 space = 100;
	   			 infoToggle = false;
	   		 }
	   		 else{
	   			 space = 0;
	   			 infoToggle = true;
	   		 }
	   	 }
	   	 else if(e.getKeyCode()==KeyEvent.VK_N){
	   		 if(textBoxToggle){
	   			 textspace = 100;
	   			 textBoxToggle = false;
	   		 }
	   		 else{
	   			 textspace = 0;
	   			 textBoxToggle = true;
	   		 }
	   	 }
	   	 update();
	   	 game.repaint();
	    }

	    private void resetGameValues() {
	   	 new TestBattleScreen(game);
	   	 this.entityA = entities.get((int)(Math.random()*entities.size()));
	   	 this.entityB = entities.get((int)(Math.random()*entities.size()));
	   	 this.entityC = entities.get((int)(Math.random()*entities.size()));
	    }

	    public void keyReleased(KeyEvent e) {    
	    }

	    public void keyTyped(KeyEvent e) {
	    }
	    
	    private void attack(int target) {
	   	 battleParticipants.get(target).setCurrentHP(battleParticipants.get(target).getCurrentHP()-(int)(Math.random()*30+20));
	   	 battleEvent(target);
	   	 update();
	   	 game.repaint();
	    }
	    
	    private void battleEvent(int target) {
	   	 if(entityA.getCurrentHP()<=50){
	   		 if(textint<words.checkBattleDialogueLength()-1&&textint<1){
	   			 textint++;
	   		 }
	   	 }
	   	 if(battleParticipants.get(target).getCurrentHP()<=0){
	   		 battleParticipants.get(target).setCurrentHP(0);
//	   		 battleParticipants.remove(target);
//	   		 entityA = null;
	   		 if(textint<words.checkBattleDialogueLength()-1){
	   			 textint++;
	   		 }
//	   		 endBattle();
	   	 }
	    }
	    
	    public void endBattle(){
	   	 if(entityA==null){
	   		 Screen mainMenu = new MainMenu(game);
	   		 game.setScreen(mainMenu);
	   	 }
//	   	 if(entityA==null&&entityB==null&&entityC==null){
//	   		 Screen mainMenu = new MainMenu(game);
//	   		 game.setScreen(mainMenu);
//	   	 }
	    }

	    
	    public static void music(){
	   	 //courtesy of Khan
	   	 try {
	   		 town1Music = new FileInputStream(musicTrack.get(0));
	   		 BGM = new AudioStream(town1Music);
	   		 AudioPlayer.player.start(BGM);
	   	 } catch (FileNotFoundException e) {
	   		 e.printStackTrace();
	   	 } catch (IOException e) {
	   		 e.printStackTrace();
	   	 }
	   	 MGP.start(loop);
	    }
	    
	    public static void dialogue(){
	   	 try {
	   		 words = new Reader();
	   	 } catch (FileNotFoundException e) {
	   		 e.printStackTrace();
	   	 }
	    }
	    
	    public static void buttonHome(){
	   	 optionNames.clear();
	   	 optionNames.add("Attack");
	   	 optionNames.add("Magic");
	   	 optionNames.add("Item");
	   	 optionNames.add("Switch");
	   	 optionNames.add("Run");
	   	 selectedOne = false;
	   	 selectedTwo = false;
	   	 selectedThree = false;
	   	 selectedFour = false;
	    }
	    public static void createButtons(ArrayList<String> keyPressAction){
	   	 optionNames.clear();
	   	 optionNames.addAll(keyPressAction);
	    }
	    
	    static boolean selectedOne;
	    static boolean selectedTwo;
	    static boolean selectedThree;
	    static boolean selectedFour;
	    
	    public void actions(int option){
	    	switch (option) {
	        	case attacks: actionAttack();
	                 	break;
	        	default: buttonHome();
	                 	break;
	    	}
		}
	    
	    public void actionAttack(){
	   	 if(selectedOne){
	   		 actionTarget(option);
	   	 }
	   	 else{
	   		 createButtons(entityAMoves);
	   		 selectedOne = true;
	   	 }
	    }
	    
	    public void actionTarget(int option){
	   	 if(selectedTwo){
	   		 attack(option);
	   		 actionCounts = 0;
	   		 buttonHome();
	   	 }
	   	 else{
	   		 createButtons(entityNames);
	   		 selectedTwo = true;
	   	 }
	    }
	}


