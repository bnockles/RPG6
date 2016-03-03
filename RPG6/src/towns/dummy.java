package towns;

public class dummy extends AbstractNPC{

	public dummy(String nm, String gen, String des, boolean talkable) {
		super(nm, gen, des, talkable);
		// TODO Auto-generated constructor stub
	}

	public String getNpcMessages(int dummyCounter){
		String message = "";
		switch(TownScreen.dummyCounter){
		case 1:  message = " Did you know, while programming this demo, developer Khandaker Shayel was on 3 kinds of red bull and listening to Kpop music?";
		break;
		case 2:  message = "All the storage dudes look the same... I secretly think they are all clones of each other! And how do they all store the same items when they are in different towns???";
		break;
		case 3:  message = "Are you Con Duh Kurr? Wow you are the most good looking guy I have ever met!";
		break;
		case 4:  message = "The merchants are so hot! If only I had money to talk to them... Then again if i had money I would buy the amazing items they sell.";
		break;
		case 5:  message = "The mini games here are so fun! It help me made some gems too!";
		break;
		default: message = "Thanks for playing the demo!";
		break; 
		}
		return message;
	}
	
	
	@Override
	public void npcMovement() {
		// TODO Auto-generated method stub
		
	}

}
