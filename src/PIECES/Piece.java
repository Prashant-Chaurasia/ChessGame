package PIECES;

import ChessBoard.Board;
import javax.swing.*;

public abstract class Piece extends JButton implements Cloneable{
    Piece(){


    }
    Piece(String path){
        ImageIcon icon = createImageIcon(path);
        //this.setBackground(color);
        this.setIcon(icon);
    }

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Board.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}

