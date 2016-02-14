package towns;

public interface repairable {
	 void reparelItem (Item item);
	 //checks item type to execute proper repair
}
public class weapons implements repairable{
	//Repairs weapons
}
public class armor implements repairable{
	//Repairs armor
}

