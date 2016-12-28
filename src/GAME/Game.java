package GAME;

import ChessBoard.*;
public class Game {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Player p1 = new Player();
                Player p2 = new Player();
                Board board = new Board(p1, p2);
            }
        });
    }

}
