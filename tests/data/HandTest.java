package data;

import org.junit.Test;

import java.util.ArrayList;


public class HandTest {

    @Test
    public void validateHand() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Colour.CLUBS,Value.ACE));
        cards.add(new Card(Colour.SPADE,Value.ACE));
        cards.add(new Card(Colour.HEARTS,Value.ACE));
        cards.add(new Card(Colour.DIAMOND,Value.ACE));
        cards.add(new Card(Colour.CLUBS,Value.KING));

        Hand hand = new Hand(cards);


    }
}