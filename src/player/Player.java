package player;

import data.HoleCards;

public abstract class Player {

    private String name;
    private int chips;
    private HoleCards cards;

    public Player(String name, int chips){
        this.name = name;
        this.chips = chips;
    }

    public int action(){

        return 10;
    }
}
