package items;


/**
 * Class to run unit tests in.
 * @class Test 
 */
public final class Test {
	public static void main(String[] args) {
		new InventoryTest().test();
	}
	
	
	public static void assertEqual(double actual, double expected, String title){
		System.out.println(title);
		
		if(actual == expected){
			System.out.println("\tAssert passed! " + actual + ", " + expected);
		}
		else{
			System.out.println("\tAssert failed! expected " + expected + "; got " + actual + " instead.");
		}
	}
	
	public static void assertEqual(boolean actual, boolean expected, String title){
		System.out.println(title);
		
		if(actual == expected){
			System.out.println("\tAssert passed! " + actual + ", " + expected);
		}
		else{
			System.out.println("\tAssert failed! expected " + expected + "; got " + actual + " instead.");
		}
	}
	
	public static void assertSimilar(Object actual, Object expected, String title){
		System.out.println(title);
		
		if(actual.equals(expected)){
			System.out.println("\tAssert passed! " + actual.toString() + ", " + expected.toString());
		}
		else{
			System.out.println("\tAssert failed! expected " + expected.toString() + "; got " + actual.toString() + " instead.");
		}
	}
}



interface Testable {
	public void test();
}


class InventoryTest implements Testable{
	private boolean notEmpty(Inventory inv, String id){
		return inv.getStock(id) > 0;
	}
	
	
	public void test(){
		Inventory one = new Inventory();
		  		  one.addStock("test");
		  		  one.addStock("test");

		Test.assertEqual(notEmpty(one,"test"), 	true, 	"Inv not empty test");
		Test.assertEqual(one.getStock("test"), 	2, 		"Inv proper stock test: 0");
		Test.assertEqual(one.getStock("foob"), 	0, 		"Inv proper stock test: 1");
	}
}

