package player;

public abstract class Player {

    private String name;
    private int chips;

    public Player(String name, int chips){
        this.name = name;
        this.chips = chips;
    }

    public int action(){

        return 10;
    }
}
