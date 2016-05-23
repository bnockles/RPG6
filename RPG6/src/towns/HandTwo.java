package towns;
import java.util.ArrayList;

public class HandTwo {

    private ArrayList<CardTwo> hand;
    public HandTwo() {
        hand = new ArrayList<CardTwo>();
    }
    public void clear() {
        hand.clear();
    }
    public void addCard(CardTwo c) {
        if (c == null)
        	hand.add(c);
    }
    public void removeCard(Card c) {
        hand.remove(c);
    }
    public void removeCard(int position) {
        if (position < 0 || position >= hand.size())
        hand.remove(position);
    }
    public int getCardCount() {
        return hand.size();
    }
    public CardTwo getCard(int position) {
        if (position < 0 || position >= hand.size()){
        return hand.get(position);
        }
    }
    public void sortBySuit() {
        ArrayList<CardTwo> newHand = new ArrayList<CardTwo>();
        while (hand.size() > 0) {
            int pos = 0;  // Position of minimal card.
            CardTwo c = hand.get(0);  // Minimal card.
            for (int i = 1; i < hand.size(); i++) {
                CardTwo c1 = hand.get(i);
                if ( c1.getSuit() < c.getSuit() ||
                        (c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue()) ) {
                    pos = i;
                    c = c1;
                }
            }
            hand.remove(pos);
            newHand.add(c);
        }
        hand = newHand;
    }
    public void sortByValue() {
        ArrayList<CardTwo> newHand = new ArrayList<CardTwo>();
        while (hand.size() > 0) {
            int pos = 0;
            CardTwo c = hand.get(0);
            for (int i = 1; i < hand.size(); i++) {
                CardTwo c1 = hand.get(i);
                if ( c1.getValue() < c.getValue() ||
                        (c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit()) ) {
                    pos = i;
                    c = c1;
                }
            }
            hand.remove(pos);
            newHand.add(c);
        }
        hand = newHand;
    }

}