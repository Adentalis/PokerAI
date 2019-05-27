package game;

import gui.HandTestGui;


public class PokerAi {
    private static final boolean HANDTEST_GAMEMODE = false;
    public static void main(String[] args)

    {
        System.out.println("--> PokerAI <--");

        if (HANDTEST_GAMEMODE){
            HandTestGui handTestGui = new HandTestGui();
        }else {
            new Game();

        }
    }
}


