package towns;
/**
 * 
 * @author Yash Patel
 *
 */
public class Deck {
	public static Card[] cards = new Card[5];
    public static String[] randomSuits=new String[5];
    public static String[] randomRanks=new String[5];
    public Deck() {
	        int x=0;
	        for(int i=0; i<cards.length; i++){
	            for(int j=0; j<cards.length; j++){
	            	int randomRank=(int) (Math.random()*12);
	            	int randomSuit=(int) (Math.random()*3);
	            		for(int k=0;k<cards.length;k++){
	            			if(!cards[k].equals(new Card(randomSuit,randomRank))){
	            				cards[x]=new Card(randomSuit,randomRank);;
	            				randomSuits[x]=Card.suits[randomSuit];
	            				randomRanks[x]=Card.ranks[randomRank];
	            				x++;
	            			}
	            			else{
	            				continue;
	            			}
	            		}
	             	}
	        }
	 }
}
