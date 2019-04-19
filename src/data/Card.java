package data;

public class Card implements Comparable<Card>{

    private final Colour colour;
    private final Value value;
    public int id;

    public Card(Colour c, Value v){
        this.colour = c;
        this.value = v ;
        this.id =0;
    }

    public Colour getColour() {
        return colour;
    }

    public Value getValue() {
        return value;
    }

    public String toString(){
        return getShowValue(value) + "("+colour+")";
    }

    private String getShowValue(Value v) {
        switch (v) {
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
                return "10";
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

    private int getShowValueInt(Value v) {
        switch (v) {
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGEHT:
                return 8;
            case NINE:
                return 9;
            case TEN:
                return 10;
            case JACK:
                return 11;
            case QUEEN:
                return 12;
            case KING:
                return 13;
            case ACE:
                return 14;
            default:
                System.out.println("THIS SHOULD NEVER HAPPEN! Cards - getShowValueInt default switch");
                return 15;
        }
    }


    @Override
    public int compareTo(Card o) {
        if(getShowValueInt(this.value) < getShowValueInt(o.value))return 1;
        else if(getShowValueInt(this.value) > getShowValueInt(o.value)) return -1;
        return 0;
    }
}
