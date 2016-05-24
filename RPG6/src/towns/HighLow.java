package towns;

public class HighLow {
	public static void main(String[] args) {
		  //Game Variables
		  int gamesPlayed = 0;
	      int sumOfScores = 0;
	      double averageScore;
	      boolean playAgain;       
	      
	      do {
	         int scoreThisGame;
	         scoreThisGame = play();
	         sumOfScores += scoreThisGame;
	         gamesPlayed++;
	         System.out.print("Play again? ");
	         playAgain = TextIO.getlnBoolean();
	      } while (playAgain);
	      
	      averageScore = ((double)sumOfScores) / gamesPlayed;
	      
	      System.out.println();
	      System.out.println("You played " + gamesPlayed + " games.");
	      System.out.printf("Your average score was %1.3f.\n", averageScore);
	   
	   } 
	   private static int play() {
	   
	      DeckTwo deckTwo = new DeckTwo();
	      
	      Card currentCard; 

	      Card nextCard;

	      int correctGuesses;
	      char guess;
	      deckTwo.shuffle();

	      correctGuesses = 0;
	      currentCard = deckTwo.dealCard();
	      System.out.println("The first card is the " + currentCard);
	      
	      while (true) {
	         System.out.print("Will the next card be higher (H) or lower (L)?  ");
	         do {
	             guess = TextIO.getlnChar();
	             guess = Character.toUpperCase(guess);
	             if (guess != 'H' && guess != 'L') 
	                System.out.print("Please respond with H or L:  ");
	         } while (guess != 'H' && guess != 'L');  
	         nextCard = deckTwo.dealCard();
	         System.out.println("The next card is " + nextCard);
	         if (nextCard.getValue() == currentCard.getValue()) {
	            System.out.println("The value is the same as the previous card.");
	            System.out.println("You lose on ties.  Sorry!");
	            break;
	         }
	         else if (nextCard.getValue() > currentCard.getValue()) {
	            if (guess == 'H') {
	                System.out.println("Your prediction was correct.");
	                correctGuesses++;
	            }
	            else {
	                System.out.println("Your prediction was incorrect.");
	                break;
	            }
	         }
	         else {
	            if (guess == 'L') {
	                System.out.println("Your prediction was correct.");
	                correctGuesses++;
	            }
	            else {
	                System.out.println("Your prediction was incorrect.");
	                break;
	            }
	         }
	         currentCard = nextCard;
	         System.out.println();
	         System.out.println("The card is " + currentCard);
	         
	      }
	      
	      System.out.println();
	      System.out.println("The game is over.");
	      System.out.println("You made " + correctGuesses 
	                                           + " correct predictions.");
	      System.out.println();
	      
	      return correctGuesses;
	      
	   } 

	}
