package data;

public class Card {

    private final Colour colour;
    private final Value value;

    public Card(Colour c, Value v){
        this.colour = c;
        this.value = v ;
    }

    public Colour getColour() {
        return colour;
    }

    public Value getValue() {
        return value;
    }

    public String toString(){
        return getShowValue() + "("+colour+") ";
    }

    private String getShowValue() {
        switch (value) {
            case TWO:
                return "2";
            case THREE:
                return "3";
            case FOUR:
                return "4";
            case FIVE:
                return "5";
            case SIX:
                return "6";
            case SEVEN:
                return "7";
            case EIGEHT:
                return "8";
            case NINE:
                return "9";
            case TEN:
                return "T";
            case JACK:
                return "J";
            case QUEEN:
                return "Q";
            case KING:
                return "K";
            case ACE:
                return "A";
            default:
                return"X";

        }
    }



}
