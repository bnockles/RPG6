package SonyaDemo;

import java.util.ArrayList;

public class SonyaDemoExecution {
	
	static ArrayList<ActiveSkills> activeSkills = new ArrayList<ActiveSkills>();
	static ArrayList<ActiveSkills> activeSkillsSorted = new ArrayList<ActiveSkills>();
	static ArrayList<ActiveSkills> lowSkills = new ArrayList<ActiveSkills>();
	static ArrayList<ActiveSkills> medSkills = new ArrayList<ActiveSkills>();
	static ArrayList<ActiveSkills> highSkills = new ArrayList<ActiveSkills>();
	static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	static ArrayList<Enemy> enemiesSorted = new ArrayList<Enemy>();
	static ArrayList<Enemy> lowEnemies = new ArrayList<Enemy>();
	static ArrayList<Enemy> medEnemies = new ArrayList<Enemy>();
	static ArrayList<Enemy> highEnemies = new ArrayList<Enemy>();
	public static ArrayList<Enemy> createEnemies(){
		
		for(int i=0;i<15;i++){
			enemies.add(new Enemy((int)(Math.random()*(11)+1)));
		}
		return enemies;
	}
	public static ArrayList<ActiveSkills> createActiveSkills(){
		for(int i=0;i<15;i++){
			activeSkills.add(new ActiveSkills((int)(Math.random()*(100)+1)));
		}
		return activeSkills;
	}
	public static ArrayList<Enemy> getEnemies(){
		return enemies;
	}
	public static ArrayList<ActiveSkills> getSkills(){
		return activeSkills;
	}
	public static ArrayList<Enemy> sortAndOrganize(ArrayList<Enemy> enemies){
		//enemies
		for(int i=0;i<enemies.size();i++){
			int min = 0;
			int minIdx = i;
			for(int j=i+1;j<enemies.size();j++){
				min = enemies.get(minIdx).getLevel();
				if(enemies.get(j).getLevel()<min){
					minIdx=j;
					min=enemies.get(j).getLevel();
				}
			}
			enemiesSorted.add(enemies.get(min));
			enemies.remove(minIdx);
			}
			//enemiesSorted.add(enemies.get(min));
			//enemies.remove(minIdx);
		System.out.println("Sorted enemies:");
		for(int i=0;i<enemiesSorted.size();i++){
			System.out.println(enemiesSorted.get(i).getLevel()+"");
		}
		for(int i=0;i<enemiesSorted.size();i++){
			if(i>=0&&i<enemiesSorted.size()/3){
				lowEnemies.add(enemiesSorted.get(i));
			}
			if(i>=(enemiesSorted.size()/3)&&i<(enemiesSorted.size()/3)*2){
				medEnemies.add(enemiesSorted.get(i));
			}
			if(i>=(enemiesSorted.size()/3)*2&&i<enemiesSorted.size()){
				highEnemies.add(enemiesSorted.get(i));
			}
		}
		return enemiesSorted;
	}
	public static ArrayList<ActiveSkills> sortAndOrganizeSkills(ArrayList<ActiveSkills> activeSkills){
		System.out.println("Unsorted Active SKills: ");
		for(int i=0;i<activeSkills.size();i++){
			System.out.println(activeSkills.get(i).getDamage());
		}
		for(int i=0;i<activeSkills.size();i++){
			//int activeSkillsDmgMin = activeSkills.get(i).getDamage();
			int min;
			int minIdx = i;
			for(int j=i+1;j<activeSkills.size();j++){
				min = activeSkills.get(minIdx).getDamage();
				if(activeSkills.get(j).getDamage()<min){
					minIdx=j;
					min=activeSkills.get(j).getDamage();
				}
			}
			activeSkillsSorted.add(activeSkills.get(minIdx));
			activeSkills.remove(minIdx);
		}
		System.out.println("Sorted Active SKills: ");
		for(int i=0;i<activeSkillsSorted.size();i++){
			System.out.println(activeSkillsSorted.get(i).getDamage());
		}
		
		for(int i=0;i<activeSkillsSorted.size();i++){
			if(i>=0&&i<activeSkillsSorted.size()/3){
				lowSkills.add(activeSkillsSorted.get(i));
			}
			if(i>=(activeSkillsSorted.size()/3)&&i<(activeSkillsSorted.size()/3)*2){
				medSkills.add(activeSkillsSorted.get(i));
			}
			if(i>=(activeSkillsSorted.size()/3)*2&&i<activeSkillsSorted.size()){
				highSkills.add(activeSkillsSorted.get(i));
			}
		}
		return activeSkillsSorted;
	}
	
	public static ArrayList<ActiveSkills> getSkills(Enemy enemy){
		/*PRECONDITION: the damage level of the enemy is one that exists in an array list declared above
		 * to do: 
		 * find which level of skill, and then go to that arrayList
		 * 
		 * */
		ArrayList<ActiveSkills> skillsList = getSkillList(enemy, enemiesSorted);
		int skillSize = skillsList.size();
		if(skillSize<=6)return skillsList;
		else{
			while(skillSize>=6){
				skillsList.remove((int)Math.random()*skillSize);
			}
			
		}
		return skillsList;
	}
	private static ArrayList<ActiveSkills> getSkillList(Enemy enemy, ArrayList<Enemy> sortedEnemies) {
		// TODO Auto-generated method stub
		int enemyLvl = enemy.getLevel();
		System.out.println("Enemy Level: "+enemyLvl+"");
		for(int i=0;i<sortedEnemies.size();i++){
			System.out.print("Sorted Enemy Level:"+sortedEnemies.get(i).getLevel());
			if(enemiesSorted.get(i).getLevel()==enemyLvl){
				if(i>=0&&i<enemiesSorted.size()/3){
					return lowSkills;
				}
				else if(i>=(sortedEnemies.size()/3)&&i<(sortedEnemies.size()/3)*2){
					return medSkills;
				}
				else if(i>=(sortedEnemies.size()/3)*2&&i<sortedEnemies.size()){
					return highSkills;
				}
			}
		}
		return null;
	}
	
	
	
	
}

