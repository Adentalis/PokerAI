package data;

public class HoleCards {
    private Card one;
    private Card two;

    private Card[] holeCards = new Card[2];

    public Card getOne() {
        return one;
    }

    public void setOne(Card one) {
        this.one = one;
    }

    public Card getTwo() {
        return two;
    }

    public void setTwo(Card two) {
        this.two = two;
    }

    public Card[] getHand() {
        return holeCards;
    }

    public void setHand(Card[] hC) {
        this.holeCards = hC;
    }

}
