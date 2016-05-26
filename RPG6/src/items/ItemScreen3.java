package items;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import directors.Game;
import directors.Screen;


public class ItemScreen3 extends Screen implements KeyListener{
	
	Character character;

	static ArrayList<Item> inventory = new ArrayList<Item>();
<<<<<<< HEAD
	static ArrayList<ActiveSkill> skillList1 = new ArrayList<ActiveSkill>();
	public ActiveSkill skill1;
	public ActiveSkill skill2;
	static ArrayList<ActiveSkill> skillList2 = new ArrayList<ActiveSkill>();
	public ActiveSkill skill3;
	static ArrayList<ActiveSkill> skillList3 = new ArrayList<ActiveSkill>();
	public ActiveSkill skill4;
	static ArrayList<ActiveSkill> skillList4 = new ArrayList<ActiveSkill>();
	public static boolean battling = true;
	public static boolean onFirst = false;
	public static boolean onSecond = false;
	public static boolean onThird = false;
	public static boolean onFourth = false;
	public static boolean onInvent = false;
	public static boolean onSkill = false;
	public static boolean selectItem = false;
	public static boolean selectItem2 = false;
	public static boolean selectedSkill = false;
	public static boolean selectedSkill2 = false;
	public static String welcomeMessage = "Battle Testing for Items and Skills";
	public static String index = "Press 'I' for inventory.";
	public static String currentPage = "Press 1-4 to select an ally.";
	public static String message = "Press buttons when prompted.";
	public static String battleMessage = ""; //For Selecting
	public static String info = "Battle Information";
	public static String resultsMessage = "";
	public static String openedMenu = "";
	public static String skillArea1 = "";
	public static String skillArea2 = "";
	public Character ally1;
	public Character ally2;
	public Character ally3;
	public Character ally4;
	public Character enemy1;
	public Character enemy2;
	public int currentHP1;
	public int currentMP1;
	public int currentHP2;
	public int currentMP2;
	public int currentHP3;
	public int currentMP3;
	public int currentHP4;
	public int currentMP4;
	public int currentHP5;
	public int currentMP5;
	public int currentHP6;
	public int currentMP6;
	public int finalDamage;
	
	/**
	 * @param game
	 */
	
	
	
	public ItemScreen3(Game game) {
		super(game);		
		this.ally1 = new Character(5, 100, new Stats(1000, 1000, 50, 50, 50, 50, 10, 10, 10), "Robin", "ally");
		this.ally2 = new Character(6, 100, new Stats(1200, 800, 60, 60, 60, 55, 10, 10, 10), "John", "ally");
		this.ally3 = new Character(2, 50, new Stats(600, 200, 20, 20, 30, 15, 1, 1, 1), "Jenny", "ally");
		this.ally4 = new Character(3, 50, new Stats(600, 200, 20, 20, 30, 15, 1, 1, 1), "Nami", "ally");
		this.enemy1 = new Character(2, 50, new Stats(600, 200, 20, 20, 30, 15, 1, 1, 1), "Natsu", "ally");
		this.enemy2 = new Character(3, 50, new Stats(1000, 200, 20, 20, 30, 15, 1, 1, 1), "Gray", "ally");
		
		this.currentHP1 = ally1.getTrueStats().getHealth();
		this.currentMP1 = ally1.getTrueStats().getMana();
		this.currentHP2 = ally2.getTrueStats().getHealth();
		this.currentMP2 = ally2.getTrueStats().getMana();
		this.currentHP3 = ally3.getTrueStats().getHealth();
		this.currentMP3 = ally3.getTrueStats().getMana();
		this.currentHP4 = ally4.getTrueStats().getHealth();
		this.currentMP4 = ally4.getTrueStats().getMana();
		this.currentHP5 = enemy1.getTrueStats().getHealth();
		this.currentMP5 = enemy1.getTrueStats().getMana();
		this.currentHP6 = enemy2.getTrueStats().getHealth();
		this.currentMP6 = enemy2.getTrueStats().getMana();
		
		this.skill1 = new ActiveSkill("Firebolt", "Burns people.", 100, "Burn", 250);
		this.skill2 = new ActiveSkill("Ice beam", "Freezes people.", 150, "Freeze", 300);
		this.skill3 = new ActiveSkill("Double Shot", "Shoots people", 50, "None", 75);
		this.skill4 = new ActiveSkill("Smack", "Hits people", 0, "None", 25);
		skillList1.add(skill1);
		skillList1.add(skill2);
		skillList2.add(skill3);
		skillList3.add(skill4);
		
		inventory.add(potionStock.consumableStock(0));
		inventory.add(potionStock.consumableStock(2));
		update();
	}

	public void paintScreen(Graphics2D g2) {
		
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.black);
		
		try{

//			int x = 150;
//			if (currentFirst){
//			for(int i=0; i<10;i++){
//				if (equips){
//					g2.drawString(inventory.get(i).getName(), 150, x);
//					x += 25;
//				}
//				if (consumes){
//					g2.drawString(cInventory.get(i).getName(), 150, x);
//					x += 25;
//				}
//			}
//			}
			g2.drawString("Allies", 150, 125);
			g2.drawString("1. NAME: " + ally1.getName(), 150, 150);
			g2.drawString("HP: " + currentHP1 + "/" + ally1.getTrueStats().getHealth(), 150, 175);
			g2.drawString("MP: " + currentMP1 + "/" + ally1.getTrueStats().getMana(), 150, 200);
			g2.drawString("2. NAME: " + ally2.getName(), 150, 225);
			g2.drawString("HP: " + currentHP2 + "/" + ally2.getTrueStats().getHealth(), 150, 250);
			g2.drawString("MP: " + currentMP2 + "/" + ally2.getTrueStats().getMana(), 150, 275);
			g2.drawString("3. NAME: " + ally3.getName(), 400, 150);
			g2.drawString("HP: " + currentHP3 + "/" + ally3.getTrueStats().getHealth(), 400, 175);
			g2.drawString("MP: " + currentMP3 + "/" + ally3.getTrueStats().getMana(), 400, 200);
			g2.drawString("4. NAME: " + ally4.getName(), 400, 225);
			g2.drawString("HP: " + currentHP4 + "/" + ally4.getTrueStats().getHealth(), 400, 250);
			g2.drawString("MP: " + currentMP4 + "/" + ally4.getTrueStats().getMana(), 400, 275);
			g2.drawString(index, 50, 75);
			g2.drawString(currentPage, 50, 100);
			g2.drawString(openedMenu, 50, 300);
			g2.drawString(skillArea1, 50, 325);
			g2.drawString(skillArea2, 50, 350);
			g2.drawString("Enemies", 700, 125);
			g2.drawString("5. NAME: " + enemy1.getName(), 700, 150);
			g2.drawString("HP: " + currentHP5 + "/" + enemy1.getTrueStats().getHealth(), 700, 175);
			g2.drawString("MP: " + currentMP5 + "/" + enemy1.getTrueStats().getMana(), 700, 200);
			g2.drawString("6. NAME: " + enemy2.getName(), 700, 225);
			g2.drawString("HP: " + currentHP6 + "/" + enemy2.getTrueStats().getHealth(), 700, 250);
			g2.drawString("MP: " + currentMP6 + "/" + enemy2.getTrueStats().getMana(), 700, 275);
			g2.drawString(welcomeMessage, 450, 50);
			g2.drawString(message, 50, 425);
			g2.drawString(battleMessage, 50, 450);
			g2.drawString(info, 50, 475);
			g2.drawString(resultsMessage, 50, 500);
			if (currentHP5 == 0 && currentHP6 == 0){
				g2.drawString("This battle is over!", 450, 700);
				battling = false;
			}
//			g2.drawString(reqMessage, 50, 525);
//			g2.drawString(descriptionMessage, 50, 550);
//			g2.drawString(statsMessage, 50, 575);
		}
		
		catch(Exception e){
			//there will only ever be one error when the Screen first prints (since enemies have not been initialized)
		}
		
	}
	

	
	public KeyListener getKeyListener() {
		return this;
	}

	public void keyPressed(KeyEvent e) {
		
//		if(e.getKeyCode()==talkNpc1 && currentTown.getTownName() == "Pellet Town"){
//			System.out.println("1 was pressed");
//			
//			if(character.getCurrency() < 300){
//				message = "Oops! Seems like you don't have enough to buy anything! You need at least 300 gems, go and see Bob to try and earn some money!";
//				actionMessage = "You need more gems!";
//			}
//	}
		if (battling){
		if(!(onInvent) && !(onSkill)){
		if(e.getKeyCode()==KeyEvent.VK_1){
				battleMessage = "You have selected " + ally1.getName() + ". Press K to view her skills.";
				onFirst = true;
				onSecond = false;
				onThird = false;
				onFourth = false;
				update();
				game.repaint();
			}
		if(e.getKeyCode()==KeyEvent.VK_2){
			battleMessage = "You have selected " + ally2.getName() + ". Press K to view his skills.";
			onFirst = false;
			onSecond = true;
			onThird = false;
			onFourth = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_3){
			battleMessage = "You have selected " + ally3.getName() + ". Press K to view her skills.";
			onFirst = false;
			onSecond = false;
			onThird = true;
			onFourth = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_4){
			battleMessage = "You have selected " + ally4.getName() + ". Press K to view her skills.";
			onFirst = false;
			onSecond = false;
			onThird = false;
			onFourth = true;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_K && onFirst){
			openedMenu = "Skills";
			battleMessage = "You have selected " + ally1.getName() + "'s skills. Press their labeled skills to use it.";
			skillArea1 = "Q: " + skillList1.get(0).getName();
			skillArea2 = "W: " + skillList1.get(1).getName();
			onSkill = true;
			onInvent = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_K && onSecond){
			openedMenu = "Skills";
			battleMessage = "You have selected " + ally2.getName() + "'s skills. Press their labeled skills to use it.";
			skillArea1 = "Q: " + skillList2.get(0).getName();
			onSkill = true;
			onInvent = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_K && onThird){
			openedMenu = "Skills";
			battleMessage = "You have selected " + ally3.getName() + "'s skills. Press their labeled skills to use it.";
			skillArea1 = "Q: " + skillList3.get(0).getName();
			onSkill = true;
			onInvent = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_K && onFourth){
			openedMenu = "Skills";
			battleMessage = "You have selected " + ally4.getName() + "'s skills. Press Z to continue.";
			skillArea1 = "This character has no skills!";
			onSkill = true;
			onInvent = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_I){
			openedMenu = "Inventory";
			battleMessage = "You have selected your inventory! Press an item to continue.";
			skillArea1 = "Q: " + inventory.get(0).getName();
			skillArea2 = "W: " + inventory.get(1).getName();
			onSkill = false;
			onInvent = true;
			update();
			game.repaint();
		}
		
		}
		if (onSkill){
			if (onFirst){
			if(e.getKeyCode()== KeyEvent.VK_Q){
				battleMessage = "You have selected " + skillList1.get(0).getName() + ". Choose an enemy to use it on them.";
				selectedSkill = true;
				update();
				game.repaint();
			}
			if(e.getKeyCode()== KeyEvent.VK_W){
				battleMessage = "You have selected " + skillList1.get(1).getName() + ". Choose an enemy to use it on them (5 or 6).";
				selectedSkill2 = true;
				update();
				game.repaint();
				}
			if(e.getKeyCode()== KeyEvent.VK_5 && selectedSkill){
				battleMessage = "You have selected to use " + skillList1.get(0).getName() + " on " + enemy1.getName() + ".";
				finalDamage = skillList1.get(0).getDamage() + ally1.getTrueStats().getAttack();
				resultsMessage = skillList1.get(0).getName() + " has done " + finalDamage + " damage on " + enemy1.getName() + " and used " + skillList1.get(0).getManaCost() + " MP! The enemy attacked back! Press Z to continue";
				currentHP1 -= 50;
				if ((currentMP1 - skillList1.get(0).getManaCost()) < 0){
					currentMP1 = 0;
				}else{
				currentMP1 -= skillList1.get(0).getManaCost();
				}
				if ((currentHP5 - finalDamage) < 0){
					currentHP5 = 0;
				} else {
					currentHP5 -= finalDamage;
				}
				update();
				game.repaint();
			}
			if(e.getKeyCode()== KeyEvent.VK_5 && selectedSkill2){
				battleMessage = "You have selected to use " + skillList1.get(1).getName() + " on " + enemy1.getName() + ".";
				finalDamage = skillList1.get(1).getDamage() + ally1.getTrueStats().getAttack();
				resultsMessage = skillList1.get(1).getName() + " has done " + finalDamage + " damage on " + enemy1.getName() + " and used " + skillList1.get(0).getManaCost() + " MP! The enemy attacked back! Press Z to continue";
				currentHP1 -= 50;
				if ((currentMP1 - skillList1.get(1).getManaCost()) < 0){
					currentMP1 = 0;
				}else{
				currentMP1 -= skillList1.get(1).getManaCost();
				}
				if ((currentHP5 - finalDamage) < 0){
					currentHP5 = 0;
				} else {
					currentHP5 -= finalDamage;
				}
				
				update();
				game.repaint();
			}
			if(e.getKeyCode()== KeyEvent.VK_6 && selectedSkill){
				battleMessage = "You have selected to use " + skillList1.get(0).getName() + " on " + enemy2.getName() + ".";
				finalDamage = skillList1.get(0).getDamage() + ally1.getTrueStats().getAttack();
				resultsMessage = skillList1.get(0).getName() + " has done " + finalDamage + " damage on " + enemy2.getName() + " and used " + skillList1.get(0).getManaCost() + " MP! The enemy attacked back! Press Z to continue";
				currentHP1 -= 50;
				if ((currentMP1 - skillList1.get(0).getManaCost()) < 0){
					currentMP1 = 0;
				}else{
				currentMP1 -= skillList1.get(0).getManaCost();
				}
				if ((currentHP6 - finalDamage) < 0){
					currentHP6 = 0;
				} else {
					currentHP6 -= finalDamage;
				}
				update();
				game.repaint();
			}
			if(e.getKeyCode()== KeyEvent.VK_6 && selectedSkill2){
				battleMessage = "You have selected to use " + skillList1.get(1).getName() + " on " + enemy2.getName() + ".";
				finalDamage = skillList1.get(1).getDamage() + ally1.getTrueStats().getAttack();
				resultsMessage = skillList1.get(1).getName() + " has done " + finalDamage + " damage on " + enemy2.getName() + " and used " + skillList1.get(0).getManaCost() + " MP! The enemy attacked back! Press Z to continue";
				currentHP1 -= 50;
				if ((currentMP1 - skillList1.get(1).getManaCost()) < 0){
					currentMP1 = 0;
				}else{
				currentMP1 -= skillList1.get(1).getManaCost();
				}
				if ((currentHP6 - finalDamage) < 0){
					currentHP6 = 0;
				} else {
					currentHP6 -= finalDamage;
				}
				
				update();
				game.repaint();
			}
			if (selectedSkill || selectedSkill2){
				if(e.getKeyCode()== KeyEvent.VK_Z){
					battleMessage = "";
					finalDamage = 0;
					resultsMessage = "";
					skillArea1 = "";
					skillArea2 = "";
					openedMenu = "";
					onFirst = false;
					onSkill = false;
					selectedSkill = false;
					selectedSkill2 = false;
					update();
					game.repaint();
				}
			}
			}
			if (onSecond){
				if(e.getKeyCode()== KeyEvent.VK_Q){
					battleMessage = "You have selected " + skillList2.get(0).getName() + ". Choose an enemy to use it on them.";
					selectedSkill = true;
					update();
					game.repaint();
				}
				if(e.getKeyCode()== KeyEvent.VK_5 && selectedSkill){
					battleMessage = "You have selected to use " + skillList2.get(0).getName() + " on " + enemy1.getName() + ".";
					finalDamage = skillList2.get(0).getDamage() + ally2.getTrueStats().getAttack();
					resultsMessage = skillList2.get(0).getName() + " has done " + finalDamage + " damage on " + enemy1.getName() + " and used " + skillList2.get(0).getManaCost() + " MP! The enemy attacked back! Press Z to continue";
					currentHP2 -= 50;
					if ((currentMP2 - skillList2.get(0).getManaCost()) < 0){
						currentMP2 = 0;
					}else{
					currentMP2 -= skillList2.get(0).getManaCost();
					}
					if ((currentHP5 - finalDamage) < 0){
						currentHP5 = 0;
					} else {
						currentHP5 -= finalDamage;
					}
					update();
					game.repaint();
				}
				if(e.getKeyCode()== KeyEvent.VK_6 && selectedSkill){
					battleMessage = "You have selected to use " + skillList2.get(0).getName() + " on " + enemy2.getName() + ".";
					finalDamage = skillList2.get(0).getDamage() + ally2.getTrueStats().getAttack();
					resultsMessage = skillList2.get(0).getName() + " has done " + finalDamage + " damage on " + enemy2.getName() + " and used " + skillList2.get(0).getManaCost() + " MP! The enemy attacked back! Press Z to continue";
					currentHP2 -= 50;
					if ((currentMP2 - skillList2.get(0).getManaCost()) < 0){
						currentMP2 = 0;
					}else{
					currentMP2 -= skillList2.get(0).getManaCost();
					}
					if ((currentHP6 - finalDamage) < 0){
						currentHP6 = 0;
					} else {
						currentHP6 -= finalDamage;
					}
					update();
					game.repaint();
				}
				if (selectedSkill || selectedSkill2){
					if(e.getKeyCode()== KeyEvent.VK_Z){
						battleMessage = "";
						finalDamage = 0;
						resultsMessage = "";
						skillArea1 = "";
						skillArea2 = "";
						openedMenu = "";
						onSecond = false;
						onSkill = false;
						selectedSkill = false;
						selectedSkill2 = false;
						update();
						game.repaint();
					}
				}
			}
			if (onThird){
				if(e.getKeyCode()== KeyEvent.VK_Q){
					battleMessage = "You have selected " + skillList3.get(0).getName() + ". Choose an enemy to use it on them.";
					selectedSkill = true;
					update();
					game.repaint();
				}
				if(e.getKeyCode()== KeyEvent.VK_5 && selectedSkill){
					battleMessage = "You have selected to use " + skillList3.get(0).getName() + " on " + enemy1.getName() + ".";
					finalDamage = skillList3.get(0).getDamage() + ally2.getTrueStats().getAttack();
					resultsMessage = skillList3.get(0).getName() + " has done " + finalDamage + " damage on " + enemy1.getName() + " and used " + skillList3.get(0).getManaCost() + " MP! The enemy attacked back! Press Z to continue";
					currentHP3 -= 50;
					if ((currentMP3 - skillList3.get(0).getManaCost()) < 0){
						currentMP3 = 0;
					}else{
					currentMP3 -= skillList3.get(0).getManaCost();
					}
					if ((currentHP5 - finalDamage) < 0){
						currentHP5 = 0;
					} else {
						currentHP5 -= finalDamage;
					}
					update();
					game.repaint();
				}
				if(e.getKeyCode()== KeyEvent.VK_6 && selectedSkill){
					battleMessage = "You have selected to use " + skillList3.get(0).getName() + " on " + enemy2.getName() + ".";
					finalDamage = skillList3.get(0).getDamage() + ally2.getTrueStats().getAttack();
					resultsMessage = skillList3.get(0).getName() + " has done " + finalDamage + " damage on " + enemy2.getName() + " and used " + skillList3.get(0).getManaCost() + " MP! The enemy attacked back! Press Z to continue";
					currentHP3 -= 50;
=======
	static ArrayList<activeSkill> skillList1 = new ArrayList<activeSkill>();
	public activeSkill skill1;
	public activeSkill skill2;
	static ArrayList<activeSkill> skillList2 = new ArrayList<activeSkill>();
	public activeSkill skill3;
	static ArrayList<activeSkill> skillList3 = new ArrayList<activeSkill>();
	public activeSkill skill4;
	static ArrayList<activeSkill> skillList4 = new ArrayList<activeSkill>();
	public static boolean battling = true;
	public static boolean onFirst = false;
	public static boolean onSecond = false;
	public static boolean onThird = false;
	public static boolean onFourth = false;
	public static boolean onInvent = false;
	public static boolean onSkill = false;
	public static boolean selectItem = false;
	public static boolean selectItem2 = false;
	public static boolean selectedSkill = false;
	public static boolean selectedSkill2 = false;
	public static String welcomeMessage = "Battle Testing for Items and Skills";
	public static String index = "Press 'I' for inventory.";
	public static String currentPage = "Press 1-4 to select an ally.";
	public static String message = "Press buttons when prompted.";
	public static String battleMessage = ""; //For Selecting
	public static String info = "Battle Information";
	public static String resultsMessage = "";
	public static String openedMenu = "";
	public static String skillArea1 = "";
	public static String skillArea2 = "";
	public static String skillArea3 = "";
	public static String skillArea4 = "";
	public Character ally1;
	public Character ally2;
	public Character ally3;
	public Character ally4;
	public Character enemy1;
	public Character enemy2;
	public Character enemy3;
	public Character enemy4;
	public int currentHP1;
	public int currentMP1;
	public int currentHP2;
	public int currentMP2;
	public int currentHP3;
	public int currentMP3;
	public int currentHP4;
	public int currentMP4;
	public int currentHP5;
	public int currentMP5;
	public int currentHP6;
	public int currentMP6;
	public int currentHP7;
	public int currentMP7;
	public int currentHP8;
	public int currentMP8;
	public int finalDamage;
	
	/**
	 * @param game
	 */
	
	
	
	public ItemScreen3(Game game) {
		super(game);		
		this.ally1 = new Character(5, 100, new Stats(1000, 1000, 50, 10, 50, 50, 50, 10, 10, 10), "Robin", "ally", inventory, 1000);
		this.ally2 = new Character(6, 100, new Stats(1200, 800, 60, 60, 60, 60, 55, 10, 10, 10), "John", "ally", inventory, 1000);
		this.ally3 = new Character(2, 50, new Stats(600, 200, 20, 20, 20, 30, 15, 1, 1, 1), "Jenny", "ally", inventory, 1000);
		this.ally4 = new Character(3, 50, new Stats(600, 200, 20, 20, 20, 30, 15, 1, 1, 1), "Nami", "ally", inventory, 1000);
		this.enemy1 = new Character(2, 50, new Stats(600, 500, 100, 20, 20, 30, 15, 1, 1, 1), "Natsu", "enemy", inventory, 1000);
		this.enemy2 = new Character(3, 50, new Stats(1000, 200, 20, 20, 20, 30, 15, 1, 1, 1), "Gray", "enemy", inventory, 1000);
		this.enemy3 = new Character(4, 50, new Stats(1000, 500, 30, 40, 40, 40, 50, 1, 1, 1), "Ken", "enemy", inventory, 1000);
		this.enemy4 = new Character(5, 50, new Stats(1200, 500, 50, 50, 50, 50, 60, 1, 1, 1), "Toujou", "enemy", inventory, 1000);
		
		this.currentHP1 = ally1.getTrueStats().getHealth();
		this.currentMP1 = ally1.getTrueStats().getMana();
		this.currentHP2 = ally2.getTrueStats().getHealth();
		this.currentMP2 = ally2.getTrueStats().getMana();
		this.currentHP3 = ally3.getTrueStats().getHealth();
		this.currentMP3 = ally3.getTrueStats().getMana();
		this.currentHP4 = ally4.getTrueStats().getHealth();
		this.currentMP4 = ally4.getTrueStats().getMana();
		this.currentHP5 = enemy1.getTrueStats().getHealth();
		this.currentMP5 = enemy1.getTrueStats().getMana();
		this.currentHP6 = enemy2.getTrueStats().getHealth();
		this.currentMP6 = enemy2.getTrueStats().getMana();
		this.currentHP7 = enemy3.getTrueStats().getHealth();
		this.currentMP7 = enemy3.getTrueStats().getMana();
		this.currentHP8 = enemy4.getTrueStats().getHealth();
		this.currentMP8 = enemy4.getTrueStats().getMana();
		
		this.skill1 = new activeSkill("Firebolt", "Burns people.", 100 , 250);
		this.skill2 = new activeSkill("Ice beam", "Freezes people.", 150, 300);
		this.skill3 = new activeSkill("Double Shot", "Shoots people", 50, 75);
		this.skill4 = new activeSkill("Smack", "Hits people", 0, 25);
		skillList1.add(skill1);
		skillList1.add(skill2);
		skillList2.add(skill3);
		skillList3.add(skill4);
		
		inventory.add(potionStock.consumableStock(0));
		inventory.add(potionStock.consumableStock(2));
		update();
	}

	public void paintScreen(Graphics2D g2) {
		
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.black);
		
		try{

//			int x = 150;
//			if (currentFirst){
//			for(int i=0; i<10;i++){
//				if (equips){
//					g2.drawString(inventory.get(i).getName(), 150, x);
//					x += 25;
//				}
//				if (consumes){
//					g2.drawString(cInventory.get(i).getName(), 150, x);
//					x += 25;
//				}
//			}
//			}
			g2.drawString("Allies", 130, 125);
			g2.drawString("1. NAME: " + ally1.getName(), 130, 150);
			g2.drawString("HP: " + currentHP1 + "/" + ally1.getTrueStats().getHealth(), 130, 175);
			g2.drawString("MP: " + currentMP1 + "/" + ally1.getTrueStats().getMana(), 130, 200);
			g2.drawString("2. NAME: " + ally2.getName(), 130, 225);
			g2.drawString("HP: " + currentHP2 + "/" + ally2.getTrueStats().getHealth(), 130, 250);
			g2.drawString("MP: " + currentMP2 + "/" + ally2.getTrueStats().getMana(), 130, 275);
			g2.drawString("3. NAME: " + ally3.getName(), 300, 150);
			g2.drawString("HP: " + currentHP3 + "/" + ally3.getTrueStats().getHealth(), 300, 175);
			g2.drawString("MP: " + currentMP3 + "/" + ally3.getTrueStats().getMana(), 300, 200);
			g2.drawString("4. NAME: " + ally4.getName(), 300, 225);
			g2.drawString("HP: " + currentHP4 + "/" + ally4.getTrueStats().getHealth(), 300, 250);
			g2.drawString("MP: " + currentMP4 + "/" + ally4.getTrueStats().getMana(), 300, 275);
			g2.drawString(index, 50, 75);
			g2.drawString(currentPage, 50, 100);
			g2.drawString(openedMenu, 50, 300);
			g2.drawString(skillArea1, 50, 325);
			g2.drawString(skillArea2, 50, 350);
			g2.drawString(skillArea3, 150, 325);
			g2.drawString(skillArea4, 150, 350);
			g2.drawString("Enemies", 550, 125);
			g2.drawString("5. NAME: " + enemy1.getName(), 550, 150);
			g2.drawString("HP: " + currentHP5 + "/" + enemy1.getTrueStats().getHealth(), 550, 175);
			g2.drawString("MP: " + currentMP5 + "/" + enemy1.getTrueStats().getMana(), 550, 200);
			g2.drawString("6. NAME: " + enemy2.getName(), 550, 225);
			g2.drawString("HP: " + currentHP6 + "/" + enemy2.getTrueStats().getHealth(), 550, 250);
			g2.drawString("MP: " + currentMP6 + "/" + enemy2.getTrueStats().getMana(), 550, 275);
			g2.drawString("7. NAME: " + enemy1.getName(), 700, 150);
			g2.drawString("HP: " + currentHP7 + "/" + enemy3.getTrueStats().getHealth(), 700, 175);
			g2.drawString("MP: " + currentMP7 + "/" + enemy3.getTrueStats().getMana(), 700, 200);
			g2.drawString("8. NAME: " + enemy2.getName(), 700, 225);
			g2.drawString("HP: " + currentHP8 + "/" + enemy4.getTrueStats().getHealth(), 700, 250);
			g2.drawString("MP: " + currentMP8 + "/" + enemy4.getTrueStats().getMana(), 700, 275);
			g2.drawString(welcomeMessage, 450, 50);
			g2.drawString(message, 50, 425);
			g2.drawString(battleMessage, 50, 450);
			g2.drawString(info, 50, 475);
			g2.drawString(resultsMessage, 50, 500);
			if (currentHP1 == 0 && currentHP2 == 0 && currentHP3 == 0 && currentHP4 == 0){
				g2.drawString("This battle is over!", 450, 700);
				battling = false;
			}
			if (currentHP5 == 0 && currentHP6 == 0 && currentHP7 == 0 && currentHP8 == 0){
				g2.drawString("This battle is over!", 450, 700);
				//draw string here for EXP and rewards for winning
				battling = false;
			}
//			g2.drawString(reqMessage, 50, 525);
//			g2.drawString(descriptionMessage, 50, 550);
//			g2.drawString(statsMessage, 50, 575);
		}
		
		catch(Exception e){
			//there will only ever be one error when the Screen first prints (since enemies have not been initialized)
		}
		
	}
	

	
	public KeyListener getKeyListener() {
		return this;
	}

	public void keyPressed(KeyEvent e) {
		
//		if(e.getKeyCode()==talkNpc1 && currentTown.getTownName() == "Pellet Town"){
//			System.out.println("1 was pressed");
//			
//			if(character.getCurrency() < 300){
//				message = "Oops! Seems like you don't have enough to buy anything! You need at least 300 gems, go and see Bob to try and earn some money!";
//				actionMessage = "You need more gems!";
//			}
//	}
		if (battling){
		if(!(onInvent) && !(onSkill)){
		if(e.getKeyCode()==KeyEvent.VK_1){
				battleMessage = "You have selected " + ally1.getName() + ". Press K to view her skills.";
				onFirst = true;
				onSecond = false;
				onThird = false;
				onFourth = false;
				update();
				game.repaint();
			}
		if(e.getKeyCode()==KeyEvent.VK_2){
			battleMessage = "You have selected " + ally2.getName() + ". Press K to view his skills.";
			onFirst = false;
			onSecond = true;
			onThird = false;
			onFourth = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_3){
			battleMessage = "You have selected " + ally3.getName() + ". Press K to view her skills.";
			onFirst = false;
			onSecond = false;
			onThird = true;
			onFourth = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_4){
			battleMessage = "You have selected " + ally4.getName() + ". Press K to view her skills.";
			onFirst = false;
			onSecond = false;
			onThird = false;
			onFourth = true;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_K && onFirst){
			openedMenu = "Skills";
			battleMessage = "You have selected " + ally1.getName() + "'s skills. Press their labeled skills to use it.";
			skillArea1 = "Q: " + skillList1.get(0).getName();
			skillArea2 = "W: " + skillList1.get(1).getName();
			onSkill = true;
			onInvent = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_K && onSecond){
			openedMenu = "Skills";
			battleMessage = "You have selected " + ally2.getName() + "'s skills. Press their labeled skills to use it.";
			skillArea1 = "Q: " + skillList2.get(0).getName();
			onSkill = true;
			onInvent = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_K && onThird){
			openedMenu = "Skills";
			battleMessage = "You have selected " + ally3.getName() + "'s skills. Press their labeled skills to use it.";
			skillArea1 = "Q: " + skillList3.get(0).getName();
			onSkill = true;
			onInvent = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_K && onFourth){
			openedMenu = "Skills";
			battleMessage = "You have selected " + ally4.getName() + "'s skills. Press Z to continue.";
			skillArea1 = "This character has no skills!";
			onSkill = true;
			onInvent = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_I){
			openedMenu = "Inventory";
			battleMessage = "You have selected your inventory! Press an item to continue.";
			skillArea1 = "Q: " + inventory.get(0).getName();
			skillArea2 = "W: " + inventory.get(1).getName();
			onSkill = false;
			onInvent = true;
			update();
			game.repaint();
		}
		
		}
		if (onSkill){
			if (onFirst){
			if(e.getKeyCode()== KeyEvent.VK_Q){
				battleMessage = "You have selected " + skillList1.get(0).getName() + ". Choose an enemy to use it on them.";
				selectedSkill = true;
				update();
				game.repaint();
			}
			if(e.getKeyCode()== KeyEvent.VK_W){
				battleMessage = "You have selected " + skillList1.get(1).getName() + ". Choose an enemy to use it on them (5 or 6).";
				selectedSkill2 = true;
				update();
				game.repaint();
				}
			if(e.getKeyCode()== KeyEvent.VK_5 && selectedSkill){
				battleMessage = "You have selected to use " + skillList1.get(0).getName() + " on " + enemy1.getName() + ".";
				finalDamage = skillList1.get(0).getDamage() + ally1.getTrueStats().getAttack();
				resultsMessage = skillList1.get(0).getName() + " has done " + finalDamage + " damage on " + enemy1.getName() + " and used " + skillList1.get(0).getManaCost() + " MP! The enemy attacked back! Press Z to continue";
				currentHP1 -= (enemy1.getTrueStats().getAttack() - ally1.getTrueStats().getDefense());
				if ((currentMP1 - skillList1.get(0).getManaCost()) < 0){
					currentMP1 = 0;
				}else{
				currentMP1 -= skillList1.get(0).getManaCost();
				}
				if ((currentHP5 - finalDamage) < 0){
					currentHP5 = 0;
				} else {
					currentHP5 -= finalDamage;
				}
				update();
				game.repaint();
			}
			if(e.getKeyCode()== KeyEvent.VK_5 && selectedSkill2){
				battleMessage = "You have selected to use " + skillList1.get(1).getName() + " on " + enemy1.getName() + ".";
				finalDamage = skillList1.get(1).getDamage() + ally1.getTrueStats().getAttack();
				resultsMessage = skillList1.get(1).getName() + " has done " + finalDamage + " damage on " + enemy1.getName() + " and used " + skillList1.get(0).getManaCost() + " MP! The enemy attacked back! Press Z to continue";
				currentHP1 -= (enemy1.getTrueStats().getAttack() - ally1.getTrueStats().getDefense());
				if ((currentMP1 - skillList1.get(1).getManaCost()) < 0){
					currentMP1 = 0;
				}else{
				currentMP1 -= skillList1.get(1).getManaCost();
				}
				if ((currentHP5 - finalDamage) < 0){
					currentHP5 = 0;
				} else {
					currentHP5 -= finalDamage;
				}
				
				update();
				game.repaint();
			}
			if(e.getKeyCode()== KeyEvent.VK_6 && selectedSkill){
				battleMessage = "You have selected to use " + skillList1.get(0).getName() + " on " + enemy2.getName() + ".";
				finalDamage = skillList1.get(0).getDamage() + ally1.getTrueStats().getAttack();
				resultsMessage = skillList1.get(0).getName() + " has done " + finalDamage + " damage on " + enemy2.getName() + " and used " + skillList1.get(0).getManaCost() + " MP! The enemy attacked back! Press Z to continue";
				currentHP1 -= (enemy2.getTrueStats().getAttack() - ally1.getTrueStats().getDefense());
				if ((currentMP1 - skillList1.get(0).getManaCost()) < 0){
					currentMP1 = 0;
				}else{
				currentMP1 -= skillList1.get(0).getManaCost();
				}
				if ((currentHP6 - finalDamage) < 0){
					currentHP6 = 0;
				} else {
					currentHP6 -= finalDamage;
				}
				update();
				game.repaint();
			}
			if(e.getKeyCode()== KeyEvent.VK_6 && selectedSkill2){
				battleMessage = "You have selected to use " + skillList1.get(1).getName() + " on " + enemy2.getName() + ".";
				finalDamage = skillList1.get(1).getDamage() + ally1.getTrueStats().getAttack();
				resultsMessage = skillList1.get(1).getName() + " has done " + finalDamage + " damage on " + enemy2.getName() + " and used " + skillList1.get(0).getManaCost() + " MP! The enemy attacked back! Press Z to continue";
				currentHP1 -= (enemy2.getTrueStats().getAttack() - ally1.getTrueStats().getDefense());
				if ((currentMP1 - skillList1.get(1).getManaCost()) < 0){
					currentMP1 = 0;
				}else{
				currentMP1 -= skillList1.get(1).getManaCost();
				}
				if ((currentHP6 - finalDamage) < 0){
					currentHP6 = 0;
				} else {
					currentHP6 -= finalDamage;
				}
				
				update();
				game.repaint();
			}
			if (selectedSkill || selectedSkill2){
				if(e.getKeyCode()== KeyEvent.VK_Z){
					battleMessage = "";
					finalDamage = 0;
					resultsMessage = "";
					skillArea1 = "";
					skillArea2 = "";
					openedMenu = "";
					onFirst = false;
					onSkill = false;
					selectedSkill = false;
					selectedSkill2 = false;
					update();
					game.repaint();
				}
			}
			}
			if (onSecond){
				if(e.getKeyCode()== KeyEvent.VK_Q){
					battleMessage = "You have selected " + skillList2.get(0).getName() + ". Choose an enemy to use it on them.";
					selectedSkill = true;
					update();
					game.repaint();
				}
				if(e.getKeyCode()== KeyEvent.VK_5 && selectedSkill){
					battleMessage = "You have selected to use " + skillList2.get(0).getName() + " on " + enemy1.getName() + ".";
					finalDamage = skillList2.get(0).getDamage() + ally2.getTrueStats().getAttack();
					resultsMessage = skillList2.get(0).getName() + " has done " + finalDamage + " damage on " + enemy1.getName() + " and used " + skillList2.get(0).getManaCost() + " MP! The enemy attacked back! Press Z to continue";
					currentHP2 -= (enemy1.getTrueStats().getAttack() - ally2.getTrueStats().getDefense());
					if ((currentMP2 - skillList2.get(0).getManaCost()) < 0){
						currentMP2 = 0;
					}else{
					currentMP2 -= skillList2.get(0).getManaCost();
					}
					if ((currentHP5 - finalDamage) < 0){
						currentHP5 = 0;
					} else {
						currentHP5 -= finalDamage;
					}
					update();
					game.repaint();
				}
				if(e.getKeyCode()== KeyEvent.VK_6 && selectedSkill){
					battleMessage = "You have selected to use " + skillList2.get(0).getName() + " on " + enemy2.getName() + ".";
					finalDamage = skillList2.get(0).getDamage() + ally2.getTrueStats().getAttack();
					resultsMessage = skillList2.get(0).getName() + " has done " + finalDamage + " damage on " + enemy2.getName() + " and used " + skillList2.get(0).getManaCost() + " MP! The enemy attacked back! Press Z to continue";
					currentHP2 -= (enemy2.getTrueStats().getAttack() - ally2.getTrueStats().getDefense());
					if ((currentMP2 - skillList2.get(0).getManaCost()) < 0){
						currentMP2 = 0;
					}else{
					currentMP2 -= skillList2.get(0).getManaCost();
					}
					if ((currentHP6 - finalDamage) < 0){
						currentHP6 = 0;
					} else {
						currentHP6 -= finalDamage;
					}
					update();
					game.repaint();
				}
				if (selectedSkill || selectedSkill2){
					if(e.getKeyCode()== KeyEvent.VK_Z){
						battleMessage = "";
						finalDamage = 0;
						resultsMessage = "";
						skillArea1 = "";
						skillArea2 = "";
						openedMenu = "";
						onSecond = false;
						onSkill = false;
						selectedSkill = false;
						selectedSkill2 = false;
						update();
						game.repaint();
					}
				}
			}
			if (onThird){
				if(e.getKeyCode()== KeyEvent.VK_Q){
					battleMessage = "You have selected " + skillList3.get(0).getName() + ". Choose an enemy to use it on them.";
					selectedSkill = true;
					update();
					game.repaint();
				}
				if(e.getKeyCode()== KeyEvent.VK_5 && selectedSkill){
					battleMessage = "You have selected to use " + skillList3.get(0).getName() + " on " + enemy1.getName() + ".";
					finalDamage = skillList3.get(0).getDamage() + ally3.getTrueStats().getAttack();
					resultsMessage = skillList3.get(0).getName() + " has done " + finalDamage + " damage on " + enemy1.getName() + " and used " + skillList3.get(0).getManaCost() + " MP! The enemy attacked back! Press Z to continue";
					currentHP3 -= (enemy1.getTrueStats().getAttack() - ally3.getTrueStats().getDefense());
					if ((currentMP3 - skillList3.get(0).getManaCost()) < 0){
						currentMP3 = 0;
					}else{
					currentMP3 -= skillList3.get(0).getManaCost();
					}
					if ((currentHP5 - finalDamage) < 0){
						currentHP5 = 0;
					} else {
						currentHP5 -= finalDamage;
					}
					update();
					game.repaint();
				}
				if(e.getKeyCode()== KeyEvent.VK_6 && selectedSkill){
					battleMessage = "You have selected to use " + skillList3.get(0).getName() + " on " + enemy2.getName() + ".";
					finalDamage = skillList3.get(0).getDamage() + ally3.getTrueStats().getAttack();
					resultsMessage = skillList3.get(0).getName() + " has done " + finalDamage + " damage on " + enemy2.getName() + " and used " + skillList3.get(0).getManaCost() + " MP! The enemy attacked back! Press Z to continue";
					currentHP3 -= (enemy2.getTrueStats().getAttack() - ally3.getTrueStats().getDefense());
>>>>>>> refs/remotes/origin/characters
					if ((currentMP3 - skillList3.get(0).getManaCost()) < 0){
						currentMP3 = 0;
					}else{
					currentMP3 -= skillList3.get(0).getManaCost();
					}
					if ((currentHP6 - finalDamage) < 0){
						currentHP6 = 0;
					} else {
						currentHP6 -= finalDamage;
					}
					update();
					game.repaint();
				}
				if (selectedSkill || selectedSkill2){
					if(e.getKeyCode()== KeyEvent.VK_Z){
						battleMessage = "";
						finalDamage = 0;
						resultsMessage = "";
						skillArea1 = "";
						skillArea2 = "";
						openedMenu = "";
						onThird = false;
						onSkill = false;
						selectedSkill = false;
						selectedSkill2 = false;
						update();
						game.repaint();
					}
				}
			}
			if (onFourth){
					if(e.getKeyCode()== KeyEvent.VK_Z){
						battleMessage = "";
						finalDamage = 0;
						resultsMessage = "";
						skillArea1 = "";
						skillArea2 = "";
						openedMenu = "";
						onFourth = false;
						onSkill = false;
						selectedSkill = false;
						selectedSkill2 = false;
						update();
						game.repaint();
					}
			}
		}
		if (onInvent){
			if (e.getKeyCode() == KeyEvent.VK_Q){
				battleMessage = "You have selected " + inventory.get(0).getName() + ". Please choose an ally target to use on.";
				selectItem = true;
				update();
				game.repaint();
			}
			if (e.getKeyCode() == KeyEvent.VK_W){
				battleMessage = "You have selected " + inventory.get(1).getName() + ". Please choose an ally target to use on.";
				selectItem2 = true;
				update();
				game.repaint();
			}
			if (e.getKeyCode() == KeyEvent.VK_1 && selectItem){
				battleMessage = "You have selected to use " + inventory.get(0).getName() + " on " + ally1.getName() + ". Press Z to continue.";
				resultsMessage = ally1.getName() + " has restored " + ((Consumable) inventory.get(0)).getValue() + " HP!";
				if(currentHP1 < ally1.getTrueStats().getHealth()){
					if ((currentHP1 + ((Consumable) inventory.get(0)).getValue()) < ally1.getTrueStats().getHealth()){
						currentHP1 += ((Consumable) inventory.get(0)).getValue();
					}
					else {
						currentHP1 = ally1.getTrueStats().getHealth();
					}
				}else {
					currentHP1 = ally1.getTrueStats().getHealth();
				}
				update();
				game.repaint();
			}
			if (e.getKeyCode() == KeyEvent.VK_2 && selectItem){
				battleMessage = "You have selected to use " + inventory.get(0).getName() + " on " + ally1.getName() + ". Press Z to continue.";
				resultsMessage = ally2.getName() + " has restored " + ((Consumable) inventory.get(0)).getValue() + " HP!";
				if(currentHP2 < ally2.getTrueStats().getHealth()){
					if ((currentHP2 + ((Consumable) inventory.get(0)).getValue()) < ally1.getTrueStats().getHealth()){
						currentHP2 += ((Consumable) inventory.get(0)).getValue();
					}
					else {
						currentHP2 = ally2.getTrueStats().getHealth();
					}
				}else {
					currentHP2 = ally2.getTrueStats().getHealth();
				}
				update();
				game.repaint();
			}
			if (e.getKeyCode() == KeyEvent.VK_3 && selectItem){
				battleMessage = "You have selected to use " + inventory.get(0).getName() + " on " + ally3.getName() + ". Press Z to continue.";
				resultsMessage = ally3.getName() + " has restored " + ((Consumable) inventory.get(0)).getValue() + " HP!";
				if(currentHP3 < ally3.getTrueStats().getHealth()){
					if ((currentHP3 + ((Consumable) inventory.get(0)).getValue()) < ally3.getTrueStats().getHealth()){
						currentHP3 += ((Consumable) inventory.get(0)).getValue();
					}
					else {
						currentHP3 = ally3.getTrueStats().getHealth();
					}
				}else {
					currentHP3 = ally3.getTrueStats().getHealth();
				}
				update();
				game.repaint();
			}
			if (e.getKeyCode() == KeyEvent.VK_4 && selectItem){
				battleMessage = "You have selected to use " + inventory.get(0).getName() + " on " + ally4.getName() + ". Press Z to continue.";
				resultsMessage = ally4.getName() + " has restored " + ((Consumable) inventory.get(0)).getValue() + " HP!";
				if(currentHP4 < ally4.getTrueStats().getHealth()){
					if ((currentHP4 + ((Consumable) inventory.get(0)).getValue()) < ally4.getTrueStats().getHealth()){
						currentHP4 += ((Consumable) inventory.get(0)).getValue();
					}
					else {
						currentHP4 = ally4.getTrueStats().getHealth();
					}
				}else {
					currentHP4 = ally4.getTrueStats().getHealth();
				}
				update();
				game.repaint();
			}
			if (e.getKeyCode() == KeyEvent.VK_1 && selectItem2){
				battleMessage = "You have selected to use " + inventory.get(1).getName() + " on " + ally1.getName() + ". Press Z to continue.";
				resultsMessage = ally1.getName() + " has restored " + ((Consumable) inventory.get(1)).getValue() + " HP!";
				if(currentHP1 < ally1.getTrueStats().getHealth()){
					if ((currentHP1 + ((Consumable) inventory.get(1)).getValue()) < ally1.getTrueStats().getHealth()){
						currentHP1 += ((Consumable) inventory.get(1)).getValue();
					}
					else {
						currentHP1 = ally1.getTrueStats().getHealth();
					}
				}else {
					currentHP1 = ally1.getTrueStats().getHealth();
				}
				update();
				game.repaint();
			}
			if (e.getKeyCode() == KeyEvent.VK_2 && selectItem2){
				battleMessage = "You have selected to use " + inventory.get(1).getName() + " on " + ally2.getName() + ". Press Z to continue.";
				resultsMessage = ally2.getName() + " has restored " + ((Consumable) inventory.get(1)).getValue() + " HP!";
				if(currentHP1 < ally2.getTrueStats().getHealth()){
					if ((currentHP2 + ((Consumable) inventory.get(1)).getValue()) < ally2.getTrueStats().getHealth()){
						currentHP2 += ((Consumable) inventory.get(1)).getValue();
					}
					else {
						currentHP2 = ally2.getTrueStats().getHealth();
					}
				}else {
					currentHP2 = ally2.getTrueStats().getHealth();
				}
				update();
				game.repaint();
			}
			if (e.getKeyCode() == KeyEvent.VK_3 && selectItem2){
				battleMessage = "You have selected to use " + inventory.get(1).getName() + " on " + ally3.getName() + ". Press Z to continue.";
				resultsMessage = ally3.getName() + " has restored " + ((Consumable) inventory.get(1)).getValue() + " HP!";
				if(currentHP3 < ally3.getTrueStats().getHealth()){
					if ((currentHP3 + ((Consumable) inventory.get(1)).getValue()) < ally3.getTrueStats().getHealth()){
						currentHP3 += ((Consumable) inventory.get(1)).getValue();
					}
					else {
						currentHP3 = ally3.getTrueStats().getHealth();
					}
				}else {
					currentHP3 = ally3.getTrueStats().getHealth();
				}
				update();
				game.repaint();
			}
			if (e.getKeyCode() == KeyEvent.VK_4 && selectItem2){
				battleMessage = "You have selected to use " + inventory.get(1).getName() + " on " + ally4.getName() + ". Press Z to continue.";
				resultsMessage = ally4.getName() + " has restored " + ((Consumable) inventory.get(1)).getValue() + " HP!";
				if(currentHP4 < ally4.getTrueStats().getHealth()){
					if ((currentHP4 + ((Consumable) inventory.get(1)).getValue()) < ally4.getTrueStats().getHealth()){
						currentHP4 += ((Consumable) inventory.get(1)).getValue();
					}
					else {
						currentHP4 = ally4.getTrueStats().getHealth();
					}
				}else {
					currentHP4 = ally4.getTrueStats().getHealth();
				}
				update();
				game.repaint();
			}
			if ((selectItem || selectItem2) && e.getKeyCode() == KeyEvent.VK_Z){
				battleMessage = "";
				resultsMessage = "";
				skillArea1 = "";
				skillArea2 = "";
				openedMenu = "";
				onInvent = false;
				selectItem = false;
				update();
				game.repaint();
			}
		}
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
