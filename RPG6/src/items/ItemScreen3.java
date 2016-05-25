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
	static ArrayList<ActiveSkill> skillList1 = new ArrayList<ActiveSkill>();
	public ActiveSkill skill1;
	public ActiveSkill skill2;
	static ArrayList<ActiveSkill> skillList2 = new ArrayList<ActiveSkill>();
	public ActiveSkill skill3;
	static ArrayList<ActiveSkill> skillList3 = new ArrayList<ActiveSkill>();
	public ActiveSkill skill4;
	static ArrayList<ActiveSkill> skillList4 = new ArrayList<ActiveSkill>();
	static ArrayList<Integer> hpInts = new ArrayList<Integer>();
	static ArrayList<Integer> mpInts = new ArrayList<Integer>();
	static ArrayList<Character> enemies = new ArrayList<Character>();
	public ActiveSkill skill5;
	public ActiveSkill skill6;
	public ActiveSkill skill7;
	public ActiveSkill skill8;
	public ActiveSkill skill9;
	public ActiveSkill skill10;
	public ActiveSkill skill11;
	public ActiveSkill skill12;
	public ActiveSkill skill13;
	public ActiveSkill skill14;
	public ActiveSkill skill15;
	public ActiveSkill skill16;
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
	public static boolean selectedSkill3 = false;
	public static boolean selectedSkill4 = false;
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
		this.ally2 = new Character(6, 100, new Stats(1200, 800, 60, 10, 60, 60, 55, 10, 10, 10), "John", "ally", inventory, 1000);
		this.ally3 = new Character(2, 50, new Stats(600, 200, 20, 10, 20, 30, 15, 1, 1, 1), "Jenny", "ally", inventory, 1000);
		this.ally4 = new Character(3, 50, new Stats(600, 200, 20, 10, 20, 30, 15, 1, 1, 1), "Nami", "ally", inventory, 1000);
		this.enemy1 = new Character(2, 50, new Stats(600, 500, 100, 10, 20, 30, 15, 1, 1, 1), "Natsu", "enemy", inventory, 1000);
		this.enemy2 = new Character(3, 50, new Stats(1000, 200, 20, 10, 20, 30, 15, 1, 1, 1), "Gray", "enemy", inventory, 1000);
		this.enemy3 = new Character(4, 50, new Stats(1000, 500, 30, 10, 40, 40, 50, 1, 1, 1), "Ken", "enemy", inventory, 1000);
		this.enemy4 = new Character(5, 50, new Stats(1200, 500, 50, 10, 50, 50, 60, 1, 1, 1), "Toujou", "enemy", inventory, 1000);
		enemies.add(enemy1);
		enemies.add(enemy2);
		enemies.add(enemy3);
		enemies.add(enemy4);

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
		hpInts.add(currentHP1);
		hpInts.add(currentHP2);
		hpInts.add(currentHP3);
		hpInts.add(currentHP4);
		hpInts.add(currentHP5);
		hpInts.add(currentHP6);
		hpInts.add(currentHP7);
		hpInts.add(currentHP8);
		mpInts.add(currentMP1);
		mpInts.add(currentMP2);
		mpInts.add(currentMP3);
		mpInts.add(currentMP4);
		

		this.skill1 = new ActiveSkill("Fireblast","Throws a Fireball at an enemy.",50,10);
		this.skill2 = new ActiveSkill("Energy Bolt","Fires a bolt of energy at an enemy.",50,10);
		this.skill3 = new ActiveSkill("Rain of Fire","Shoots fire arrows into the sky to rain down on all enemies.",50,10);
		this.skill4 = new ActiveSkill("Sticky Bombs","Attaches bombs that will explode in 3 turns.",50,10);
		this.skill5 = new ActiveSkill("Holy Bolt","Shoots a bolt of holy light.",50,10);
		this.skill6 = new ActiveSkill("Impact","Puts an explosive on an enemy that instantly blows up to do impactful damage.",50,10);
		this.skill7 = new ActiveSkill("Fan of Knives","Throws lots of knives that attack all enemies.",50,10);
		this.skill8 = new ActiveSkill("Backstab","Stabs an enemy from behind. Deals more damage than a normal attack.",100,40);
		this.skill9 = new ActiveSkill("Eruption","Calls on the power of the earth to rupture upon all enemies.",50,10);
		this.skill10 = new ActiveSkill("One Punch","Destructive blow that can guarentee a K.O.",5000,10);
		this.skill11 = new ActiveSkill("Body Slam","Slams yourself against an enemy to deal intense damage.",150,20);
		this.skill12 = new ActiveSkill("Ground Smash","Smashes the ground and damaged all enemies.",150,1000);
		this.skill13 = new ActiveSkill("Javalin Throw","Tosses a far ranged attack that pierces one enemy.",50,10);
		this.skill14 = new ActiveSkill("Helix Rockets","Shoots three rockets to massively damage an enemy.",150,20);
		this.skill15 = new ActiveSkill("Super Freeze Arrow","Deals damage and freezes an enemy for one turn.",50,10);
		this.skill16 = new ActiveSkill("Dragon Strike","Summons the power of the dragon to strike down an enemy.",1500,1000);
		skillList1.add(skill1);
		skillList2.add(skill2);
		skillList3.add(skill3);
		skillList4.add(skill4);
		skillList1.add(skill5);
		skillList2.add(skill6);
		skillList3.add(skill7);
		skillList4.add(skill8);
		skillList1.add(skill9);
		skillList2.add(skill10);
		skillList3.add(skill11);
		skillList4.add(skill12);
		skillList1.add(skill13);
		skillList2.add(skill14);
		skillList3.add(skill15);
		skillList4.add(skill16);


		inventory.add(potionStock.consumableStock(1));
		inventory.add(potionStock.consumableStock(2));
		inventory.add(potionStock.consumableStock(8));
		inventory.add(potionStock.consumableStock(11));
		update();
	}

		public ArrayList<Integer> attackOneEnemy(ArrayList<ActiveSkill> skillList, int skillNumber, Character ally, Character enemy, int AllyHPTarget, int HPTarget, int MPTarget){
		battleMessage = "You have selected to use " + skillList.get(skillNumber).getName() + " on " + enemy.getName() + ".";
		finalDamage = (skillList.get(skillNumber).getDamage() + ally.getTrueStats().getAttack()) - enemy.getTrueStats().getDefense();
		resultsMessage = skillList.get(skillNumber).getName() + " has done " + finalDamage + " damage on " + enemy.getName() + " and used " + skillList.get(skillNumber).getManaCost() + " MP! The enemy attacked back! Press Z to continue";
		AllyHPTarget -= (enemy.getTrueStats().getAttack() - ally.getTrueStats().getDefense());
		if ((HPTarget - finalDamage) < 0){
			HPTarget = 0;
		} else {
			HPTarget -= finalDamage;
		}
		if ((MPTarget - skillList.get(skillNumber).getManaCost()) < 0){
			MPTarget = 0;
		}else{
			MPTarget -= skillList.get(skillNumber).getManaCost();
		}
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(AllyHPTarget);
		temp.add(HPTarget);
		temp.add(MPTarget);
		return temp;
//		update();
//		game.repaint();
	}

	  public ArrayList<Integer> AttackAllEnemies(ArrayList<ActiveSkill> skillList, int skillNumber, Character ally, ArrayList<Character> enemies, int MPTarget, int AllyHPTarget){
		battleMessage = "You have selected to use " + skillList.get(skillNumber).getName() + " on all enemies.";
		finalDamage = skillList.get(skillNumber).getDamage() + ally.getTrueStats().getAttack();
		resultsMessage = skillList.get(skillNumber).getName() + " has done " + finalDamage + " damage (before defense) on all enemies and used " + skillList.get(skillNumber).getManaCost() + " MP! An enemy attacked back! Press Z to continue";
		AllyHPTarget -= (enemies.get(0).getTrueStats().getAttack() - ally.getTrueStats().getDefense());
		if ((MPTarget - skillList.get(skillNumber).getManaCost()) < 0){
			MPTarget = 0;
		}else{
			MPTarget -= skillList.get(skillNumber).getManaCost();
		}
		
		if ((currentHP5 - finalDamage) < 0){
			currentHP5 = 0;
		} else {
			currentHP5 -= (finalDamage - enemies.get(0).getTrueStats().getDefense());
		}
		if ((currentHP6 - finalDamage) < 0){
			currentHP6 = 0;
		} else {
			currentHP6 -= (finalDamage - enemies.get(1).getTrueStats().getDefense());
		}
		if ((currentHP7 - finalDamage) < 0){
			currentHP7 = 0;
		} else {
			currentHP7 -= (finalDamage - enemies.get(2).getTrueStats().getDefense());
		}
		if ((currentHP8 - finalDamage) < 0){
			currentHP8 = 0;
		} else {
			currentHP8 -= (finalDamage - enemies.get(3).getTrueStats().getDefense());
		}
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(AllyHPTarget);
		temp.add(MPTarget);
		return temp;
	}
	  
	 public int usePotion(Consumable potion, Character ally){
		 
		 return 1;
	 }
	  
	public void resetter(){
		battleMessage = "";
		finalDamage = 0;
		resultsMessage = "";
		skillArea1 = "";
		skillArea2 = "";
		skillArea3 = "";
		skillArea4 = "";
		openedMenu = "";
		onFirst = false;
		onSecond = false;
		onThird = false;
		onFourth = false;
		onSkill = false;
		onInvent = false;
		selectedSkill = false;
		selectedSkill2 = false;
		selectedSkill3 = false;
		selectedSkill4 = false;
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
			g2.drawString("7. NAME: " + enemy3.getName(), 700, 150);
			g2.drawString("HP: " + currentHP7 + "/" + enemy3.getTrueStats().getHealth(), 700, 175);
			g2.drawString("MP: " + currentMP7 + "/" + enemy3.getTrueStats().getMana(), 700, 200);
			g2.drawString("8. NAME: " + enemy4.getName(), 700, 225);
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
					skillArea3 = "E: " + skillList1.get(2).getName();
					skillArea4 = "R: " + skillList1.get(3).getName();
					onSkill = true;
					onInvent = false;
					update();
					game.repaint();
				}
				if(e.getKeyCode()==KeyEvent.VK_K && onSecond){
					openedMenu = "Skills";
					battleMessage = "You have selected " + ally2.getName() + "'s skills. Press their labeled skills to use it.";
					skillArea1 = "Q: " + skillList2.get(0).getName();
					skillArea2 = "W: " + skillList2.get(1).getName();
					skillArea3 = "E: " + skillList2.get(2).getName();
					skillArea4 = "R: " + skillList2.get(3).getName();
					onSkill = true;
					onInvent = false;
					update();
					game.repaint();
				}
				if(e.getKeyCode()==KeyEvent.VK_K && onThird){
					openedMenu = "Skills";
					battleMessage = "You have selected " + ally3.getName() + "'s skills. Press their labeled skills to use it.";
					skillArea1 = "Q: " + skillList3.get(0).getName();
					skillArea2 = "W: " + skillList3.get(1).getName();
					skillArea3 = "E: " + skillList3.get(2).getName();
					skillArea4 = "R: " + skillList3.get(3).getName();
					onSkill = true;
					onInvent = false;
					update();
					game.repaint();
				}
				if(e.getKeyCode()==KeyEvent.VK_K && onFourth){
					openedMenu = "Skills";
					battleMessage = "You have selected " + ally4.getName() + "'s skills.";
					skillArea1 = "Q: " + skillList4.get(0).getName();
					skillArea2 = "W: " + skillList4.get(1).getName();
					skillArea3 = "E: " + skillList4.get(2).getName();
					skillArea4 = "R: " + skillList4.get(3).getName();
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
						battleMessage = "You have selected " + skillList1.get(1).getName() + ". Choose an enemy to use it on them.";
						selectedSkill2 = true;
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_E){
						battleMessage = "You have selected " + skillList1.get(2).getName() + ". Choose an enemy to use it on them.";
						selectedSkill3 = true;
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_R){
						battleMessage = "You have selected " + skillList1.get(3).getName() + ". Choose an enemy to use it on them.";
						selectedSkill4 = true;
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_5 && selectedSkill){
						ArrayList<Integer> temp = attackOneEnemy(skillList1, 0, ally1, enemy1, currentHP1, currentHP5, currentMP1);
						currentHP1 = temp.get(0);
						currentHP5 = temp.get(1);
						currentMP1 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_5 && selectedSkill2){
						ArrayList<Integer> temp = attackOneEnemy(skillList1, 1, ally1, enemy1, currentHP1, currentHP5, currentMP1);
						currentHP1 = temp.get(0);
						currentHP5 = temp.get(1);
						currentMP1 = temp.get(2);
						update();
						game.repaint();

						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_5 && selectedSkill3){
						ArrayList<Integer> temp = AttackAllEnemies(skillList1, 2, ally1, enemies, currentMP1, currentHP1);
						currentHP1 = temp.get(0);
						currentMP1 = temp.get(1);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_5 && selectedSkill4){
						ArrayList<Integer> temp = attackOneEnemy(skillList1, 3, ally1, enemy1, currentHP1, currentHP5, currentMP1);
						currentHP1 = temp.get(0);
						currentHP5 = temp.get(1);
						currentMP1 = temp.get(2);
						update();
						game.repaint();

						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_6 && selectedSkill){
						ArrayList<Integer> temp = attackOneEnemy(skillList1, 0, ally1, enemy2, currentHP1, currentHP6, currentMP1);
						currentHP1 = temp.get(0);
						currentHP6 = temp.get(1);
						currentMP1 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_6 && selectedSkill2){
						ArrayList<Integer> temp = attackOneEnemy(skillList1, 1, ally1, enemy2, currentHP1, currentHP6, currentMP1);
						currentHP1 = temp.get(0);
						currentHP6 = temp.get(1);
						currentMP1 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_6 && selectedSkill3){
						ArrayList<Integer> temp = AttackAllEnemies(skillList1, 2, ally1, enemies, currentMP1, currentHP1);
						currentHP1 = temp.get(0);
						currentMP1 = temp.get(1);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_6 && selectedSkill4){
						ArrayList<Integer> temp = attackOneEnemy(skillList1, 3, ally1, enemy2, currentHP1, currentHP6, currentMP1);
						currentHP1 = temp.get(0);
						currentHP6 = temp.get(1);
						currentMP1 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_7 && selectedSkill){
						ArrayList<Integer> temp = attackOneEnemy(skillList1, 0, ally1, enemy3, currentHP1, currentHP7, currentMP1);
						currentHP1 = temp.get(0);
						currentHP7 = temp.get(1);
						currentMP1 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_7 && selectedSkill2){
						ArrayList<Integer> temp = attackOneEnemy(skillList1, 1, ally1, enemy3, currentHP1, currentHP7, currentMP1);
						currentHP1 = temp.get(0);
						currentHP7 = temp.get(1);
						currentMP1 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_7 && selectedSkill3){
						ArrayList<Integer> temp = AttackAllEnemies(skillList1, 2, ally1, enemies, currentMP1, currentHP1);
						currentHP1 = temp.get(0);
						currentMP1 = temp.get(1);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_7 && selectedSkill4){
						ArrayList<Integer> temp = attackOneEnemy(skillList1, 3, ally1, enemy3, currentHP1, currentHP7, currentMP1);
						currentHP1 = temp.get(0);
						currentHP7 = temp.get(1);
						currentMP1 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_8 && selectedSkill){
						ArrayList<Integer> temp = attackOneEnemy(skillList1, 0, ally1, enemy4, currentHP1, currentHP8, currentMP1);
						currentHP1 = temp.get(0);
						currentHP8 = temp.get(1);
						currentMP1 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_8 && selectedSkill2){
						ArrayList<Integer> temp = attackOneEnemy(skillList1, 1, ally1, enemy4, currentHP1, currentHP8, currentMP1);
						currentHP1 = temp.get(0);
						currentHP8 = temp.get(1);
						currentMP1 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_8 && selectedSkill3){
						ArrayList<Integer> temp = AttackAllEnemies(skillList1, 2, ally1, enemies, currentMP1, currentHP1);
						currentHP1 = temp.get(0);
						currentMP1 = temp.get(1);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_8 && selectedSkill4){
						ArrayList<Integer> temp = attackOneEnemy(skillList1, 3, ally1, enemy4, currentHP1, currentHP8, currentMP1);
						currentHP1 = temp.get(0);
						currentHP8 = temp.get(1);
						currentMP1 = temp.get(2);
						update();
						game.repaint();
					}
					if (selectedSkill || selectedSkill2 || selectedSkill3 ||selectedSkill4){
						if(e.getKeyCode()== KeyEvent.VK_Z){
							resetter();
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
					if(e.getKeyCode()== KeyEvent.VK_W){
						battleMessage = "You have selected " + skillList2.get(1).getName() + ". Choose an enemy to use it on them.";
						selectedSkill2 = true;
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_E){
						battleMessage = "You have selected " + skillList2.get(2).getName() + ". Choose an enemy to use it on them.";
						selectedSkill3 = true;
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_R){
						battleMessage = "You have selected " + skillList2.get(3).getName() + ". Choose an enemy to use it on them.";
						selectedSkill4 = true;
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_5 && selectedSkill){
						ArrayList<Integer> temp = attackOneEnemy(skillList2, 0, ally2, enemy1, currentHP2, currentHP5, currentMP2);
						currentHP2 = temp.get(0);
						currentHP5 = temp.get(1);
						currentMP2 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_5 && selectedSkill2){
						ArrayList<Integer> temp = attackOneEnemy(skillList2, 1, ally2, enemy1, currentHP2, currentHP5, currentMP2);
						currentHP2 = temp.get(0);
						currentHP5 = temp.get(1);
						currentMP2 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_5 && selectedSkill3){
						ArrayList<Integer> temp = attackOneEnemy(skillList2, 2, ally2, enemy1, currentHP2, currentHP5, currentMP2);
						currentHP2 = temp.get(0);
						currentHP5 = temp.get(1);
						currentMP2 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_5 && selectedSkill4){
						ArrayList<Integer> temp = attackOneEnemy(skillList2, 3, ally2, enemy1, currentHP2, currentHP5, currentMP2);
						currentHP2 = temp.get(0);
						currentHP5 = temp.get(1);
						currentMP2 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_6 && selectedSkill){
						ArrayList<Integer> temp = attackOneEnemy(skillList2, 0, ally2, enemy2, currentHP2, currentHP6, currentMP2);
						currentHP2 = temp.get(0);
						currentHP6 = temp.get(1);
						currentMP2 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_6 && selectedSkill2){
						ArrayList<Integer> temp = attackOneEnemy(skillList2, 1, ally2, enemy2, currentHP2, currentHP6, currentMP2);
						currentHP2 = temp.get(0);
						currentHP6 = temp.get(1);
						currentMP2 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_6 && selectedSkill3){
						ArrayList<Integer> temp = attackOneEnemy(skillList2, 2, ally2, enemy2, currentHP2, currentHP6, currentMP2);
						currentHP2 = temp.get(0);
						currentHP6 = temp.get(1);
						currentMP2 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_6 && selectedSkill4){
						ArrayList<Integer> temp = attackOneEnemy(skillList2, 3, ally2, enemy2, currentHP2, currentHP6, currentMP2);
						currentHP2 = temp.get(0);
						currentHP6 = temp.get(1);
						currentMP2 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_7 && selectedSkill){
						ArrayList<Integer> temp = attackOneEnemy(skillList2, 0, ally2, enemy3, currentHP2, currentHP7, currentMP2);
						currentHP2 = temp.get(0);
						currentHP7 = temp.get(1);
						currentMP2 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_7 && selectedSkill2){
						ArrayList<Integer> temp = attackOneEnemy(skillList2, 1, ally2, enemy3, currentHP2, currentHP7, currentMP2);
						currentHP2 = temp.get(0);
						currentHP7 = temp.get(1);
						currentMP2 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_7 && selectedSkill3){
						ArrayList<Integer> temp = attackOneEnemy(skillList2, 2, ally2, enemy3, currentHP2, currentHP7, currentMP2);
						currentHP2 = temp.get(0);
						currentHP7 = temp.get(1);
						currentMP2 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_7 && selectedSkill4){
						ArrayList<Integer> temp = attackOneEnemy(skillList2, 3, ally2, enemy3, currentHP2, currentHP7, currentMP2);
						currentHP2 = temp.get(0);
						currentHP7 = temp.get(1);
						currentMP2 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_8 && selectedSkill){
						ArrayList<Integer> temp = attackOneEnemy(skillList2, 0, ally2, enemy4, currentHP2, currentHP8, currentMP2);
						currentHP2 = temp.get(0);
						currentHP8 = temp.get(1);
						currentMP2 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_8 && selectedSkill2){
						ArrayList<Integer> temp = attackOneEnemy(skillList2, 1, ally2, enemy4, currentHP2, currentHP8, currentMP2);
						currentHP2 = temp.get(0);
						currentHP8 = temp.get(1);
						currentMP2 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_8 && selectedSkill3){
						ArrayList<Integer> temp = attackOneEnemy(skillList2, 2, ally2, enemy4, currentHP2, currentHP8, currentMP2);
						currentHP2 = temp.get(0);
						currentHP8 = temp.get(1);
						currentMP2 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_8 && selectedSkill4){
						ArrayList<Integer> temp = attackOneEnemy(skillList2, 3, ally2, enemy4, currentHP2, currentHP8, currentMP2);
						currentHP2 = temp.get(0);
						currentHP8 = temp.get(1);
						currentMP2 = temp.get(2);
						update();
						game.repaint();
					}
					if (selectedSkill || selectedSkill2 || selectedSkill3 ||selectedSkill4){
						if(e.getKeyCode()== KeyEvent.VK_Z){
							resetter();
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
					if(e.getKeyCode()== KeyEvent.VK_W){
						battleMessage = "You have selected " + skillList3.get(1).getName() + ". Choose an enemy to use it on them.";
						selectedSkill2 = true;
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_E){
						battleMessage = "You have selected " + skillList3.get(2).getName() + ". Choose an enemy to use it on them.";
						selectedSkill3 = true;
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_R){
						battleMessage = "You have selected " + skillList3.get(3).getName() + ". Choose an enemy to use it on them.";
						selectedSkill4 = true;
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_5 && selectedSkill){
						ArrayList<Integer> temp = AttackAllEnemies(skillList3, 0, ally3, enemies, currentMP3, currentHP3);
						currentHP3 = temp.get(0);
						currentMP3 = temp.get(1);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_5 && selectedSkill2){
						ArrayList<Integer> temp = AttackAllEnemies(skillList3, 1, ally3, enemies, currentMP3, currentHP3);
						currentHP3 = temp.get(0);
						currentMP3 = temp.get(1);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_5 && selectedSkill3){
						ArrayList<Integer> temp = attackOneEnemy(skillList3, 2, ally3, enemy1, currentHP3, currentHP5, currentMP3);
						currentHP3 = temp.get(0);
						currentHP5 = temp.get(1);
						currentMP3 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_5 && selectedSkill4){
						ArrayList<Integer> temp = attackOneEnemy(skillList3, 3, ally3, enemy1, currentHP3, currentHP5, currentMP3);
						currentHP3 = temp.get(0);
						currentHP5 = temp.get(1);
						currentMP3 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_6 && selectedSkill){
						ArrayList<Integer> temp = AttackAllEnemies(skillList3, 0, ally3, enemies, currentMP3, currentHP3);
						currentHP3 = temp.get(0);
						currentMP3 = temp.get(1);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_6 && selectedSkill2){
						ArrayList<Integer> temp = AttackAllEnemies(skillList3, 1, ally3, enemies, currentMP3, currentHP3);
						currentHP3 = temp.get(0);
						currentMP3 = temp.get(1);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_6 && selectedSkill3){
						ArrayList<Integer> temp = attackOneEnemy(skillList3, 2, ally3, enemy2, currentHP3, currentHP6, currentMP3);
						currentHP3 = temp.get(0);
						currentHP6 = temp.get(1);
						currentMP3 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_6 && selectedSkill4){
						ArrayList<Integer> temp = attackOneEnemy(skillList3, 3, ally3, enemy2, currentHP3, currentHP6, currentMP3);
						currentHP3 = temp.get(0);
						currentHP6 = temp.get(1);
						currentMP3 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_7 && selectedSkill){
						ArrayList<Integer> temp = AttackAllEnemies(skillList3, 0, ally3, enemies, currentMP3, currentHP3);
						currentHP3 = temp.get(0);
						currentMP3 = temp.get(1);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_7 && selectedSkill2){
						ArrayList<Integer> temp = AttackAllEnemies(skillList3, 1, ally3, enemies, currentMP3, currentHP3);
						currentHP3 = temp.get(0);
						currentMP3 = temp.get(1);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_7 && selectedSkill3){
						ArrayList<Integer> temp = attackOneEnemy(skillList3, 2, ally3, enemy3, currentHP3, currentHP7, currentMP3);
						currentHP3 = temp.get(0);
						currentHP7 = temp.get(1);
						currentMP3 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_7 && selectedSkill4){
						ArrayList<Integer> temp = attackOneEnemy(skillList3, 3, ally3, enemy3, currentHP3, currentHP7, currentMP3);
						currentHP3 = temp.get(0);
						currentHP7 = temp.get(1);
						currentMP3 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_8 && selectedSkill){
						ArrayList<Integer> temp = AttackAllEnemies(skillList3, 0, ally3, enemies, currentMP3, currentHP3);
						currentHP3 = temp.get(0);
						currentMP3 = temp.get(1);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_8 && selectedSkill2){
						ArrayList<Integer> temp = AttackAllEnemies(skillList3, 1, ally3, enemies, currentMP3, currentHP3);
						currentHP3 = temp.get(0);
						currentMP3 = temp.get(1);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_8 && selectedSkill3){
						ArrayList<Integer> temp = attackOneEnemy(skillList3, 2, ally3, enemy4, currentHP3, currentHP8, currentMP3);
						currentHP3 = temp.get(0);
						currentHP8 = temp.get(1);
						currentMP3 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_8 && selectedSkill4){
						ArrayList<Integer> temp = attackOneEnemy(skillList3, 3, ally3, enemy4, currentHP3, currentHP8, currentMP3);
						currentHP3 = temp.get(0);
						currentHP8 = temp.get(1);
						currentMP3 = temp.get(2);
						update();
						game.repaint();
					}
					if (selectedSkill || selectedSkill2 || selectedSkill3 ||selectedSkill4){
						if(e.getKeyCode()== KeyEvent.VK_Z){
							resetter();
							update();
							game.repaint();
						}
					}
				}
				if (onFourth){
					if(e.getKeyCode()== KeyEvent.VK_Q){
						battleMessage = "You have selected " + skillList4.get(0).getName() + ". Choose an enemy to use it on them.";
						selectedSkill = true;
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_W){
						battleMessage = "You have selected " + skillList4.get(1).getName() + ". Choose an enemy to use it on them.";
						selectedSkill2 = true;
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_E){
						battleMessage = "You have selected " + skillList4.get(2).getName() + ". Choose an enemy to use it on them.";
						selectedSkill3 = true;
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_R){
						battleMessage = "You have selected " + skillList4.get(3).getName() + ". Choose an enemy to use it on them.";
						selectedSkill4 = true;
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_5 && selectedSkill){
						ArrayList<Integer> temp = attackOneEnemy(skillList4, 0, ally4, enemy1, currentHP4, currentHP5, currentMP4);
						currentHP4 = temp.get(0);
						currentHP5 = temp.get(1);
						currentMP4 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_5 && selectedSkill2){
						ArrayList<Integer> temp = attackOneEnemy(skillList4, 1, ally4, enemy1, currentHP4, currentHP5, currentMP4);
						currentHP4 = temp.get(0);
						currentHP5 = temp.get(1);
						currentMP4 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_5 && selectedSkill3){
						ArrayList<Integer> temp = AttackAllEnemies(skillList4, 2, ally4, enemies, currentMP4, currentHP4);
						currentHP4 = temp.get(0);
						currentMP4 = temp.get(1);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_5 && selectedSkill4){
						ArrayList<Integer> temp = attackOneEnemy(skillList4, 3, ally4, enemy1, currentHP4, currentHP5, currentMP4);
						currentHP4 = temp.get(0);
						currentHP5 = temp.get(1);
						currentMP4 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_6 && selectedSkill){
						ArrayList<Integer> temp = attackOneEnemy(skillList4, 0, ally4, enemy2, currentHP4, currentHP6, currentMP4);
						currentHP4 = temp.get(0);
						currentHP6 = temp.get(1);
						currentMP4 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_6 && selectedSkill2){
						ArrayList<Integer> temp = attackOneEnemy(skillList4, 1, ally4, enemy2, currentHP4, currentHP6, currentMP4);
						currentHP4 = temp.get(0);
						currentHP6 = temp.get(1);
						currentMP4 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_6 && selectedSkill3){
						ArrayList<Integer> temp = AttackAllEnemies(skillList4, 2, ally4, enemies, currentMP4, currentHP4);
						currentHP4 = temp.get(0);
						currentMP4 = temp.get(1);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_6 && selectedSkill4){
						ArrayList<Integer> temp = attackOneEnemy(skillList4, 3, ally4, enemy2, currentHP4, currentHP6, currentMP4);
						currentHP4 = temp.get(0);
						currentHP6 = temp.get(1);
						currentMP4 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_7 && selectedSkill){
						ArrayList<Integer> temp = attackOneEnemy(skillList4, 0, ally4, enemy3, currentHP4, currentHP7, currentMP4);
						currentHP4 = temp.get(0);
						currentHP7 = temp.get(1);
						currentMP4 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_7 && selectedSkill2){
						ArrayList<Integer> temp = attackOneEnemy(skillList4, 1, ally4, enemy3, currentHP4, currentHP7, currentMP4);
						currentHP4 = temp.get(0);
						currentHP7 = temp.get(1);
						currentMP4 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_7 && selectedSkill3){
						ArrayList<Integer> temp = AttackAllEnemies(skillList4, 2, ally4, enemies, currentMP4, currentHP4);
						currentHP4 = temp.get(0);
						currentMP4 = temp.get(1);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_7 && selectedSkill4){
						ArrayList<Integer> temp = attackOneEnemy(skillList4, 3, ally4, enemy3, currentHP4, currentHP7, currentMP4);
						currentHP4 = temp.get(0);
						currentHP7 = temp.get(1);
						currentMP4 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_8 && selectedSkill){
						ArrayList<Integer> temp = attackOneEnemy(skillList4, 0, ally4, enemy4, currentHP4, currentHP8, currentMP4);
						currentHP4 = temp.get(0);
						currentHP8 = temp.get(1);
						currentMP4 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_8 && selectedSkill2){
						ArrayList<Integer> temp = attackOneEnemy(skillList4, 1, ally4, enemy4, currentHP4, currentHP8, currentMP4);
						currentHP4 = temp.get(0);
						currentHP8 = temp.get(1);
						currentMP4 = temp.get(2);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_8 && selectedSkill3){
						ArrayList<Integer> temp = AttackAllEnemies(skillList4, 2, ally4, enemies, currentMP4, currentHP4);
						currentHP4 = temp.get(0);
						currentMP4 = temp.get(1);
						update();
						game.repaint();
					}
					if(e.getKeyCode()== KeyEvent.VK_8 && selectedSkill4){
						ArrayList<Integer> temp = attackOneEnemy(skillList4, 3, ally4, enemy4, currentHP4, currentHP8, currentMP4);
						currentHP4 = temp.get(0);
						currentHP8 = temp.get(1);
						currentMP4 = temp.get(2);
						update();
						game.repaint();
					}
					if (selectedSkill || selectedSkill2 || selectedSkill3 ||selectedSkill4){
						if(e.getKeyCode()== KeyEvent.VK_Z){
							resetter();
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
					if (e.getKeyCode() == KeyEvent.VK_E){
						battleMessage = "You have selected " + inventory.get(2).getName() + ". Please choose an ally target to use on.";
						selectItem2 = true;
						update();
						game.repaint();
					}
					if (e.getKeyCode() == KeyEvent.VK_R){
						battleMessage = "You have selected " + inventory.get(3).getName() + ". Please choose an ally target to use on.";
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
						resetter();
						update();
						game.repaint();
					}
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
