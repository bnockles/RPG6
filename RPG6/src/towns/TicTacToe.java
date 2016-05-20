package towns;

public class TicTacToe{
    
    public static int playerResponse(String statement,String[][]tictac,int originalBlank,int newBlank){
        while(newBlank==originalBlank){
				newBlank = 0;
				
				statement = Main.in.nextLine();
				
				if(Main.findKeyword(statement,"1",0)>=0 && statement.length()==1){
					if(tictac[0][0]==" "){
						tictac[0][0] = "x";
					}
					else{
					    System.out.println("This box is already filled please enter a different number");			
					}
				}
				if(Main.findKeyword(statement,"2",0)>=0 && statement.length()==1){
					if(tictac[0][1]==" "){
						tictac[0][1] = "x";
					}
					else{
					    System.out.println("This box is already filled please enter a different number");			
					}
				}
				if(Main.findKeyword(statement,"3",0)>=0 && statement.length()==1){
					if(tictac[0][2]==" "){
						tictac[0][2] = "x";
					}
					else{
					    System.out.println("This box is already filled please enter a different number");			
					}
				}
				if(Main.findKeyword(statement,"4",0)>=0 && statement.length()==1){
					if(tictac[1][0]==" "){
						tictac[1][0] = "x";
					}
					else{
					    System.out.println("This box is already filled please enter a different number");			
					}
				}
				if(Main.findKeyword(statement,"5",0)>=0 && statement.length()==1){
					if(tictac[1][1]==" "){
						tictac[1][1] = "x";
					}
					else{
					    System.out.println("This box is already filled please enter a different number");			
					}
				}
				if(Main.findKeyword(statement,"6",0)>=0 && statement.length()==1){
					if(tictac[1][2]==" "){
						tictac[1][2] = "x";
					}
					else{
					    System.out.println("This box is already filled please enter a different number");			
					}
				}
				if(Main.findKeyword(statement,"7",0)>=0 && statement.length()==1){
					if(tictac[2][0]==" "){
						tictac[2][0] = "x";
					}
					else{
					    System.out.println("This box is already filled please enter a different number");			
					}
				}
				if(Main.findKeyword(statement,"8",0)>=0 && statement.length()==1){
					if(tictac[2][1]==" "){
						tictac[2][1] = "x";
					}
					else{
					    System.out.println("This box is already filled please enter a different number");			
					}
				}
				if(Main.findKeyword(statement,"9",0)>=0 && statement.length()==1){
					if(tictac[2][2]==" "){
						tictac[2][2] = "x";
					}
					else{
					    System.out.println("This box is already filled please enter a different number");			
					}
				}
				if(statement.length()!=1){
				    System.out.println("Enter only a single digit from 1-9.");
				}
				for(int i=0;i<tictac.length;i++){
					for(int index=0;index<tictac.length;index++){
						if(tictac[i][index]==" "){
							newBlank++;
						}
					}
				}
			}
			return newBlank;
    }
    
    public static int computerResponse(String[][]tictac,int originalBlank,int newBlank){
        while(newBlank == originalBlank){
			newBlank = 0;
			int row = (int)(Math.random()*3);
			int column = (int)(Math.random()*3);				
    		if(tictac[row][column] == " "){
    			tictac[row][column] = "o";
    		}
			for(int i=0;i<tictac.length;i++){
				for(int index=0;index<tictac.length;index++){
					if(tictac[i][index]==" "){
						newBlank++;
					}
					}
				}
		}
		return newBlank;
    }
    
    public static String winCondition(String[][]tictac,int originalBlank){
        String response = "";
		for(int i=0;i<tictac.length;i++){
			if(tictac[i][1] == "x"&&tictac[i][0] == "x"&&tictac[i][2] == "x"){
				response = "You have beat me.";
			}
		}
		for(int i=0;i<tictac[0].length;i++){
			if(tictac[0][i] == "x"&&tictac[1][i] == "x"&&tictac[2][i] == "x"){
				response = "You have beat me.";
			}
		}
		if(tictac[0][0] == "x"&&tictac[1][1] == "x"&&tictac[2][2] == "x"){
			response = "You have beat me.";
		}
		if(tictac[0][2] == "x"&&tictac[1][1] == "x"&&tictac[2][0] == "x"){
			response = "You have beat me.";
		}
			
			
		for(int i=0;i<tictac.length;i++){
			if(tictac[i][1] == "o"&&tictac[i][0] == "o"&&tictac[i][2] == "o"){
				response = "I have beat you.";
			}
		}
		for(int i=0;i<tictac[0].length;i++){
			if(tictac[0][i] == "o"&&tictac[1][i] == "o"&&tictac[2][i] == "o"){
				response = "I have beat you.";
			}
		}
		if(tictac[0][0] == "o"&&tictac[1][1] == "o"&&tictac[2][2] == "o"){
			response = "I have beat you.";
		}
		if(tictac[0][2] == "o"&&tictac[1][1] == "o"&&tictac[2][0] == "o"){
			response = "I have beat you.";
		}
		if(response==""){
    		if(originalBlank == 0){
    			response = "Neither of us won.";
    		}
		}
		return response;
    }
    
    public static boolean endGame(String[][]tictac,boolean playing,int originalBlank){
        for(int i=0;i<tictac.length;i++){
			if(tictac[i][1] == "x"&&tictac[i][0] == "x"&&tictac[i][2] == "x"){
				playing = false;
			}
		}
		for(int i=0;i<tictac[0].length;i++){
			if(tictac[0][i] == "x"&&tictac[1][i] == "x"&&tictac[2][i] == "x"){
				playing = false;
			}
		}
		if(tictac[0][0] == "x"&&tictac[1][1] == "x"&&tictac[2][2] == "x"){
			playing = false;
		}
		if(tictac[0][2] == "x"&&tictac[1][1] == "x"&&tictac[2][0] == "x"){
			playing = false;
		}
			
			
		for(int i=0;i<tictac.length;i++){
			if(tictac[i][1] == "o"&&tictac[i][0] == "o"&&tictac[i][2] == "o"){
				playing = false;
			}
		}
		for(int i=0;i<tictac[0].length;i++){
			if(tictac[0][i] == "o"&&tictac[1][i] == "o"&&tictac[2][i] == "o"){
				playing = false;
			}
		}
		if(tictac[0][0] == "o"&&tictac[1][1] == "o"&&tictac[2][2] == "o"){
			playing = false;
		}
		if(tictac[0][2] == "o"&&tictac[1][1] == "o"&&tictac[2][0] == "o"){
			playing = false;
		}
		if(originalBlank == 0){
			playing = false;
		}
		return playing;
    }
    
    public static void display(String[][]tictac){
        System.out.println(tictac[0][0]+"|"+tictac[0][1]+"|"+tictac[0][2]);
		System.out.println(tictac[1][0]+"|"+tictac[1][1]+"|"+tictac[1][2]);
		System.out.println(tictac[2][0]+"|"+tictac[2][1]+"|"+tictac[2][2]);
    }

    public static void ticTacToe(){
        System.out.println("Let's play tictactoe. Choose where you would like to go using the numbers 1 2 3 for the top row, 4 5 6 for the middle row, and 7 8 9 for the bottom row.");
	    boolean playing = true;
    	String statement = "";
    	String response = "";
    		
		String[][] tictac = new String[3][3];
    	tictac[0][0] = " ";
		tictac[0][1] = " ";
    	tictac[0][2] = " ";
    	tictac[1][0] = " ";
		tictac[1][1] = " ";
    	tictac[1][2] = " ";
    	tictac[2][0] = " ";
		tictac[2][1] = " ";
    	tictac[2][2] = " ";
    	
		int originalBlank = 9;
    	int newBlank = 9;
    	String giveup = "";
    	while(playing){
    	    newBlank = playerResponse(statement,tictac,originalBlank,newBlank);
    	    originalBlank = newBlank;
		    System.out.println("You moved");
    	    display(tictac);
    	    System.out.println(winCondition(tictac,originalBlank));
    	    playing = endGame(tictac,playing,originalBlank);
		    newBlank = computerResponse(tictac,originalBlank,newBlank);
    	    originalBlank = newBlank;
    	    if(playing){
    	        System.out.println("Computer moved");
        	    display(tictac);
    		    System.out.println(winCondition(tictac,originalBlank));
        	    playing = endGame(tictac,playing,originalBlank);
    	    }
		    if(playing){
    	        System.out.println("Do you want to give up?Type yes to give up or anything else to continue");
		        giveup = Main.in.nextLine();
		        giveup = giveup.toLowerCase();
		    }
    	    giveup = giveup.toLowerCase();
    	    if(giveup.equals("yes")&& playing!=false){
    	        playing = false;
		    }
    	    if(playing){
		        System.out.println("Make your move.");
    	    }
		}
    }
}
