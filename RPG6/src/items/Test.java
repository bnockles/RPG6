package items;

import spell.test.Inventory;

/**
 * Class to run unit tests in.
 * @class Test 
 */
public final class Test {

	class InventoryTest implements Testable{
		public static boolean notEmpty(Inventory inv, String id){
			return inv.getStock(id) > 0;
		}
		
		public boolean test(){
			Inventory one = new Inventory();
			  		  one.addStock("test");
			  		  one.addStock("test");

			assert(notEmpty(one, "test"));
		}
	}
	
	
	public static void main(String[] args) {
		
	}
}

interface Testable {
	boolean test();
}