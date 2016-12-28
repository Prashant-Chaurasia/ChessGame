package PIECES;

import GAME.*;
import javax.swing.*;

public class Knight extends Piece {


    private String image_Path ;
    //    int loc_x, loc_y;
    private String color;
    private boolean ep_able;
    private boolean hasMoved;


    public Knight(Player w, Player b, JButton board[][], String p, String pColor){
        super(w,b,board);
        ImageIcon icon = createImageIcon(p);
        //this.setBackground(color);
        this.setIcon(icon);
        image_Path= p;
        color = pColor;
    }


    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getImage_Path() {
        return image_Path;
    }

    @Override
    public boolean validateMove(int currentRow, int currentCol, int newRow, int newCol) {

        if(Math.abs(newRow - currentRow) == 2 && Math.abs(newCol - currentCol) == 1){
            if(isAtPosition(newRow,newCol)){
                if(isEmpty(newRow,newCol).getColor().equals(color))
                    return false;
            }
            return true;
        }

        if(Math.abs(newRow - currentRow) == 1 && Math.abs(newCol - currentCol) == 2){
            if(isAtPosition(newRow,newCol)){
                if(isEmpty(newRow,newCol).getColor().equals(color))
                    return false;
            }
            return true;
        }

        return false;
    }
}
