package data;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> deck;
    private Random rnd;

    private int cardsDealt = 0;

    public Deck(){
        deck = new ArrayList<>();
        initDeck();
        shuffle();
    }

    public void shuffle(){
        //ToDo
        rnd = new Random();

        for(int i = 52 ; i > 0 ; i--){
            Card choosen = deck.get(rnd.nextInt(i));
            deck.remove(choosen);
            deck.add(choosen);
        }

        cardsDealt = 0;
    }

    public Card getCard(){
        if(cardsDealt == 52){
            System.out.println("NO MORE CARDS LEFT - SHOULD NOT HAPPEN");
            return null;
        }
        return deck.get(cardsDealt++);
    }

    private void initDeck() {
        deck.add(new Card(Colour.HEARTS,Value.TWO));
        deck.add(new Card(Colour.HEARTS,Value.THREE));
        deck.add(new Card(Colour.HEARTS,Value.FOUR));
        deck.add(new Card(Colour.HEARTS,Value.FIVE));
        deck.add(new Card(Colour.HEARTS,Value.SIX));
        deck.add(new Card(Colour.HEARTS,Value.SEVEN));
        deck.add(new Card(Colour.HEARTS,Value.EIGEHT));
        deck.add(new Card(Colour.HEARTS,Value.NINE));
        deck.add(new Card(Colour.HEARTS,Value.TEN));
        deck.add(new Card(Colour.HEARTS,Value.JACK));
        deck.add(new Card(Colour.HEARTS,Value.QUEEN));
        deck.add(new Card(Colour.HEARTS,Value.KING));
        deck.add(new Card(Colour.HEARTS,Value.ACE));
        deck.add(new Card(Colour.DIAMOND,Value.TWO));
        deck.add(new Card(Colour.DIAMOND,Value.THREE));
        deck.add(new Card(Colour.DIAMOND,Value.FOUR));
        deck.add(new Card(Colour.DIAMOND,Value.FIVE));
        deck.add(new Card(Colour.DIAMOND,Value.SIX));
        deck.add(new Card(Colour.DIAMOND,Value.SEVEN));
        deck.add(new Card(Colour.DIAMOND,Value.EIGEHT));
        deck.add(new Card(Colour.DIAMOND,Value.NINE));
        deck.add(new Card(Colour.DIAMOND,Value.TEN));
        deck.add(new Card(Colour.DIAMOND,Value.JACK));
        deck.add(new Card(Colour.DIAMOND,Value.QUEEN));
        deck.add(new Card(Colour.DIAMOND,Value.KING));
        deck.add(new Card(Colour.DIAMOND,Value.ACE));
        deck.add(new Card(Colour.SPADE,Value.TWO));
        deck.add(new Card(Colour.SPADE,Value.THREE));
        deck.add(new Card(Colour.SPADE,Value.FOUR));
        deck.add(new Card(Colour.SPADE,Value.FIVE));
        deck.add(new Card(Colour.SPADE,Value.SIX));
        deck.add(new Card(Colour.SPADE,Value.SEVEN));
        deck.add(new Card(Colour.SPADE,Value.EIGEHT));
        deck.add(new Card(Colour.SPADE,Value.NINE));
        deck.add(new Card(Colour.SPADE,Value.TEN));
        deck.add(new Card(Colour.SPADE,Value.JACK));
        deck.add(new Card(Colour.SPADE,Value.QUEEN));
        deck.add(new Card(Colour.SPADE,Value.KING));
        deck.add(new Card(Colour.SPADE,Value.ACE));
        deck.add(new Card(Colour.CLUBS,Value.TWO));
        deck.add(new Card(Colour.CLUBS,Value.THREE));
        deck.add(new Card(Colour.CLUBS,Value.FOUR));
        deck.add(new Card(Colour.CLUBS,Value.FIVE));
        deck.add(new Card(Colour.CLUBS,Value.SIX));
        deck.add(new Card(Colour.CLUBS,Value.SEVEN));
        deck.add(new Card(Colour.CLUBS,Value.EIGEHT));
        deck.add(new Card(Colour.CLUBS,Value.NINE));
        deck.add(new Card(Colour.CLUBS,Value.TEN));
        deck.add(new Card(Colour.CLUBS,Value.JACK));
        deck.add(new Card(Colour.CLUBS,Value.QUEEN));
        deck.add(new Card(Colour.CLUBS,Value.KING));
        deck.add(new Card(Colour.CLUBS,Value.ACE));
    }


}
