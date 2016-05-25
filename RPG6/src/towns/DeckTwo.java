package towns;
//Slightly modified than Deck.java (Deck code for Poker). Code for High Low
public class DeckTwo {

    private Card[] deck;

    private int cardsUsed;

    public DeckTwo(boolean includeJokers) {
            deck = new Card[52];
        int cardCount = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int value = 1; value <= 13; value++) {
                deck[cardCount] = new Card(value,suit);
                cardCount++;
            }
        }
        cardsUsed = 0;
    }
    public void shuffle() {
        for (int i = deck.length-1; i > 0; i-- ) {
            int random = (int)(Math.random()*(i+1));
            Card temp = deck[i];
            deck[i] = deck[random];
            deck[random] = temp;
        }
        cardsUsed = 0;
    }
    public int cardsLeft() {
        return deck.length - cardsUsed;
    }
    public Card dealCard() {
        if (cardsUsed == deck.length)
            throw new IllegalStateException("No cards are left in the deck.");
        cardsUsed++;
        return deck[cardsUsed - 1];
    }
    public boolean hasJokers() {
        return (deck.length == 54);
    }

}