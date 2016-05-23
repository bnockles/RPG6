package items;

import java.util.ArrayList;

public class equipStock {
	
	public static ArrayList<Item> recipe = new ArrayList<Item>();
	public static final int B_SD = 0;
	public static final int S_SD = 1;
	public static final int G_SD = 2;
	public static final int P_SD = 3;
	public static final int B_DR = 4;
	public static final int S_DR = 5;
	public static final int G_DR = 6;
	public static final int P_DR = 7;
	public static final int W_BW = 8;
	public static final int I_BW = 9;
	public static final int P_BW = 10;
	public static final int D_BW = 11;
	public static final int W_WD = 12;
	public static final int M_WD = 13;
	public static final int F_WD = 14;
	public static final int A_WD = 15;
	public static final int E_SF = 16;
	public static final int R_SF = 17;
	public static final int Q_SF = 18;
	public static final int S_SF = 19;
	public static final int W_SR = 20;
	public static final int G_SR = 21;
	public static final int B_SR = 22;
	public static final int SR_D = 23;
	public static final int G_HR = 24;
	public static final int M_HR = 25;
	public static final int D_HR = 26;
	public static final int P_HR = 27;
	public static final int W_SD = 28;
	public static final int I_SD = 29;
	public static final int T_WL = 30;
	public static final int GS_D = 31;
	public static final int W_CE = 32;
	public static final int I_CE = 33;
	public static final int D_CE = 34;
	public static final int D_AR = 35;
	public static final int L_PT = 36;
	public static final int S_PT = 37;
	public static final int GW_P = 38;
	public static final int F_LG = 39;
	public static final int S_HT = 40;
	public static final int I_HT = 41;
	public static final int P_HT = 42;
	public static final int S_HD = 43;
	public static final int R_SE = 44;
	public static final int R_BT = 45;
	public static final int A_SE = 46;
	public static final int G_SL = 47;
	
	public static Equipment equipStocks(int type) {
		if (type == B_SD){
			return new Equipment("Bronze Sword", "REQ: LVL1, 5 STR", "This bronze sword is as useless as wood.", "None", 0, 0, 5, new Stats(5, 5, 1, 0, 0, 1), 100, new CraftHelper(true, recipe));
		}
		if (type == S_SD){
			return new Equipment("Silver Sword", "REQ: LVL8, 15 STR", "This silver sword is a little better. It can cut flesh.", "None", 0, 0, 5, new Stats(20, 15, 3, 0, 0, 3),100, new CraftHelper(true, recipe));
		}
		if (type == G_SD){
			return new Equipment("Gold Sword", "REQ: LVL19, 35 STR", "This golden sword forged with passion. It can slice through any armor", "None", 0, 0, 5, new Stats(50, 35, 5, 0, 0, 5), 100, new CraftHelper(true, recipe));
		}
		if (type == P_SD){
			return new Equipment("Plat Sword", "REQ: LVL30, 75 STR", "Unbreakable platinum. This sword is the best of its class.", "None", 0, 0, 5, new Stats(80, 75, 10, 1, 1, 10), 100, new CraftHelper(true, recipe));
		}
		if (type == B_DR){
			return new Equipment("Bronze Dagger", "REQ: LVL1, 6 STR", "This bronze dagger can cut vegetables.", "None", 0, 0, 5, new Stats(5, 6, 1, 0, 0, 1), 100, new CraftHelper(true, recipe));
		}
		if (type == S_DR){
			return new Equipment("Silver Dagger", "REQ: LVL7, 18 STR", "This silver dagger is good for quick kills.", "None", 0, 0, 5, new Stats(20, 18, 3, 0, 0, 3), 100, new CraftHelper(true, recipe));
		}
		if (type == G_DR){
			return new Equipment("Gold Dagger", "REQ: LVL16, 40 STR", "This golden dagger has been used on many assassination missions.", "None", 0, 0, 5, new Stats(50, 40, 5, 0, 0, 5), 100, new CraftHelper(true, recipe));
		}
		if (type == P_DR){
			return new Equipment("Plat Dagger", "REQ: LVL29, 80 STR", "This platinum dagger is used for extensive ninja operations.", "None", 0, 0, 5, new Stats(80, 80, 10, 1, 1, 10), 100, new CraftHelper(true, recipe));
		}
		if (type == W_BW){
			return new Equipment("Wooden Bow", "REQ: LVL1, 1 STR; 5 DEX", "This wooden bow can kill small animals.", "None", 0, 0, 5, new Stats(5, 1, 5, 0, 0, 1), 100, new CraftHelper(true, recipe));
		}
		if (type == I_BW){
			return new Equipment("Iron Bow", "REQ: LVL9, 5 STR; 15 DEX", "With sharper precision, it's good for hunting humans.", "None", 0, 0, 5, new Stats(20, 5, 15, 0, 0, 3), 100, new CraftHelper(true, recipe));
		}
		if (type == P_BW){
			return new Equipment("Plat Bow", "REQ: LVL21, 10 STR, 35 DEX", "Gleaming with power, this bow can pierce any flesh and armor.", "None", 0, 0, 5, new Stats(50, 12, 36, 0, 0, 5), 100, new CraftHelper(true, recipe));
		}
		if (type == D_BW){
			return new Equipment("Diamond Bow", "REQ: LVL31, 16 STR; 75 DEX", "Unbreakable and destructive; This diamond bow will reign through any battle.", "None", 0, 0, 5, new Stats(80, 16, 75, 0, 0, 10), 100, new CraftHelper(true, recipe));
		}
		if (type == W_WD){
			return new Equipment("Wooden Wand", "REQ: LVL1, 5 INT", "This wooden wand can cast very basic skills without breaking", "None", 0, 0, 5, new Stats(5, 0, 0, 5, 5, 1), 100, new CraftHelper(true, recipe));
		}
		if (type == M_WD){
			return new Equipment("Mithril Wand", "REQ: LVL7, 15 INT", "This mithril wand is forged by the goddess's of this planet.", "None", 0, 0, 5, new Stats(15, 0, 0, 15, 10, 3), 100, new CraftHelper(true, recipe));
		}
		if (type == F_WD){
			return new Equipment("Fairy's Wand", "REQ: LVL18, 35 INT, 20 WIS", "Fairies inherited their magic into this wand", "None", 0, 0, 5, new Stats(50, 0, 0, 35, 24, 5), 100, new CraftHelper(true, recipe));
		}
		if (type == A_WD){
			return new Equipment("Angel's Wand", "REQ: LVL30, 75 INT, 50 WIS", "Reincarnated Angels crafted their souls into this very object.", "None", 0, 0, 5, new Stats(80, 0, 0, 80, 60, 10), 100, new CraftHelper(true, recipe));
		}
		if (type == E_SF){
			return new Equipment("Emerald Staff", "REQ: LVL1, 10 INT", "Putting an emerald magic stone onto a stick. Very clever.", "None", 0, 0, 5, new Stats(8, 0, 0, 10, 10, 1), 100, new CraftHelper(true, recipe));
		}
		if (type == R_SF){
			return new Equipment("Emerald Staff", "REQ: LVL10, 45 INT", "Harnesses the powers of the fire ruby.", "None", 0, 0, 5, new Stats(40, 0, 0, 50, 40, 5), 100, new CraftHelper(true, recipe));
		}
		if (type == Q_SF){
			return new Equipment("Queen's Staff", "REQ: LVL22, 75 INT", "From the queen herself. Forged by the servants of the queen.", "None", 0, 0, 5, new Stats(70, 0, 0, 75, 50, 10), 100, new CraftHelper(true, recipe));
		}
		if (type == S_SF){
			return new Equipment("Sun Goddess's Staff", "REQ: LVL35, 100 INT", "With the power of a thousand suns. The Sun Goddess's Staff is the stronget of its kind", "None", 0, 0, 5, new Stats(90, 0, 0, 100, 65, 20), 100, new CraftHelper(true, recipe));
		}
		if (type == W_SR){
			return new Equipment("Wooden Spear", "REQ: LVL1, 5 STR", "This wooden spear will break when it hits any type of armor.", "None", 0, 0, 5, new Stats(5, 5, 1, 0, 0, 1), 100, new CraftHelper(true, recipe));
		}
		if (type == G_SR){
			return new Equipment("Golden Spear", "REQ: LVL11, 20 STR", "A spear made of gold. Stronger than it looks.", "None", 0, 0, 5, new Stats(20, 20, 3, 0, 0, 3), 100, new CraftHelper(true, recipe));
		}
		if (type == B_SR){
			return new Equipment("Battle Axe Spear", "REQ: LVL24, 50 STR", "Equipped with a battle axe at the end of the pole. Scary.", "None", 0, 0, 5, new Stats(50, 50, 5, 0, 0, 5), 100, new CraftHelper(true, recipe));
		}
		if (type == SR_D){
			return new Equipment("Spear of Destruction", "REQ: LVL35, 99 STR", "Harnesses the dark powers to invoke world destruction.", "None", 0, 0, 5, new Stats(120, 100, 10, 1, 1, 10), 100, new CraftHelper(true, recipe));
		}
		if (type == G_HR){
			return new Equipment("Golden Hammer", "REQ: LVL1, 5 STR", "Harder than steel. A hammer that will serve it's purpose", "None", 0, 0, 5, new Stats(5, 5, 1, 0, 0, 1), 100, new CraftHelper(true, recipe));
		}
		if (type == M_HR){
			return new Equipment("Mithril Hammer", "REQ: LVL10, 15 STR", "Forged with fascinating gems. Adds a twist of powers", "None", 0, 0, 5, new Stats(15, 15, 3, 0, 0, 3), 100, new CraftHelper(true, recipe));
		}
		if (type == D_HR){
			return new Equipment("Diamond Hammer", "REQ: LVL20, 35 STR", "Hardest of all hammers. Truly outrageous.", "None", 0, 0, 5, new Stats(35, 35, 5, 0, 0, 5), 100, new CraftHelper(true, recipe));
		}
		if (type == P_HR){
			return new Equipment("Poppy's Hammer", "REQ: LVL30, 70 STR", "Poppy's Hammer. It has lived through thousands of wars. An ancient killing weapon.", "None", 0, 0, 5, new Stats(70, 70, 10, 0, 0, 10), 100, new CraftHelper(true, recipe));
		}
		if (type == W_SD){
			return new Equipment("Wooden Shield", "REQ: LVL1, 5 STR", "It can defend against a snail... Probably?", "None", 0, 0, 5, new Stats(5, 5, 1, 0, 0, 1), 100, new CraftHelper(true, recipe));
		}
		if (type == I_SD){
			return new Equipment("Iron Shield", "REQ: LVL8, 15 STR", "Forged with decent materials. It will serve it's purpose; for the most part.", "None", 0, 0, 5, new Stats(15, 15, 3, 0, 0, 3), 100, new CraftHelper(true, recipe));
		}
		if (type == T_WL){
			return new Equipment("Tank's Will", "REQ: LVL16, 30 STR", "Brings out the will of the tank. Protects with passion.", "None", 0, 0, 5, new Stats(30, 30, 5, 0, 0, 5), 100, new CraftHelper(true, recipe));
		}
		if (type == GS_D){
			return new Equipment("God's Shield", "REQ: LVL35, 100 STR", "An undestructible shield. God forged it himself.", "None", 0, 0, 5, new Stats(100, 100, 10, 10, 10, 10), 100, new CraftHelper(true, recipe));
		}
		if (type == W_CE){
			return new Equipment("Wooden Chestplate", "REQ: NONE", "Blocks from any incoming attack, partially.", "None", 0, 0, 2, new Stats(10, 10, 10, 10, 10), 100, new CraftHelper(true, recipe));
		}
		if (type == I_CE){
			return new Equipment("Iron Chestplate", "REQ: LVL 12, 15 STR", "Guards the wearer from all physical attacks.", "None", 0, 0, 2, new Stats(20, 20, 20, 20, 20), 100, new CraftHelper(true, recipe));
		}
		if (type == D_CE){
			return new Equipment("Diamond Chestplate", "REQ: LVL21, 40 STR", "Hard as diamond. Well it is diamond. Very sturdy.", "None", 0, 0, 2, new Stats(40, 40, 30, 30, 30), 100, new CraftHelper(true, recipe));
		}
		if (type == D_AR){
			return new Equipment("Devil's Armor", "REQ: LVL38, 999 STR", "Armor made of darkness. Anyone who wears this will die. Anyone who doesn't is a devil.", "None", 0, 0, 2, new Stats(500, 500, 99, 99, 99), 100, new CraftHelper(true, recipe));
		}
		if (type == L_PT){
			return new Equipment("Leather Pants", "REQ: LVL1, 5 STR", "Pants of a leather. Sticks to the skin.", "None", 0, 0, 3, new Stats(5, 5, 0, 0, 0), 100, new CraftHelper(true, recipe));
		}
		if (type == S_PT){
			return new Equipment("Silk Pants", "REQ: LVL9, 15 STR", "Soft but protective.", "None", 0, 0, 3, new Stats(15, 15, 1, 1, 1), 100, new CraftHelper(true, recipe));
		}
		if (type == GW_P){
			return new Equipment("God Woven Pants", "REQ: LVL19, 50 STR", "God made these pants himself. They will never break.", "None", 0, 0, 3, new Stats(50, 55, 3, 3, 3), 100, new CraftHelper(true, recipe));
		}
		if (type == F_LG){
			return new Equipment("Forsaken Leggings", "REQ: LVL35, 100 STR", "Pants forbidden from this world. It's surging with power.", "None", 0, 0, 3, new Stats(100, 100, 5, 5, 5), 100, new CraftHelper(true, recipe));
		}
		if (type == S_HT){
			return new Equipment("Straw Hat", "REQ: LVL1, 5 STR", "Looks like a pirate will wear this hat. Old but fashionable.", "None", 0, 0, 1, new Stats(5, 5, 1, 1, 1), 100, new CraftHelper(true, recipe));
		}
		if (type == I_HT){
			return new Equipment("Iron Helmet", "REQ: LVL10, 20 STR", "Helmet that covers the whole face. For the sake of protection.", "None", 0, 0, 1, new Stats(20, 20, 3, 3, 3), 100, new CraftHelper(true, recipe));
		}
		if (type == P_HT){
			return new Equipment("Plat Helmet", "REQ: LVL22, 55 STR", "It's heavy. It is probably not a good idea to wear this if you have a squishy head.", "None", 0, 0, 1, new Stats(55, 50, 5, 5, 5), 100, new CraftHelper(true, recipe));
		}
		if (type == S_HD){
			return new Equipment("Satan's Headguard", "REQ: LVL45, 500 STR", "Stolen from Satan. Any human who wears this will turn into a devil.", "None", 0, 0, 1, new Stats(500, 500, 500, 500, 500), 100, new CraftHelper(true, recipe));
		}
		if (type == R_SE){
			return new Equipment("Running Shoes", "REQ: LVL1, 5 STR", "Shoes that make you run faster.", "None", 0, 0, 4, new Stats(5, 5, 1, 1, 1), 100, new CraftHelper(true, recipe));
		}
		if (type == R_BT){
			return new Equipment("Rain Boots", "REQ: LVL12, 15 STR", "Boots that help you in the rain.", "None", 0, 0, 4, new Stats(15, 15, 5, 5, 5), 100, new CraftHelper(true, recipe));
		}
		if (type == A_SE){
			return new Equipment("Armor Shoes", "REQ: LVL22, 45 STR", "Shoes that protect your feet. It helps protect the wearer generally too.", "None", 0, 0, 4, new Stats(45, 45, 10, 10, 10), 100, new CraftHelper(true, recipe));
		}
		if (type == G_SL){
			return new Equipment("God's Sandals", "REQ: LVL34, 100 STR", "God wears these sandals. They look weak and old, but they help a lot.", "None", 0, 0, 4, new Stats(100, 100, 100, 100, 100), 100, new CraftHelper(true, recipe));
		}
		return null;
	}

}
